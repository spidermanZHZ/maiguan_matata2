package com.example.administrator.matata_android.homepage.fragments;

import android.view.MotionEvent;
import android.view.View;

import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.zhzbase.base.BaseFragment;

/**
 * 课程详情里课程目录
 */
public class CourseDetailsCatalogFragment extends BaseFragment {
    @Override
    protected int initLayoutId() {
        return R.layout.fragment_course_details_catalog;
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
