package com.example.administrator.matata_android.my;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.my.activitys.MyExtendActivity;
import com.example.administrator.matata_android.my.activitys.MyFollowActivity;
import com.example.administrator.matata_android.my.activitys.MyFriendActivity;
import com.example.administrator.matata_android.my.activitys.MyMessageActivity;
import com.example.administrator.matata_android.my.activitys.MyOrdersActivity;
import com.example.administrator.matata_android.my.activitys.MySetActivity;
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
    ImageView stuEdit;
    @BindView(R.id.my_ll_vip)
    LinearLayout myLlVip;
    @BindView(R.id.my_ll_orders)
    LinearLayout myLlExtension;
    @BindView(R.id.my_ll_order)
    LinearLayout myLlOrder;
    @BindView(R.id.my_ll_follow)
    LinearLayout myLlFollow;
    Unbinder unbinder;
    @BindView(R.id.my_ll_message)
    LinearLayout myLlMessage;
    @BindView(R.id.my_ll_friend)
    LinearLayout myLlFriend;
    @BindView(R.id.ll_my_set)
    LinearLayout llMySet;

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

    @OnClick({R.id.my_ll_vip, R.id.my_ll_orders, R.id.my_ll_order, R.id.my_ll_follow, R.id.my_ll_message, R.id.my_ll_friend,R.id.ll_my_set})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.my_ll_vip:
                startActivity(new Intent(getContext(), MyVipActivity.class));
                break;
            case R.id.my_ll_orders:
                startActivity(new Intent(getContext(), MyOrdersActivity.class));
                break;
            case R.id.my_ll_order:
                startActivity(new Intent(getContext(), MyExtendActivity.class));
                break;
            case R.id.my_ll_follow:
                startActivity(new Intent(getContext(), MyFollowActivity.class));
                break;
            case R.id.my_ll_message:
                startActivity(new Intent(getContext(), MyMessageActivity.class));
                break;
            case R.id.my_ll_friend:
                startActivity(new Intent(getContext(), MyFriendActivity.class));
                break;
            case R.id.ll_my_set:
                startActivity(new Intent(getContext(), MySetActivity.class));
                break;
        }
    }

}
