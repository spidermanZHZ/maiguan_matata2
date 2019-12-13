package com.example.administrator.matata_android.my.activitys;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.UserInfoBean;
import com.example.administrator.matata_android.homepage.activitys.ArtBuyCompleteActivity;
import com.example.administrator.matata_android.httputils.BaseObserver;
import com.example.administrator.matata_android.httputils.RetrofitUtil;
import com.example.administrator.matata_android.zhzbase.base.BaseActivity;
import com.example.administrator.matata_android.zhzbase.utils.MatataSPUtils;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * VIP会员页面
 * '
 */
public class MyVipActivity extends BaseActivity {


    @BindView(R.id.iv_vip_card)
    ImageView ivVipCard;
    @BindView(R.id.tv_my_is_vip)
    TextView tvMyIsVip;
    @BindView(R.id.ll_vip_one)
    LinearLayout llVipOne;
    @BindView(R.id.ll_vip_two)
    LinearLayout llVipTwo;
    @BindView(R.id.ll_vip_three)
    LinearLayout llVipThree;
    @BindView(R.id.ll_vip_four)
    LinearLayout llVipFour;
    @BindView(R.id.ll_vip_five)
    LinearLayout llVipFive;
    @BindView(R.id.ll_vip_six)
    LinearLayout llVipSix;
    @BindView(R.id.ll_vip_seven)
    LinearLayout llVipSeven;
    @BindView(R.id.ll_vip_eight)
    LinearLayout llVipEight;
    @BindView(R.id.ll_vip_nine)
    LinearLayout llVipNine;
    @BindView(R.id.title_bar)
    TitleBar titleBar;
    private BaseObserver<UserInfoBean> userInfoBeanBaseObserver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_my_vip);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onResume() {
        super.onResume();
        getUserInfo();
    }

    @Override
    protected void getExras() {

    }

    @Override
    protected void initData() {
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


    }
    /**
     * 获取用户个人信息
     */
    private void getUserInfo() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("token", MatataSPUtils.getToken());
        userInfoBeanBaseObserver = new BaseObserver<UserInfoBean>(this, true, false) {
            @Override
            public void onSuccess(UserInfoBean userInfoBean) {
                MatataSPUtils.saveIsVip(userInfoBean.getIs_vip());
                if (MatataSPUtils.getIsVip().equals("0")){
                    tvMyIsVip.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MyVipActivity.this, VipBuyActivity.class);

                            startActivity(intent);
                        }
                    });
                }else {
                    ivVipCard.setImageResource(R.mipmap.is_vip);
                    tvMyIsVip.setText(String.valueOf(userInfoBean.getVip_info().getVip_name()));
                }
            }
        };

        RetrofitUtil.getInstance().getApiService().getUserInfo(map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userInfoBeanBaseObserver);
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

    @OnClick({R.id.tv_my_is_vip, R.id.ll_vip_one, R.id.ll_vip_two, R.id.ll_vip_three, R.id.ll_vip_four, R.id.ll_vip_five, R.id.ll_vip_six, R.id.ll_vip_seven, R.id.ll_vip_eight, R.id.ll_vip_nine})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_my_is_vip:
                break;
            case R.id.ll_vip_one:
                break;
            case R.id.ll_vip_two:
                break;
            case R.id.ll_vip_three:
                break;
            case R.id.ll_vip_four:
                break;
            case R.id.ll_vip_five:
                break;
            case R.id.ll_vip_six:
                break;
            case R.id.ll_vip_seven:
                break;
            case R.id.ll_vip_eight:
                break;
            case R.id.ll_vip_nine:
                break;
        }
    }
}
