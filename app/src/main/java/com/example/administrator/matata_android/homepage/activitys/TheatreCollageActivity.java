package com.example.administrator.matata_android.homepage.activitys;


import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.zhzbase.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TheatreCollageActivity extends BaseActivity {

    @BindView(R.id.theatre_collage_rv)
    RecyclerView theatreCollageRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_theatre_collage);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);


    }

    @Override
    protected void getExras() {

    }

    @Override
    protected void initData() {
        //创建VirtuaLayoutManager
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(this);
        theatreCollageRv.setLayoutManager(layoutManager);

        //设置服用池设置回收复用池大小，（如果一屏内相同类型的 View 个数比较多，需要设置一个合适的大小，防止来回滚动时重新创建 View）：
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        viewPool.setMaxRecycledViews(0, 10);
        theatreCollageRv.setRecycledViewPool(viewPool);

        //创建一个adapter的list
        List<DelegateAdapter.Adapter> adapters=new ArrayList<>();


        //创建delegateadapter
        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager, true);






    }

    @Override
    protected void setListener() {

    }

    @Override
    protected boolean onKeyBack() {
        return false;
    }

    @Override
    protected boolean onKeyMenu() {
        return false;
    }
}
