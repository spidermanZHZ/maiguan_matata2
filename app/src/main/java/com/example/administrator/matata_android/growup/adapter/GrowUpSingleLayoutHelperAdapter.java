package com.example.administrator.matata_android.growup.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.ChildDetailsBean;
import com.example.administrator.matata_android.growup.activity.ChangChildInfoActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.blankj.utilcode.util.ActivityUtils.startActivity;

/**
 * 单行布局
 */
public class GrowUpSingleLayoutHelperAdapter extends DelegateAdapter.Adapter<GrowUpSingleLayoutHelperAdapter.SingleLayoutHelperViewHolder> {

    private Context mContext;
    private DateAdapter dateAdapter;
    private LayoutHelper mHelper;
    private ChildDetailsBean childDetailsBean;
    private static final String URL = "https://www.maiguanjy.com/";
    private String child_id;

    public GrowUpSingleLayoutHelperAdapter(Context mContext, LayoutHelper mHelper, ChildDetailsBean childDetailsBean) {
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
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_growup_single_layout_helper, parent, false);
        return new SingleLayoutHelperViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SingleLayoutHelperViewHolder holder, int position) {
        dateAdapter = new DateAdapter(mContext, null);
        if (childDetailsBean != null) {
            child_id = childDetailsBean.getId();

            //加载头像
            Glide.with(mContext)
                    .load(URL + childDetailsBean.getHead_file())
                    .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                    .into(holder.ivGrowUpChildHead);

            holder.stuName.setText(childDetailsBean.getName());
            if (childDetailsBean.getSex().equals("1")){
                holder.stuSex.setText("男生"+String.valueOf("\t" + "\t" + childDetailsBean.getAge()+"岁"));
            }else {
                holder.stuSex.setText("女生"+String.valueOf("\t" + "\t" + childDetailsBean.getAge()+"岁"));
            }

            holder.stuSign.setText(childDetailsBean.getSignature());
            holder.stuAllTime.setText(childDetailsBean.getTime().getSumTime());
            holder.stuTestTime.setText(childDetailsBean.getTime().getExerciseTime());
            holder.stuAllDay.setText(childDetailsBean.getTime().getOnlineTime());
            holder.stuDay.setText(childDetailsBean.getTime().getOfflineTime());

            holder.stuEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent2 = new Intent(mContext, ChangChildInfoActivity.class);
                    intent2.putExtra("child_id", child_id);
                    startActivity(intent2);
                }
            });

        }


    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class SingleLayoutHelperViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_grow_up_child_head)
        ImageView ivGrowUpChildHead;
        @BindView(R.id.stu_name)
        TextView stuName;
        @BindView(R.id.stu_sex)
        TextView stuSex;
        @BindView(R.id.stu_sign)
        TextView stuSign;
        @BindView(R.id.stu_edit)
        TextView stuEdit;
        @BindView(R.id.stu_more)
        TextView stuMore;
        @BindView(R.id.stu_all_time)
        TextView stuAllTime;
        @BindView(R.id.stu_test_time)
        TextView stuTestTime;
        @BindView(R.id.stu_all_day)
        TextView stuAllDay;
        @BindView(R.id.stu_day)
        TextView stuDay;
        public SingleLayoutHelperViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
