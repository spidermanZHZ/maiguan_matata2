package com.example.administrator.matata_android.my.activitys;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.UserInfoBean;
import com.example.administrator.matata_android.bean.VipListBean;
import com.example.administrator.matata_android.bean.WXPayBean;
import com.example.administrator.matata_android.homepage.SerializableMap;
import com.example.administrator.matata_android.homepage.activitys.ArtBuyCompleteActivity;
import com.example.administrator.matata_android.homepage.adapters.ArtBuyJoinPeopleAdapter;
import com.example.administrator.matata_android.httputils.BaseObserver;
import com.example.administrator.matata_android.httputils.RetrofitUtil;
import com.example.administrator.matata_android.wxapi.WXPayUtils;
import com.example.administrator.matata_android.zhzbase.base.BaseActivity;
import com.example.administrator.matata_android.zhzbase.utils.MatataSPUtils;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 课程购买页面
 */
public class VipBuyActivity extends BaseActivity {


    @BindView(R.id.title_bar)
    TitleBar titleBar;
    @BindView(R.id.art_buy_iv)
    ImageView artBuyIv;
    @BindView(R.id.tv_vip_bug_price)
    TextView tvVipBugPrice;
    @BindView(R.id.rv_buy_vip)
    RecyclerView rvBuyVip;
    @BindView(R.id.art_btn_buy_confirm)
    Button artBtnBuyConfirm;
    private BaseObserver<UserInfoBean> userInfoBeanBaseObserver;
    private BaseObserver<WXPayBean> wxPayBeanBaseObserver;
    private static final String URL = "https://www.maiguanjy.com/";
    private List<String> mData;
    private List<String> mPrice;
    private ArtBuyJoinPeopleAdapter adapter;
    private BaseObserver<List<VipListBean>> listBaseObserver;

    private String vip_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_choose_vip);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);

    }


    @Override
    protected void getExras() {

    }

    @Override
    protected void initData() {
        mData=new ArrayList<>();
        mPrice=new ArrayList<>();
        titleBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onLeftClick(View v) {
                finishActivity();
            }

            @Override
            public void onTitleClick(View v) {

            }

            @Override
            public void onRightClick(View v) {

            }
        });
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rvBuyVip.setLayoutManager(manager);

        adapter=new ArtBuyJoinPeopleAdapter(this,null);
        rvBuyVip.setAdapter(adapter);

        getVipList();

    }

    /**
     * 获取Vip列表
     */
    private void getVipList() {
        Map<String, Object> map = new HashMap<>();
        map.put("token", MatataSPUtils.getToken());
        listBaseObserver = new BaseObserver<List<VipListBean>>(this, true, false) {
            @Override
            public void onSuccess(List<VipListBean> vipListBeans) {
                Glide.with(mContext).load(URL + vipListBeans.get(0).getValue().getPic())
                        .into(artBuyIv);
                double b=(double)vipListBeans.get(0).getValue().getPrice()/100;
                tvVipBugPrice.setText(String.valueOf("¥"+b));
                mData.add(vipListBeans.get(0).getValue().getName());
                mData.add(vipListBeans.get(1).getValue().getName());
                adapter.addData(mData);
                adapter.setSelection(0);
                vip_id=String.valueOf(vipListBeans.get(0).getId());

                mPrice.add(String.valueOf("¥"+(double)vipListBeans.get(0).getValue().getPrice()/100));
                mPrice.add(String.valueOf("¥"+(double)vipListBeans.get(1).getValue().getPrice()/100));
                adapter.setOnItemClickLitener(new ArtBuyJoinPeopleAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        adapter.setSelection(position);
                        tvVipBugPrice.setText(mPrice.get(position));
                        vip_id=String.valueOf(vipListBeans.get(position).getId());
                    }

                    @Override
                    public void onItemLongClick(View view, int position) {

                    }
                });
                artBtnBuyConfirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getVip(vip_id);

                    }
                });



            }
        };
        RetrofitUtil.getInstance().getApiService().getVipList(map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listBaseObserver);
    }
    /**
     * 开通Vip
     * @param id
     */
    private void getVip(String id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("token", MatataSPUtils.getToken());
        map.put("vip_id", id);
        map.put("pay_type", "wx");

        wxPayBeanBaseObserver = new BaseObserver<WXPayBean>(this, true, false) {
            @Override
            public void onSuccess(WXPayBean wXPayBean) {

                if (wXPayBean != null) {
                    WXPayUtils.WXPayBuilder builder = new WXPayUtils.WXPayBuilder();
                    builder.setAppId("wx0c29113c18ba2dfc")
                            .setPartnerId(wXPayBean.getPartnerid())
                            .setPrepayId(wXPayBean.getPrepayid())
                            .setPackageValue(wXPayBean.getPackageX())
                            .setNonceStr(wXPayBean.getNoncestr())
                            .setTimeStamp(String.valueOf(wXPayBean.getTimestamp()))
                            .setSign(wXPayBean.getSign())
                            .build()
                            .toWXPayNotSign(VipBuyActivity.this, "wx0c29113c18ba2dfc");
                }
                finishActivity();
            }
        };
        RetrofitUtil.getInstance().getApiService().payVip(map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(wxPayBeanBaseObserver);


    }
    @Override
    protected void setListener() {

    }

    @Override
    protected boolean onKeyBack() {
        return false;
    }

    @Override
    protected boolean onKeyMenu() {
        return false;
    }
}
