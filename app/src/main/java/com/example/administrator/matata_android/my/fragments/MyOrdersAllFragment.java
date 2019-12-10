package com.example.administrator.matata_android.my.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.MyOrderBean;
import com.example.administrator.matata_android.my.adapters.MyOrdersAdapter;
import com.example.administrator.matata_android.zhzbase.base.BaseFragment;

public class MyOrdersAllFragment extends Fragment {
    boolean mIsPrepare = false;		//视图还没准备好
    boolean mIsVisible= false;		//不可见
    boolean mIsFirstLoad = true;	//第一次加载
    View rootView;
    private MyOrderBean myOrderBean;
    private RecyclerView recyclerView;
    private MyOrdersAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle=getArguments();

        if (bundle!=null){
            myOrderBean=(MyOrderBean)bundle.getSerializable("myOrdersAllFragment");
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mIsPrepare=true;
        lazyLoad();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //isVisibleToUser这个boolean值表示:该Fragment的UI 用户是否可见
        if (isVisibleToUser) {
            mIsVisible = true;
            lazyLoad();
        } else {
            mIsVisible = false;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (rootView==null){
            rootView=inflater.inflate(R.layout.fragment_all_orders,container,false);
            recyclerView=(RecyclerView)rootView.findViewById(R.id.my_order_rv);
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(linearLayoutManager);
            adapter=new MyOrdersAdapter(getContext(),R.layout.adapter_music_online,null);
            if (myOrderBean!=null){
                adapter.addData(myOrderBean.getAll());
            }
            recyclerView.setAdapter(adapter);
        }
        return rootView;
    }

    /**
     * 懒加载
     */
    private void lazyLoad(){

    }

    /**
     * 加载数据
     */
    private void lazyData(){

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mIsFirstLoad=true;
        mIsPrepare=false;
        mIsVisible = false;
        if (rootView!=null){
            ((ViewGroup)rootView.getParent()).removeView(rootView);
        }
    }

}
