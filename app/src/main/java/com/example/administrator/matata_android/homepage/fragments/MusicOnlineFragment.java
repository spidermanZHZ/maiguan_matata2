package com.example.administrator.matata_android.homepage.fragments;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.MusicOnlineBean;
import com.example.administrator.matata_android.homepage.adapters.MusicOnlineAdapter;
import com.example.administrator.matata_android.httputils.BaseObserver;
import com.example.administrator.matata_android.httputils.RetrofitUtil;
import com.example.administrator.matata_android.zhzbase.base.BaseFragment;
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
public class MusicOnlineFragment extends BaseFragment {


    private RecyclerView musicAdapterOnlineRv;
    private BaseObserver<MusicOnlineBean> musicOnlineBeanBaseObserver;
    private MusicOnlineAdapter adapter;

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_music_online;
    }

    @Override
    protected void getExras() {
        musicAdapterOnlineRv= (RecyclerView)rootView.findViewById(R.id.music_adapter_online_rv);
    }

    @Override
    protected void initData() {
        getMusicOnline();
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        musicAdapterOnlineRv.setLayoutManager(linearLayoutManager);
        adapter=new MusicOnlineAdapter(getContext(),R.layout.adapter_music_online,null);
        musicAdapterOnlineRv.setAdapter(adapter);

    }

    @Override
    protected void setListener() {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    /**
     * 获取线上课数据
     */
    private void getMusicOnline() {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("token", MatataSPUtils.getToken());
        musicOnlineBeanBaseObserver = new BaseObserver<MusicOnlineBean>(getContext(), false, false) {
            @Override
            public void onSuccess(MusicOnlineBean musicOnlineBean) {

            adapter.addData(musicOnlineBean.getData());
            adapter.notifyDataSetChanged();

            }
        };
        RetrofitUtil.getInstance().getApiService().getMusicOnline(map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(musicOnlineBeanBaseObserver);


    }


}
