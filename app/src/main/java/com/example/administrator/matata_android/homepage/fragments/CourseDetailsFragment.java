package com.example.administrator.matata_android.homepage.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.homepage.WrapContentHeightViewPager;
import com.example.administrator.matata_android.zhzbase.base.BaseFragment;
import com.example.administrator.matata_android.zhzbase.base.BaseViewNeedSetFragment;

/**
 * 课程详情fragment
 */
public class CourseDetailsFragment extends BaseViewNeedSetFragment {
    private Context context;
    private String  url;//课程介绍web.url
    private static final String BUNDLE_COURSEDETAILSFRAGMENT_URL="CourseDetailsFragment_url";
    private final String URLweb = "https://www.maiguanjy.com/api/app/view/details";
    private WebView webView;

    private WrapContentHeightViewPager viewPager;
    private static CourseDetailsFragment newInstance(String urls){
        Bundle bundle=new Bundle();
        bundle.putString(BUNDLE_COURSEDETAILSFRAGMENT_URL,urls);
        CourseDetailsFragment courseDetailsFragment=new CourseDetailsFragment();
        courseDetailsFragment.setArguments(bundle);
        return courseDetailsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Bundle bundle=getArguments();
        if (bundle!=null){
            url =bundle.getString(BUNDLE_COURSEDETAILSFRAGMENT_URL);
        }
        View view =inflater.inflate( R.layout.fragment_course_details,null);
        viewPager.setViewForPosition(view,0);
        webView= (WebView)view.findViewById(R.id.course_details_web);
        webView.loadUrl(URLweb+"?id="+url+"&type=course_online");

        return view;
    }

    /**
     * 用于自适应高度
     * @param mViewPagerView
     */
    public void setWrapContentHeightViewPager(WrapContentHeightViewPager mViewPagerView) {
        this.viewPager=mViewPagerView;
    }

}
