package com.example.administrator.matata_android.homepage.activitys;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.alibaba.android.vlayout.layout.StickyLayoutHelper;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.TheatreCourseDetailsBean;
import com.example.administrator.matata_android.bean.TheatreHotInfoBean;
import com.example.administrator.matata_android.homepage.adapters.TheatreCollageOneAdapter;
import com.example.administrator.matata_android.homepage.adapters.TheatreCollageStickyLayoutHelperAdapter;
import com.example.administrator.matata_android.homepage.adapters.TheatreCollageTwoAdapter;
import com.example.administrator.matata_android.homepage.adapters.TheatreCollageTwoSingleLayoutHelperAdapter;
import com.example.administrator.matata_android.httputils.BaseObserver;
import com.example.administrator.matata_android.httputils.RetrofitUtil;
import com.example.administrator.matata_android.zhzbase.base.BaseActivity;
import com.example.administrator.matata_android.zhzbase.utils.MatataSPUtils;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class TheatreEnglishActivity extends BaseActivity {

    @BindView(R.id.theatre_collage_rv)
    RecyclerView theatreCollageRv;
    @BindView(R.id.title_bar)
    TitleBar titleBar;

    private TheatreCollageOneAdapter theatreCollageOneAdapter;
    private TheatreCollageTwoAdapter theatreCollageTwoAdapter;
    private BaseObserver<TheatreHotInfoBean> theatreHotInfoBeanBaseObserver;
    private BaseObserver<TheatreCourseDetailsBean> beanBaseObservers;
    private TheatreCollageStickyLayoutHelperAdapter theatreCollageStickyLayoutHelperAdapter;
    private TheatreCollageTwoSingleLayoutHelperAdapter theatreCollageTwoSingleLayoutHelperAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_theatre_collage);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);


    }

    @Override
    protected void getExras() {

    }

    @Override
    protected void initData() {
        titleBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onLeftClick(View v) {
                finishActivity();
            }

            @Override
            public void onTitleClick(View v) {

            }

            @Override
            public void onRightClick(View v) {

            }
        });

        //创建VirtuaLayoutManager
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(this);
        theatreCollageRv.setLayoutManager(layoutManager);

        //设置服用池设置回收复用池大小，（如果一屏内相同类型的 View 个数比较多，需要设置一个合适的大小，防止来回滚动时重新创建 View）：
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        viewPool.setMaxRecycledViews(0, 10);
        theatreCollageRv.setRecycledViewPool(viewPool);

        //创建一个adapter的list
        List<DelegateAdapter.Adapter> adapters = new ArrayList<>();

        //创建delegateadapter
        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager, true);
        //热门课程
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        theatreCollageOneAdapter = new TheatreCollageOneAdapter(this, singleLayoutHelper, null);
        //绑定数据
        getTheatreHotInfo();

        //吸顶布局。实现分类功能
        StickyLayoutHelper stickyLayoutHelper = new StickyLayoutHelper();
        theatreCollageStickyLayoutHelperAdapter = new TheatreCollageStickyLayoutHelperAdapter(this, stickyLayoutHelper);


        //戏剧课程列表
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        theatreCollageTwoSingleLayoutHelperAdapter = new TheatreCollageTwoSingleLayoutHelperAdapter(this, linearLayoutHelper, null);
        getCourseDetails();


        //分类点击事件
        theatreCollageStickyLayoutHelperAdapter.setOnItemClickListener(new TheatreCollageStickyLayoutHelperAdapter.OnItemClickListener() {
            @Override
            public void onOnLineClick(View v, int position) {

            }

            @Override
            public void onItemClick(View v, int position) {

            }

            @Override
            public void onItemLongClick(View v, int position) {

            }
        });

        adapters.add(theatreCollageOneAdapter);
        adapters.add(theatreCollageStickyLayoutHelperAdapter);
        adapters.add(theatreCollageTwoSingleLayoutHelperAdapter);

        delegateAdapter.setAdapters(adapters);
        theatreCollageRv.setAdapter(delegateAdapter);

    }

    /**
     * 获取戏剧学院热门课程的列表
     */
    private void getTheatreHotInfo() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("token", MatataSPUtils.getToken());
        theatreHotInfoBeanBaseObserver = new BaseObserver<TheatreHotInfoBean>(this, false, false) {
            @Override
            public void onSuccess(TheatreHotInfoBean theatreHotInfoBean) {
                theatreCollageOneAdapter.addData(theatreHotInfoBean);
            }
        };

        RetrofitUtil.getInstance().getApiService().getTheatreInfo(map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(theatreHotInfoBeanBaseObserver);
    }

    /**
     * 获取戏剧全部课程列表
     */
    private void getCourseDetails() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("token", MatataSPUtils.getToken());
        map.put("class_id", "98");

        beanBaseObservers = new BaseObserver<TheatreCourseDetailsBean>(this, true, false) {
            @Override
            public void onSuccess(TheatreCourseDetailsBean theatreCourseDetailsBean) {

                theatreCollageTwoSingleLayoutHelperAdapter.addData(theatreCourseDetailsBean);
                theatreCollageTwoSingleLayoutHelperAdapter.setOnItemClickListener(new TheatreCollageTwoSingleLayoutHelperAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(mContext, TheatreCollageCourseDetailsActivity.class);
                        String id;
//                        if (theatreCourseDetailsBean.getData().size()==1){
//                           id =String.valueOf(theatreCourseDetailsBean.getData().get(0).getId());
//                        }else {
//                            id =String.valueOf(theatreCourseDetailsBean.getData().get(position).getId());
//                        }
                        id = String.valueOf(theatreCourseDetailsBean.getData().get(position).getId());
                        intent.putExtra("offlineId", id);
                        startActivity(intent);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                });
            }

        };
        RetrofitUtil.getInstance().getApiService().getTheatreCourseDetails(map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(beanBaseObservers);


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
}
