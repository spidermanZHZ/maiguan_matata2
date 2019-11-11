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
import com.example.administrator.matata_android.bean.MusicOnlineBean;

import java.util.List;

/**
 * 音乐学院线上课程适配器
 */
public class MusicOnlineAdapter extends BaseQuickAdapter<MusicOnlineBean.DataBean ,BaseViewHolder> {

    private Context mContext;
    private final static String URL="https://www.maiguanjy.com/";

    public MusicOnlineAdapter(Context context,int layoutResId, @Nullable List<MusicOnlineBean.DataBean> data) {
        super(layoutResId, data);
        this.mContext=context;
    }


    @Override
    protected void convert(@NonNull BaseViewHolder helper, MusicOnlineBean.DataBean item) {
        //加载图片
        //设置图片圆角角度
        RoundedCorners roundedCorners = new RoundedCorners(10);
        //通过RequestOptions扩展功能
        RequestOptions options = RequestOptions.bitmapTransform(roundedCorners).override(300, 300);
        Glide.with(mContext)
                .load(URL+item.getCover_pic())
                .apply(options)
                .into((ImageView)helper.getView(R.id.music_adapter_cover_iv));
        helper.setText(R.id.music_adapter_tv_title,item.getName());
        if (item.getTeacher()!=null){
            helper.setText(R.id.music_adapter_tv_achievement,item.getTeacher().getGrade()+" | "+item.getTeacher().getCertification());
        }else {
            helper.setText(R.id.music_adapter_tv_achievement,"暂无数据");
        }

        helper.setText(R.id.music_adapter_tv_introduce,item.getDescription());


    }
}
