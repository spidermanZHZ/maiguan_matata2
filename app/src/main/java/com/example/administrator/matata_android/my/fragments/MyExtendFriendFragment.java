package com.example.administrator.matata_android.my.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.MotionEvent;
import android.view.View;


import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.MyExtendBean;

import com.example.administrator.matata_android.my.adapters.MyExtendFriendFragmentAdapter;
import com.example.administrator.matata_android.zhzbase.base.BaseFragment;

/**
 * 我的小伙伴
 */
public class MyExtendFriendFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private MyExtendBean myExtendBean;
    private MyExtendFriendFragmentAdapter adapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            myExtendBean = (MyExtendBean) bundle.getSerializable("MyExtendFriendFragment");
        }
    }

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_extend1;
    }

    @Override
    protected void getExras() {

    }

    @Override
    protected void initData() {
        recyclerView=(RecyclerView)rootView.findViewById(R.id.extend_rv1);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter=new MyExtendFriendFragmentAdapter(R.layout.adapter_my_extend_friend,null);
        if (myExtendBean != null) {
            adapter.addData(myExtendBean.getDistribution());
        }
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void setListener() {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

}
