package com.example.administrator.matata_android.homepage.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.TeacherInfoBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 瀑布流布局
 */
public class AllTeacherStaggeredGridHelperAdapter extends DelegateAdapter.Adapter<AllTeacherStaggeredGridHelperAdapter.LinearHelperAdapterViewHolder> {
    private static final String URL = "https://www.maiguanjy.com/";
    private Context mContext;
    private LayoutHelper layoutHelper;

    private TeacherInfoBean teacherInfoBean;

    public interface  OnItemClickListener{
        void onItemClick(View view,int position);
        void onLongItemClick(View view,int position);
    }
    public OnItemClickListener mOnItemClickListenre;//设置点击事件

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListenre=onItemClickListener;
    }

    public AllTeacherStaggeredGridHelperAdapter(Context mContext, LayoutHelper layoutHelper, TeacherInfoBean teacherInfoBean) {
        this.mContext = mContext;
        this.layoutHelper = layoutHelper;
        this.teacherInfoBean = teacherInfoBean;
    }

    /**
     * 获取老师列表
     *
     * @return
     */
    public void addteacherInfoData(TeacherInfoBean teacherInfoBean) {
        this.teacherInfoBean = teacherInfoBean;
        notifyDataSetChanged();
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public LinearHelperAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_theatre_hot_info, null);
        return new LinearHelperAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LinearHelperAdapterViewHolder helper, int position) {
        ViewGroup.LayoutParams layoutParams =  helper.adapterTheatreInfoTitle.getLayoutParams();
        if (position % 2==0){

        }else {
            layoutParams.height = 100 + position % 7 * 20;
        }
        helper.adapterTheatreInfoTitle.setLayoutParams(layoutParams);

        if (mOnItemClickListenre!=null){
            helper.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListenre.onItemClick(helper.itemView,helper.getAdapterPosition());
                }
            });
        }


        if (teacherInfoBean!=null){
            //设置图片圆角角度
            RoundedCorners roundedCorners = new RoundedCorners(10);
            //通过RequestOptions扩展功能
            RequestOptions options = RequestOptions.bitmapTransform(roundedCorners).override(300, 300);

            //加载图片
            Glide.with(mContext)
                    .load(URL + teacherInfoBean.getData().get(position).getIntroduction_images())
                    .apply(options)
                    .into(helper.adapterTheatreInfoIv);
            helper.adapterTheatreInfoName.setText( teacherInfoBean.getData().get(position).getName());
            helper.adapterTheatreInfoTitle.setText( teacherInfoBean.getData().get(position).getDescription());
        }

    }

    @Override
    public int getItemCount() {
        if (teacherInfoBean != null) {
            return teacherInfoBean.getData().size();
        }
        return 0;
    }

    class LinearHelperAdapterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.adapter_theatre_info_iv)
        ImageView adapterTheatreInfoIv;
        @BindView(R.id.adapter_theatre_info_title)
        TextView adapterTheatreInfoTitle;
        @BindView(R.id.adapter_theatre_info_name)
        TextView adapterTheatreInfoName;

        public LinearHelperAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
