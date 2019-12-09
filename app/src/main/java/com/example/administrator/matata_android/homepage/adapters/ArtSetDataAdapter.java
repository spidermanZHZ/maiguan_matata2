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
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.TheatreCourseDetailsBean;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArtSetDataAdapter extends RecyclerView.Adapter<ArtSetDataAdapter.SingleLayoutHelperViewHolder> {

    private Context mContext;
    private LayoutHelper mHelper;
    private TheatreCourseDetailsBean theatreCourseDetailsBean;
    private final static String URL="https://www.maiguanjy.com/";

    public interface  OnItemClickListener{
        void onItemClick(View view, int position);
        void onLongItemClick(View view, int position);
    }
    public OnItemClickListener mOnItemClickListenre;//设置点击事件

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListenre=onItemClickListener;
    }


    public ArtSetDataAdapter(Context mContext, TheatreCourseDetailsBean theatreCourseDetailsBean) {
        this.mContext = mContext;
        this.theatreCourseDetailsBean = theatreCourseDetailsBean;
    }
    public  void addData(TheatreCourseDetailsBean theatreCourseDetailsBean){
        this.theatreCourseDetailsBean=theatreCourseDetailsBean;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SingleLayoutHelperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_music_online, parent, false);
        return new SingleLayoutHelperViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SingleLayoutHelperViewHolder holder, int position) {

        if (mOnItemClickListenre!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListenre.onItemClick(holder.itemView,position);
                }
            });
        }

        if (theatreCourseDetailsBean!=null){
            //设置图片圆角角度
            RoundedCorners roundedCorners=new RoundedCorners(10);
            //通过RequestOptions扩展功能
            RequestOptions options=RequestOptions.bitmapTransform(roundedCorners).override(300,300);
            //加载图片
            Glide.with(mContext)
                    .load(URL+theatreCourseDetailsBean.getData().get(position).getCover_pic())
                    .apply(options)
                    .into(holder.musicAdapterCoverIv);
            holder.musicAdapterTvTitle.setText(theatreCourseDetailsBean.getData().get(position).getName());


            if (theatreCourseDetailsBean.getData().get(position).getTeacher()!=null){
                holder.musicAdapterTvAchievement.setText(String.valueOf(theatreCourseDetailsBean.getData().get(position).getTeacher().getGrade()+"|"+theatreCourseDetailsBean.getData().get(position).getTeacher().getCertification()));
              }else {
                holder.musicAdapterTvAchievement.setText("暂无数据");
            }
                holder.musicAdapterTvIntroduce.setText(theatreCourseDetailsBean.getData().get(position).getDescription());

        }

    }


    @Override
    public int getItemCount() {
        if (theatreCourseDetailsBean!=null){
            return theatreCourseDetailsBean.getData().size();
        }
        return 0;
    }


    class SingleLayoutHelperViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.music_adapter_cover_iv)
        ImageView musicAdapterCoverIv;
        @BindView(R.id.music_adapter_tv_title)
        TextView musicAdapterTvTitle;
        @BindView(R.id.music_adapter_tv_achievement)
        TextView musicAdapterTvAchievement;
        @BindView(R.id.music_adapter_tv_introduce)
        TextView musicAdapterTvIntroduce;

        public SingleLayoutHelperViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
