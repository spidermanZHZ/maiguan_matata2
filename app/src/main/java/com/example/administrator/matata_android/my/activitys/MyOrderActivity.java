package com.example.administrator.matata_android.my.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.zhzbase.base.BaseActivity;

/**
 * 我的订单页面
 */
public class MyOrderActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_my_order);
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
