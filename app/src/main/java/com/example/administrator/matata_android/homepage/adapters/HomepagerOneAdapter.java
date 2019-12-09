package com.example.administrator.matata_android.homepage.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.HomepagerTeacherBean;
import com.example.administrator.matata_android.homepage.activitys.ArtCampActivity;
import com.example.administrator.matata_android.homepage.activitys.ArtSetActivity;
import com.example.administrator.matata_android.homepage.activitys.CourseDetailsTwoActivity;
import com.example.administrator.matata_android.homepage.activitys.MusicCollageThreeActivity;
import com.example.administrator.matata_android.homepage.activitys.TheatreCollageActivity;
import com.example.administrator.matata_android.homepage.activitys.TheatreCollageCourseDetailsActivity;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.bgabanner.BGABanner;

import static com.blankj.utilcode.util.ActivityUtils.startActivity;

/**
 * 首页装载轮播图适配器,以及按钮
 */
public class HomepagerOneAdapter extends DelegateAdapter.Adapter<HomepagerOneAdapter.HomepagerOneAdapterViewHolder> {
    private Context mContext;
    private LayoutHelper layoutHelper;
    private HomepagerTeacherBean homepagerTeacherBeans;
    private final static String URL = "https://www.maiguanjy.com/";

    public HomepagerOneAdapter(Context mContext, LayoutHelper layoutHelper, HomepagerTeacherBean homepagerTeacherBean) {
        this.mContext = mContext;
        this.layoutHelper = layoutHelper;
        this.homepagerTeacherBeans = homepagerTeacherBean;
    }

    public void addData(HomepagerTeacherBean homepagerTeacherBean) {
        this.homepagerTeacherBeans = homepagerTeacherBean;
        notifyDataSetChanged();

    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public HomepagerOneAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_home_pager_one_banner, parent, false);
        return new HomepagerOneAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomepagerOneAdapterViewHolder holder, int position) {

        holder.bannerGuideContent.setAdapter(new BGABanner.Adapter<ImageView, String>() {
            @Override
            public void fillBannerItem(BGABanner banner, ImageView itemView, @Nullable String url, int position) {

                //设置图片圆角角度
                RoundedCorners roundedCorners = new RoundedCorners(10);
                //通过RequestOptions扩展功能
                RequestOptions options = RequestOptions.bitmapTransform(roundedCorners).override(300, 300);
                Glide.with(mContext)
                        .load(url)
                        .apply(options)
                        .into(itemView);
            }
        });
        //添加网络图片
        //List<String> urls=new ArrayList<String>();
        if (homepagerTeacherBeans != null) {
            //urls.add(URL+homepagerTeacherBeans.getBanner().get(0).getImg());
            holder.bannerGuideContent.setData(Arrays.asList(URL + homepagerTeacherBeans.getBanner().get(0).getImg(), URL + homepagerTeacherBeans.getBanner().get(1).getImg(), URL + homepagerTeacherBeans.getBanner().get(2).getImg()), Arrays.asList(homepagerTeacherBeans.getBanner().get(0).getName(), homepagerTeacherBeans.getBanner().get(1).getName(), homepagerTeacherBeans.getBanner().get(2).getName()));
        }
        //点击事件
        holder.bannerGuideContent.setDelegate(new BGABanner.Delegate<ImageView, String>() {
            @Override
            public void onBannerItemClick(BGABanner banner, ImageView itemView, @Nullable String model, int position) {

                if (homepagerTeacherBeans.getBanner().get(position).getSub().equals("JXKC")){
                    Intent intent = new Intent(mContext, CourseDetailsTwoActivity.class);
                    String id=String.valueOf(homepagerTeacherBeans.getBanner().get(position).getId());
                    intent.putExtra("onlineId",id);
                    startActivity(intent);
                }else if (homepagerTeacherBeans.getBanner().get(position).getSub().equals("OFFJXKC")){
                    Intent intent = new Intent(mContext, TheatreCollageCourseDetailsActivity.class);
                    String id =String.valueOf(homepagerTeacherBeans.getBanner().get(position).getId());
                    intent.putExtra("offlineId",id);
                    startActivity(intent);
                }else if(homepagerTeacherBeans.getBanner().get(position).getSub().equals("DRAMA")){
                    Intent intent = new Intent(mContext, TheatreCollageCourseDetailsActivity.class);
                    String id =String.valueOf(homepagerTeacherBeans.getBanner().get(position).getId());
                    intent.putExtra("offlineId",id);
                    startActivity(intent);
                }




            }
        });

        //音乐学院
        holder.llHomepageMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, MusicCollageThreeActivity.class));
            }
        });
        //戏剧学院
        holder.llHomepageTheatre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, TheatreCollageActivity.class));
            }
        });
        //艺术营地
        holder.llHomepageArtCamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, ArtCampActivity.class));
            }
        });
        //考级报名
        holder.llHomepageGrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "该功能暂未开通", Toast.LENGTH_SHORT).show();
            }
        });
        //艺术定制
        holder.homePagerSetArtIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ArtSetActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class HomepagerOneAdapterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.banner_guide_content)
        BGABanner bannerGuideContent;
        @BindView(R.id.ll_homepage_music)
        LinearLayout llHomepageMusic;
        @BindView(R.id.ll_homepage_theatre)
        LinearLayout llHomepageTheatre;
        @BindView(R.id.ll_homepage_art_camp)
        LinearLayout llHomepageArtCamp;
        @BindView(R.id.ll_homepage_grade)
        LinearLayout llHomepageGrade;
        @BindView(R.id.home_pager_set_art_iv)
        ImageView homePagerSetArtIv;
        public HomepagerOneAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
