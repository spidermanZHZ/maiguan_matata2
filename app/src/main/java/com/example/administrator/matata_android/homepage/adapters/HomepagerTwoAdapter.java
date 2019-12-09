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
import com.example.administrator.matata_android.homepage.activitys.AllTeacherActivity;
import com.example.administrator.matata_android.homepage.activitys.TeacherDetailsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.blankj.utilcode.util.ActivityUtils.startActivity;

/**
 * 首页装载推荐老师适配器
 */
public class HomepagerTwoAdapter extends DelegateAdapter.Adapter<HomepagerTwoAdapter.HomepagerTwoAdapterViewHolder> {
    private Context mContext;
    private LayoutHelper layoutHelper;
    private HomepagerTeacherBean homepagerTeacherBean;
    private HomePagerTeacherInfoAdapter adapter;

    public void addData(HomepagerTeacherBean homepagerTeacherBean){
        this.homepagerTeacherBean=homepagerTeacherBean;
        notifyDataSetChanged();

    }

    public HomepagerTwoAdapter(Context mContext, LayoutHelper layoutHelper, HomepagerTeacherBean homepagerTeacherBean) {
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
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_home_pager_two, parent, false);

        return new HomepagerTwoAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomepagerTwoAdapterViewHolder holder, int i) {
        holder.homePagerMoreTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到全部老师页面
                Intent intent = new Intent(mContext, AllTeacherActivity.class);
                startActivity(intent);
            }
        });
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        holder.rvHomepageTeacher.setLayoutManager(linearLayoutManager);
        adapter=new HomePagerTeacherInfoAdapter(R.layout.adapter_home_pager_teacher_info,null,mContext);
        holder.rvHomepageTeacher.setAdapter(adapter);
        if (homepagerTeacherBean!=null){
            adapter.addData(homepagerTeacherBean.getTeacher());
        }
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                 Intent intent = new Intent(mContext, TeacherDetailsActivity.class);
                        String id=String.valueOf(homepagerTeacherBean.getTeacher().get(position).getId());
                        intent.putExtra("teacher_id",id);
                        startActivity(intent);
            }
        });
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
