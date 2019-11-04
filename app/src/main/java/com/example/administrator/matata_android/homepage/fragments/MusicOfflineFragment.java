package com.example.administrator.matata_android.homepage.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.MusicOffLineBean;
import com.example.administrator.matata_android.bean.MusicOnlineBean;
import com.example.administrator.matata_android.homepage.adapters.MusicOfflineAdapter;
import com.example.administrator.matata_android.homepage.adapters.MusicOnlineAdapter;
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
public class MusicOfflineFragment extends BaseViewNeedSetFragment {

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
        getMusicOnline();
        return view;
    }


    private void initData() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        musicAdapterRv.setLayoutManager(linearLayoutManager);
        musicAdapterRv.setAdapter(adapter);
    }

    /**
     * 获取线下课数据
     */
    private void getMusicOnline() {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("token", MatataSPUtils.getToken());
        musicOnlineBeanBaseObserver = new BaseObserver<MusicOffLineBean>(getContext(), false, false) {
            @Override
            public void onSuccess(MusicOffLineBean musicOffLineBean) {

                adapter.addData(musicOffLineBean.getData());
                adapter.notifyDataSetChanged();

            }
        };
        RetrofitUtil.getInstance().getApiService().getMusicOffline(map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(musicOnlineBeanBaseObserver);


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
