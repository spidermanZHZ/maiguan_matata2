package com.example.administrator.matata_android.homepage.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.HomepagerTeacherBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 首页装载推荐老师适配器
 */
public class TheatreCollageTwoAdapter extends DelegateAdapter.Adapter<TheatreCollageTwoAdapter.HomepagerTwoAdapterViewHolder> {
    private Context mContext;
    private LayoutHelper layoutHelper;
    private HomepagerTeacherBean homepagerTeacherBean;
    private HomePagerTeacherInfoAdapter adapter;

    public void addData(HomepagerTeacherBean homepagerTeacherBean){
        this.homepagerTeacherBean=homepagerTeacherBean;
        notifyDataSetChanged();

    }

    public TheatreCollageTwoAdapter(Context mContext, LayoutHelper layoutHelper, HomepagerTeacherBean homepagerTeacherBean) {
        this.mContext = mContext;
        this.layoutHelper = layoutHelper;
        this.homepagerTeacherBean = homepagerTeacherBean;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public HomepagerTwoAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_theatre_collage_two, parent, false);

        return new HomepagerTwoAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomepagerTwoAdapterViewHolder holder, int i) {

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        holder.rvHomepageTeacher.setLayoutManager(linearLayoutManager);
        adapter=new HomePagerTeacherInfoAdapter(R.layout.adapter_home_pager_teacher_info,null,mContext);
        holder.rvHomepageTeacher.setAdapter(adapter);
        if (homepagerTeacherBean!=null){
            adapter.addData(homepagerTeacherBean.getTeacher());
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class HomepagerTwoAdapterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.home_pager_more_teacher)
        TextView homePagerMoreTeacher;
        @BindView(R.id.rv_homepage_teacher)
        RecyclerView rvHomepageTeacher;
        public HomepagerTwoAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
