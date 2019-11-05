package com.example.administrator.matata_android.homepage.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.administrator.matata_android.R;

/**
 * 戏剧学院全部课程适配器
 */
public class ThearteLinearLayoutHelperAdapter extends DelegateAdapter.Adapter<ThearteLinearLayoutHelperAdapter.ThearteLinearLayoutHelperAdapterViewHolder> {
    private Context mContext;
    private LayoutHelper layoutHelper;

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public ThearteLinearLayoutHelperAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.adapter_theatre_layout_four,parent,false);

        return new ThearteLinearLayoutHelperAdapterViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ThearteLinearLayoutHelperAdapterViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ThearteLinearLayoutHelperAdapterViewHolder extends RecyclerView.ViewHolder{

        public ThearteLinearLayoutHelperAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
