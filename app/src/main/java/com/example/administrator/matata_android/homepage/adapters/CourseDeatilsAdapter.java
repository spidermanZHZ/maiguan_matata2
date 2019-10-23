package com.example.administrator.matata_android.homepage.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.MusicHotBean;
import com.example.administrator.matata_android.bean.OnLineCourseBean;

import java.util.List;

/**
 * 音乐学院最新上架适配器
 */
public class CourseDeatilsAdapter extends BaseQuickAdapter<OnLineCourseBean,BaseViewHolder> {
    private Context mContext;
    private final String URL="https://www.maiguanjy.com/";

    public CourseDeatilsAdapter(Context mContext,int layoutResId, @Nullable List<OnLineCourseBean> data) {
        super(layoutResId, data);
        this.mContext=mContext;
    }


    @Override
    protected void convert(@NonNull BaseViewHolder helper, OnLineCourseBean item) {
            //加载图片
            Glide.with(mContext)
                    .load(URL+item.getCover_pic())
                    .into((ImageView)helper.getView(R.id.adapter_course_details_pic));



    }
}
