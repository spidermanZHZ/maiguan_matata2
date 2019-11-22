package com.example.administrator.matata_android.my.activitys;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.zhzbase.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Vip介绍页面
 */
public class MyVipIntroduceActivity extends BaseActivity {

    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_my_vip_introduce);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void getExras() {

    }

    @Override
    protected void initData() {

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
