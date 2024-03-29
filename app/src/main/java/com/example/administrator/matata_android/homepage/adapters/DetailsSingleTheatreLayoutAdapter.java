package com.example.administrator.matata_android.homepage.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.OnLineCourseBean;
import com.example.administrator.matata_android.bean.TheatreCourseDetailsBean;

import recycler.coverflow.RecyclerCoverFlow;

/**
 * 课程详情适配器
 */
public class DetailsSingleTheatreLayoutAdapter extends DelegateAdapter.Adapter<DetailsSingleTheatreLayoutAdapter.DetailsSingleLayoutAdapterViewHolder> {

    private Context mContext;
    private LayoutHelper mHelper;

    private TheatreCourseDetailsBean theatreCourseDetailsBean;
    private ArtCampAtPicAdapter adapter;

    public DetailsSingleTheatreLayoutAdapter(Context mContext, LayoutHelper mHelper, TheatreCourseDetailsBean theatreCourseDetailsBean) {
        this.mContext = mContext;
        this.mHelper = mHelper;
        this.theatreCourseDetailsBean = theatreCourseDetailsBean;
    }

    /**
     * 添加数据
     * @param theatreCourseDetailsBean
     */
    public void addData(TheatreCourseDetailsBean  theatreCourseDetailsBean){
        this.theatreCourseDetailsBean=theatreCourseDetailsBean;
        notifyDataSetChanged();
    }


    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mHelper;
    }

    @NonNull
    @Override
    public DetailsSingleLayoutAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.adapter_details_single_view,parent,false);
        return new DetailsSingleLayoutAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsSingleLayoutAdapterViewHolder holder, int position) {
        adapter = new ArtCampAtPicAdapter(mContext, null);
        holder.recyclerCoverFlow.setAdapter(adapter);


    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class DetailsSingleLayoutAdapterViewHolder extends RecyclerView.ViewHolder{
        private RecyclerCoverFlow recyclerCoverFlow;
        private TextView course_details_title;
        private TextView course_details_label;
        private TextView course_details_work_off;
        public DetailsSingleLayoutAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerCoverFlow=(RecyclerCoverFlow)itemView.findViewById(R.id.music_three_cover_flow_rv);
            course_details_title=(TextView)itemView.findViewById(R.id.course_details_title);
            course_details_label=(TextView)itemView.findViewById(R.id.course_details_label);
            course_details_work_off=(TextView)itemView.findViewById(R.id.course_details_work_off);
        }
    }
}
