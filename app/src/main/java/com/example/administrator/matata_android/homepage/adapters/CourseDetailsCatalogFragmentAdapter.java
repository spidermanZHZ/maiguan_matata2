package com.example.administrator.matata_android.homepage.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.OnLineCourseBean;

import org.w3c.dom.Text;

import java.util.List;

/**
 * 课程详情课程目录adapter
 */
public class CourseDetailsCatalogFragmentAdapter extends BaseQuickAdapter<OnLineCourseBean.CatalogBean,BaseViewHolder>{

    public CourseDetailsCatalogFragmentAdapter(int layoutResId, @Nullable List<OnLineCourseBean.CatalogBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, OnLineCourseBean.CatalogBean item) {

        helper.setText(R.id.course_details_catalog_name,item.getName());
        helper.setText(R.id.course_details_catalog_all_time,"时长："+item.getVideo_time_length());
        if (item.getIs_audition().equals("1")){
            helper.setImageResource(R.id.course_details_catalog_iv, R.mipmap.video_true);
        }else {
            helper.setImageResource(R.id.course_details_catalog_iv, R.mipmap.video_false);
        }

    }




}
