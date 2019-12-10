package com.example.administrator.matata_android.my.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;

import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.MyOrderBean;
import com.example.administrator.matata_android.my.adapters.MyOrders2Adapter;
import com.example.administrator.matata_android.zhzbase.base.BaseFragment;

/**
 * 待付款
 */
public class MyOrdersNoPaidFragment extends BaseFragment{
    private MyOrderBean myOrderBean;
    private RecyclerView recyclerView;
    private MyOrders2Adapter adapter;

    @Override
    protected int initLayoutId() {
     return R.layout.fragment_all_orders;
    }

    @Override
    protected void getExras() {

        Bundle bundle=getArguments();
        if (bundle!=null){
            myOrderBean=(MyOrderBean)bundle.getSerializable("myOrdersNoPaidFragment");
        }
    }

    @Override
    protected void initData() {
  recyclerView=(RecyclerView)rootView.findViewById(R.id.my_order_rv);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter=new MyOrders2Adapter(getContext(),R.layout.adapter_music_online,null);
        if (myOrderBean!=null){
            adapter.addData(myOrderBean.getUnfinished());
        }
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void setListener() {

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}
