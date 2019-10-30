package com.example.administrator.matata_android.homepage.activitys;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.MusicHotBean;
import com.example.administrator.matata_android.homepage.adapters.MusicHotAdapter;
import com.example.administrator.matata_android.homepage.fragments.MusicOfflineFragment;
import com.example.administrator.matata_android.homepage.fragments.MusicOnlineFragment;
import com.example.administrator.matata_android.httputils.BaseObserver;
import com.example.administrator.matata_android.httputils.RetrofitUtil;
import com.example.administrator.matata_android.zhzbase.base.BaseFragmentActivity;
import com.example.administrator.matata_android.zhzbase.utils.MatataSPUtils;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.indicator.IndicatorViewPager.IndicatorFragmentPagerAdapter;
import com.shizhefei.view.indicator.ScrollIndicatorView;
import com.shizhefei.view.indicator.slidebar.SpringBar;
import com.shizhefei.view.indicator.transition.OnTransitionTextListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import recycler.coverflow.RecyclerCoverFlow;

public class MusicCollagetwoActivity extends BaseFragmentActivity {


    @BindView(R.id.spring_indicator)
    ScrollIndicatorView indicator;
    @BindView(R.id.spring_viewPager)
    ViewPager viewPager;
    @BindView(R.id.music_tv_refresh_hot)
    TextView musicTvRefreshHot;
    @BindView(R.id.coverflow_recycler)
    RecyclerCoverFlow coverflowRecycler;
    @BindView(R.id.music_ll_top)
    LinearLayout musicLlTop;
    @BindView(R.id.music_nestedscrollview)
    NestedScrollView musicNestedscrollview;


    private int unSelectColor;
    private IndicatorViewPager indicatorViewPager;
    private LayoutInflater inflate;

    private List<Fragment> fragmentList;

    private MusicHotAdapter hotAdapter;
    private BaseObserver<List<MusicHotBean>> baseMusicHotBeanObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_music_collagetwo);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void getExras() {
            int position =musicLlTop.getTop();
            musicNestedscrollview.smoothScrollTo(0,position);
    }

    @Override
    protected void initData() {

        hotAdapter = new MusicHotAdapter(this, R.layout.adapter_music_hot, null);
        getMusicHot();
        coverflowRecycler.setAdapter(hotAdapter);


        int selectColor = Color.parseColor("#f8f8f8");
        unSelectColor = Color.parseColor("#010101");

        indicator.setOnTransitionListener(new OnTransitionTextListener().setColor(selectColor, unSelectColor));
        indicator.setScrollBar(new SpringBar(getApplicationContext(), Color.GRAY));
        viewPager.setOffscreenPageLimit(1);//保持当前页的前后一页，当fragment过多时会被销毁
        indicatorViewPager = new IndicatorViewPager(indicator, viewPager);
        inflate = LayoutInflater.from(getApplicationContext());


        fragmentList = new ArrayList<>();
        fragmentList.add(new MusicOnlineFragment());
        fragmentList.add(new MusicOfflineFragment());

        indicatorViewPager.setAdapter(new MyAdapter(getSupportFragmentManager(), fragmentList));
        indicatorViewPager.setCurrentItem(0, false);

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
                        Intent intent = new Intent(MusicCollagetwoActivity.this, CourseDetailsActivity.class);
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

    private class MyAdapter extends IndicatorFragmentPagerAdapter {
        private List<Fragment> fragmentList;

        public MyAdapter(FragmentManager fragmentManager, List<Fragment> fragments) {
            super(fragmentManager);
            this.fragmentList = fragments;
        }

        @Override
        public int getCount() {
            return fragmentList.size();//2个fragment
        }

        @Override
        public View getViewForTab(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = inflate.inflate(R.layout.tab_top, container, false);
            }
            TextView textView = (TextView) convertView;
            textView.setText(names[position % names.length]);
            int padding = dipToPix(10);
            textView.setPadding(padding, 0, padding, 0);
            return convertView;
        }


        @Override
        public Fragment getFragmentForPage(int position) {
            return fragmentList.get(position);
        }

    }


    private String[] names = {"线上课程", "线下课程"};

    /**
     * 根据dip值转化成px值
     *
     * @param dip
     * @return
     */
    private int dipToPix(float dip) {
        int size = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, getResources().getDisplayMetrics());
        return size;
    }
}
