package com.example.administrator.matata_android.homepage.activitys;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.OnLineCourseBean;
import com.example.administrator.matata_android.homepage.adapters.ArtCampAtPicAdapter;
import com.example.administrator.matata_android.homepage.adapters.CourseDeatilsAdapter;
import com.example.administrator.matata_android.homepage.fragments.CourseDetailsCatalogFragment;
import com.example.administrator.matata_android.homepage.fragments.CourseDetailsFragment;
import com.example.administrator.matata_android.homepage.fragments.CourseDetailsRemarkFragment;
import com.example.administrator.matata_android.httputils.BaseObserver;
import com.example.administrator.matata_android.httputils.RetrofitUtil;
import com.example.administrator.matata_android.zhzbase.base.BaseFragmentActivity;
import com.example.administrator.matata_android.zhzbase.utils.MatataSPUtils;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.indicator.ScrollIndicatorView;
import com.shizhefei.view.indicator.slidebar.SpringBar;
import com.shizhefei.view.indicator.transition.OnTransitionTextListener;

import org.greenrobot.eventbus.EventBus;

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

    @BindView(R.id.course_details_price)
    TextView courseDetailsPrice;
    @BindView(R.id.course_details_join)
    TextView courseDetailsJoin;
    @BindView(R.id.spring_indicator)
    ScrollIndicatorView indicator;
    @BindView(R.id.spring_viewPager)
    ViewPager viewPager;

    private List<Fragment> fragmentList;

    private ArtCampAtPicAdapter adapter;
    private BaseObserver<OnLineCourseBean> beanBaseObservers;
    private String onlineId;

    private CourseDetailsFragment courseDetailsFragment = new CourseDetailsFragment();
    private CourseDetailsCatalogFragment courseDetailsCatalogFragment = new CourseDetailsCatalogFragment();
    private CourseDetailsRemarkFragment courseDetailsRemarkFragment = new CourseDetailsRemarkFragment();


    private IndicatorViewPager indicatorViewPager;
    private LayoutInflater inflate;
    private int unSelectColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_course_details);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void getExras() {
        Intent intent = getIntent();
        onlineId = intent.getStringExtra("onlineId");

        Bundle bundless = new Bundle();
        bundless.putString("CourseDetailsFragment_url", onlineId);
        courseDetailsFragment.setArguments(bundless);

    }

    @Override
    protected void initData() {

        adapter = new ArtCampAtPicAdapter(this, null);
        getCourseDetails();
        courseDetailsCoverflowRecycler.setAdapter(adapter);


        int selectColor = Color.parseColor("#f8f8f8");
        unSelectColor = Color.parseColor("#010101");

        indicator.setOnTransitionListener(new OnTransitionTextListener().setColor(selectColor, unSelectColor));
        indicator.setScrollBar(new SpringBar(getApplicationContext(), Color.GRAY));
        viewPager.setOffscreenPageLimit(1);//保持当前页的前后一页，当fragment过多时会被销毁
        indicatorViewPager = new IndicatorViewPager(indicator, viewPager);
        inflate = LayoutInflater.from(getApplicationContext());

        fragmentList = new ArrayList<>();
        fragmentList.add(courseDetailsFragment);
        fragmentList.add(courseDetailsCatalogFragment);
        fragmentList.add(courseDetailsRemarkFragment);

        indicatorViewPager.setAdapter(new CourseDetailsActivity.CourseDetailsAdapter(getSupportFragmentManager(), fragmentList));
        indicatorViewPager.setCurrentItem(0, false);

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
    private void getCourseDetails() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("token", MatataSPUtils.getToken());
        map.put("onlineId", onlineId);

        beanBaseObservers = new BaseObserver<OnLineCourseBean>(this, true, false) {
            @Override
            public void onSuccess(OnLineCourseBean onLineCourseBean) {

                adapter.getData(onLineCourseBean.getDetail_pic());
                adapter.notifyDataSetChanged();

                //设置数据
                courseDetailsTitle.setText(onLineCourseBean.getName());
                courseDetailsLabel.setText(String.valueOf("共" + onLineCourseBean.getNum() + "节"));
                courseDetailsWorkOff.setText(String.valueOf("已售出" + onLineCourseBean.getPay_num()));


                //发送数据
                EventBus.getDefault().post(onLineCourseBean);

                Bundle bundle = new Bundle();
                bundle.putSerializable("CourseDetailsRemarkFragment_Online", onLineCourseBean);
                courseDetailsRemarkFragment.setArguments(bundle);

            }

        };
        RetrofitUtil.getInstance().getApiService().getOnlineCourse(map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(beanBaseObservers);


    }


    private class CourseDetailsAdapter extends IndicatorViewPager.IndicatorFragmentPagerAdapter {
        private List<Fragment> fragmentList;

        public CourseDetailsAdapter(FragmentManager fragmentManager, List<Fragment> fragments) {
            super(fragmentManager);
            this.fragmentList = fragments;
        }

        @Override
        public int getCount() {
            return fragmentList.size();//2个fragment
        }

        @Override
        public View getViewForTab(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = inflate.inflate(R.layout.tab_top, container, false);
            }
            TextView textView = (TextView) convertView;
            textView.setText(names[position % names.length]);
            int padding = dipToPix(10);
            textView.setPadding(padding, 0, padding, 0);
            return convertView;
        }


        @Override
        public Fragment getFragmentForPage(int position) {
            return fragmentList.get(position);
        }

    }



    private String[] names = {"课程介绍", "课程目录","课程评价"};

    /**
     * 根据dip值转化成px值
     *
     * @param dip
     * @return
     */
    private int dipToPix(float dip) {
        int size = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, getResources().getDisplayMetrics());
        return size;
    }
}
