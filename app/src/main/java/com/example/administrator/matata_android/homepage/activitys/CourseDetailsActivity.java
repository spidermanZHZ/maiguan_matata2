package com.example.administrator.matata_android.homepage.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.OnLineCourseBean;
import com.example.administrator.matata_android.homepage.WrapContentHeightViewPager;
import com.example.administrator.matata_android.homepage.adapters.CourseDeatilsAdapter;
import com.example.administrator.matata_android.homepage.adapters.MusicPageAdapter;
import com.example.administrator.matata_android.homepage.fragments.CourseDetailsCatalogFragment;
import com.example.administrator.matata_android.homepage.fragments.CourseDetailsFragment;
import com.example.administrator.matata_android.homepage.fragments.CourseDetailsRemarkFragment;
import com.example.administrator.matata_android.homepage.fragments.MusicOfflineFragment;
import com.example.administrator.matata_android.homepage.fragments.MusicOnlineFragment;
import com.example.administrator.matata_android.httputils.BaseObserver;
import com.example.administrator.matata_android.httputils.RetrofitUtil;
import com.example.administrator.matata_android.zhzbase.base.BaseFragmentActivity;
import com.example.administrator.matata_android.zhzbase.utils.MatataSPUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import recycler.coverflow.RecyclerCoverFlow;

/**
 * 课程详情页面
 */
public class CourseDetailsActivity extends BaseFragmentActivity {

    @BindView(R.id.title)
    LinearLayout title;
    @BindView(R.id.course_details_coverflow_recycler)
    RecyclerCoverFlow courseDetailsCoverflowRecycler;
    @BindView(R.id.course_details_title)
    TextView courseDetailsTitle;
    @BindView(R.id.course_details_label)
    TextView courseDetailsLabel;
    @BindView(R.id.course_details_collect_iv)
    ImageView courseDetailsCollectIv;
    @BindView(R.id.course_details_collect_tv)
    TextView courseDetailsCollectTv;
    @BindView(R.id.course_details_collect)
    LinearLayout courseDetailsCollect;
    @BindView(R.id.course_details_work_off)
    TextView courseDetailsWorkOff;
    @BindView(R.id.course_details_tablelayout)
    TabLayout courseDetailsTablelayout;
    @BindView(R.id.course_details_viewpager)
    WrapContentHeightViewPager viewPager;
    @BindView(R.id.course_details_price)
    TextView courseDetailsPrice;
    @BindView(R.id.course_details_join)
    TextView courseDetailsJoin;

    private List<Fragment> fragmentList;
    private List<String> list_Title;
    private CourseDeatilsAdapter adapter;
    private BaseObserver<OnLineCourseBean> beanBaseObservers;
    private String onlineId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_course_details);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void getExras() {
        Intent intent = getIntent();
        onlineId=intent.getStringExtra("onlineId");
    }

    @Override
    protected void initData() {

        adapter=new CourseDeatilsAdapter(this,R.layout.adapter_course_details_pic,null);

        fragmentList = new ArrayList<>();
        fragmentList.add(new CourseDetailsFragment());
        fragmentList.add(new CourseDetailsCatalogFragment());
        fragmentList.add(new CourseDetailsRemarkFragment());
        list_Title = new ArrayList<>();

        list_Title.add("课程介绍");
        list_Title.add("课程目录");
        list_Title.add("课程评价");

        viewPager.setAdapter(new MusicPageAdapter(getSupportFragmentManager(), fragmentList, CourseDetailsActivity.this, list_Title));
        courseDetailsTablelayout.setupWithViewPager(viewPager);
        getCourseDetails();
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

    /**
     * 获取课程详情
     */
    private void getCourseDetails(){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("token", MatataSPUtils.getToken());
        map.put("onlineId",onlineId);
        beanBaseObservers=new BaseObserver<OnLineCourseBean>(this,false,false) {
            @Override
            public void onSuccess(OnLineCourseBean onLineCourseBean) {
                 adapter.addData(onLineCourseBean);
                 adapter.notifyDataSetChanged();
            }
        };
        RetrofitUtil.getInstance().getApiService().getOnlineCourse(map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(beanBaseObservers);
    }
}
