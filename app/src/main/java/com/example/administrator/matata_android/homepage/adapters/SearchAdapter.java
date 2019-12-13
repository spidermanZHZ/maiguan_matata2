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
import com.example.administrator.matata_android.bean.SearchBean;

import java.util.List;

public class SearchAdapter extends BaseQuickAdapter<SearchBean.AllBean,BaseViewHolder> {
    private Context mContext;
    private final static String URL="https://www.maiguanjy.com/";
    public SearchAdapter(Context context,int layoutResId, @Nullable List<SearchBean.AllBean> data) {
        super(layoutResId, data);
        this.mContext=context;
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, SearchBean.AllBean item) {
        //加载图片
        //设置图片圆角角度
        RoundedCorners roundedCorners = new RoundedCorners(10);
        //通过RequestOptions扩展功能
        RequestOptions options = RequestOptions.bitmapTransform(roundedCorners).override(300, 300);
        Glide.with(mContext)
                .load(URL+item.getImg())
                .apply(options)
                .into((ImageView)helper.getView(R.id.music_adapter_cover_iv));
        helper.setText(R.id.music_adapter_tv_title,item.getName());

        if (item.getType().equals("teacher")){
            helper.setText(R.id.music_adapter_tv_achievement,"热门老师");
        }else if (item.getType().equals("campsite")){
            helper.setText(R.id.music_adapter_tv_achievement,"营地活动");
        }else if (item.getType().equals("offline")){
            helper.setText(R.id.music_adapter_tv_achievement,"线下课程");
        }else if (item.getType().equals("online")){
            helper.setText(R.id.music_adapter_tv_achievement,"线上课程");
        }



        helper.setText(R.id.music_adapter_tv_introduce,item.getDescription());

    }
}
