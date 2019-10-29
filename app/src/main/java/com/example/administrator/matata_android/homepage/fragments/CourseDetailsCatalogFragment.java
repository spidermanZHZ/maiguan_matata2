package com.example.administrator.matata_android.homepage.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.OnLineCourseBean;
import com.example.administrator.matata_android.homepage.WrapContentHeightViewPager;
import com.example.administrator.matata_android.homepage.adapters.CourseDetailsCatalogFragmentAdapter;
import com.example.administrator.matata_android.zhzbase.base.BaseFragment;
import com.example.administrator.matata_android.zhzbase.base.BaseViewNeedSetFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * 课程详情里课程目录
 */
public class CourseDetailsCatalogFragment  extends BaseViewNeedSetFragment {

    private RecyclerView rv;
    private CourseDetailsCatalogFragmentAdapter adapter;
    private WrapContentHeightViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =inflater.inflate( R.layout.fragment_course_details_catalog,null);
        viewPager.setViewForPosition(view,1);
        adapter=new CourseDetailsCatalogFragmentAdapter(getContext(),R.layout.adapter_course_details_catalog,null);
        rv=(RecyclerView)view.findViewById(R.id.course_details_catalog_rv);

        EventBus.getDefault().register(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(adapter);

        return view;
    }

    /**
     * EventBus接收数据
     * @param onLineCourseBean
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(OnLineCourseBean onLineCourseBean){
        if (onLineCourseBean!=null){
            adapter.addData(onLineCourseBean.getCatalog());
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    /**
     * 用于自适应高度
     * @param mViewPagerView
     */
    public void setWrapContentHeightViewPager(WrapContentHeightViewPager mViewPagerView) {
        this.viewPager=mViewPagerView;
    }
}
