package com.example.administrator.matata_android.my.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.MusicOnlineBean;
import com.example.administrator.matata_android.bean.MyFollowBean;
import com.example.administrator.matata_android.homepage.activitys.CourseDetailsTwoActivity;
import com.example.administrator.matata_android.homepage.adapters.MusicOnlineAdapter;
import com.example.administrator.matata_android.httputils.BaseObserver;
import com.example.administrator.matata_android.httputils.RetrofitUtil;
import com.example.administrator.matata_android.my.adapters.MyFollowOnlineAdapter;
import com.example.administrator.matata_android.zhzbase.base.BaseViewNeedSetFragment;
import com.example.administrator.matata_android.zhzbase.utils.MatataSPUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 音乐学院线上课程
 */
public class FollowOnlineFragment extends BaseViewNeedSetFragment {

    @BindView(R.id.music_adapter_online_rv)
    RecyclerView musicAdapterOnlineRv;
    Unbinder unbinder;

    private MyFollowBean myFollowBean;
    private MyFollowOnlineAdapter adapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle=getArguments();
        if (bundle!=null){
            myFollowBean =(MyFollowBean)bundle.getSerializable("FollowOnlineFragment");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music_online, null);
        unbinder = ButterKnife.bind(this, view);
        initData();
        return view;
    }


    private void initData() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        musicAdapterOnlineRv.setLayoutManager(linearLayoutManager);

        adapter = new MyFollowOnlineAdapter(getContext(), R.layout.adapter_music_online, null);
        if (myFollowBean!=null){
            adapter.addData(myFollowBean.getOnline_course());
        }
        musicAdapterOnlineRv.setAdapter(adapter);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
