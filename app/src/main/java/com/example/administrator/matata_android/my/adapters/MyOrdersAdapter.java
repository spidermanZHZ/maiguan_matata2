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
import com.example.administrator.matata_android.bean.MyOrderBean;

import java.util.List;

public class MyOrdersAdapter  extends BaseQuickAdapter<MyOrderBean.AllBean,BaseViewHolder>{
    private Context mContext;
    private final static String URL="https://www.maiguanjy.com/";


    public MyOrdersAdapter(Context context,int layoutResId, @Nullable List<MyOrderBean.AllBean> data) {
        super(layoutResId, data);
        this.mContext=context;

    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, MyOrderBean.AllBean item) {

        //加载图片
        //设置图片圆角角度
        RoundedCorners roundedCorners = new RoundedCorners(10);
        //通过RequestOptions扩展功能
        RequestOptions options = RequestOptions.bitmapTransform(roundedCorners).override(300, 300);
        Glide.with(mContext)
                .load(URL+item.getImage())
                .apply(options)
                .into((ImageView)helper.getView(R.id.music_adapter_cover_iv));
        helper.setText(R.id.music_adapter_tv_title,item.getName());

        double a=(double) item.getPrice()/100;
        helper.setText(R.id.music_adapter_tv_introduce,"合计：¥"+a);
        if (item.getStatus().equals("0")){
            helper.setText(R.id.music_adapter_tv_achievement,"订单状态：未完成支付");
        }else if (item.getStatus().equals("1")){
            helper.setText(R.id.music_adapter_tv_achievement,"订单状态：已完成支付");
        }


    }
}
