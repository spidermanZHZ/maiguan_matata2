package com.example.administrator.matata_android.my.adapters;

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

/**
 * 我的关注吸顶布局
 */
public class MyFollowStickyLayoutHelperAdapter extends DelegateAdapter.Adapter<MyFollowStickyLayoutHelperAdapter.MyFollowStickyLayoutHelperAdapterViewHolder> {


    private Context mContext;
    private LayoutHelper mHelper;

    public  interface OnItemClickListener{

        void onTeacherClick(View v, int position);
        void onOnlineCourseClick(View v, int position);
        void onOfflineCourseClick(View v, int position);
        void onItemClick(View v, int position);
        void onItemLongClick(View v, int position);

    }
    private OnItemClickListener mOnItemClickListener;//声明自定义的接口

    //定义方法并传给外面的使用者

    public void setOnItemClickListener(OnItemClickListener  listener) {
        this.mOnItemClickListener  = listener;
    }

    public MyFollowStickyLayoutHelperAdapter(Context mContext, LayoutHelper mHelper) {
        this.mContext = mContext;
        this.mHelper = mHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mHelper;
    }

    @NonNull
    @Override
    public MyFollowStickyLayoutHelperAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
           View view= LayoutInflater.from(mContext).inflate(R.layout.adapter_music_course_stick_layout,parent,false);
        return new MyFollowStickyLayoutHelperAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyFollowStickyLayoutHelperAdapterViewHolder holder, int i) {
            holder.tv_course.setText("老师");
            holder.course_tag.setText("线上课程");
            holder.course_comment.setText("线下课程");
        if (mOnItemClickListener!=null){
            holder.tv_course.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onTeacherClick(holder.itemView,pos);
                }
            });
            holder.course_tag.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onOnlineCourseClick(holder.itemView,pos);
                }
            });
            holder.course_comment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onOfflineCourseClick(holder.itemView,pos);
                }
            });


        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class MyFollowStickyLayoutHelperAdapterViewHolder extends RecyclerView.ViewHolder{
        TextView tv_course;
        TextView course_tag;
        TextView course_comment;
        public MyFollowStickyLayoutHelperAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_course=(TextView)itemView.findViewById(R.id.tv_course);
            course_tag=(TextView)itemView.findViewById(R.id.course_tag);
            course_comment=(TextView)itemView.findViewById(R.id.course_comment);

        }
    }
}
