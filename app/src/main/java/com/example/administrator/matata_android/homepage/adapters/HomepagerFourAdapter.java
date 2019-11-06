package com.example.administrator.matata_android.homepage.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.HomepagerTeacherBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 首页装载轮播图适配器,以及按钮
 */
public class HomepagerFourAdapter extends DelegateAdapter.Adapter<HomepagerFourAdapter.HomepagerFourAdapterViewHolder> {
    private Context mContext;
    private LayoutHelper layoutHelper;

    public HomepagerFourAdapter(Context mContext, LayoutHelper layoutHelper) {
        this.mContext = mContext;
        this.layoutHelper = layoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public HomepagerFourAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_home_pager_four, parent, false);
        return new HomepagerFourAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomepagerFourAdapterViewHolder holder, int position) {
        holder.homePagerSetArtIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "该功能暂未开放", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class HomepagerFourAdapterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.home_pager_set_art_iv)
        ImageView homePagerSetArtIv;

        public HomepagerFourAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
