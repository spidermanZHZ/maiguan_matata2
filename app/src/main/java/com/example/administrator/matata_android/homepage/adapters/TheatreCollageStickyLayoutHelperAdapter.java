package com.example.administrator.matata_android.homepage.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.administrator.matata_android.R;

/**
 * 吸顶布局
 */
public class TheatreCollageStickyLayoutHelperAdapter extends DelegateAdapter.Adapter<TheatreCollageStickyLayoutHelperAdapter.StickyLayoutHelperViewHolder> {

    private Context mContext;
    private LayoutHelper mHelper;


    public TheatreCollageStickyLayoutHelperAdapter(Context mContext, LayoutHelper mHelper) {
        this.mContext = mContext;
        this.mHelper = mHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mHelper;
    }

    @NonNull
    @Override
    public StickyLayoutHelperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.adapter_theatre_collage_stick_layout,parent,false);
        return new StickyLayoutHelperViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StickyLayoutHelperViewHolder helper, int position) {
//        if (mOnItemClickListener!=null){
//            helper.onlinetv.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int pos = helper.getLayoutPosition();
//                    mOnItemClickListener.onOnLineClick(helper.itemView,pos);
//                }
//            });
//
//        }

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class StickyLayoutHelperViewHolder extends RecyclerView.ViewHolder{



         public StickyLayoutHelperViewHolder(@NonNull View itemView) {
             super(itemView);


             //为view添加点击事件
         }
     }
    //==========以下为item中的控件点击事件处理===========


    public  interface OnItemClickListener{

        void onOnLineClick(View v, int position);
        void onItemClick(View v, int position);
        void onItemLongClick(View v, int position);

    }
    private OnItemClickListener mOnItemClickListener;//声明自定义的接口

    //定义方法并传给外面的使用者

    public void setOnItemClickListener(OnItemClickListener  listener) {
        this.mOnItemClickListener  = listener;
    }

}
