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
import com.example.administrator.matata_android.bean.OffLineCourseBean;
import com.example.administrator.matata_android.homepage.adapters.DetailSingleLayoutTheatreCollageTwoAdapter;
import com.example.administrator.matata_android.homepage.adapters.StickyLayoutHelperTheatreTwoAdapter;
import com.example.administrator.matata_android.homepage.adapters.TheatreCollageDetailsSingleLayoutAdapter;
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
 * 线下戏剧课程详情
 */
public class TheatreCollageCourseDetailsActivity extends SupportActivity {

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

    private String offlineId;

    private BaseObserver<OffLineCourseBean> offLineCourseBeanBaseObserver;

    private TheatreCollageDetailsSingleLayoutAdapter theatreCollageDetailsSingleLayoutAdapter;

    private DetailSingleLayoutTheatreCollageTwoAdapter detailSingleLayoutTheatreCollageTwoAdapter;

    private StickyLayoutHelperTheatreTwoAdapter stickyLayoutHelperTwoAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_course_details_two);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);
        BarUtils.setStatusBarColor(this,getResources().getColor(R.color.transparent),true);
        setAndroidNativeLightStatusBar(this,true);
        getExras();
        initData();
    }


    private void getExras() {

        Intent intent = getIntent();
        offlineId = intent.getStringExtra("offlineId");


    }


    private void initData() {
        titleBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onLeftClick(View v) {
                ActivityUtils.finishActivity(TheatreCollageCourseDetailsActivity.this);
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
        theatreCollageDetailsSingleLayoutAdapter = new TheatreCollageDetailsSingleLayoutAdapter(this, singleLayoutHelper, null);


        //底部ViewPager+Fragment
        SingleLayoutHelper singleLayoutHelper1 = new SingleLayoutHelper();
        detailSingleLayoutTheatreCollageTwoAdapter = new DetailSingleLayoutTheatreCollageTwoAdapter(TheatreCollageCourseDetailsActivity.this, singleLayoutHelper1, 0, null, offlineId);


        //吸顶布局
        StickyLayoutHelper stickyLayoutHelper = new StickyLayoutHelper();
        stickyLayoutHelperTwoAdapter = new StickyLayoutHelperTheatreTwoAdapter(this, stickyLayoutHelper);

        getCourseDetails();

        adapters.add(theatreCollageDetailsSingleLayoutAdapter);
        adapters.add(stickyLayoutHelperTwoAdapter);
        adapters.add(detailSingleLayoutTheatreCollageTwoAdapter);

        delegateAdapter.setAdapters(adapters);
        courseDetailsTwoRv.setAdapter(delegateAdapter);

        stickyLayoutHelperTwoAdapter.setOnItemClickListener(new StickyLayoutHelperTheatreTwoAdapter.OnItemClickListener() {
            @Override
            public void onCourse(View v, int position) {
                detailSingleLayoutTheatreCollageTwoAdapter.setType(0);
                delegateAdapter.notifyDataSetChanged();
            }


            @Override
            public void onCourseComment(View v, int position) {
                detailSingleLayoutTheatreCollageTwoAdapter.setType(2);
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
        map.put("offlineId", offlineId);

        offLineCourseBeanBaseObserver = new BaseObserver<OffLineCourseBean>(this, true, false) {
            @Override
            public void onSuccess(OffLineCourseBean offLineCourseBean) {
                theatreCollageDetailsSingleLayoutAdapter.addData(offLineCourseBean);
                detailSingleLayoutTheatreCollageTwoAdapter.addData(offLineCourseBean);

                theatreCollageDetailsSingleLayoutAdapter.setOnItemClickListener(new TheatreCollageDetailsSingleLayoutAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }

                    @Override
                    public void onFavoriteClick(View view, int position) {
                        setFavorite(offLineCourseBean, "已成功收藏");
                    }

                    @Override
                    public void onCanleFavoriteClick(View view, int position) {
                        setFavorite(offLineCourseBean, "已取消收藏");
                    }
                });


                //价格后台返回数据需处理
                if (offLineCourseBean.getPrice() != null) {
                    String price = "¥" + getPrice(String.valueOf(offLineCourseBean.getPrice().get(0).getPrice())) + "(" + offLineCourseBean.getPrice().get(0).getNum() + "次)";
                    courseDetailsPrice.setText(price);
                    courseDetailsJoin.setText("购买课程");
                    courseDetailsJoin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //跳转到课程购买页面
                            Intent intent = new Intent(TheatreCollageCourseDetailsActivity.this, ThetreaBuyActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("offLineCourseBean", offLineCourseBean);
                            intent.putExtra("info_bundle", bundle);
                            startActivity(intent);
                        }
                    });
                } else {
                    courseDetailsPrice.setText("价格待定");
                    courseDetailsJoin.setText("课程暂未上架");
                }

            }

        };
        RetrofitUtil.getInstance().getApiService().getOfflineCourse(map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(offLineCourseBeanBaseObserver);


    }

    /**
     * 设置收藏按钮
     */
    private void setFavorite(OffLineCourseBean offLineCourseBean, String string) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("token", MatataSPUtils.getToken());
        map.put("type", "offlineCourse");
        map.put("obj_id", String.valueOf(offLineCourseBean.getId()));
        baseObserver = new BaseObserver<Object>(this, false, false) {
            @Override
            public void onSuccess(Object o) {
                Toast.makeText(TheatreCollageCourseDetailsActivity.this, string, Toast.LENGTH_SHORT).show();
            }
        };
        RetrofitUtil.getInstance().getApiService().favoriteProject(map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(baseObserver);


    }

    /**
     * 处理接口返回String类型价格
     */
    public String getPrice(String price) {
        int a = Integer.parseInt(price);
        int b = a / 100;
        return String.valueOf(b);
    }
    private static void setAndroidNativeLightStatusBar(Activity activity, boolean dark) {
        View decor = activity.getWindow().getDecorView();
        if (dark) {
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        } else {
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }
    }
}
