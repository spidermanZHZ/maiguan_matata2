package com.example.administrator.matata_android.homepage.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.HomepagerTeacherBean;

import java.util.List;

public class HomePagerTeacherInfoAdapter  extends BaseQuickAdapter<HomepagerTeacherBean.TeacherBean ,BaseViewHolder> {
    private Context context;
    private final String URL="https://www.maiguanjy.com/";
    public HomePagerTeacherInfoAdapter(int layoutResId, @Nullable List<HomepagerTeacherBean.TeacherBean> data,Context context) {
        super(layoutResId, data);
        this.context=context;
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, HomepagerTeacherBean.TeacherBean item) {

        //加载图片
        Glide.with(mContext)
                .load(URL+item.getHead_pic())
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into((ImageView)helper.getView(R.id.adapter_teacher_info_iv));
            helper.setText(R.id.adapter_teacher_info_name,String.valueOf(item.getName()));
            helper.setText(R.id.adapter_teacher_info_title,String.valueOf(item.getMajor()));

    }
}
