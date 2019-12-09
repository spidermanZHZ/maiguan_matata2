package com.example.administrator.matata_android.my.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;

import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.MyExtendBean;
import com.example.administrator.matata_android.zhzbase.base.BaseFragment;

public class MyExtendTeacherFragment extends BaseFragment {
    private MyExtendBean myExtendBean;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            myExtendBean=(MyExtendBean)bundle.getSerializable("MyExtendTeacherFragment");
        }
    }

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_extend1;
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
}
