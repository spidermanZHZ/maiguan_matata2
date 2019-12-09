package com.example.administrator.matata_android.homepage.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.blankj.utilcode.util.BarUtils;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.zhzbase.base.BaseActivity;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArtsetTwoActivity extends BaseActivity {

    @BindView(R.id.rb_department1)
    RadioButton rbDepartment1;
    @BindView(R.id.rb_department2)
    RadioButton rbDepartment2;
    @BindView(R.id.rb_department3)
    RadioButton rbDepartment3;
    @BindView(R.id.rb_department4)
    RadioButton rbDepartment4;
    @BindView(R.id.rg_department)
    RadioGroup rgDepartment;
    @BindView(R.id.rb_want1)
    RadioButton rbWant1;
    @BindView(R.id.rb_want4)
    RadioButton rbWant4;
    @BindView(R.id.rb_want2)
    RadioButton rbWant2;
    @BindView(R.id.rb_want3)
    RadioButton rbWant3;
    @BindView(R.id.rg_student_want)
    RadioGroup rgStudentWant;
    @BindView(R.id.rb_price1)
    RadioButton rbPrice1;
    @BindView(R.id.rb_price2)
    RadioButton rbPrice2;
    @BindView(R.id.rb_price3)
    RadioButton rbPrice3;
    @BindView(R.id.rg_student_price)
    RadioGroup rgStudentPrice;
    @BindView(R.id.rb_action1)
    RadioButton rbAction1;
    @BindView(R.id.rb_action2)
    RadioButton rbAction2;
    @BindView(R.id.rb_action3)
    RadioButton rbAction3;
    @BindView(R.id.rb_action4)
    RadioButton rbAction4;
    @BindView(R.id.rg_student_action)
    RadioGroup rgStudentAction;
    @BindView(R.id.art_set_iv1)
    ImageView artSetIv1;
    @BindView(R.id.title_bar)
    TitleBar titleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_artset_two);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);
        BarUtils.setStatusBarColor(this, getResources().getColor(R.color.background_art_set), true);

    }

    @Override
    protected void getExras() {

    }

    @Override
    protected void initData() {
        titleBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onLeftClick(View v) {
                finishActivity();
            }

            @Override
            public void onTitleClick(View v) {

            }

            @Override
            public void onRightClick(View v) {
                Intent intent = new Intent(ArtsetTwoActivity.this,ArtSetThreeActivity.class);
                startActivity(intent);

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
