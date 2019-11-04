package com.example.administrator.matata_android.homepage.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.MusicHotBean;
import com.example.administrator.matata_android.homepage.activitys.CourseDetailsActivity;
import com.example.administrator.matata_android.homepage.activitys.CourseDetailsTwoActivity;
import com.example.administrator.matata_android.homepage.activitys.MusicCollageThreeActivity;

import java.util.List;

import recycler.coverflow.RecyclerCoverFlow;

import static com.blankj.utilcode.util.ActivityUtils.startActivity;

/**
 * 单行布局
 */
public class SingleLayoutHelperAdapter extends DelegateAdapter.Adapter<SingleLayoutHelperAdapter.SingleLayoutHelperViewHolder> {

    private Context mContext;
    private List<MusicHotBean> musicHotBeans;
    private LayoutHelper mHelper;
    private MusicHotAdapter hotAdapter;
    private ArtCampAtPicAdapter adapter;//修改画廊布局的适配器
    public SingleLayoutHelperAdapter(Context mContext, List<MusicHotBean> musicHotBeans, LayoutHelper mHelper) {
        this.mContext = mContext;
        this.musicHotBeans = musicHotBeans;
        this.mHelper = mHelper;
    }

    /**
     * 添加数据
     * @param musicHotBeanData
     */
     public void addData(List<MusicHotBean> musicHotBeanData){
        this.musicHotBeans=musicHotBeanData;
        notifyDataSetChanged();
    }
    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mHelper;
    }

    @NonNull
    @Override
    public SingleLayoutHelperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.adapter_music_three_single_view,parent,false);
        return new SingleLayoutHelperViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SingleLayoutHelperViewHolder holder, int position) {

        hotAdapter = new MusicHotAdapter(mContext, R.layout.adapter_music_hot, musicHotBeans);

        holder.recyclerCoverFlow.setAdapter(hotAdapter);
        hotAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(mContext, CourseDetailsTwoActivity.class);
                intent.putExtra("onlineId",musicHotBeans.get(position).getId());
                startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class SingleLayoutHelperViewHolder extends RecyclerView.ViewHolder{
        private RecyclerCoverFlow recyclerCoverFlow;
        public SingleLayoutHelperViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerCoverFlow=(RecyclerCoverFlow)itemView.findViewById(R.id.music_three_cover_flow_rv);
        }
    }
}
