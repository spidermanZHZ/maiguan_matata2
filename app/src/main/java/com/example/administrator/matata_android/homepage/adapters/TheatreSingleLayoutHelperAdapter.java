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

import java.util.zip.Inflater;

import recycler.coverflow.RecyclerCoverFlow;

/**
 * 戏剧学院热门课程适配器
 */
public class TheatreSingleLayoutHelperAdapter extends DelegateAdapter.Adapter<TheatreSingleLayoutHelperAdapter.TheatreSingleLayoutHelperAdapterViewHolder> {

    private Context mContext;
    private LayoutHelper layoutHelper;

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public TheatreSingleLayoutHelperAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.adapter_theatre_layout_one,parent,false);

        return new TheatreSingleLayoutHelperAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TheatreSingleLayoutHelperAdapterViewHolder theatreSingleLayoutHelperAdapterViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class TheatreSingleLayoutHelperAdapterViewHolder extends RecyclerView.ViewHolder{
        private RecyclerCoverFlow rv_theatre_cover_flow;
        public TheatreSingleLayoutHelperAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            rv_theatre_cover_flow=(RecyclerCoverFlow)itemView.findViewById(R.id.rv_theatre_cover_flow);
        }
    }

}
