package com.example.administrator.matata_android.my.activitys;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.ActivityUtils;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.MyOrderBean;
import com.example.administrator.matata_android.httputils.BaseObserver;
import com.example.administrator.matata_android.httputils.RetrofitUtil;
import com.example.administrator.matata_android.my.fragments.MyOrdersAllFragment;
import com.example.administrator.matata_android.my.fragments.MyOrdersCompleteFragment;
import com.example.administrator.matata_android.my.fragments.MyOrdersNoPaidFragment;
import com.example.administrator.matata_android.zhzbase.base.BaseFragmentActivity;
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
 * 订单页面
 */
public class MyOrdersActivity extends BaseFragmentActivity {

    @BindView(R.id.my_orders_tab)
    TabLayout myOrdersTab;
    @BindView(R.id.my_orders_viewpager)
    ViewPager myOrdersViewpager;
    @BindView(R.id.title_bar)
    TitleBar titleBar;
    private List<Fragment> fragments;
    private List<String> titles;

    private MyOrdersAllFragment myOrdersAllFragment;
    private MyOrdersCompleteFragment myOrdersCompleteFragment;
    private MyOrdersNoPaidFragment myOrdersNoPaidFragment;
    private BaseObserver<MyOrderBean> myOrderBeanBaseObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_my_orders);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void getExras() {

    }

    @Override
    protected void initData() {
        titleBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onLeftClick(View v) {
                ActivityUtils.finishActivity(MyOrdersActivity.this);
            }

            @Override
            public void onTitleClick(View v) {

            }

            @Override
            public void onRightClick(View v) {

            }
        });
        getMyOrders();

    }

    @Override
    protected void setListener() {

    }

    /**
     * 获取我的订单
     */
    private void getMyOrders() {
        Map<String, Object> map = new HashMap<>();
        map.put("token", MatataSPUtils.getToken());
        myOrderBeanBaseObserver = new BaseObserver<MyOrderBean>(this, true, false) {
            @Override
            public void onSuccess(MyOrderBean myOrderBean) {

                fragments = new ArrayList<>();
                titles = new ArrayList<>();

                myOrdersAllFragment = new MyOrdersAllFragment();
                //往fragment传递数据
                Bundle bundle1 = new Bundle();
                bundle1.putSerializable("myOrdersAllFragment", myOrderBean);
                myOrdersAllFragment.setArguments(bundle1);
                fragments.add(myOrdersAllFragment);

                myOrdersNoPaidFragment = new MyOrdersNoPaidFragment();
                Bundle bundle3 = new Bundle();
                bundle3.putSerializable("myOrdersNoPaidFragment", myOrderBean);
                myOrdersNoPaidFragment.setArguments(bundle3);
                fragments.add(myOrdersNoPaidFragment);

                myOrdersCompleteFragment = new MyOrdersCompleteFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("myOrdersCompleteFragment", myOrderBean);
                myOrdersCompleteFragment.setArguments(bundle2);
                fragments.add(myOrdersCompleteFragment);


                titles.add("全部");
                titles.add("待支付");
                titles.add("已支付");

                myOrdersViewpager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
                    @Override
                    public Fragment getItem(int position) {
                        return fragments.get(position);
                    }

                    @Override
                    public int getCount() {
                        return fragments.size();
                    }

                    @Override
                    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                        super.destroyItem(container, position, object);
                    }

                    @Nullable
                    @Override
                    public CharSequence getPageTitle(int position) {
                        return titles.get(position);
                    }
                });
                myOrdersTab.setupWithViewPager(myOrdersViewpager);


            }
        };
        RetrofitUtil.getInstance().getApiService().getMyOrderInfo(map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(myOrderBeanBaseObserver);
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
