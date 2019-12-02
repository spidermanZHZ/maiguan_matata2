package com.example.administrator.matata_android.my.adapters;

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
import com.example.administrator.matata_android.bean.MyFollowBean;

import java.util.List;

/**
 * 我的收藏老师页面
 */
public class MyFollowOfflineAdapter extends BaseQuickAdapter<MyFollowBean.OfflineCourseBean,BaseViewHolder> {

    private Context mContext;
    private final static String URL="https://www.maiguanjy.com/";

    public MyFollowOfflineAdapter(Context context, int layoutResId, @Nullable List<MyFollowBean.OfflineCourseBean> data) {
        super(layoutResId, data);
        this.mContext=context;
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, MyFollowBean.OfflineCourseBean item) {
        //加载图片
        //设置图片圆角角度
        RoundedCorners roundedCorners = new RoundedCorners(10);
        //通过RequestOptions扩展功能
        RequestOptions options = RequestOptions.bitmapTransform(roundedCorners).override(300, 300);
        Glide.with(mContext)
                .load(URL+item.getOffline_course())
                .apply(options)
                .into((ImageView)helper.getView(R.id.music_adapter_cover_iv));
        helper.setText(R.id.music_adapter_tv_title,item.getOffline_course().getName());

        helper.setGone(R.id.music_adapter_tv_achievement,false);

        helper.setText(R.id.music_adapter_tv_introduce,item.getOffline_course().getDescription());

    }

}
