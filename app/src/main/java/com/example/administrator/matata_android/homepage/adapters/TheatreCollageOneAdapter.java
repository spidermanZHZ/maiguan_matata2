package com.example.administrator.matata_android.homepage.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.bumptech.glide.Glide;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.HomepagerTeacherBean;
import com.example.administrator.matata_android.bean.TheatreHotInfoBean;
import com.example.administrator.matata_android.homepage.Banner;
import com.example.administrator.matata_android.homepage.activitys.TheatreCollageCourseDetailsActivity;
import com.loonggg.rvbanner.lib.RecyclerViewBanner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.blankj.utilcode.util.ActivityUtils.startActivity;

/**
 * 首页装载推荐老师适配器
 */
public class TheatreCollageOneAdapter extends DelegateAdapter.Adapter<TheatreCollageOneAdapter.TheatreCollageOneAdapterViewHolder> {
    private Context mContext;
    private LayoutHelper layoutHelper;
    private TheatreHotInfoBean theatreHotInfoBeans;
    private static final String URL="https://www.maiguanjy.com/";

    public void addData(TheatreHotInfoBean theatreHotInfoBean){
        this.theatreHotInfoBeans=theatreHotInfoBean;
        notifyDataSetChanged();

    }

    public TheatreCollageOneAdapter(Context mContext, LayoutHelper layoutHelper, TheatreHotInfoBean theatreHotInfoBean) {
        this.mContext = mContext;
        this.layoutHelper = layoutHelper;
        this.theatreHotInfoBeans = theatreHotInfoBean;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public TheatreCollageOneAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_theatre_collage_one, parent, false);

        return new TheatreCollageOneAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TheatreCollageOneAdapterViewHolder holder, int i) {
        final List<Banner> banners = new ArrayList<>();
        if (theatreHotInfoBeans!=null){
            for (int j = 0; j < theatreHotInfoBeans.getCourse().size(); j++) {
                banners.add(new Banner( URL+theatreHotInfoBeans.getCourse().get(i).getCover_pic()));
            }
        }
        holder.rvHomepageTeacher.setRvBannerData(banners);
        holder.rvHomepageTeacher.setOnSwitchRvBannerListener(new RecyclerViewBanner.OnSwitchRvBannerListener() {
            @Override
            public void switchBanner(int position, AppCompatImageView bannerView) {
                Glide.with(bannerView.getContext())
                        .load(banners.get(position).getUrl())
                        .placeholder(R.mipmap.ic_launcher)
                        .into(bannerView);
            }
        });
        holder.rvHomepageTeacher.setOnRvBannerClickListener(new RecyclerViewBanner.OnRvBannerClickListener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(mContext, TheatreCollageCourseDetailsActivity.class);
                String id =String.valueOf(theatreHotInfoBeans.getCourse().get(position).getId());
                intent.putExtra("offlineId",id);
                startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class TheatreCollageOneAdapterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_mtt_hot)
        TextView tv_mtt_hot;
        @BindView(R.id.rv_homepage_teacher)
        RecyclerViewBanner rvHomepageTeacher;
        public TheatreCollageOneAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
