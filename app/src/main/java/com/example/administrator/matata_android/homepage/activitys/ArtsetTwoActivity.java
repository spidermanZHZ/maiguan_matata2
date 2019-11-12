package com.example.administrator.matata_android.homepage.activitys;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.zhzbase.base.BaseActivity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_artset_two);
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
}
