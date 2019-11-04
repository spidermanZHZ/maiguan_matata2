package com.example.administrator.matata_android.homepage.activitys;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.OnLineCourseBean;
import com.example.administrator.matata_android.homepage.adapters.CourseDeatilsAdapter;
import com.example.administrator.matata_android.homepage.adapters.DetailSingleLayoutTwoAdapter;
import com.example.administrator.matata_android.homepage.adapters.DetailsSingleLayoutAdapter;
import com.example.administrator.matata_android.httputils.BaseObserver;
import com.example.administrator.matata_android.httputils.RetrofitUtil;
import com.example.administrator.matata_android.zhzbase.base.BaseFragmentActivity;
import com.example.administrator.matata_android.zhzbase.utils.MatataSPUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CourseDetailsTwoActivity extends BaseFragmentActivity {

    @BindView(R.id.title)
    LinearLayout title;
    @BindView(R.id.course_details_two_rv)
    RecyclerView courseDetailsTwoRv;
    @BindView(R.id.course_details_price)
    TextView courseDetailsPrice;
    @BindView(R.id.course_details_join)
    TextView courseDetailsJoin;

    private String onlineId;

    private BaseObserver<OnLineCourseBean> beanBaseObservers;

    private DetailsSingleLayoutAdapter detailsSingleLayoutAdapter;

    private DetailSingleLayoutTwoAdapter detailSingleLayoutTwoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_course_details_two);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void getExras() {

        Intent intent = getIntent();
        onlineId = intent.getStringExtra("onlineId");


    }

    @Override
    protected void initData() {

        //创建VirtuaLayoutManager
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(this);
        courseDetailsTwoRv.setLayoutManager(layoutManager);

        //设置服用池设置回收复用池大小，（如果一屏内相同类型的 View 个数比较多，需要设置一个合适的大小，防止来回滚动时重新创建 View）：
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        viewPool.setMaxRecycledViews(0, 10);
        courseDetailsTwoRv.setRecycledViewPool(viewPool);

        //创建一个adapter的list
        List<DelegateAdapter.Adapter> adapters=new ArrayList<>();

        //创建delegateadapter
        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager, true);
        //单独布局
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        detailsSingleLayoutAdapter=new DetailsSingleLayoutAdapter(this,singleLayoutHelper,null);
        getCourseDetails();
        adapters.add(detailsSingleLayoutAdapter);

        //底部ViewPager+Fragment
        SingleLayoutHelper singleLayoutHelper1=new SingleLayoutHelper();
        detailSingleLayoutTwoAdapter=new DetailSingleLayoutTwoAdapter(this,singleLayoutHelper1);
        adapters.add(detailSingleLayoutTwoAdapter);



        delegateAdapter.setAdapters(adapters);
        courseDetailsTwoRv.setAdapter(delegateAdapter);

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
                detailsSingleLayoutAdapter.addData(onLineCourseBean);
                Toast.makeText(CourseDetailsTwoActivity.this, "运行到这里、、、", Toast.LENGTH_SHORT).show();
            }

        };
        RetrofitUtil.getInstance().getApiService().getOnlineCourse(map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(beanBaseObservers);


    }
}
