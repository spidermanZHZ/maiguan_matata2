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
 * 戏剧学院吸顶布局适配器
 */
public class ThearteStrickLayoutHelperAdapter extends DelegateAdapter.Adapter<ThearteStrickLayoutHelperAdapter.ThearteStrickLayoutHelperAdapterViewHolder>{

    private Context mContext;
    private LayoutHelper layoutHelper;

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public ThearteStrickLayoutHelperAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.adapter_theatre_layout_three,parent,false);

        return new ThearteStrickLayoutHelperAdapterViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ThearteStrickLayoutHelperAdapterViewHolder thearteThreeSingleLayoutHelperAdapterViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class ThearteStrickLayoutHelperAdapterViewHolder extends RecyclerView.ViewHolder{

        public ThearteStrickLayoutHelperAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
