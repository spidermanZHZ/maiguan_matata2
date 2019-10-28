package com.example.administrator.matata_android.my;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ActivityUtils;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.login.activitys.LoginActivity;
import com.example.administrator.matata_android.my.activitys.MyExtensionActivity;
import com.example.administrator.matata_android.my.activitys.MyFollowActivity;
import com.example.administrator.matata_android.my.activitys.MyFriendActivity;
import com.example.administrator.matata_android.my.activitys.MyMessageActivity;
import com.example.administrator.matata_android.my.activitys.MyOrderActivity;
import com.example.administrator.matata_android.my.activitys.MyVipActivity;
import com.example.administrator.matata_android.zhzbase.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MyFragment extends BaseFragment {

    @BindView(R.id.stu_name)
    TextView stuName;
    @BindView(R.id.stu_sex)
    TextView stuSex;
    @BindView(R.id.stu_sign)
    TextView stuSign;
    @BindView(R.id.stu_edit)
    TextView stuEdit;
    @BindView(R.id.my_ll_vip)
    LinearLayout myLlVip;
    @BindView(R.id.my_ll_extension)
    LinearLayout myLlExtension;
    @BindView(R.id.my_ll_order)
    LinearLayout myLlOrder;
    @BindView(R.id.my_ll_follow)
    LinearLayout myLlFollow;
    @BindView(R.id.my_btn_offlogin)
    Button myBtnOfflogin;
    Unbinder unbinder;
    @BindView(R.id.my_ll_message)
    LinearLayout myLlMessage;
    @BindView(R.id.my_ll_friend)
    LinearLayout myLlFriend;

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_my;
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
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.my_ll_vip, R.id.my_ll_extension, R.id.my_ll_order, R.id.my_ll_follow, R.id.my_btn_offlogin,R.id.my_ll_message, R.id.my_ll_friend})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.my_ll_vip:
                startActivity(new Intent(getContext(), MyVipActivity.class));
                break;
            case R.id.my_ll_extension:
                startActivity(new Intent(getContext(), MyExtensionActivity.class));
                break;
            case R.id.my_ll_order:
                startActivity(new Intent(getContext(), MyOrderActivity.class));
                break;
            case R.id.my_ll_follow:
                startActivity(new Intent(getContext(), MyFollowActivity.class));
                break;
            case R.id.my_btn_offlogin:
                startActivity(new Intent(getContext(), LoginActivity.class));
                ActivityUtils.finishAllActivities();
                break;
            case R.id.my_ll_message:
                startActivity(new Intent(getContext(), MyMessageActivity.class));
                break;
            case R.id.my_ll_friend:
                startActivity(new Intent(getContext(), MyFriendActivity.class));
                break;
        }
    }

}
