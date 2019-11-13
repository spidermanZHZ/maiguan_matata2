package com.example.administrator.matata_android.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.HomepagerTeacherBean;
import com.example.administrator.matata_android.homepage.activitys.HomePagerSearchActivity;
import com.example.administrator.matata_android.homepage.activitys.TheatreCollageActivity;
import com.example.administrator.matata_android.homepage.adapters.HomepagerOneAdapter;
import com.example.administrator.matata_android.homepage.adapters.HomepagerThreeAdapter;
import com.example.administrator.matata_android.homepage.adapters.HomepagerTwoAdapter;
import com.example.administrator.matata_android.httputils.BaseObserver;
import com.example.administrator.matata_android.httputils.RetrofitUtil;
import com.example.administrator.matata_android.zhzbase.base.BaseApplication;
import com.example.administrator.matata_android.zhzbase.base.BaseViewNeedSetFragment;
import com.example.administrator.matata_android.zhzbase.utils.MatataSPUtils;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 首页fragment页面
 */
public class HomePageFragment extends BaseViewNeedSetFragment {


    @BindView(R.id.home_pager_rv)
    RecyclerView homePagerRv;
    Unbinder unbinder;
    @BindView(R.id.home_pager_title_bar)
    TitleBar homePagerTitleBar;
    private BaseObserver<HomepagerTeacherBean> teacherBeanBaseObserver;
    private HomepagerOneAdapter homepagerOneAdapter;
    private HomepagerTwoAdapter homepagerTwoAdapter;
    private HomepagerThreeAdapter homepagerThreeAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_homepage, container, false);
        unbinder = ButterKnife.bind(this, view);
        initData();
        return view;
    }

    public void initData() {
        homePagerTitleBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onLeftClick(View v) {

            }

            @Override
            public void onTitleClick(View v) {

            }

            @Override
            public void onRightClick(View v) {
                startActivity(new Intent(getContext(), HomePagerSearchActivity.class));
            }
        });
        //创建VirtuaLayoutManager
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(BaseApplication.getInstance());
        homePagerRv.setLayoutManager(layoutManager);

        //设置服用池设置回收复用池大小，（如果一屏内相同类型的 View 个数比较多，需要设置一个合适的大小，防止来回滚动时重新创建 View）：
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        viewPool.setMaxRecycledViews(0, 10);
        homePagerRv.setRecycledViewPool(viewPool);

        //创建一个adapter的list
        List<DelegateAdapter.Adapter> adapters = new ArrayList<>();

        //创建delegateadapter
        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager, true);

        //装载轮播图
        SingleLayoutHelper singleLayoutHelper2 = new SingleLayoutHelper();
        homepagerOneAdapter = new HomepagerOneAdapter(getContext(), singleLayoutHelper2, null);

//        StickyLayoutHelper stickyLayoutHelper = new StickyLayoutHelper();
//        homepagerFourAdapter = new HomepagerFourAdapter(getContext(), stickyLayoutHelper);

        //单独布局，热门老师
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        homepagerTwoAdapter = new HomepagerTwoAdapter(getContext(), singleLayoutHelper, null);

        //装载热门课程
        SingleLayoutHelper singleLayoutHelper13 = new SingleLayoutHelper();
        homepagerThreeAdapter = new HomepagerThreeAdapter(getContext(), singleLayoutHelper13, null);


        //加载资源
        getHomePagerInfo();

        adapters.add(homepagerOneAdapter);
        //  adapters.add(homepagerFourAdapter);
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
        teacherBeanBaseObserver = new BaseObserver<HomepagerTeacherBean>(getContext(), true, false) {
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
}
