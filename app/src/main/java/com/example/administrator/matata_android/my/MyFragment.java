package com.example.administrator.matata_android.my;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.UserInfoBean;
import com.example.administrator.matata_android.httputils.BaseObserver;
import com.example.administrator.matata_android.httputils.RetrofitUtil;
import com.example.administrator.matata_android.my.activitys.ChangeUserInfoActivity;
import com.example.administrator.matata_android.my.activitys.MyExtendActivity;
import com.example.administrator.matata_android.my.activitys.MyFollowActivity;
import com.example.administrator.matata_android.my.activitys.MyFriendActivity;
import com.example.administrator.matata_android.my.activitys.MyMessageActivity;
import com.example.administrator.matata_android.my.activitys.MyOrdersActivity;
import com.example.administrator.matata_android.my.activitys.MySetActivity;
import com.example.administrator.matata_android.my.activitys.MyVipActivity;
import com.example.administrator.matata_android.zhzbase.base.BaseViewNeedSetFragment;
import com.example.administrator.matata_android.zhzbase.dialog.CustomDialog;
import com.example.administrator.matata_android.zhzbase.dialog.TextDialog;
import com.example.administrator.matata_android.zhzbase.utils.MatataSPUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MyFragment extends BaseViewNeedSetFragment {

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
    @BindView(R.id.add_friend)
    LinearLayout addFriend;
    @BindView(R.id.user_head)
    ImageView userHead;

    private TextDialog textDialog;
    private CustomDialog customDialog;
    private BaseObserver<UserInfoBean> userInfoBeanBaseObserver;
    private static final String URL = "https://www.maiguanjy.com/";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);

        unbinder = ButterKnife.bind(this, view);

        initData();
        return view;
    }

    public void initData() {
        if (MatataSPUtils.getUserHead()!=null){
            //加载头像
            Glide.with(getContext())
                    .load(URL + MatataSPUtils.getUserHead())
                    .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                    .into(userHead);
        }
        stuSign.setText(String.valueOf("手机号：" + MatataSPUtils.getUserName()));
        stuName.setText(String.valueOf("用户名：" + MatataSPUtils.getUserNName()));
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.stu_edit, R.id.my_ll_vip, R.id.my_ll_orders, R.id.my_ll_order, R.id.my_ll_follow, R.id.my_ll_message, R.id.my_ll_friend, R.id.ll_my_set, R.id.add_friend})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.stu_edit:
                Intent intent = new Intent(getContext(), ChangeUserInfoActivity.class);
                startActivity(intent);
                break;
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
                showProgressDialog("客服热线：0531-88821319", true);

                break;
            case R.id.ll_my_set:
                startActivity(new Intent(getContext(), MySetActivity.class));
                break;
            case R.id.add_friend:
                startActivity(new Intent(getContext(), MyFriendActivity.class));
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
        customDialog.setOnYesOnClickListener(new CustomDialog.onYesOnClickListener() {
            @Override
            public void onYesClick() {
                call("053188821319");
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

    /**
     * 调用拨号界面
     *
     * @param phone 电话号码
     */
    private void call(String phone) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    /**
     * 直接拨号
     *
     * @param phone 电话号码
     */
    private void callpast(String phone) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
        startActivity(intent);
    }


    @OnClick(R.id.add_friend)
    public void onClick() {
    }
}

