package com.example.administrator.matata_android.my.adapters;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.matata_android.bean.MyExtendBean;

import java.util.List;

public class MyExtendTeacherFragmentAdapter extends BaseQuickAdapter<MyExtendBean.WithdrawListBean,BaseViewHolder> {
    public MyExtendTeacherFragmentAdapter(int layoutResId, @Nullable List<MyExtendBean.WithdrawListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, MyExtendBean.WithdrawListBean item) {

    }
}
