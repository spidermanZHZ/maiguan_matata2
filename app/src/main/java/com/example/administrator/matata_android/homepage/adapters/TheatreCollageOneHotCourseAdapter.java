package com.example.administrator.matata_android.homepage.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.TheatreHotInfoBean;

import java.util.List;

public class TheatreCollageOneHotCourseAdapter extends BaseQuickAdapter<TheatreHotInfoBean.CourseBean ,BaseViewHolder> {
    private Context mContext;

    private final static String URL = "https://www.maiguanjy.com/";

    public TheatreCollageOneHotCourseAdapter(int layoutResId, @Nullable List<TheatreHotInfoBean.CourseBean> data,Context context) {
        super(layoutResId, data);
        mContext=context;
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, TheatreHotInfoBean.CourseBean item) {

        //设置图片圆角角度
        RoundedCorners roundedCorners = new RoundedCorners(10);
        //通过RequestOptions扩展功能
        RequestOptions options = RequestOptions.bitmapTransform(roundedCorners).override(300, 300);
        Glide.with(mContext)
                .load(URL+item.getCover_pic())
                .apply(options)
                .into((ImageView)helper.getView(R.id.adapter_theatre_info_iv));
        helper.setText(R.id.adapter_theatre_info_title,String.valueOf(item.getNum()));
        helper.setText(R.id.adapter_theatre_info_name,item.getName());

    }
}
