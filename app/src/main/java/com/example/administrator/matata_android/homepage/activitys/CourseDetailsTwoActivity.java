package com.example.administrator.matata_android.homepage.activitys;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.alibaba.android.vlayout.layout.StickyLayoutHelper;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.BarUtils;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.OnLineCourseBean;
import com.example.administrator.matata_android.homepage.adapters.DetailSingleLayoutTwoAdapter;
import com.example.administrator.matata_android.homepage.adapters.DetailsSingleLayoutAdapter;
import com.example.administrator.matata_android.homepage.adapters.StickyLayoutHelperTwoAdapter;
import com.example.administrator.matata_android.httputils.BaseObserver;
import com.example.administrator.matata_android.httputils.RetrofitUtil;
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
import me.yokeyword.fragmentation.SupportActivity;

/**
 * 线上课程
 */
public class CourseDetailsTwoActivity extends SupportActivity {

    @BindView(R.id.title)
    LinearLayout title;
    @BindView(R.id.course_details_two_rv)
    RecyclerView courseDetailsTwoRv;
    @BindView(R.id.course_details_price)
    TextView courseDetailsPrice;
    @BindView(R.id.course_details_join)
    TextView courseDetailsJoin;
    @BindView(R.id.title_bar)
    TitleBar titleBar;
    private BaseObserver<Object> baseObserver;
    private String onlineId;

    private BaseObserver<OnLineCourseBean> beanBaseObservers;

    private DetailsSingleLayoutAdapter detailsSingleLayoutAdapter;

    private DetailSingleLayoutTwoAdapter detailSingleLayoutTwoAdapter;

    private StickyLayoutHelperTwoAdapter stickyLayoutHelperTwoAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_course_details_two);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);
        BarUtils.setStatusBarColor(this,getResources().getColor(R.color.white),true);
        setAndroidNativeLightStatusBar(this,true);
        getExras();
        initData();
    }

    private static void setAndroidNativeLightStatusBar(Activity activity, boolean dark) {
        View decor = activity.getWindow().getDecorView();
        if (dark) {
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        } else {
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }
    }
    private void getExras() {

        Intent intent = getIntent();
        onlineId = intent.getStringExtra("onlineId");


    }


    private void initData() {
        titleBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onLeftClick(View v) {
                ActivityUtils.finishActivity(CourseDetailsTwoActivity.class);
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
        courseDetailsTwoRv.setLayoutManager(layoutManager);

        //设置服用池设置回收复用池大小，（如果一屏内相同类型的 View 个数比较多，需要设置一个合适的大小，防止来回滚动时重新创建 View）：
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        viewPool.setMaxRecycledViews(0, 10);
        courseDetailsTwoRv.setRecycledViewPool(viewPool);

        //创建一个adapter的list
        List<DelegateAdapter.Adapter> adapters = new ArrayList<>();

        //创建delegateadapter
        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager, true);
        //单独布局
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        detailsSingleLayoutAdapter = new DetailsSingleLayoutAdapter(this, singleLayoutHelper, null);

//        //底部ViewPager+Fragment
//        SingleLayoutHelper singleLayoutHelper1=new SingleLayoutHelper();
//        detailSingleLayoutTwoAdapter=new DetailSingleLayoutTwoAdapter(this,singleLayoutHelper1,0,null,onlineId);

        //底部ViewPager+Fragment
        SingleLayoutHelper singleLayoutHelper1 = new SingleLayoutHelper();
        detailSingleLayoutTwoAdapter = new DetailSingleLayoutTwoAdapter(CourseDetailsTwoActivity.this, singleLayoutHelper1, 0, null, onlineId);

        getCourseDetails();


        adapters.add(detailsSingleLayoutAdapter);

        //吸顶布局
        StickyLayoutHelper stickyLayoutHelper = new StickyLayoutHelper();
        stickyLayoutHelperTwoAdapter = new StickyLayoutHelperTwoAdapter(this, stickyLayoutHelper);
        adapters.add(stickyLayoutHelperTwoAdapter);


        adapters.add(detailSingleLayoutTwoAdapter);

        delegateAdapter.setAdapters(adapters);
        courseDetailsTwoRv.setAdapter(delegateAdapter);

        stickyLayoutHelperTwoAdapter.setOnItemClickListener(new StickyLayoutHelperTwoAdapter.OnItemClickListener() {
            @Override
            public void onCourse(View v, int position) {
                detailSingleLayoutTwoAdapter.setType(0);
                delegateAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCourseTag(View v, int position) {
                detailSingleLayoutTwoAdapter.setType(1);
                delegateAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCourseComment(View v, int position) {
                detailSingleLayoutTwoAdapter.setType(2);
                delegateAdapter.notifyDataSetChanged();
            }

            @Override
            public void onItemClick(View v, int position) {

            }

            @Override
            public void onItemLongClick(View v, int position) {

            }
        });


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
                detailSingleLayoutTwoAdapter.addData(onLineCourseBean);
                detailsSingleLayoutAdapter.setOnItemClickListener(new DetailsSingleLayoutAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }

                    @Override
                    public void onFavoriteClick(View view, int position) {
                        setFavorite(onLineCourseBean, "已成功收藏");
                    }

                    @Override
                    public void onCanleFavoriteClick(View view, int position) {
                        setFavorite(onLineCourseBean, "已取消收藏");
                    }
                });

                if (onLineCourseBean.getOriginal_price()==0){
                    courseDetailsPrice.setText("免费课程");
                    courseDetailsJoin.setText("直接观看");
                }else {


                    courseDetailsPrice.setText(String.valueOf("¥" + onLineCourseBean.getOriginal_price()));
                    if (onLineCourseBean.isIs_purchase()) {
                        courseDetailsJoin.setText("已购买本课程");
                        Toast.makeText(CourseDetailsTwoActivity.this, "已购买本课程，可以永久观看，无需再次购买", Toast.LENGTH_SHORT).show();
                    } else {
                        courseDetailsJoin.setText("购买课程");
                    }
                    courseDetailsJoin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Intent intent = new Intent();
                            intent.setClass(CourseDetailsTwoActivity.this, ArtBuyCompleteActivity.class);
                            intent.putExtra("online_price", onLineCourseBean.getOriginal_price());
                            intent.putExtra("type", "online");
                            intent.putExtra("online_id", String.valueOf(onLineCourseBean.getId()));
                            startActivity(intent);
                        }
                    });
                }
            }

        };
        RetrofitUtil.getInstance().getApiService().getOnlineCourse(map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(beanBaseObservers);


    }

    /**
     * 设置收藏按钮
     */
    private void setFavorite(OnLineCourseBean onLineCourseBean, String string) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("token", MatataSPUtils.getToken());
        map.put("type", "onlineCourse");
        map.put("obj_id", String.valueOf(onLineCourseBean.getId()));
        baseObserver = new BaseObserver<Object>(this, false, false) {
            @Override
            public void onSuccess(Object o) {
                Toast.makeText(CourseDetailsTwoActivity.this, string, Toast.LENGTH_SHORT).show();
            }
        };
        RetrofitUtil.getInstance().getApiService().favoriteProject(map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(baseObserver);


    }

}
