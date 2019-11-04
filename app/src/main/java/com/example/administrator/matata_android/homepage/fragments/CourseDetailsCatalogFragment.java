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
import com.example.administrator.matata_android.zhzbase.base.BaseFragment;
import com.example.administrator.matata_android.zhzbase.base.BaseViewNeedSetFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.w3c.dom.Text;

/**
 * 课程详情里课程目录
 */
public class CourseDetailsCatalogFragment  extends BaseViewNeedSetFragment {

    private RecyclerView rv;
    private TextView textView;
    private CourseDetailsCatalogFragmentAdapter adapter;
private String testsss;

    private OnLineCourseBean onLineCourseBean;


    private static final String BUNDLE_ONLINE="CourseDetailsCatalogFragment_Online";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle=CourseDetailsCatalogFragment.this.getArguments();
        if (bundle!=null){
            onLineCourseBean=(OnLineCourseBean)bundle.getSerializable(BUNDLE_ONLINE);
            testsss=bundle.getString(BUNDLE_ONLINE);
            Toast.makeText(getContext(),"第2个fragment" +testsss, Toast.LENGTH_SHORT).show();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =inflater.inflate( R.layout.fragment_course_details_catalog, container,false);
        EventBus.getDefault().register(this);

        rv=(RecyclerView)view.findViewById(R.id.course_details_catalog_rv);
        textView=(TextView)view.findViewById(R.id.test2222);
        adapter=new CourseDetailsCatalogFragmentAdapter(getContext(),R.layout.adapter_course_details_catalog,null);
        if (onLineCourseBean!=null){
            adapter.addData(onLineCourseBean.getCatalog());
            adapter.notifyDataSetChanged();
        }
        initData();
        return view;
    }

    private void initData(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(adapter);
    }


    /**
     *接受数据
     * @param onLineCourseBean
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void  Event(OnLineCourseBean onLineCourseBean) {
       adapter.addData(onLineCourseBean.getCatalog());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(EventBus.getDefault().isRegistered(this))
        {
            EventBus.getDefault().unregister(this);
        }
    }
}
