package com.example.administrator.matata_android.homepage.activitys;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.MusicHotBean;
import com.example.administrator.matata_android.homepage.adapters.MusicHotAdapter;
import com.example.administrator.matata_android.homepage.adapters.MusicPageAdapter;
import com.example.administrator.matata_android.homepage.fragments.MusicOfflineFragment;
import com.example.administrator.matata_android.homepage.fragments.MusicOnlineFragment;
import com.example.administrator.matata_android.httputils.BaseObserver;
import com.example.administrator.matata_android.httputils.RetrofitUtil;
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
import liang.lollipop.rvbannerlib.BannerUtil4J;

/**
 * 首页二级页面，音乐学院页面
 */
public class MusicCollageActivity extends BaseFragmentActivity {

    @BindView(R.id.music_tv_refresh_hot)
    TextView musicTvRefreshHot;

    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.abl_bar)
    AppBarLayout ablBar;
    @BindView(R.id.music_recycler)
    RecyclerView musicRecycler;


    private TabLayout tabLayout;
    private BaseObserver<List<MusicHotBean>> baseMusicHotBeanObserver;
    private MusicHotAdapter hotAdapter;
    private List<Fragment> fragmentList;
    private List<String> list_Title;

    private MusicOnlineFragment musicOnlineFragment = new MusicOnlineFragment();
    private MusicOfflineFragment musicOfflineFragment = new MusicOfflineFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_music_collage);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void getExras() {

        ablBar.post(new Runnable() {
            @Override
            public void run() {
                CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) ablBar.getLayoutParams();
                AppBarLayout.Behavior behavior = (AppBarLayout.Behavior) params.getBehavior();
                if (behavior != null) {
                    behavior.setDragCallback(new AppBarLayout.Behavior.DragCallback() {
                        @Override
                        public boolean canDrag(@NonNull AppBarLayout appBarLayout) {
                            return true;
                        }
                    });
                }
            }
        });

    }

    @Override
    protected void initData() {
        tabLayout = (TabLayout) findViewById(R.id.tablelayout);
        hotAdapter = new MusicHotAdapter(this, R.layout.adapter_music_hot, null);

        getMusicHot();

        //如果使用默认设置，那么可以像下方这样，3行代码
        BannerUtil4J.with(musicRecycler)//关联一个RecyclerView
                .attachAdapter(hotAdapter )//传入RecyclerView的Adapter
                .init();//执行初始化

        fragmentList = new ArrayList<>();
        fragmentList.add(musicOnlineFragment);
        fragmentList.add(musicOfflineFragment);
        list_Title = new ArrayList<>();
        list_Title.add("one");
        list_Title.add("two");
        viewpager.setAdapter(new MusicPageAdapter(getSupportFragmentManager(), fragmentList, MusicCollageActivity.this, list_Title));
        tabLayout.setupWithViewPager(viewpager);

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

                hotAdapter.addData(musicHotBean);
                hotAdapter.notifyDataSetChanged();

                hotAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        Intent intent = new Intent(MusicCollageActivity.this, CourseDetailsActivity.class);
                        intent.putExtra("onlineId", musicHotBean.get(position).getId());
                        startActivity(intent);
                    }
                });
            }
        };
        RetrofitUtil.getInstance().getApiService().getMusicHot(map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(baseMusicHotBeanObserver);
    }
}
