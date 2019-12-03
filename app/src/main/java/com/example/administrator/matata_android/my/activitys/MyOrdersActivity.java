package com.example.administrator.matata_android.my.activitys;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;

import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.my.fragments.MyOrdersAllFragment;
import com.example.administrator.matata_android.zhzbase.base.BaseFragmentActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 订单页面
 */
public class MyOrdersActivity extends BaseFragmentActivity {

    @BindView(R.id.my_orders_tab)
    TabLayout myOrdersTab;
    @BindView(R.id.my_orders_viewpager)
    ViewPager myOrdersViewpager;
    private List<Fragment> fragments;
    private List<String> titles;


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
            fragments=new ArrayList<>();
            titles=new ArrayList<>();

            fragments.add(new MyOrdersAllFragment());
            fragments.add(new MyOrdersAllFragment());
            fragments.add(new MyOrdersAllFragment());

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
