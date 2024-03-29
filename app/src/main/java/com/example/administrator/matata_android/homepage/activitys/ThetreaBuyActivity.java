package com.example.administrator.matata_android.homepage.activitys;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.OffLineCourseBean;
import com.example.administrator.matata_android.bean.UserInfoBean;
import com.example.administrator.matata_android.growup.activity.ChangChildInfoActivity;
import com.example.administrator.matata_android.homepage.SerializableMap;
import com.example.administrator.matata_android.homepage.adapters.ArtBuyJoinPeopleAdapter;
import com.example.administrator.matata_android.httputils.BaseObserver;
import com.example.administrator.matata_android.httputils.RetrofitUtil;
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
public class ThetreaBuyActivity extends BaseActivity {

    @BindView(R.id.title_bar)
    TitleBar titleBar;
    @BindView(R.id.title)
    LinearLayout title;
    @BindView(R.id.art_buy_iv)
    ImageView artBuyIv;
    @BindView(R.id.tv_join_bug_price)
    TextView tvJoinBugPrice;
    @BindView(R.id.tv_join_bug_vip_price)
    TextView tvJoinBugVipPrice;
    @BindView(R.id.tv_join_to_bug_vip)
    TextView tvJoinToBugVip;
    @BindView(R.id.tv_join_bug_name)
    TextView tvJoinBugName;
    @BindView(R.id.buy_title_one)
    TextView buyTitleOne;
    @BindView(R.id.buy_title_two)
    TextView buyTitleTwo;
    @BindView(R.id.rv_join_people)
    RecyclerView rvJoinPeople;
    @BindView(R.id.but_ll_shuxing_one)
    LinearLayout butLlShuxingOne;

    @BindView(R.id.art_btn_buy_confirm)
    Button artBtnBuyConfirm;
    @BindView(R.id.buy_title_three)
    TextView buyTitleThree;
    @BindView(R.id.rv_join_date)
    RecyclerView rvJoinDate;
    @BindView(R.id.but_ll_shuxing_two)
    LinearLayout butLlShuxingTwo;

    private BaseObserver<UserInfoBean> userInfoBeanBaseObserver;

    private OffLineCourseBean offLineCourseBean;
    private static final String URL = "https://www.maiguanjy.com/";
    private List<String> mData;
    private List<String> mChildData;
    private HashMap<String, String> mPrice;
    private  HashMap<String, Object> dataMap = new HashMap<String, Object>();
    SerializableMap myMap;
    private String lastPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_theatrea_buy);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);

    }

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            Bundle bundle = msg.getData();
            tvJoinBugPrice.setText(String.valueOf("¥" + bundle.getString("normalPrice")));
            tvJoinBugVipPrice.setText(String.valueOf("会员价：" + bundle.getString("vipPrice")));
            return false;
        }
    });

    @Override
    protected void getExras() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("info_bundle");
        offLineCourseBean = (OffLineCourseBean) bundle.getSerializable("offLineCourseBean");
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

        mPrice = new HashMap<String, String>();
        //加载孩子列表
        butLlShuxingTwo.setVisibility(View.VISIBLE);
       getUserInfo();//加载孩子信息



        if (offLineCourseBean != null) {
            Glide.with(mContext).load(URL + offLineCourseBean.getCover_pic())
                    .into(artBuyIv);
            int a = Integer.parseInt(MatataSPUtils.getIsVip());
            //若是会员，则隐藏按钮
            if (a == 1) {
                tvJoinToBugVip.setVisibility(View.GONE);
                tvJoinBugPrice.setVisibility(View.GONE);
                int c = offLineCourseBean.getPrice().get(0).getPrice() / 100;//原价
                double d = (100 - offLineCourseBean.getDiscount()) / 100;//折扣价
                int f = (int) (c * d);
                lastPrice=String.valueOf(f);
            }
            tvJoinToBugVip.setVisibility(View.VISIBLE);
            tvJoinBugPrice.setVisibility(View.VISIBLE);
            String price = "¥" + getPrice(String.valueOf(offLineCourseBean.getPrice().get(0).getPrice())) + "(" + offLineCourseBean.getPrice().get(0).getNum() + "次)";
            tvJoinBugPrice.setText(price);
            lastPrice=price;
            int c = offLineCourseBean.getPrice().get(0).getPrice() / 100;//原价
            double d = (100 - offLineCourseBean.getDiscount()) / 100;//折扣价
            int f = (int) (c * d);
            tvJoinBugVipPrice.setText(String.valueOf("vip：" + f + "(" + offLineCourseBean.getPrice().get(0).getNum() + "次)"));

            tvJoinToBugVip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "点击了开通会员", Toast.LENGTH_SHORT).show();
                }
            });

            //加载价格标签

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            rvJoinPeople.setLayoutManager(linearLayoutManager);
            mData = new ArrayList<String>();

            for (int i = 0; i < offLineCourseBean.getPrice().size(); i++) {
                mData.add(offLineCourseBean.getPrice().get(i).getName() + " | " + getPrice(String.valueOf(offLineCourseBean.getPrice().get(i).getPrice())) + "元 | " + offLineCourseBean.getPrice().get(i).getNum() + "次");
            }
            ArtBuyJoinPeopleAdapter artBuyJoinPeopleAdapter = new ArtBuyJoinPeopleAdapter(this, mData);
            rvJoinPeople.setAdapter(artBuyJoinPeopleAdapter);
            artBuyJoinPeopleAdapter.setSelection(0);
            //传入所选套餐类型
            dataMap.put("card_type", offLineCourseBean.getPrice().get(0).getType());

            artBuyJoinPeopleAdapter.setOnItemClickLitener(new ArtBuyJoinPeopleAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    artBuyJoinPeopleAdapter.setSelection(position);

                    //保存价格position
                    mPrice.put("position", String.valueOf(position));

                    //更新String价格显示
                    String prices = "¥" + getPrice(String.valueOf(offLineCourseBean.getPrice().get(position).getPrice())) + "(" + offLineCourseBean.getPrice().get(position).getNum() + "次)";

                    tvJoinBugPrice.setText(prices);

                    int a = offLineCourseBean.getPrice().get(position).getPrice() / 100;//原价

                    double b = (100 - offLineCourseBean.getDiscount()) / 100;//折扣价

                    int c = (int) (a * b);
                    tvJoinBugVipPrice.setText(String.valueOf("vip：" + c + "(" + offLineCourseBean.getPrice().get(position).getNum() + "次)"));

                    dataMap.put("card_type", offLineCourseBean.getPrice().get(position).getType());
                }

                @Override
                public void onItemLongClick(View view, int position) {

                }

            });
            artBtnBuyConfirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent();
                    intent.setClass(ThetreaBuyActivity.this, ArtBuyCompleteActivity.class);

                    myMap = new SerializableMap();
                    myMap.setMap(dataMap);

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("myMap", myMap);
                    intent.putExtra("type", "offline");
                    intent.putExtra("lastPrice",lastPrice);
                    intent.putExtra("offline_id",String.valueOf(offLineCourseBean.getId()) );
                    intent.putExtra("mBundle", bundle);
                    startActivity(intent);
                }
            });

        }

    }

    /**
     * 处理接口返回String类型价格
     */
    public String getPrice(String price) {
        int a = Integer.parseInt(price);
        int b = a / 100;
        return String.valueOf(b);
    }

    /**
     * 处理商品数量
     */
    public String getNumber(int number) {
        return String.valueOf(number);
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
                buyTitleThree.setText("选择学员");
                mChildData = new ArrayList<String>();

                if ( userInfoBean.getUser_child()!=null){
                    if (  userInfoBean.getUser_child().size()==0){
                        showTextDialog("请先添加一名学员");
                        Intent intent = new Intent(ThetreaBuyActivity.this, ChangChildInfoActivity.class);
                        startActivity(intent);
                    }else {
                        for (int i = 0; i <   userInfoBean.getUser_child().size(); i++) {
                            mChildData.add(  userInfoBean.getUser_child().get(i).getName());
                        }
                    }
                    LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(ThetreaBuyActivity.this);
                    linearLayoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
                    rvJoinDate.setLayoutManager(linearLayoutManager2);
                    ArtBuyJoinPeopleAdapter artBuyJoinPeopleAdapter2 = new ArtBuyJoinPeopleAdapter(ThetreaBuyActivity.this, mChildData);
                    rvJoinDate.setAdapter(artBuyJoinPeopleAdapter2);
                    artBuyJoinPeopleAdapter2.setSelection(0);
                    //传入所选套餐类型
                    dataMap.put("child_id",String.valueOf(  userInfoBean.getUser_child().get(0).getId()));

                    artBuyJoinPeopleAdapter2.setOnItemClickLitener(new ArtBuyJoinPeopleAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            artBuyJoinPeopleAdapter2.setSelection(position);

                            dataMap.put("child_id",String.valueOf(  userInfoBean.getUser_child().get(position).getId()));
                        }

                        @Override
                        public void onItemLongClick(View view, int position) {

                        }

                    });

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
}
