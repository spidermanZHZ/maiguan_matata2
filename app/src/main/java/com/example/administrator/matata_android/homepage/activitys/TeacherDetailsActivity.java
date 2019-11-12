package com.example.administrator.matata_android.homepage.activitys;

import android.content.Intent;
import android.os.Bundle;


import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.TeacherDetailsInfoBean;

import com.example.administrator.matata_android.httputils.BaseObserver;
import com.example.administrator.matata_android.httputils.RetrofitUtil;
import com.example.administrator.matata_android.zhzbase.base.BaseActivity;
import com.example.administrator.matata_android.zhzbase.utils.MatataSPUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 老师详情页面
 */
public class TeacherDetailsActivity extends BaseActivity {

    private BaseObserver<TeacherDetailsInfoBean> teacherInfoBeanBaseObserver;
    private String teacher_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_teacher_details);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void getExras() {
        Intent intent = getIntent();
        teacher_id=intent.getStringExtra("teacher_id");
    }

    @Override
    protected void initData() {

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
            public void onSuccess( TeacherDetailsInfoBean teacherDetailsInfoBean) {

            }


        };
        RetrofitUtil.getInstance().getApiService().getTeacherDetails(map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(teacherInfoBeanBaseObserver);
    }

}
