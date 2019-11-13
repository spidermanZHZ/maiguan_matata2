package com.example.administrator.matata_android.my.activitys;


import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.alibaba.android.vlayout.layout.StickyLayoutHelper;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.homepage.adapters.TeacherDetailsSingleLayoutAdapter;
import com.example.administrator.matata_android.homepage.adapters.TeacherStickyLayoutHelperAdapter;
import com.example.administrator.matata_android.homepage.adapters.TeacherTwoDetailSingleLayoutAdapter;
import com.example.administrator.matata_android.zhzbase.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * VIP会员页面，git123
 * VIP会员页面，git测试一下
 */
public class MyVipActivity extends BaseActivity {

    @BindView(R.id.my_vip_rv)
    RecyclerView myVipRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_my_vip);
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
        myVipRv.setLayoutManager(layoutManager);

        //设置服用池设置回收复用池大小，（如果一屏内相同类型的 View 个数比较多，需要设置一个合适的大小，防止来回滚动时重新创建 View）：
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        viewPool.setMaxRecycledViews(0, 10);
        myVipRv.setRecycledViewPool(viewPool);

        //创建一个adapter的list
        List<DelegateAdapter.Adapter> adapters = new ArrayList<>();

        //创建delegateadapter
        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager, true);
        //单独布局
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
 //       teacherDetailsSingleLayoutAdapter=new TeacherDetailsSingleLayoutAdapter(this,singleLayoutHelper,null);

        //底部ViewPager+Fragment
        SingleLayoutHelper singleLayoutHelper1 = new SingleLayoutHelper();
       // teacherTwoDetailSingleLayoutAdapter = new TeacherTwoDetailSingleLayoutAdapter(this, singleLayoutHelper1, 0, null, teacher_id);



        //吸顶布局
        StickyLayoutHelper stickyLayoutHelper = new StickyLayoutHelper();
//        stickyLayoutHelperTwoAdapter = new TeacherStickyLayoutHelperAdapter(this, stickyLayoutHelper);

//        adapters.add(teacherDetailsSingleLayoutAdapter);
//        adapters.add(stickyLayoutHelperTwoAdapter);
//        adapters.add(teacherTwoDetailSingleLayoutAdapter);

        delegateAdapter.setAdapters(adapters);
        myVipRv.setAdapter(delegateAdapter);
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
