package com.example.administrator.matata_android.my.activitys;


import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.alibaba.android.vlayout.layout.StickyLayoutHelper;
import com.blankj.utilcode.util.ActivityUtils;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.MyFollowBean;
import com.example.administrator.matata_android.httputils.BaseObserver;
import com.example.administrator.matata_android.httputils.RetrofitUtil;
import com.example.administrator.matata_android.my.adapters.MyFollowSingleLayoutAdapter;
import com.example.administrator.matata_android.my.adapters.MyFollowStickyLayoutHelperAdapter;
import com.example.administrator.matata_android.zhzbase.base.BaseActivity;
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
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * 我的收藏页面
 */
public class MyFollowActivity extends BaseFragmentActivity {

    @BindView(R.id.my_follow_bar)
    TitleBar myFollowBar;
    @BindView(R.id.my_follow_rv)
    RecyclerView myFollowRv;

    private MyFollowStickyLayoutHelperAdapter myFollowStickyLayoutHelperAdapter;
    private MyFollowSingleLayoutAdapter myFollowSingleLayoutAdapter;

    private BaseObserver<MyFollowBean> myFollowBeanBaseObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_my_follow);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void getExras() {

    }

    @Override
    protected void initData() {
        myFollowBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onLeftClick(View v) {
                ActivityUtils.finishActivity(MyFollowActivity.this);
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
        myFollowRv.setLayoutManager(layoutManager);

        //设置服用池设置回收复用池大小，（如果一屏内相同类型的 View 个数比较多，需要设置一个合适的大小，防止来回滚动时重新创建 View）：
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        viewPool.setMaxRecycledViews(0, 10);
        myFollowRv.setRecycledViewPool(viewPool);

        //创建一个adapter的list
        List<DelegateAdapter.Adapter> adapters=new ArrayList<>();

        //创建delegateadapter
        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager, true);

        //吸顶布局
        StickyLayoutHelper stickyLayoutHelper=new StickyLayoutHelper();
        myFollowStickyLayoutHelperAdapter=new MyFollowStickyLayoutHelperAdapter(this,stickyLayoutHelper);


        //底部Fragment
        SingleLayoutHelper singleLayoutHelper1=new SingleLayoutHelper();
        myFollowSingleLayoutAdapter=new MyFollowSingleLayoutAdapter(this,singleLayoutHelper1,0,null);

        getFavorite();

        adapters.add(myFollowStickyLayoutHelperAdapter);
        adapters.add(myFollowSingleLayoutAdapter);
        myFollowStickyLayoutHelperAdapter.setOnItemClickListener(new MyFollowStickyLayoutHelperAdapter.OnItemClickListener() {
            @Override
            public void onTeacherClick(View v, int position) {
                myFollowSingleLayoutAdapter.setType(0);
            }

            @Override
            public void onOnlineCourseClick(View v, int position) {
                myFollowSingleLayoutAdapter.setType(1);
            }

            @Override
            public void onOfflineCourseClick(View v, int position) {
                myFollowSingleLayoutAdapter.setType(2);
            }

            @Override
            public void onItemClick(View v, int position) {

            }

            @Override
            public void onItemLongClick(View v, int position) {

            }
        });

        delegateAdapter.setAdapters(adapters);
        myFollowRv.setAdapter(delegateAdapter);

    }

    @Override
    protected void setListener() {

    }

    /**
     * 获取收藏的课程
     */
    private void getFavorite(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("token", MatataSPUtils.getToken());
       myFollowBeanBaseObserver=new BaseObserver<MyFollowBean>(this,true,false) {
           @Override
           public void onSuccess(MyFollowBean myFollowBean) {
               Toast.makeText(MyFollowActivity.this, "请求成功", Toast.LENGTH_SHORT).show();
               myFollowSingleLayoutAdapter.addData(myFollowBean);
           }
       };
        RetrofitUtil.getInstance().getApiService().getFavoriteProject(map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(myFollowBeanBaseObserver);

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
