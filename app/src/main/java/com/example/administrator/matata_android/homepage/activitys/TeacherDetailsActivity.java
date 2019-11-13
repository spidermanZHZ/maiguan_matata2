package com.example.administrator.matata_android.homepage.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.alibaba.android.vlayout.layout.StickyLayoutHelper;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.TeacherDetailsInfoBean;
import com.example.administrator.matata_android.homepage.adapters.DetailSingleLayoutTheatreCollageTwoAdapter;
import com.example.administrator.matata_android.homepage.adapters.StickyLayoutHelperTheatreTwoAdapter;
import com.example.administrator.matata_android.homepage.adapters.TeacherDetailsSingleLayoutAdapter;
import com.example.administrator.matata_android.homepage.adapters.TeacherStickyLayoutHelperAdapter;
import com.example.administrator.matata_android.homepage.adapters.TeacherTwoDetailSingleLayoutAdapter;
import com.example.administrator.matata_android.homepage.adapters.TheatreCollageDetailsSingleLayoutAdapter;
import com.example.administrator.matata_android.httputils.BaseObserver;
import com.example.administrator.matata_android.httputils.RetrofitUtil;
import com.example.administrator.matata_android.zhzbase.base.BaseActivity;
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

/**
 * 老师详情页面
 */
public class TeacherDetailsActivity extends BaseFragmentActivity {

    @BindView(R.id.teacher_rv)
    RecyclerView teacherRv;
    private BaseObserver<TeacherDetailsInfoBean> teacherInfoBeanBaseObserver;
    private String teacher_id;

    private TeacherDetailsSingleLayoutAdapter teacherDetailsSingleLayoutAdapter;
    private TeacherStickyLayoutHelperAdapter stickyLayoutHelperTwoAdapter;
    private TeacherTwoDetailSingleLayoutAdapter teacherTwoDetailSingleLayoutAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_teacher_details);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void getExras() {
        Intent intent = getIntent();
        teacher_id = intent.getStringExtra("teacher_id");
    }

    @Override
    protected void initData() {
        //创建VirtuaLayoutManager
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(this);
        teacherRv.setLayoutManager(layoutManager);

        //设置服用池设置回收复用池大小，（如果一屏内相同类型的 View 个数比较多，需要设置一个合适的大小，防止来回滚动时重新创建 View）：
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        viewPool.setMaxRecycledViews(0, 10);
        teacherRv.setRecycledViewPool(viewPool);

        //创建一个adapter的list
        List<DelegateAdapter.Adapter> adapters = new ArrayList<>();

        //创建delegateadapter
        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager, true);
        //单独布局
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        teacherDetailsSingleLayoutAdapter=new TeacherDetailsSingleLayoutAdapter(this,singleLayoutHelper,null);

        //底部ViewPager+Fragment
        SingleLayoutHelper singleLayoutHelper1 = new SingleLayoutHelper();
        teacherTwoDetailSingleLayoutAdapter = new TeacherTwoDetailSingleLayoutAdapter(this, singleLayoutHelper1, 0, null, teacher_id);

        getCourseDetails();

        //吸顶布局
        StickyLayoutHelper stickyLayoutHelper = new StickyLayoutHelper();
        stickyLayoutHelperTwoAdapter = new TeacherStickyLayoutHelperAdapter(this, stickyLayoutHelper);

          adapters.add(teacherDetailsSingleLayoutAdapter);
          adapters.add(stickyLayoutHelperTwoAdapter);
          adapters.add(teacherTwoDetailSingleLayoutAdapter);

        delegateAdapter.setAdapters(adapters);
        teacherRv.setAdapter(delegateAdapter);


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
     * 获取老师详情
     */
    private void getCourseDetails() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("token", MatataSPUtils.getToken());
        map.put("teacher_id", teacher_id);
        teacherInfoBeanBaseObserver = new BaseObserver<TeacherDetailsInfoBean>(this, true, false) {
            @Override
            public void onSuccess(TeacherDetailsInfoBean teacherDetailsInfoBean) {
                teacherDetailsSingleLayoutAdapter.addData(teacherDetailsInfoBean);
                teacherTwoDetailSingleLayoutAdapter.addData(teacherDetailsInfoBean);
            }


        };
        RetrofitUtil.getInstance().getApiService().getTeacherDetails(map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(teacherInfoBeanBaseObserver);
    }

}
