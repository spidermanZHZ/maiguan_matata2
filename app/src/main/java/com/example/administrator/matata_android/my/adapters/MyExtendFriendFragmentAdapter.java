package com.example.administrator.matata_android.my.adapters;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.MyExtendBean;

import java.util.List;

public class MyExtendFriendFragmentAdapter extends BaseQuickAdapter<MyExtendBean.DistributionBean,BaseViewHolder> {
    private final String URL="https://www.maiguanjy.com/";
    public MyExtendFriendFragmentAdapter(int layoutResId, @Nullable List<MyExtendBean.DistributionBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, MyExtendBean.DistributionBean item) {
        //设置图片圆角角度
        RoundedCorners roundedCorners=new RoundedCorners(10);
        //通过RequestOptions扩展功能
        RequestOptions options=RequestOptions.bitmapTransform(roundedCorners).override(300,300);
        //加载图片
        Glide.with(mContext)
                .load(URL+item.getHead_file())
                .apply(options)
                .into((ImageView)helper.getView(R.id.iv_extend_friend_head));
        helper.setText(R.id.iv_extend_friend_name,item.getNickname());
        if (item.getSex().equals("1")){
            helper.setText(R.id.iv_extend_friend_sex,"男生");
        }else {
            helper.setText(R.id.iv_extend_friend_sex,"女生");
        }
        if (item.getSign_date()!=null){
            helper.setText(R.id.iv_extend_friend_sign,String.valueOf(item.getSign_date()));
        }else {
            helper.setText(R.id.iv_extend_friend_sign,"这个人没有填写简介");
        }


    }
}
