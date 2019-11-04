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
import com.example.administrator.matata_android.homepage.adapters.CourseDetailsRemarkFragmentAdapter;
import com.example.administrator.matata_android.zhzbase.base.BaseFragment;
import com.example.administrator.matata_android.zhzbase.base.BaseViewNeedSetFragment;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * 课程评价
 */
public class CourseDetailsRemarkFragment extends BaseViewNeedSetFragment {


    private RecyclerView courseDetailsRemarkRv;



    private CourseDetailsRemarkFragmentAdapter adapter;

    private OnLineCourseBean onLineCourseBean;

    private static final String BUNDLE_COURSEDETAILSFREMARKRAGMENT_ONLINE="CourseDetailsRemarkFragment_Online";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Bundle bundle=getArguments();
//
//        if (bundle!=null){
//            onLineCourseBean =(OnLineCourseBean)bundle.getSerializable(BUNDLE_COURSEDETAILSFREMARKRAGMENT_ONLINE);
//        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_course_details_remark,  container,false);

        courseDetailsRemarkRv=(RecyclerView)view.findViewById(R.id.course_details_remark_rv);

        adapter=new CourseDetailsRemarkFragmentAdapter(getContext(),R.layout.adapter_course_details_remark,null);


        adapter.addData(onLineCourseBean.getEvaluate());
        adapter.notifyDataSetChanged();
        initData();
        return view;

    }

    @Override
    public void onResume() {
        super.onResume();



    }

    private void initData() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        courseDetailsRemarkRv.setLayoutManager(linearLayoutManager);
        courseDetailsRemarkRv.setAdapter(adapter);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }



}