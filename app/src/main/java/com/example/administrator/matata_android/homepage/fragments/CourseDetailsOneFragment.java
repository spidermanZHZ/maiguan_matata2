package com.example.administrator.matata_android.homepage.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.administrator.matata_android.R;

import me.yokeyword.fragmentation.SupportFragment;

public class CourseDetailsOneFragment extends SupportFragment {

   private WebView courseDetailsWeb;
    private String url;//课程介绍web.url
    private static final String BUNDLE_COURSEDETAILSFRAGMENT_URL = "CourseDetailsFragment_url";
    private final String URLweb = "https://www.maiguanjy.com/api/app/view/details";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_course_details, container,false);
        courseDetailsWeb=(WebView)view.findViewById(R.id.course_details_web) ;
        courseDetailsWeb.loadUrl(URLweb + "?id=" + url + "&type=course_online");

        return view;

    }

    @Override
    public void onNewBundle(Bundle args) {
        super.onNewBundle(args);
       url= args.getString("onlineId");
    }
}
