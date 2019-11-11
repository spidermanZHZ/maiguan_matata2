package com.example.administrator.matata_android.homepage.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Toast;

import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.zhzbase.base.BaseApplication;
import com.example.administrator.matata_android.zhzbase.base.BaseViewNeedSetFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 课程详情fragment
 */
public class TheatreCourseDetailsFragment extends BaseViewNeedSetFragment {
    @BindView(R.id.course_details_web)
    WebView courseDetailsWeb;
    Unbinder unbinder;
    private Context context;
    private String url;//课程介绍web.url
    private static final String BUNDLE_COURSEDETAILSFRAGMENT_URL = "CourseDetailsFragment_url";
    private final String URLweb = "https://www.maiguanjy.com/api/app/view/details";
    private WebView webView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            url = bundle.getString(BUNDLE_COURSEDETAILSFRAGMENT_URL);
            Toast.makeText(BaseApplication.getInstance(), url, Toast.LENGTH_SHORT).show();
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_course_details, container,false);
        unbinder = ButterKnife.bind(this, view);
        courseDetailsWeb.loadUrl(URLweb + "?id=" + url + "&type=course_offline");
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
