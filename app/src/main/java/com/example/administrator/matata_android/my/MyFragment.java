package com.example.administrator.matata_android.my;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ActivityUtils;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.my.activitys.MyExtendActivity;
import com.example.administrator.matata_android.my.activitys.MyFollowActivity;
import com.example.administrator.matata_android.my.activitys.MyFriendActivity;
import com.example.administrator.matata_android.my.activitys.MyMessageActivity;
import com.example.administrator.matata_android.my.activitys.MyOrdersActivity;
import com.example.administrator.matata_android.my.activitys.MySetActivity;
import com.example.administrator.matata_android.my.activitys.MyVipActivity;
import com.example.administrator.matata_android.zhzbase.base.BaseFragment;
import com.example.administrator.matata_android.zhzbase.dialog.CustomDialog;
import com.example.administrator.matata_android.zhzbase.dialog.TextDialog;
import com.example.administrator.matata_android.zhzbase.utils.MatataSPUtils;

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
    private TextDialog textDialog;
    private CustomDialog customDialog;
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

        stuSign.setText(String.valueOf("手机号："+MatataSPUtils.getUserName()));
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
                showProgressDialog("客服热线：0531-88821319",true);
               // startActivity(new Intent(getContext(), MyFriendActivity.class));
                break;
            case R.id.ll_my_set:
                startActivity(new Intent(getContext(), MySetActivity.class));
                break;
        }
    }

    /**
     * 显示提示弹窗
     *
     * @param text 弹窗提示语
     */
    public void showTextDialog(String text) {
        if (textDialog == null)
            textDialog = new TextDialog(getContext());
        textDialog.setText(text);
        textDialog.show();
    }
    /**
     * 显示交互弹窗
     *
     * @param text       弹窗提示语id
     * @param cancelable 是否可以点击弹窗外侧取消
     */
    public void showProgressDialog(String text, boolean cancelable) {
        if (customDialog == null)
            customDialog = new CustomDialog(getContext());
        customDialog.setTitle("提示");
        customDialog.setMessage(text);
        customDialog.setYes("拨打");
        customDialog.setNo("取消");
        customDialog.setOnYesOnClickListener( new CustomDialog.onYesOnClickListener() {
            @Override
            public void onYesClick() {
                call("053188821319");
            }
        });
        customDialog.setNoOnclickListener( new CustomDialog.onNoOnClickLister() {
            @Override
            public void onNoClick() {
                customDialog.cancelImediately();
            }
        });
        customDialog.setCancelable(cancelable);
        customDialog.show();

    }
    /**
     * 调用拨号界面
     * @param phone 电话号码
     */
    private void call(String phone) {
        Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+phone));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    /**
     * 直接拨号
     * @param phone 电话号码
     */
    private void callpast(String phone) {
        Intent intent=new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+phone));
        startActivity(intent);
    }



}

