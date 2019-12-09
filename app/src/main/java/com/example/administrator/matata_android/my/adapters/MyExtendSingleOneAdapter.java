package com.example.administrator.matata_android.my.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.MyExtendBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 推广中心适配器1
 */
public class MyExtendSingleOneAdapter extends DelegateAdapter.Adapter<MyExtendSingleOneAdapter.MyExtendSingleOneAdapterViewHolder> {
    private Context mContext;
    private LayoutHelper layoutHelper;
    private MyExtendBean myExtendBean;
    private static final String URL = "https://www.maiguanjy.com/";


    public interface  OnItemClickListener{
        void onMoneyClick(View view,int position);
        void onFriendClick(View view,int position);
        void onTeacherClick(View view,int position);
        void onItemClick(View view,int position);
        void onLongItemClick(View view,int position);

    }
    public OnItemClickListener mOnItemClickListenre;//设置点击事件

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListenre=onItemClickListener;
    }

    public  void addData(MyExtendBean myExtendBean){
        this.myExtendBean=myExtendBean;
        notifyDataSetChanged();
    }

    public MyExtendSingleOneAdapter(Context mContext, LayoutHelper layoutHelper,MyExtendBean myExtendBean) {
        this.mContext = mContext;
        this.layoutHelper = layoutHelper;
        this.myExtendBean=myExtendBean;

    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public MyExtendSingleOneAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_extend_single, parent, false);

        return new MyExtendSingleOneAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyExtendSingleOneAdapterViewHolder holder, int position) {
        if(myExtendBean!=null){
            holder.money.setText(String.valueOf("¥"+myExtendBean.getBalance()));
            holder.friend.setText(String.valueOf(myExtendBean.getDistributionCount()));
            holder.teacher.setText(String.valueOf(myExtendBean.getStudentCount()));
            if (mOnItemClickListenre!=null){
                holder.moneyLl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = holder.getLayoutPosition();
                        mOnItemClickListenre.onMoneyClick(holder.itemView,pos);
                    }
                });
            }
            if (mOnItemClickListenre!=null){
                holder.friendLl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = holder.getLayoutPosition();
                        mOnItemClickListenre.onFriendClick(holder.itemView,pos);
                    }
                });
            }
            if (mOnItemClickListenre!=null){
                holder.teacherLl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = holder.getLayoutPosition();
                        mOnItemClickListenre.onTeacherClick(holder.itemView,pos);
                    }
                });
            }
        }

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class MyExtendSingleOneAdapterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.money)
        TextView money;
        @BindView(R.id.money_ll)
        LinearLayout moneyLl;
        @BindView(R.id.friend)
        TextView friend;
        @BindView(R.id.friend_ll)
        LinearLayout friendLl;
        @BindView(R.id.teacher)
        TextView teacher;
        @BindView(R.id.teacher_ll)
        LinearLayout teacherLl;

        public MyExtendSingleOneAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
