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
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.OffLineCourseBean;
import com.example.administrator.matata_android.httputils.BaseObserver;
import com.example.administrator.matata_android.httputils.RetrofitUtil;
import com.example.administrator.matata_android.zhzbase.utils.MatataSPUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import recycler.coverflow.RecyclerCoverFlow;

/**
 * 课程详情适配器
 */
public class TheatreCollageDetailsSingleLayoutAdapter extends DelegateAdapter.Adapter<TheatreCollageDetailsSingleLayoutAdapter.DetailsSingleLayoutAdapterViewHolder> {


    private Context mContext;
    private LayoutHelper mHelper;

    private OffLineCourseBean offLineCourseBean;
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

    public TheatreCollageDetailsSingleLayoutAdapter(Context mContext, LayoutHelper mHelper, OffLineCourseBean offLineCourseBean) {
        this.mContext = mContext;
        this.mHelper = mHelper;
        this.offLineCourseBean = offLineCourseBean;
    }

    /**
     * 添加数据
     *
     * @param offLineCourseBean
     */
    public void addData(OffLineCourseBean offLineCourseBean) {
        this.offLineCourseBean = offLineCourseBean;
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

        if (offLineCourseBean != null) {
            adapter.getData(offLineCourseBean.getDetail_pic());
            //设置数据
            holder.course_details_title.setText(offLineCourseBean.getName());
            holder.course_details_label.setText(String.valueOf("共" + offLineCourseBean.getNum() + "节"));
            holder.course_details_work_off.setText(String.valueOf("已售出" + offLineCourseBean.getPay_num()));
            if (offLineCourseBean.isIsFavorite()) {
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
        @BindView(R.id.course_details_collect)
        LinearLayout courseDetailsCollect;

        @BindView(R.id.course_details_collect_tv)
        TextView courseDetailsCollectTv;

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
