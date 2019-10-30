package com.example.administrator.matata_android.homepage.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.MusicOffLineBean;
import com.example.administrator.matata_android.bean.MusicOnlineBean;

import java.util.List;

/**
 * 音乐学院线上课程适配器
 */
public class MusicOfflineAdapter extends BaseQuickAdapter<MusicOffLineBean.DataBean ,BaseViewHolder> {

    private Context mContext;
    private final String URL="https://www.maiguanjy.com/";

    public MusicOfflineAdapter(Context context, int layoutResId, @Nullable List<MusicOffLineBean.DataBean> data) {
        super(layoutResId, data);
        this.mContext=context;
    }


    @Override
    protected void convert(@NonNull BaseViewHolder helper, MusicOffLineBean.DataBean item) {
        //加载图片
        Glide.with(mContext)
                .load(URL+item.getCover_pic())
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
