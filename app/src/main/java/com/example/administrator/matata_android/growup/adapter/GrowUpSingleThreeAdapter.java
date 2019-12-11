package com.example.administrator.matata_android.growup.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.ChildDetailsBean;
import com.example.administrator.matata_android.growup.activity.StudyAdjustActivity;
import com.example.administrator.matata_android.zhzbase.utils.DateUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.blankj.utilcode.util.ActivityUtils.startActivity;

/**
 * 单行布局
 */
public class GrowUpSingleThreeAdapter extends DelegateAdapter.Adapter<GrowUpSingleThreeAdapter.SingleLayoutHelperViewHolder> {


    private Context mContext;
    private DateAdapter dateAdapter;
    private LayoutHelper mHelper;
    private ChildDetailsBean childDetailsBean;
    private static final String URL = "https://www.maiguanjy.com/";
    private String child_id;

    public GrowUpSingleThreeAdapter(Context mContext, LayoutHelper mHelper, ChildDetailsBean childDetailsBean) {
        this.mContext = mContext;
        this.mHelper = mHelper;
        this.childDetailsBean = childDetailsBean;
    }

    /**
     * 添加数据
     *
     * @param
     */
    public void addData(ChildDetailsBean childDetailsBean) {
        this.childDetailsBean = childDetailsBean;
        notifyDataSetChanged();
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mHelper;
    }

    @NonNull
    @Override
    public SingleLayoutHelperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_growup_single_three_layout, parent, false);
        return new SingleLayoutHelperViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SingleLayoutHelperViewHolder holder, int position) {
        if (childDetailsBean != null) {
            child_id = childDetailsBean.getId();

            dateAdapter = new DateAdapter(mContext, null);

            holder.stuAdjust.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext,StudyAdjustActivity.class);
                    intent.putExtra("child_id",String.valueOf(child_id));
                    startActivity(intent);
                }
            });


            if (childDetailsBean.getPlans().size()>0) {
                //日期加载
                dateAdapter.addData(childDetailsBean.getPlans());
                dateAdapter.notifyDataSetChanged();
                dateAdapter.setSelect(0);
                holder.upTvPlanStudy.setText(String.valueOf("计划学习" + DateUtils.getInstance().stringTime(childDetailsBean.getPlans().get(0).getSum_time()) + "分钟"));
                holder.upTvStudyAlready.setText(String.valueOf("已按计划学习" + DateUtils.getInstance().stringTime(childDetailsBean.getPlans().get(0).getTime()) + "分钟"));

                int sun_time = Integer.parseInt(childDetailsBean.getPlans().get(0).getSum_time());
                int time = Integer.parseInt(childDetailsBean.getPlans().get(0).getTime());
                if (sun_time > 0) {

                    if (time >= sun_time) {
                        holder.upTvStudyState.setText("已完成计划");
                    } else {
                        holder.upTvStudyState.setText("未完成计划");
                    }
                } else {
                    holder.upTvStudyState.setText("未制定计划");
                }
            }

            LinearLayoutManager linearLayoutManager =new LinearLayoutManager(mContext);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            holder.stuRvPlanTime.setLayoutManager(linearLayoutManager);
            holder.stuRvPlanTime.setAdapter(dateAdapter);


            dateAdapter.setOnItemClickListener(new DateAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    dateAdapter.setSelect(position);
                    holder.stuAdjust.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(mContext, StudyAdjustActivity.class);
                            intent.putExtra("child_id", child_id);
                            startActivity(intent);
                        }
                    });
                    holder.upTvPlanStudy.setText(String.valueOf("计划学习" + DateUtils.getInstance().stringTime(childDetailsBean.getPlans().get(position).getSum_time()) + "分钟"));
                    holder.upTvStudyAlready.setText(String.valueOf("已按计划学习" + DateUtils.getInstance().stringTime(childDetailsBean.getPlans().get(position).getTime()) + "分钟"));

                    int sun_time = Integer.parseInt(childDetailsBean.getPlans().get(position).getSum_time());
                    int time = Integer.parseInt(childDetailsBean.getPlans().get(position).getTime());
                    if (sun_time > 0) {

                        if (time >= sun_time) {
                            holder.upTvStudyState.setText("已完成计划");
                        } else {
                            holder.upTvStudyState.setText("未完成计划");
                        }
                    } else {
                        holder.upTvStudyState.setText("未制定计划");
                    }
                }

                @Override
                public void onLongItemClick(View view, int position) {

                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class SingleLayoutHelperViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.stu_adjust)
        TextView stuAdjust;
        @BindView(R.id.stu_rv_plan_time)
        RecyclerView stuRvPlanTime;
        @BindView(R.id.up_tv_plan_study)
        TextView upTvPlanStudy;
        @BindView(R.id.up_tv_study_already)
        TextView upTvStudyAlready;
        @BindView(R.id.up_ll_plan)
        LinearLayout upLlPlan;
        @BindView(R.id.up_tv_study_state)
        TextView upTvStudyState;
        @BindView(R.id.grow_up_time)
        TextView growUpTime;
        @BindView(R.id.up_stu_start_test)
        Button upStuStartTest;
        public SingleLayoutHelperViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
