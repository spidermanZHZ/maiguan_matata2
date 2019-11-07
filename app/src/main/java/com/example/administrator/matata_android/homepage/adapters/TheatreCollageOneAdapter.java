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
import com.example.administrator.matata_android.bean.TheatreHotInfoBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 首页装载推荐老师适配器
 */
public class TheatreCollageOneAdapter extends DelegateAdapter.Adapter<TheatreCollageOneAdapter.TheatreCollageOneAdapterViewHolder> {
    private Context mContext;
    private LayoutHelper layoutHelper;
    private TheatreHotInfoBean theatreHotInfoBeans;
    private TheatreCollageOneHotCourseAdapter adapter;

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

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        holder.rvHomepageTeacher.setLayoutManager(linearLayoutManager);
        adapter=new TheatreCollageOneHotCourseAdapter(R.layout.adapter_theatre_hot_info,null,mContext);
        holder.rvHomepageTeacher.setAdapter(adapter);
        if (theatreHotInfoBeans!=null){
            adapter.addData(theatreHotInfoBeans.getCourse());
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class TheatreCollageOneAdapterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_mtt_hot)
        TextView tv_mtt_hot;
        @BindView(R.id.rv_homepage_teacher)
        RecyclerView rvHomepageTeacher;
        public TheatreCollageOneAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
