package com.example.administrator.matata_android.growup.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.blankj.utilcode.util.BarUtils;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.zhzbase.base.BaseActivity;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 课前预习
 */
public class OfflineCourseTaskActivity extends BaseActivity {

    @BindView(R.id.title_bar)
    TitleBar titleBar;
    private String num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_offline_course_task);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);
        BarUtils.setStatusBarColor(this,getResources().getColor(R.color.background_title),true);
    }

    @Override
    protected void getExras() {
        Intent intent = getIntent();
        num =   intent.getStringExtra("num");
    }

    @Override
    protected void initData() {
        titleBar.setTitle("第"+num+"课时");
        titleBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onLeftClick(View v) {

            }

            @Override
            public void onTitleClick(View v) {

            }

            @Override
            public void onRightClick(View v) {

            }
        });
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
