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
import com.example.administrator.matata_android.bean.ArtCampATListBean;

import java.util.List;

/**
 * 艺术营地全部活动适配器
 */
public class  ArtCampAtListAdapter extends  BaseQuickAdapter<ArtCampATListBean.data,BaseViewHolder>{

    private Context mContext;
    private final String URL="https://www.maiguanjy.com/";

    public ArtCampAtListAdapter(Context context, int layoutResId, @Nullable List<ArtCampATListBean.data> data) {
        super(layoutResId, data);
        this.mContext=context;
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper,ArtCampATListBean.data item) {

        //设置图片圆角角度
        RoundedCorners roundedCorners=new RoundedCorners(10);
        //通过RequestOptions扩展功能
        RequestOptions options=RequestOptions.bitmapTransform(roundedCorners).override(300,300);
        //加载图片
        Glide.with(mContext)
                .load(URL+item.getCover_pic())
                .apply(options)
                .into((ImageView)helper.getView(R.id.iv_art_camp_hot));

        helper.setText(R.id.tv_art_camp_hot_title,item.getName());//名称
        helper.setText(R.id.tv_art_camp_hot_description,item.getDescription());//简介
        try {
            String pricestr=item.getPrice().get(0);
            int a= Integer.parseInt(pricestr);
            int b=a/100;
            String pricestr2=String.valueOf(b);
            String price="热销价：¥"+pricestr2+"("+item.getAttribute().get(0)+")";
            helper.setText(R.id.tv_art_camp_hot_price,price);
        }catch (Exception e){

        }

    }
}
