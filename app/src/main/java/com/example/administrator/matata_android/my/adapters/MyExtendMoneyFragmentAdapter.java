package com.example.administrator.matata_android.my.adapters;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.MyExtendBean;

import java.util.List;

public class MyExtendMoneyFragmentAdapter extends BaseQuickAdapter<MyExtendBean.WithdrawListBean,BaseViewHolder> {

    public MyExtendMoneyFragmentAdapter(int layoutResId, @Nullable List<MyExtendBean.WithdrawListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, MyExtendBean.WithdrawListBean item) {
        if(item!=null){
            helper.setText(R.id.my_extend_name,item.getReal_name());
            helper.setText(R.id.my_extend_bank,item.getBankName());
            helper.setText(R.id.my_extend_bank_num,item.getBank_card_no());
            int a=item.getApply_money()/100;
            helper.setText(R.id.my_extend_money,String.valueOf("¥"+a));
        }

    }
}
