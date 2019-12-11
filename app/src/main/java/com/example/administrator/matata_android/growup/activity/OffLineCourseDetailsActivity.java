package com.example.administrator.matata_android.growup.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.blankj.utilcode.util.BarUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.MyCourseBean;
import com.example.administrator.matata_android.bean.MyOffLineCourseNumBean;
import com.example.administrator.matata_android.bean.OffLineCourseBean;
import com.example.administrator.matata_android.growup.adapter.GridLayoutHelperAdapter;
import com.example.administrator.matata_android.httputils.BaseObserver;
import com.example.administrator.matata_android.httputils.RetrofitUtil;
import com.example.administrator.matata_android.zhzbase.base.BaseActivity;
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
 * 线下戏剧课程详情
 */
public class OffLineCourseDetailsActivity extends BaseActivity {


    @BindView(R.id.title_bar)
    TitleBar titleBar;
    @BindView(R.id.tv_info)
    TextView tvInfo;
    @BindView(R.id.my_course_rv)
    RecyclerView myCourseRv;
    private String offlineId;
    private String name;
    private String description;

    private BaseObserver<List<MyOffLineCourseNumBean>> myOffLineCourseNumBeanBaseObserver;
    private GridLayoutHelperAdapter gridLayoutHelperAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_offlinecourse);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);
        BarUtils.setStatusBarColor(this,getResources().getColor(R.color.background_title),true);
    }

    @Override
    protected void getExras() {
        Intent intent = getIntent();
        offlineId = intent.getStringExtra("offlineId");
        name=intent.getStringExtra("name");
        description=intent.getStringExtra("description");

    }

    @Override
    protected void initData() {

        titleBar.setTitle(name);
        tvInfo.setText(description);

        titleBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onLeftClick(View v) {
                finishActivity();
            }

            @Override
            public void onTitleClick(View v) {

            }

            @Override
            public void onRightClick(View v) {

            }
        });
        //LayoutManager
        GridLayoutManager layoutManager = new GridLayoutManager(this,6);
        myCourseRv.setLayoutManager(layoutManager);
        gridLayoutHelperAdapter=new GridLayoutHelperAdapter(this,R.layout.adapter_grow_up_grid,null);
        getNum();
        myCourseRv.setAdapter(gridLayoutHelperAdapter);
    }
    private void getNum(){
        Map<String ,Object> map=new HashMap<>();
        map.put("token",MatataSPUtils.getToken());
        map.put("offline_course_id",offlineId);
        myOffLineCourseNumBeanBaseObserver=new BaseObserver<List<MyOffLineCourseNumBean>>(this,true,false) {
            @Override
            public void onSuccess(List<MyOffLineCourseNumBean> myOffLineCourseNumBean) {
                gridLayoutHelperAdapter.addData(myOffLineCourseNumBean);
                gridLayoutHelperAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        Intent intent = new Intent(OffLineCourseDetailsActivity.this, OfflineCourseTaskActivity.class);
                            intent.putExtra("num",myOffLineCourseNumBean.get(position).getNum());
                        if (myOffLineCourseNumBean.get(position).getNum_id()!=null){
                            intent.putExtra("num_id",myOffLineCourseNumBean.get(position).getNum_id());
                        }
                        startActivity(intent);
                    }
                });

            }
        };
        RetrofitUtil.getInstance().getApiService().getMyOfflineCourseNum(map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(myOffLineCourseNumBeanBaseObserver);


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
