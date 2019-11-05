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
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.OnLineCourseBean;
import com.example.administrator.matata_android.homepage.WrapContentHeightViewPager;
import com.example.administrator.matata_android.homepage.adapters.CourseDetailsCatalogFragmentAdapter;
import com.example.administrator.matata_android.httputils.BaseObserver;
import com.example.administrator.matata_android.httputils.RetrofitUtil;
import com.example.administrator.matata_android.zhzbase.base.BaseFragment;
import com.example.administrator.matata_android.zhzbase.base.BaseViewNeedSetFragment;
import com.example.administrator.matata_android.zhzbase.utils.MatataSPUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 课程详情里课程目录
 */
public class CourseDetailsCatalogFragment  extends BaseViewNeedSetFragment {

    private RecyclerView rv;

    private CourseDetailsCatalogFragmentAdapter adapter;

    private OnLineCourseBean onLineCourseBean;


    private static final String BUNDLE_ONLINE="CourseDetailsCatalogFragment_Online";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle=CourseDetailsCatalogFragment.this.getArguments();
        if (bundle!=null){
            onLineCourseBean=(OnLineCourseBean)bundle.getSerializable(BUNDLE_ONLINE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =inflater.inflate( R.layout.fragment_course_details_catalog, container,false);

        rv=(RecyclerView)view.findViewById(R.id.course_details_catalog_rv);
        adapter=new CourseDetailsCatalogFragmentAdapter(R.layout.adapter_course_details_catalog,onLineCourseBean.getCatalog());
        adapter.addData(onLineCourseBean.getCatalog());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(adapter);

        return view;
    }



}
