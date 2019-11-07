package com.example.administrator.matata_android.homepage.activitys;


import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.HomepagerTeacherBean;
import com.example.administrator.matata_android.bean.TheatreHotInfoBean;
import com.example.administrator.matata_android.homepage.adapters.TheatreCollageOneAdapter;
import com.example.administrator.matata_android.homepage.adapters.TheatreCollageTwoAdapter;
import com.example.administrator.matata_android.httputils.BaseObserver;
import com.example.administrator.matata_android.httputils.RetrofitUtil;
import com.example.administrator.matata_android.zhzbase.base.BaseActivity;
import com.example.administrator.matata_android.zhzbase.utils.MatataSPUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class TheatreCollageActivity extends BaseActivity {

    @BindView(R.id.theatre_collage_rv)
    RecyclerView theatreCollageRv;

    private TheatreCollageOneAdapter theatreCollageOneAdapter;
    private TheatreCollageTwoAdapter theatreCollageTwoAdapter;
    private BaseObserver<TheatreHotInfoBean> theatreHotInfoBeanBaseObserver;

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
        //创建VirtuaLayoutManager
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(this);
        theatreCollageRv.setLayoutManager(layoutManager);

        //设置服用池设置回收复用池大小，（如果一屏内相同类型的 View 个数比较多，需要设置一个合适的大小，防止来回滚动时重新创建 View）：
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        viewPool.setMaxRecycledViews(0, 10);
        theatreCollageRv.setRecycledViewPool(viewPool);

        //创建一个adapter的list
        List<DelegateAdapter.Adapter> adapters=new ArrayList<>();

        //创建delegateadapter
        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager, true);
        //热门课程
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        theatreCollageOneAdapter=new TheatreCollageOneAdapter(this,singleLayoutHelper,null);
        //绑定数据
        getTheatreHotInfo();


        adapters.add(theatreCollageOneAdapter);

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
