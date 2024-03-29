package com.example.administrator.matata_android.homepage.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.TeacherDetailsInfoBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import recycler.coverflow.RecyclerCoverFlow;

/**
 * 课程详情适配器
 */
public class TeacherDetailsSingleLayoutAdapter extends DelegateAdapter.Adapter<TeacherDetailsSingleLayoutAdapter.DetailsSingleLayoutAdapterViewHolder> {


    private Context mContext;
    private LayoutHelper mHelper;

    private TeacherDetailsInfoBean teacherDetailsInfoBean;
    private ArtCampAtPicAdapter adapter;

    public interface  OnItemClickListener{
        void onItemClick(View view,int position);
        void onLongItemClick(View view,int position);
        void onFavoriteClick(View view,int position);
        void onCanleFavoriteClick(View view,int position);
    }
    public OnItemClickListener mOnItemClickListenre;//设置点击事件

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListenre=onItemClickListener;
    }
    public TeacherDetailsSingleLayoutAdapter(Context mContext, LayoutHelper mHelper, TeacherDetailsInfoBean teacherDetailsInfoBean) {
        this.mContext = mContext;
        this.mHelper = mHelper;
        this.teacherDetailsInfoBean = teacherDetailsInfoBean;
    }

    /**
     * 添加数据
     *
     * @param teacherDetailsInfoBean
     */
    public void addData(TeacherDetailsInfoBean teacherDetailsInfoBean) {
        this.teacherDetailsInfoBean = teacherDetailsInfoBean;
        notifyDataSetChanged();
    }


    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mHelper;
    }

    @NonNull
    @Override
    public DetailsSingleLayoutAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_details_single_view, parent, false);
        return new DetailsSingleLayoutAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsSingleLayoutAdapterViewHolder holder, int position) {
        adapter = new ArtCampAtPicAdapter(mContext, null);
        holder.recyclerCoverFlow.setAdapter(adapter);

        if (teacherDetailsInfoBean != null) {
            List<String> list = new ArrayList<>();
            list.add(teacherDetailsInfoBean.getIntroduction_images());
            adapter.getData(list);
            //设置数据
            holder.course_details_title.setText(teacherDetailsInfoBean.getName());
            holder.course_details_label.setText(String.valueOf(teacherDetailsInfoBean.getCertification() + " | " + teacherDetailsInfoBean.getGrade()));
            holder.course_details_work_off.setText("暂无数据");
            if (teacherDetailsInfoBean.isIs_favorite()) {
                holder.courseDetailsCollectTv.setText("已收藏");
                holder.courseDetailsCollectIv.setImageResource(R.mipmap.shoucang1);
                if (mOnItemClickListenre!=null){
                    holder.courseDetailsCollect.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mOnItemClickListenre.onCanleFavoriteClick(holder.courseDetailsCollect,holder.getAdapterPosition());
                            holder.courseDetailsCollectTv.setText("收藏");
                            holder.courseDetailsCollectIv.setImageResource(R.mipmap.shoucang2);
                        }
                    });
                }

            } else {
                holder.courseDetailsCollectTv.setText("收藏");
                holder.courseDetailsCollectIv.setImageResource(R.mipmap.shoucang2);
                if (mOnItemClickListenre!=null){
                    holder.courseDetailsCollect.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mOnItemClickListenre.onFavoriteClick(holder.courseDetailsCollect,holder.getAdapterPosition());
                            holder.courseDetailsCollectTv.setText("已收藏");
                            holder.courseDetailsCollectIv.setImageResource(R.mipmap.shoucang1);
                        }
                    });
                }

            }







        }

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class DetailsSingleLayoutAdapterViewHolder extends RecyclerView.ViewHolder {
        private RecyclerCoverFlow recyclerCoverFlow;
        private TextView course_details_title;
        private TextView course_details_label;
        private TextView course_details_work_off;
        @BindView(R.id.course_details_collect_iv)
        ImageView courseDetailsCollectIv;
        @BindView(R.id.course_details_collect_tv)
        TextView courseDetailsCollectTv;
        @BindView(R.id.course_details_collect)
        LinearLayout courseDetailsCollect;

        public DetailsSingleLayoutAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            recyclerCoverFlow = (RecyclerCoverFlow) itemView.findViewById(R.id.music_three_cover_flow_rv);
            course_details_title = (TextView) itemView.findViewById(R.id.course_details_title);
            course_details_label = (TextView) itemView.findViewById(R.id.course_details_label);
            course_details_work_off = (TextView) itemView.findViewById(R.id.course_details_work_off);
        }
    }


}
