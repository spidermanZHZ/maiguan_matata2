package com.example.administrator.matata_android.growup.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.MyOffLineCourseNumBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 单行布局
 */
public class GridLayoutHelperAdapter extends BaseQuickAdapter<MyOffLineCourseNumBean ,BaseViewHolder> {

    private Context mContext;
    public GridLayoutHelperAdapter(Context context,int layoutResId, @Nullable List<MyOffLineCourseNumBean> data) {
        super(layoutResId, data);
        this.mContext=context;
    }


    @Override
    protected void convert(@NonNull BaseViewHolder helper, MyOffLineCourseNumBean item) {

        if (item!=null){
            helper.setText(R.id.number,item.getNum());
            if (item.getIs_end().equals("true")){
                helper.setBackgroundColor(R.id.number,mContext.getResources().getColor(R.color.background_title));
            }
        }

    }
}
