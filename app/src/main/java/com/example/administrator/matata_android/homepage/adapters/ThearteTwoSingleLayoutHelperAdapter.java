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
 * 戏剧学院轮播图适配器
 */
public class ThearteTwoSingleLayoutHelperAdapter extends DelegateAdapter.Adapter<ThearteTwoSingleLayoutHelperAdapter.ThearteTwoSingleLayoutHelperAdapterViewHolder> {

    private Context mContext;
    private LayoutHelper layoutHelper;


    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public ThearteTwoSingleLayoutHelperAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.adapter_theatre_layout_two,parent,false);

        return new ThearteTwoSingleLayoutHelperAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThearteTwoSingleLayoutHelperAdapterViewHolder thearteTwoSingleLayoutHelperAdapterViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class ThearteTwoSingleLayoutHelperAdapterViewHolder extends RecyclerView.ViewHolder{

        public ThearteTwoSingleLayoutHelperAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
