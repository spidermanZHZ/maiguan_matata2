package com.example.administrator.matata_android.my.fragments;

import android.view.MotionEvent;
import android.view.View;

import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.zhzbase.base.BaseFragment;

/**
 * 待付款
 */
public class MyOrdersNoPaidFragment extends BaseFragment{
    @Override
    protected int initLayoutId() {
     return R.layout.fragment_all_orders;
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
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}
