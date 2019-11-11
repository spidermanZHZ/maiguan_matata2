package com.example.administrator.matata_android.homepage.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.MusicHotBean;
import com.example.administrator.matata_android.homepage.activitys.CourseDetailsTwoActivity;
import com.example.administrator.matata_android.homepage.activitys.TheatreCollageCourseDetailsActivity;
import com.loonggg.rvbanner.lib.RecyclerViewBanner;

import java.util.ArrayList;
import java.util.List;

import static com.blankj.utilcode.util.ActivityUtils.startActivity;

/**
 * 单行布局
 */
public class SingleLayoutHelperAdapter extends DelegateAdapter.Adapter<SingleLayoutHelperAdapter.SingleLayoutHelperViewHolder> {

    private Context mContext;
    private List<MusicHotBean> musicHotBeans;
    private LayoutHelper mHelper;
    private MusicHotAdapter hotAdapter;
    private ArtCampAtPicAdapter adapter;//修改画廊布局的适配器
    private static final String URL="https://www.maiguanjy.com/";

    public SingleLayoutHelperAdapter(Context mContext, List<MusicHotBean> musicHotBeans, LayoutHelper mHelper) {
        this.mContext = mContext;
        this.musicHotBeans = musicHotBeans;
        this.mHelper = mHelper;
    }

    /**
     * 添加数据
     * @param musicHotBeanData
     */
     public void addData(List<MusicHotBean> musicHotBeanData){
        this.musicHotBeans=musicHotBeanData;
        notifyDataSetChanged();
    }
    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mHelper;
    }

    @NonNull
    @Override
    public SingleLayoutHelperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.adapter_music_three_single_view,parent,false);
        return new SingleLayoutHelperViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SingleLayoutHelperViewHolder holder, int position) {

        final List<Banner> banners = new ArrayList<>();
        if (musicHotBeans!=null){
            for (int i = 0; i < musicHotBeans.size(); i++) {
                banners.add(new Banner( URL+musicHotBeans.get(i).getCover_pic()));
            }
        }
        hotAdapter = new MusicHotAdapter(mContext, R.layout.adapter_music_hot, musicHotBeans);

       // holder.recyclerCoverFlow.setAdapter(hotAdapter);


           holder.recyclerCoverFlow.setRvBannerData(banners);
           holder.recyclerCoverFlow.setOnSwitchRvBannerListener(new RecyclerViewBanner.OnSwitchRvBannerListener() {
               @Override
               public void switchBanner(int position, AppCompatImageView bannerView) {
                   //设置图片圆角角度
                   RoundedCorners roundedCorners = new RoundedCorners(10);
                   //通过RequestOptions扩展功能
                   RequestOptions options = RequestOptions.bitmapTransform(roundedCorners).override(300, 300);
                   Glide.with(bannerView.getContext())
                           .load(banners.get(position).getUrl())
                           .apply(options)
                           .placeholder(R.mipmap.ic_launcher)
                           .into(bannerView);
               }
           });
            holder.recyclerCoverFlow.setOnRvBannerClickListener(new RecyclerViewBanner.OnRvBannerClickListener() {
                @Override
                public void onClick(int position) {
                   if (musicHotBeans.get(position).getType().equals("online")){
                       Intent intent = new Intent(mContext, CourseDetailsTwoActivity.class);
                       intent.putExtra("onlineId",musicHotBeans.get(position).getId());
                       startActivity(intent);
                   }else {
                       Intent intent = new Intent(mContext, TheatreCollageCourseDetailsActivity.class);
                       intent.putExtra("offlineId",musicHotBeans.get(position).getId());
                       startActivity(intent);
                   }

                }
            });



        hotAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(mContext, CourseDetailsTwoActivity.class);
                intent.putExtra("onlineId",musicHotBeans.get(position).getId());
                startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class SingleLayoutHelperViewHolder extends RecyclerView.ViewHolder{
        private RecyclerViewBanner recyclerCoverFlow;
        public SingleLayoutHelperViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerCoverFlow=(RecyclerViewBanner)itemView.findViewById(R.id.music_three_cover_flow_rv);
        }
    }
    private class Banner {
        String url;

        public Banner(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
