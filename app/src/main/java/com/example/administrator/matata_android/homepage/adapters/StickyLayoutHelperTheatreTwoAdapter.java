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

public class StickyLayoutHelperTheatreTwoAdapter extends DelegateAdapter.Adapter<StickyLayoutHelperTheatreTwoAdapter.StickyLayoutHelperTwoAdapterViewHolder> {

    private Context mContext;
    private LayoutHelper mHelper;

    public StickyLayoutHelperTheatreTwoAdapter(Context mContext, LayoutHelper mHelper) {
        this.mContext = mContext;
        this.mHelper = mHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mHelper;
    }

    @NonNull
    @Override
    public StickyLayoutHelperTwoAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.adapter_music_course_stick_layout,parent,false);
        return new StickyLayoutHelperTwoAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StickyLayoutHelperTwoAdapterViewHolder holder, int position) {
        holder.course_tag.setVisibility(View.GONE);

        if (mOnItemClickListener!=null){
            holder.tv_course.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onCourse(holder.itemView,pos);
                }
            });

            holder.course_comment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onCourseComment(holder.itemView,pos);
                }
            });


        }

    }

    @Override
    public int getItemCount() {
        return 1;
    }
    //==========以下为item中的控件点击事件处理===========


    public  interface OnItemClickListener{

        void onCourse(View v, int position);
        void onCourseComment(View v, int position);
        void onItemClick(View v, int position);
        void onItemLongClick(View v, int position);

    }
    private OnItemClickListener mOnItemClickListener;//声明自定义的接口

    //定义方法并传给外面的使用者

    public void setOnItemClickListener(OnItemClickListener  listener) {
        this.mOnItemClickListener  = listener;
    }


    class StickyLayoutHelperTwoAdapterViewHolder extends RecyclerView.ViewHolder{
            TextView tv_course;
            TextView course_tag;
            TextView course_comment;

        public StickyLayoutHelperTwoAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_course=(TextView)itemView.findViewById(R.id.tv_course);
            course_tag=(TextView)itemView.findViewById(R.id.course_tag);
            course_comment=(TextView)itemView.findViewById(R.id.course_comment);

        }
    }


}
