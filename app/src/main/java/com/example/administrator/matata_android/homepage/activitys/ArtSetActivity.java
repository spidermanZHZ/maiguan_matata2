package com.example.administrator.matata_android.homepage.activitys;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.zhzbase.base.BaseActivity;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 艺术定制页面
 */
public class ArtSetActivity extends BaseActivity {

    @BindView(R.id.rb_man)
    RadioButton rbMan;
    @BindView(R.id.rb_woman)
    RadioButton rbWoman;
    @BindView(R.id.rg_gender)
    RadioGroup rgGender;
    @BindView(R.id.student_age)
    EditText studentAge;
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
    @BindView(R.id.rb_jichu_one)
    RadioButton rbJichuOne;
    @BindView(R.id.rb_jichu_two)
    RadioButton rbJichuTwo;
    @BindView(R.id.rg_student_two)
    RadioGroup rgStudentTwo;
    @BindView(R.id.rb_type1)
    RadioButton rbType1;
    @BindView(R.id.rb_type2)
    RadioButton rbType2;
    @BindView(R.id.rb_type3)
    RadioButton rbType3;
    @BindView(R.id.rg_student_study_type)
    RadioGroup rgStudentStudyType;
    @BindView(R.id.rb_time1)
    RadioButton rbTime1;
    @BindView(R.id.rb_time2)
    RadioButton rbTime2;
    @BindView(R.id.rb_time3)
    RadioButton rbTime3;
    @BindView(R.id.rg_student_study_t)
    RadioGroup rgStudentStudyT;
    @BindView(R.id.art_set_iv1)
    ImageView artSetIv1;
    @BindView(R.id.title_bar)
    TitleBar titleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_art_set);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void getExras() {

    }

    @Override
    protected void initData() {
        titleBar.setOnTitleBarListener(new OnTitleBarListener() {
    @Override
    public void onLeftClick(View v) {

    }

    @Override
    public void onTitleClick(View v) {

    }

    @Override
    public void onRightClick(View v) {
        Intent intent = new Intent(ArtSetActivity.this,ArtsetTwoActivity.class);
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
