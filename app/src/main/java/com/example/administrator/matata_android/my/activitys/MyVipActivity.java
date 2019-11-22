package com.example.administrator.matata_android.my.activitys;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.zhzbase.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * VIP会员页面
 *'
 */
public class MyVipActivity extends BaseActivity {


    @BindView(R.id.iv_vip_card)
    ImageView ivVipCard;
    @BindView(R.id.tv_my_is_vip)
    TextView tvMyIsVip;
    @BindView(R.id.ll_vip_one)
    LinearLayout llVipOne;
    @BindView(R.id.ll_vip_two)
    LinearLayout llVipTwo;
    @BindView(R.id.ll_vip_three)
    LinearLayout llVipThree;
    @BindView(R.id.ll_vip_four)
    LinearLayout llVipFour;
    @BindView(R.id.ll_vip_five)
    LinearLayout llVipFive;
    @BindView(R.id.ll_vip_six)
    LinearLayout llVipSix;
    @BindView(R.id.ll_vip_seven)
    LinearLayout llVipSeven;
    @BindView(R.id.ll_vip_eight)
    LinearLayout llVipEight;
    @BindView(R.id.ll_vip_nine)
    LinearLayout llVipNine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_my_vip);
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

    @OnClick({R.id.tv_my_is_vip, R.id.ll_vip_one, R.id.ll_vip_two, R.id.ll_vip_three, R.id.ll_vip_four, R.id.ll_vip_five, R.id.ll_vip_six, R.id.ll_vip_seven, R.id.ll_vip_eight, R.id.ll_vip_nine})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_my_is_vip:
                break;
            case R.id.ll_vip_one:
                break;
            case R.id.ll_vip_two:
                break;
            case R.id.ll_vip_three:
                break;
            case R.id.ll_vip_four:
                break;
            case R.id.ll_vip_five:
                break;
            case R.id.ll_vip_six:
                break;
            case R.id.ll_vip_seven:
                break;
            case R.id.ll_vip_eight:
                break;
            case R.id.ll_vip_nine:
                break;
        }
    }
}
