package com.example.administrator.matata_android.my.activitys;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.blankj.utilcode.util.ActivityUtils;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.login.activitys.LoginActivity;
import com.example.administrator.matata_android.login.activitys.RetrievePasswordOneActivity;
import com.example.administrator.matata_android.zhzbase.base.BaseActivity;
import com.example.administrator.matata_android.zhzbase.dialog.CustomDialog;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MySetActivity extends BaseActivity {

    @BindView(R.id.titile_bar)
    TitleBar titileBar;
    @BindView(R.id.ll_my_set)
    LinearLayout llMySet;
    @BindView(R.id.my_btn_offlogin)
    Button myBtnOfflogin;
    @BindView(R.id.ll_my_password)
    LinearLayout llMyPassword;
    private CustomDialog customDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_my_set);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);
        initData();
    }

    @Override
    protected void getExras() {

    }

    @Override
    protected void initData() {
        titileBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onLeftClick(View v) {
                ActivityUtils.finishActivity(MySetActivity.class);
            }

            @Override
            public void onTitleClick(View v) {

            }

            @Override
            public void onRightClick(View v) {

            }
        });
        myBtnOfflogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showProgressDialog("是否退出当前账号", false);
//            Intent intent = new Intent(MySetActivity.this, LoginActivity.class);
//            startActivity(intent);
//            ActivityUtils.finishAllActivities();

            }
        });

        llMyPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MySetActivity.this, RetrievePasswordOneActivity.class);
                startActivity(intent);
                finishActivity();
            }
        });

    }

    /**
     * 显示交互弹窗
     *
     * @param text       弹窗提示语id
     * @param cancelable 是否可以点击弹窗外侧取消
     */
    public void showProgressDialog(String text, boolean cancelable) {
        if (customDialog == null)
            customDialog = new CustomDialog(this);
        customDialog.setTitle("提示");
        customDialog.setMessage(text);
        customDialog.setYes("确认");
        customDialog.setNo("取消");
        customDialog.setOnYesOnClickListener(new CustomDialog.onYesOnClickListener() {
            @Override
            public void onYesClick() {
                Intent intent = new Intent(MySetActivity.this, LoginActivity.class);
                startActivity(intent);
                ActivityUtils.finishAllActivities();
            }
        });
        customDialog.setNoOnclickListener(new CustomDialog.onNoOnClickLister() {
            @Override
            public void onNoClick() {
                customDialog.cancelImediately();
            }
        });
        customDialog.setCancelable(cancelable);
        customDialog.show();

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
