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
import com.example.administrator.matata_android.bean.MusicOffLineBean;
import com.example.administrator.matata_android.homepage.activitys.TheatreCollageCourseDetailsActivity;
import com.example.administrator.matata_android.homepage.adapters.MusicOfflineAdapter;
import com.example.administrator.matata_android.httputils.BaseObserver;
import com.example.administrator.matata_android.httputils.RetrofitUtil;
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
 * 线下课程
 */
public class FollowOfflineFragment extends BaseViewNeedSetFragment {

    @BindView(R.id.music_adapter_rv)
    RecyclerView musicAdapterRv;
    Unbinder unbinder;
    private MusicOfflineAdapter adapter;
    private BaseObserver<MusicOffLineBean> musicOnlineBeanBaseObserver;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music_offline, null);
        unbinder = ButterKnife.bind(this, view);
        musicAdapterRv = (RecyclerView) view.findViewById(R.id.music_adapter_rv);
        adapter = new MusicOfflineAdapter(getContext(), R.layout.adapter_music_online, null);
        initData();

        return view;
    }


    private void initData() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        musicAdapterRv.setLayoutManager(linearLayoutManager);
        musicAdapterRv.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
