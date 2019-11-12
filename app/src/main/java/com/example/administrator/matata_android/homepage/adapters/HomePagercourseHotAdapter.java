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
import com.example.administrator.matata_android.bean.HomepagerTeacherBean;
import com.example.administrator.matata_android.bean.MusicHotBean;

import java.util.List;

/**
 * 音乐学院最新上架适配器
 */
public class HomePagercourseHotAdapter extends BaseQuickAdapter<HomepagerTeacherBean.CourseBean,BaseViewHolder> {
    private Context mContext;
    private final String URL="https://www.maiguanjy.com/";

    public HomePagercourseHotAdapter(int layoutResId, @Nullable List<HomepagerTeacherBean.CourseBean> data,Context context) {
        super(layoutResId, data);
        this.mContext=context;
    }


    @Override
    protected void convert(@NonNull BaseViewHolder helper, HomepagerTeacherBean.CourseBean item) {
        //设置图片圆角角度
        RoundedCorners roundedCorners = new RoundedCorners(10);
        //通过RequestOptions扩展功能
        RequestOptions options = RequestOptions.bitmapTransform(roundedCorners).override(300, 300);
        //加载图片
        Glide.with(mContext)
                .load(URL+item.getCover_pic())
                .apply(options)
                .into((ImageView)helper.getView(R.id.adapter_home_pager_course_hot_iv));

        helper.setText(R.id.adapter_home_pager_course_hot_title,item.getName());

        if (item.getType().equals("online")){
            helper.setText(R.id.adapter_home_pager_course_hot_achievement,"线上课程");
        }else if (item.getType().equals("offline")){
            helper.setText(R.id.adapter_home_pager_course_hot_achievement,"线下课程");
        }else if (item.getType().equals("drama")){
            helper.setText(R.id.adapter_home_pager_course_hot_achievement,"戏剧课程");
        }

        helper.setText(R.id.adapter_home_pager_course_hot_introduce,item.getDescription());



    }
}
