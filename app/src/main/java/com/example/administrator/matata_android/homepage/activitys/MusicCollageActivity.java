package com.example.administrator.matata_android.homepage.activitys;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;


import android.widget.TextView;
import android.widget.Toast;

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
import recycler.coverflow.RecyclerCoverFlow;

/**
 * 首页二级页面，音乐学院页面
 */
public class MusicCollageActivity extends BaseFragmentActivity {

    @BindView(R.id.music_tv_refresh_hot)
    TextView musicTvRefreshHot;
    @BindView(R.id.coverflow_recycler)
    RecyclerCoverFlow coverflowRecycler;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    private   TabLayout tabLayout;
    private BaseObserver<List<MusicHotBean>> baseMusicHotBeanObserver;
    private MusicHotAdapter hotAdapter;
    private List<Fragment> fragmentList;
    private List<String> list_Title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_music_collage);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onResume() {
        super.onResume();
        getMusicHot();
    }

    @Override
    protected void getExras() {

    }

    @Override
    protected void initData() {
        tabLayout=(TabLayout)findViewById(R.id.tablelayout);
        getMusicHot();
        hotAdapter = new MusicHotAdapter(this, R.layout.adapter_music_hot, null);
        coverflowRecycler.setAdapter(hotAdapter);

        fragmentList=new ArrayList<>();
        fragmentList.add(new MusicOnlineFragment());
        fragmentList.add(new MusicOfflineFragment());
        list_Title = new ArrayList<>();
        list_Title.add("one");
        list_Title.add("two");

        viewpager.setAdapter(new MusicPageAdapter(getSupportFragmentManager(),fragmentList,MusicCollageActivity.this,list_Title));
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
                        Toast.makeText(MusicCollageActivity.this, "请求成功", Toast.LENGTH_SHORT).show();
                        Toast.makeText(MusicCollageActivity.this, "点击了第" + position + "位置", Toast.LENGTH_SHORT).show();
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
