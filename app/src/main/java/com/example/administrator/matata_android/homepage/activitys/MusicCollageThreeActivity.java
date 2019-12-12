package com.example.administrator.matata_android.homepage.activitys;


import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.alibaba.android.vlayout.layout.StickyLayoutHelper;
import com.blankj.utilcode.util.ActivityUtils;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.MusicHotBean;
import com.example.administrator.matata_android.homepage.adapters.SingleLayoutHelperAdapter;
import com.example.administrator.matata_android.homepage.adapters.SingleLayoutHelperCollageAdapter;
import com.example.administrator.matata_android.homepage.adapters.StickyLayoutHelperAdapter;
import com.example.administrator.matata_android.httputils.BaseObserver;
import com.example.administrator.matata_android.httputils.RetrofitUtil;
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
 * Vlayout效果实现音乐学院页面
 */
public class MusicCollageThreeActivity extends BaseFragmentActivity {

    @BindView(R.id.music_three_rv)
    RecyclerView musicThreeRv;
    @BindView(R.id.title_bar)
    TitleBar titleBar;
    private BaseObserver<List<MusicHotBean>> baseMusicHotBeanObserver;

    private SingleLayoutHelperAdapter singleLayoutHelperAdapter;

    private StickyLayoutHelperAdapter stickyLayoutHelperAdapter;


    private SingleLayoutHelperCollageAdapter singleLayoutHelperCollageAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_music_collage_three);
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
               ActivityUtils. finishActivity(MusicCollageThreeActivity.this);
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
        musicThreeRv.setLayoutManager(layoutManager);

        //设置服用池设置回收复用池大小，（如果一屏内相同类型的 View 个数比较多，需要设置一个合适的大小，防止来回滚动时重新创建 View）：
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        viewPool.setMaxRecycledViews(0, 10);
        musicThreeRv.setRecycledViewPool(viewPool);

        //创建一个adapter的list
        List<DelegateAdapter.Adapter> adapters = new ArrayList<>();


        //创建delegateadapter
        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager, true);

        //单独布局
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelperAdapter = new SingleLayoutHelperAdapter(this, null, singleLayoutHelper);
        getMusicHot();//更新数据
        //向list中添加adapter
        adapters.add(singleLayoutHelperAdapter);

        //吸顶布局
        StickyLayoutHelper stickyLayoutHelper = new StickyLayoutHelper();
        stickyLayoutHelperAdapter = new StickyLayoutHelperAdapter(this, stickyLayoutHelper);
        adapters.add(stickyLayoutHelperAdapter);


        //单独布局+Fragment 实现线上线下课程切换
        SingleLayoutHelper singleLayoutHelper1 = new SingleLayoutHelper();
        singleLayoutHelperCollageAdapter = new SingleLayoutHelperCollageAdapter(this, singleLayoutHelper1, 0);
        adapters.add(singleLayoutHelperCollageAdapter);


        stickyLayoutHelperAdapter.setOnItemClickListener(new StickyLayoutHelperAdapter.OnItemClickListener() {
            @Override
            public void onOnLineClick(View v, int position) {
                singleLayoutHelperCollageAdapter.setType(0);
                delegateAdapter.notifyDataSetChanged();

            }

            @Override
            public void onOffLineClick(View v, int position) {
                singleLayoutHelperCollageAdapter.setType(1);
                delegateAdapter.notifyDataSetChanged();

            }

            @Override
            public void onItemClick(View v, int position) {

            }

            @Override
            public void onItemLongClick(View v, int position) {

            }
        });

        //delegateAdapter可以设置一个Adapter的list
        delegateAdapter.setAdapters(adapters);

        //设置adapter
        musicThreeRv.setAdapter(delegateAdapter);
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
     * 获取最新上架的列表
     */
    private void getMusicHot() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("token", MatataSPUtils.getToken());
        baseMusicHotBeanObserver = new BaseObserver<List<MusicHotBean>>(this, false, false) {
            @Override
            public void onSuccess(List<MusicHotBean> musicHotBean) {
                singleLayoutHelperAdapter.addData(musicHotBean);

            }
        };
        RetrofitUtil.getInstance().getApiService().getMusicHot(map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(baseMusicHotBeanObserver);
    }


}
