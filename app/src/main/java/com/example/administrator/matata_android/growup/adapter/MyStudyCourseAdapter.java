package com.example.administrator.matata_android.growup.adapter;

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
import com.example.administrator.matata_android.bean.MyCourseBean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 学习中的课程适配器
 */
public class MyStudyCourseAdapter extends BaseQuickAdapter<MyCourseBean.AllBean ,BaseViewHolder> {

    private Context mContext;
    private final static String URL="https://www.maiguanjy.com/";

    public MyStudyCourseAdapter(Context context, int layoutResId, @Nullable List<MyCourseBean.AllBean> data) {
        super(layoutResId, data);
        this.mContext=context;
    }


    @Override
    protected void convert(@NonNull BaseViewHolder helper, MyCourseBean.AllBean item) {
        if (item!=null){
            //加载图片
            //设置图片圆角角度
            RoundedCorners roundedCorners = new RoundedCorners(10);
            //通过RequestOptions扩展功能
            RequestOptions options = RequestOptions.bitmapTransform(roundedCorners).override(300, 300);
            Glide.with(mContext)
                    .load(URL+item.getCourse().getCover_pic())
                    .apply(options)
                    .into((ImageView)helper.getView(R.id.music_adapter_cover_iv));
            helper.setText(R.id.music_adapter_tv_title,item.getCourse().getName());

            if (item.getCourse_type().equals("00")){
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try
                {
                    Date d1 = df.parse(item.getCreateDt());
                    Date d2 = new Date(System.currentTimeMillis());//你也可以获取当前时间
                    long diff = d1.getTime() - d2.getTime();//这样得到的差值是微秒级别
                    long days = diff / (1000 * 60 * 60 * 24);

//            long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
//            long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);
//            System.out.println(""+days+"天"+hours+"小时"+minutes+"分");
                    helper.setText(R.id.music_adapter_tv_achievement,"已学习"+days+1+"天");
                }
                catch (Exception e)
                {
                }

            }else {
                helper.setText(R.id.music_adapter_tv_achievement,"剩余上课次数"+"10"+"次");
            }




            helper.setText(R.id.music_adapter_tv_introduce,item.getCourse().getDescription());


        }


    }
}
