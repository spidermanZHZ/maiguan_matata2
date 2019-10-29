package com.example.administrator.matata_android.homepage.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.OnLineCourseBean;

import java.util.List;

/**
 * 课程评价适配器
 */
public class CourseDetailsRemarkFragmentAdapter extends BaseQuickAdapter<OnLineCourseBean.EvaluateBean,BaseViewHolder> {
    private Context context;

    public CourseDetailsRemarkFragmentAdapter( Context context,int layoutResId, @Nullable List<OnLineCourseBean.EvaluateBean> data) {
        super(layoutResId, data);
        this.context=context;
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, OnLineCourseBean.EvaluateBean item) {

        helper.setText(R.id.course_details_remark_name,String.valueOf(item.getFd_user_name()));
        helper.setText(R.id.course_details_remark_time,String.valueOf(item.getEvaluate_time()));
        helper.setText(R.id.course_details_remark_evaluate_content,String.valueOf(item.getEvaluate_content()));

    }
}
