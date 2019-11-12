package com.example.administrator.matata_android.growup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.ChildDetailsBean;
import com.example.administrator.matata_android.growup.activity.ChangChildInfoActivity;
import com.example.administrator.matata_android.growup.activity.StudyAdjustActivity;
import com.example.administrator.matata_android.growup.adapter.DateAdapter;
import com.example.administrator.matata_android.growup.adapter.GrowUpSingleLayoutHelperAdapter;
import com.example.administrator.matata_android.growup.adapter.GrowUpSingleLayoutHelperTwoAdapter;
import com.example.administrator.matata_android.homepage.adapters.HomepagerOneAdapter;
import com.example.administrator.matata_android.homepage.adapters.HomepagerThreeAdapter;
import com.example.administrator.matata_android.homepage.adapters.HomepagerTwoAdapter;
import com.example.administrator.matata_android.httputils.BaseObserver;
import com.example.administrator.matata_android.httputils.RetrofitUtil;
import com.example.administrator.matata_android.zhzbase.base.BaseApplication;
import com.example.administrator.matata_android.zhzbase.base.BaseViewNeedSetFragment;
import com.example.administrator.matata_android.zhzbase.utils.DateUtils;
import com.example.administrator.matata_android.zhzbase.utils.MatataSPUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 成长陪伴页面
 */
public class GrowUpFragment extends BaseViewNeedSetFragment {


    Unbinder unbinder;
    @BindView(R.id.rv_grow_up_fragment)
    RecyclerView rvGrowUpFragment;

    private String child_id;
    private BaseObserver<ChildDetailsBean> childDetailsBeanBaseObserver;
    private DateAdapter dateAdapter;
    private GrowUpSingleLayoutHelperAdapter growUpSingleLayoutHelperAdapter;
    private GrowUpSingleLayoutHelperTwoAdapter growUpSingleLayoutHelperTwoAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_growup, container, false);
        unbinder = ButterKnife.bind(this, view);
        initData();
        return view;

    }
    private void initData() {

        //创建VirtuaLayoutManager
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(BaseApplication.getInstance());
        rvGrowUpFragment.setLayoutManager(layoutManager);

        //设置服用池设置回收复用池大小，（如果一屏内相同类型的 View 个数比较多，需要设置一个合适的大小，防止来回滚动时重新创建 View）：
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        viewPool.setMaxRecycledViews(0, 10);
        rvGrowUpFragment.setRecycledViewPool(viewPool);

        //创建一个adapter的list
        List<DelegateAdapter.Adapter> adapters = new ArrayList<>();

        //创建delegateadapter
        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager, true);

        //装载成长陪伴个人信息，总学习时间，周计划
        SingleLayoutHelper singleLayoutHelper2 = new SingleLayoutHelper();
        growUpSingleLayoutHelperAdapter=new GrowUpSingleLayoutHelperAdapter(getContext(),singleLayoutHelper2,null);

        //装载学习中的课程
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        growUpSingleLayoutHelperTwoAdapter=new GrowUpSingleLayoutHelperTwoAdapter(getContext(),singleLayoutHelper,null);

        getChlidDetails();

       //装载开始练习功能
        SingleLayoutHelper singleLayoutHelper13 = new SingleLayoutHelper();


       adapters.add(growUpSingleLayoutHelperAdapter);
       adapters.add(growUpSingleLayoutHelperTwoAdapter);

//        adapters.add(homepagerThreeAdapter);

        delegateAdapter.setAdapters(adapters);

        rvGrowUpFragment.setAdapter(delegateAdapter);
    }


    public void getChlidDetails() {
        HashMap<String, Object> childMap = new HashMap<>();
        childMap.put("token", MatataSPUtils.getToken());
        childMap.put("child_id", "19");

        childDetailsBeanBaseObserver = new BaseObserver<ChildDetailsBean>(getContext(), false, false) {
            @Override
            public void onSuccess(ChildDetailsBean childDetailsBean) {

                growUpSingleLayoutHelperAdapter.addData(childDetailsBean);
                growUpSingleLayoutHelperTwoAdapter.addData(childDetailsBean);
                child_id = childDetailsBean.getId();


            }
        };
        RetrofitUtil.getInstance().getApiService().getChildDetails(childMap)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(childDetailsBeanBaseObserver);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
