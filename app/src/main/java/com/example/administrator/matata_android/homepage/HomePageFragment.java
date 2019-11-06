package com.example.administrator.matata_android.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.alibaba.android.vlayout.layout.StickyLayoutHelper;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.HomepagerTeacherBean;
import com.example.administrator.matata_android.homepage.activitys.ArtCampActivity;
import com.example.administrator.matata_android.homepage.activitys.MusicCollageThreeActivity;
import com.example.administrator.matata_android.homepage.activitys.TheatreCollageActivity;
import com.example.administrator.matata_android.homepage.adapters.HomepagerFourAdapter;
import com.example.administrator.matata_android.homepage.adapters.HomepagerOneAdapter;
import com.example.administrator.matata_android.homepage.adapters.HomepagerThreeAdapter;
import com.example.administrator.matata_android.homepage.adapters.HomepagerTwoAdapter;
import com.example.administrator.matata_android.httputils.BaseObserver;
import com.example.administrator.matata_android.httputils.RetrofitUtil;
import com.example.administrator.matata_android.zhzbase.base.BaseApplication;
import com.example.administrator.matata_android.zhzbase.base.BaseFragment;
import com.example.administrator.matata_android.zhzbase.base.BaseViewNeedSetFragment;
import com.example.administrator.matata_android.zhzbase.utils.MatataSPUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.bingoogolapple.bgabanner.BGABanner;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 首页fragment页面
 */
public class HomePageFragment extends BaseViewNeedSetFragment {
    @BindView(R.id.banner_guide_content)
    BGABanner bannerGuideContent;
    @BindView(R.id.ll_homepage_art_camp)
    LinearLayout llHomepageArtCamp;
    @BindView(R.id.rv_homepage_teacher)
    RecyclerView rvHomepageTeacher;
    @BindView(R.id.rv_homepage_course)
    RecyclerView rvHomepageCourse;
    Unbinder unbinder;
    @BindView(R.id.ll_homepage_music)
    LinearLayout llHomepageMusic;
    @BindView(R.id.ll_homepage_theatre)
    LinearLayout llHomepageTheatre;
    @BindView(R.id.ll_homepage_grade)
    LinearLayout llHomepageGrade;
    @BindView(R.id.home_pager_rv)
    RecyclerView homePagerRv;
    private BaseObserver<HomepagerTeacherBean> teacherBeanBaseObserver;
    private HomepagerOneAdapter homepagerOneAdapter;
    private HomepagerTwoAdapter homepagerTwoAdapter;
    private HomepagerThreeAdapter homepagerThreeAdapter;
    private HomepagerFourAdapter homepagerFourAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_homepage,container,false);
        unbinder = ButterKnife.bind(this, view);
        initData();
        return view;
    }

    public void initData() {
        //创建VirtuaLayoutManager
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(BaseApplication.getInstance());
        homePagerRv.setLayoutManager(layoutManager);

        //设置服用池设置回收复用池大小，（如果一屏内相同类型的 View 个数比较多，需要设置一个合适的大小，防止来回滚动时重新创建 View）：
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        viewPool.setMaxRecycledViews(0, 10);
        homePagerRv.setRecycledViewPool(viewPool);

        //创建一个adapter的list
        List<DelegateAdapter.Adapter> adapters=new ArrayList<>();

        //创建delegateadapter
        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager, true);

        //装载轮播图
        SingleLayoutHelper singleLayoutHelper2=new SingleLayoutHelper();
        homepagerOneAdapter=new HomepagerOneAdapter(getContext(),singleLayoutHelper2,null);

        StickyLayoutHelper stickyLayoutHelper=new StickyLayoutHelper();
        homepagerFourAdapter=new HomepagerFourAdapter(getContext(),stickyLayoutHelper);

        //单独布局，热门老师
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        homepagerTwoAdapter=new HomepagerTwoAdapter(getContext(),singleLayoutHelper,null);

        //装载热门课程
        SingleLayoutHelper singleLayoutHelper13=new SingleLayoutHelper();
        homepagerThreeAdapter=new HomepagerThreeAdapter(getContext(),singleLayoutHelper13,null);



        //加载资源
        getHomePagerInfo();

        adapters.add(homepagerOneAdapter);
        adapters.add(homepagerFourAdapter);
        adapters.add(homepagerTwoAdapter);
        adapters.add(homepagerThreeAdapter);

        delegateAdapter.setAdapters(adapters);
        homePagerRv.setAdapter(delegateAdapter);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * 获取最新上架的列表
     */
    private void getHomePagerInfo() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("token", MatataSPUtils.getToken());
       teacherBeanBaseObserver=new BaseObserver<HomepagerTeacherBean>(getContext(),false,false) {
           @Override
           public void onSuccess(HomepagerTeacherBean homepagerTeacherBean) {
               homepagerOneAdapter.addData(homepagerTeacherBean);
               homepagerTwoAdapter.addData(homepagerTeacherBean);
               homepagerThreeAdapter.addData(homepagerTeacherBean);
           }
       };
        RetrofitUtil.getInstance().getApiService().getHomePagerInfo(map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(teacherBeanBaseObserver);
    }





    @OnClick({R.id.ll_homepage_music, R.id.ll_homepage_theatre, R.id.ll_homepage_art_camp, R.id.ll_homepage_grade})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_homepage_music:
                startActivity(new Intent(getActivity(), MusicCollageThreeActivity.class));
                break;
            case R.id.ll_homepage_theatre:
                startActivity(new Intent(getActivity(), TheatreCollageActivity.class));
                break;
            case R.id.ll_homepage_art_camp:
                startActivity(new Intent(getActivity(), ArtCampActivity.class));
                break;
            case R.id.ll_homepage_grade:
                break;
        }
    }
}
