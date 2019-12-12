package com.example.administrator.matata_android.my.activitys;


import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.blankj.utilcode.util.ActivityUtils;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.MyExtendBean;
import com.example.administrator.matata_android.httputils.BaseObserver;
import com.example.administrator.matata_android.httputils.RetrofitUtil;
import com.example.administrator.matata_android.my.adapters.MyExtendSingleOneAdapter;
import com.example.administrator.matata_android.my.adapters.MyExtendSingleTwoAdapter;
import com.example.administrator.matata_android.zhzbase.base.BaseFragmentActivity;
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

/**
 * 推广中心页面
 */
public class MyExtendActivity extends BaseFragmentActivity {

    @BindView(R.id.extend_rv)
    RecyclerView extendRv;
    @BindView(R.id.title_bar)
    TitleBar titleBar;

    private BaseObserver<MyExtendBean> myExtendBeanBaseObserver;
    private MyExtendSingleOneAdapter myExtendSingleOneAdapter;
    private MyExtendSingleTwoAdapter myExtendSingleTwoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_my_order);
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
                ActivityUtils.finishActivity(MyExtendActivity.class);
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
        extendRv.setLayoutManager(layoutManager);

        //设置服用池设置回收复用池大小，（如果一屏内相同类型的 View 个数比较多，需要设置一个合适的大小，防止来回滚动时重新创建 View）：
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        viewPool.setMaxRecycledViews(0, 10);
        extendRv.setRecycledViewPool(viewPool);

        //创建一个adapter的list
        List<DelegateAdapter.Adapter> adapters = new ArrayList<>();

        //创建delegateadapter
        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager, true);
        //推广中心1
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        myExtendSingleOneAdapter = new MyExtendSingleOneAdapter(this, singleLayoutHelper, null);
        SingleLayoutHelper singleLayoutHelper2 = new SingleLayoutHelper();
        myExtendSingleTwoAdapter = new MyExtendSingleTwoAdapter(this, singleLayoutHelper2, null);
        getExtendInfo();

        adapters.add(myExtendSingleOneAdapter);
        adapters.add(myExtendSingleTwoAdapter);

        delegateAdapter.setAdapters(adapters);
        extendRv.setAdapter(delegateAdapter);

        myExtendSingleOneAdapter.setOnItemClickListener(new MyExtendSingleOneAdapter.OnItemClickListener() {

            @Override
            public void onMoneyClick(View view, int position) {
                myExtendSingleTwoAdapter.setType(0);
                delegateAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFriendClick(View view, int position) {
                myExtendSingleTwoAdapter.setType(1);
                delegateAdapter.notifyDataSetChanged();
            }

            @Override
            public void onTeacherClick(View view, int position) {
                myExtendSingleTwoAdapter.setType(2);
                delegateAdapter.notifyDataSetChanged();
            }

            @Override
            public void onItemClick(View view, int position) {

            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        });
    }

    /**
     * 请求推广中心数据
     */
    private void getExtendInfo() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("token", MatataSPUtils.getToken());
        myExtendBeanBaseObserver = new BaseObserver<MyExtendBean>(this, true, false) {
            @Override
            public void onSuccess(MyExtendBean myExtendBean) {
                if (myExtendBean != null) {

                    myExtendSingleOneAdapter.addData(myExtendBean);
                    myExtendSingleTwoAdapter.addData(myExtendBean);
                    myExtendSingleTwoAdapter.setType(0);
                }

            }
        };
        RetrofitUtil.getInstance().getApiService().getExtendInfo(map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(myExtendBeanBaseObserver);

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
