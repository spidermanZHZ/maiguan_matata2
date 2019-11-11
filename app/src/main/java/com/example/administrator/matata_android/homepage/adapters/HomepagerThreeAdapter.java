package com.example.administrator.matata_android.homepage.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.HomepagerTeacherBean;
import com.example.administrator.matata_android.homepage.activitys.CourseDetailsTwoActivity;
import com.example.administrator.matata_android.homepage.activitys.MusicCollageThreeActivity;
import com.example.administrator.matata_android.homepage.activitys.TheatreCollageCourseDetailsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.blankj.utilcode.util.ActivityUtils.startActivity;

/**
 * 首页装载推荐课程适配器
 */
public class HomepagerThreeAdapter extends DelegateAdapter.Adapter<HomepagerThreeAdapter.HomepagerThreeAdapterViewHolder> {

    private Context mContext;
    private LayoutHelper layoutHelper;
    private HomepagerTeacherBean homepagerTeacherBean;
    private HomePagercourseHotAdapter adapter;
    public HomepagerThreeAdapter(Context mContext, LayoutHelper layoutHelper, HomepagerTeacherBean homepagerTeacherBean) {
        this.mContext = mContext;
        this.layoutHelper = layoutHelper;
        this.homepagerTeacherBean = homepagerTeacherBean;
    }
    public void addData(HomepagerTeacherBean homepagerTeacherBean){
        this.homepagerTeacherBean=homepagerTeacherBean;
        notifyDataSetChanged();

    }
    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public HomepagerThreeAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_home_pager_three, parent, false);
        return new HomepagerThreeAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomepagerThreeAdapterViewHolder holder, int i) {
        holder.homePagerMoreCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, MusicCollageThreeActivity.class));
            }
        });


        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        holder.rvHomepageCourse.setLayoutManager(linearLayoutManager);
        adapter=new HomePagercourseHotAdapter(R.layout.adapter_home_pager_course_hot,null,mContext);
        holder.rvHomepageCourse.setAdapter(adapter);
        if (homepagerTeacherBean!=null){
            adapter.addData(homepagerTeacherBean.getCourse());
            adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    if (homepagerTeacherBean.getCourse().get(position).getType().equals("online")){
                        Intent intent = new Intent(mContext, CourseDetailsTwoActivity.class);
                        String id=String.valueOf(homepagerTeacherBean.getCourse().get(position).getId());
                        intent.putExtra("onlineId",id);
                        startActivity(intent);
                    }else {
                        Intent intent = new Intent(mContext, TheatreCollageCourseDetailsActivity.class);
                        String id =String.valueOf(homepagerTeacherBean.getCourse().get(position).getId());
                        intent.putExtra("offlineId",id);
                        startActivity(intent);

                    }
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class HomepagerThreeAdapterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.home_pager_more_course)
        TextView homePagerMoreCourse;
        @BindView(R.id.rv_homepage_course)
        RecyclerView rvHomepageCourse;
        public HomepagerThreeAdapterViewHolder(@NonNull View itemView) {
            super(itemView);ButterKnife.bind(this, itemView);
        }
    }
}
