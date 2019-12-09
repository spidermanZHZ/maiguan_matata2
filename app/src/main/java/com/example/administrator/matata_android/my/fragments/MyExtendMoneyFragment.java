package com.example.administrator.matata_android.my.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.MyExtendBean;
import com.example.administrator.matata_android.my.adapters.MyExtendMoneyFragmentAdapter;
import com.example.administrator.matata_android.zhzbase.base.BaseViewNeedSetFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MyExtendMoneyFragment extends BaseViewNeedSetFragment {
    @BindView(R.id.extend_rv1)
    RecyclerView extendRv1;
    Unbinder unbinder;
    private MyExtendBean myExtendBean;
    private MyExtendMoneyFragmentAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            myExtendBean = (MyExtendBean) bundle.getSerializable("myExtendMoneyFragment");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_extend1,null);
        unbinder = ButterKnife.bind(this, rootView);
        adapter = new MyExtendMoneyFragmentAdapter(R.layout.adapter_my_extend_money, null);
        if (myExtendBean != null) {
            adapter.addData(myExtendBean.getWithdrawList());
        }
        initData();
        return rootView;

    }

    private void initData() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        extendRv1.setLayoutManager(linearLayoutManager);
        extendRv1.setAdapter(adapter);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
