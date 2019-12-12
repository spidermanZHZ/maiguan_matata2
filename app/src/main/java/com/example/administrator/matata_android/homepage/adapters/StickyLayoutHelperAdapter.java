package com.example.administrator.matata_android.homepage.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.administrator.matata_android.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 吸顶布局
 */
public class StickyLayoutHelperAdapter extends DelegateAdapter.Adapter<StickyLayoutHelperAdapter.StickyLayoutHelperViewHolder> {

    private Context mContext;
    private LayoutHelper mHelper;
    private Window mWindow;

    public StickyLayoutHelperAdapter(Context mContext, LayoutHelper mHelper) {
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
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_music_three_stick_layout, parent, false);
        return new StickyLayoutHelperViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StickyLayoutHelperViewHolder helper, int position) {
            helper.llFenlei.setVisibility(View.GONE);
            helper.tvLeibie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               popWindow(view);
            }
        });



        if (mOnItemClickListener != null) {
            helper.onlinetv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = helper.getLayoutPosition();
                    mOnItemClickListener.onOnLineClick(helper.itemView, pos);
                }
            });
            helper.offlinetv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = helper.getLayoutPosition();
                    mOnItemClickListener.onOffLineClick(helper.itemView, pos);
                }
            });
        }

    }
    private void popWindow(View view){
        // 设置背景变暗
        mWindow = ((Activity)mContext).getWindow();
        WindowManager.LayoutParams params = mWindow.getAttributes();
        params.alpha = 0.7f;
        mWindow.setAttributes(params);
        // 设置弹出框
        View productListView = LayoutInflater.from(mContext).inflate(R.layout.popwindow_layout, null);
        PopupWindow popWindow = new PopupWindow(productListView, 780, 900);
        popWindow.setOutsideTouchable(true);      //必须设置背景 即使为null或者透明 否则点击外部不会消失
        popWindow.setBackgroundDrawable(null);
        //相对于父控件的位置（例如正中央Gravity.CENTER，下方Gravity.BOTTOM等），可以设置偏移或无偏移
        popWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
        popWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                if(mWindow!=null){
                    WindowManager.LayoutParams params = mWindow.getAttributes();
                    params.alpha = 1.0f;
                    mWindow.setAttributes(params);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class StickyLayoutHelperViewHolder extends RecyclerView.ViewHolder {

        private TextView onlinetv;
        private TextView offlinetv;
        @BindView(R.id.tv_all)
        TextView tvAll;
        @BindView(R.id.tv_leibie)
        TextView tvLeibie;
        @BindView(R.id.tv_grade)
        TextView tvGrade;
        @BindView(R.id.ll_fenlei)
        LinearLayout llFenlei;
        public StickyLayoutHelperViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            onlinetv = (TextView) itemView.findViewById(R.id.stick_layout_tv_online);
            offlinetv = (TextView) itemView.findViewById(R.id.stick_layout_tv_offline);
            //为view添加点击事件
        }
    }
    //==========以下为item中的控件点击事件处理===========


    public interface OnItemClickListener {

        void onOnLineClick(View v, int position);

        void onOffLineClick(View v, int position);

        void onItemClick(View v, int position);

        void onItemLongClick(View v, int position);

    }

    private OnItemClickListener mOnItemClickListener;//声明自定义的接口

    //定义方法并传给外面的使用者

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

}
