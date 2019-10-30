package com.example.administrator.matata_android.homepage.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.bumptech.glide.Glide;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.MusicOffLineBean;
import com.example.administrator.matata_android.bean.MusicOnlineBean;

import java.net.URL;
import java.util.List;

/**
 * 正常布局
 */
public class LinearHelperAdapter extends DelegateAdapter.Adapter<LinearHelperAdapter.LinearHelperAdapterViewHolder> {
    private static final String URL="https://www.maiguanjy.com/";
    private Context mContext;
    private LayoutHelper layoutHelper;
    private MusicOnlineBean musicOnlineBean;
    private MusicOffLineBean musicOffLineBean;
    private boolean isOnline;

    public LinearHelperAdapter(Context mContext, LayoutHelper layoutHelper,boolean isOnline) {
        this.mContext = mContext;
        this.layoutHelper = layoutHelper;
        this.isOnline=isOnline;
    }

    /**
     * 获取线上课程
     * @return
     */
    public void addOnlineData( MusicOnlineBean musicOnlineBean){
        this.musicOnlineBean=musicOnlineBean;
        notifyDataSetChanged();
    }
    /**
     * 获取线上课程
     * @return
     */
    public void addOfflineData(MusicOffLineBean musicOfflineBean){
        this.musicOffLineBean=musicOfflineBean;
        notifyDataSetChanged();
    }

    /**
     * 设置展示线上数据
     * @param isOnline
     */
    public void setOnline(boolean isOnline){
        this.isOnline=isOnline;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public LinearHelperAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(mContext).inflate(R.layout.adapter_music_online,null);
        return new LinearHelperAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LinearHelperAdapterViewHolder helper, int position) {
        if (isOnline){
            //加载图片
            Glide.with(mContext)
                    .load(URL+musicOnlineBean.getData().get(position).getCover_pic())
                    .into(helper.imageView);

            helper.title.setText(musicOnlineBean.getData().get(position).getName());

            if (musicOnlineBean.getData().get(position).getTeacher()!=null){
                helper.achievement.setText(String.valueOf(musicOnlineBean.getData().get(position).getTeacher().getGrade()+" | "+musicOnlineBean.getData().get(position).getTeacher().getCertification()));
            }else {
                helper.achievement.setText("暂无数据");
            }
            helper.introduce.setText(musicOnlineBean.getData().get(position).getDescription());
        }else {
            //加载图片
            Glide.with(mContext)
                    .load(URL+musicOffLineBean.getData().get(position).getCover_pic())
                    .into(helper.imageView);

            helper.title.setText(musicOffLineBean.getData().get(position).getName());

            if (musicOffLineBean.getData().get(position).getTeacher()!=null){
                helper.achievement.setText(String.valueOf(musicOffLineBean.getData().get(position).getTeacher().getGrade()+" | "+musicOffLineBean.getData().get(position).getTeacher().getCertification()));
            }else {
                helper.achievement.setText("暂无数据");
            }
            helper.introduce.setText(musicOffLineBean.getData().get(position).getDescription());
        }


    }

    @Override
    public int getItemCount() {
        if (musicOnlineBean!=null){
            return musicOnlineBean.getData().size();
        }
        return 0;
    }

    class LinearHelperAdapterViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView title;
        private TextView achievement;
        private TextView introduce;
        public LinearHelperAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.music_adapter_cover_iv);
            title=(TextView)itemView.findViewById(R.id.music_adapter_tv_title);
            achievement=(TextView)itemView.findViewById(R.id.music_adapter_tv_achievement);
            introduce=(TextView)itemView.findViewById(R.id.music_adapter_tv_introduce);
        }
    }
}
