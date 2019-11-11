package com.example.administrator.matata_android.homepage.activitys;


import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.alibaba.android.vlayout.layout.StaggeredGridLayoutHelper;
import com.alibaba.android.vlayout.layout.StickyLayoutHelper;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.homepage.adapters.AllTeacherStaggeredGridHelperAdapter;
import com.example.administrator.matata_android.homepage.adapters.AllTeacherStickyLayoutHelperAdapter;
import com.example.administrator.matata_android.homepage.adapters.SingleLayoutHelperAdapter;
import com.example.administrator.matata_android.homepage.adapters.SingleLayoutHelperCollageAdapter;
import com.example.administrator.matata_android.homepage.adapters.StickyLayoutHelperAdapter;
import com.example.administrator.matata_android.zhzbase.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 全部老师页面
 */
public class AllTeacherActivity extends BaseActivity {

    @BindView(R.id.rv_all_teacher)
    RecyclerView rvAllTeacher;

    private AllTeacherStickyLayoutHelperAdapter allTeacherStickyLayoutHelperAdapter;
    private AllTeacherStaggeredGridHelperAdapter teacherStaggeredGridHelperAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_all_teacher);
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
        rvAllTeacher.setLayoutManager(layoutManager);

        //设置服用池设置回收复用池大小，（如果一屏内相同类型的 View 个数比较多，需要设置一个合适的大小，防止来回滚动时重新创建 View）：
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        viewPool.setMaxRecycledViews(0, 10);
        rvAllTeacher.setRecycledViewPool(viewPool);

        //创建一个adapter的list
        List<DelegateAdapter.Adapter> adapters=new ArrayList<>();


        //创建delegateadapter
        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager, true);


        //吸顶布局,实现顶部筛选条件
        StickyLayoutHelper stickyLayoutHelper=new StickyLayoutHelper();
        allTeacherStickyLayoutHelperAdapter=new AllTeacherStickyLayoutHelperAdapter(this,stickyLayoutHelper);

        //瀑布流效果，老师列表
        StaggeredGridLayoutHelper staggeredGridLayoutHelper  =new StaggeredGridLayoutHelper();
        teacherStaggeredGridHelperAdapter=new AllTeacherStaggeredGridHelperAdapter(this,staggeredGridLayoutHelper,null);

        adapters.add(allTeacherStickyLayoutHelperAdapter);
        adapters.add(teacherStaggeredGridHelperAdapter);
        //delegateAdapter可以设置一个Adapter的list
        delegateAdapter.setAdapters(adapters);

        //设置adapter
        rvAllTeacher.setAdapter(delegateAdapter);
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
