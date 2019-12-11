package com.example.administrator.matata_android.growup.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.MyCourseBean;
import com.example.administrator.matata_android.growup.activity.OffLineCourseDetailsActivity;
import com.example.administrator.matata_android.homepage.activitys.CourseDetailsTwoActivity;
import com.example.administrator.matata_android.homepage.activitys.TheatreCollageCourseDetailsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.blankj.utilcode.util.ActivityUtils.startActivity;

/**
 * 单行布局
 */
public class GrowUpSingleLayoutHelperTwoAdapter extends DelegateAdapter.Adapter<GrowUpSingleLayoutHelperTwoAdapter.SingleLayoutHelperViewHolder> {


    private Context mContext;
    private LayoutHelper mHelper;
    private MyCourseBean myCourseBean;
    private MyStudyCourseAdapter adapter;
    private static final String URL = "https://www.maiguanjy.com/";
    private String child_id;

    public GrowUpSingleLayoutHelperTwoAdapter(Context mContext, LayoutHelper mHelper, MyCourseBean myCourseBean) {
        this.mContext = mContext;
        this.mHelper = mHelper;
        this.myCourseBean = myCourseBean;
    }

    /**
     * 添加数据
     *
     * @param
     */
    public void addData(MyCourseBean myCourseBean) {
        this.myCourseBean = myCourseBean;
        notifyDataSetChanged();
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mHelper;
    }

    @NonNull
    @Override
    public SingleLayoutHelperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.growup_two_single_layout_helper, parent, false);
        return new SingleLayoutHelperViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SingleLayoutHelperViewHolder holder, int position) {


        if (myCourseBean!=null) {


                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                holder.upStuRvCourse.setLayoutManager(linearLayoutManager);
                adapter = new MyStudyCourseAdapter(mContext, R.layout.adapter_music_online, null);
                holder.upStuRvCourse.setAdapter(adapter);
                adapter.addData(myCourseBean.getAll());
                View emptyView=LayoutInflater.from(mContext).inflate(R.layout.empty_view,null,false);
                adapter.setEmptyView(emptyView);
                adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        if (myCourseBean.getAll().get(position).getCourse_type().equals("00")){
                            Intent intent = new Intent(mContext, CourseDetailsTwoActivity.class);
                            String id=String.valueOf(myCourseBean.getAll().get(position).getCourse_id());
                            intent.putExtra("onlineId",id);
                            startActivity(intent);
                        }else {
                            Intent intent = new Intent(mContext, OffLineCourseDetailsActivity.class);
                            String id =String.valueOf(myCourseBean.getAll().get(position).getCourse_id());

                            intent.putExtra("offlineId",id);
                            intent.putExtra("name",myCourseBean.getAll().get(position).getCourse().getName());
                            intent.putExtra("description",myCourseBean.getAll().get(position).getCourse().getDescription());
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

    class SingleLayoutHelperViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.stu_course_more)
        TextView stuCourseMore;
        @BindView(R.id.up_stu_rv_course)
        RecyclerView upStuRvCourse;

        public SingleLayoutHelperViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
