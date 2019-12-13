package com.example.administrator.matata_android.homepage.activitys;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.SearchBean;
import com.example.administrator.matata_android.homepage.adapters.SearchAdapter;
import com.example.administrator.matata_android.httputils.BaseObserver;
import com.example.administrator.matata_android.httputils.RetrofitUtil;
import com.example.administrator.matata_android.zhzbase.base.BaseActivity;
import com.example.administrator.matata_android.zhzbase.utils.MatataSPUtils;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.blankj.utilcode.util.ActivityUtils.startActivity;

/**
 * 搜索页面
 */
public class HomePagerSearchActivity extends BaseActivity {

    @BindView(R.id.home_pager_title_bar)
    TitleBar homePagerTitleBar;
    @BindView(R.id.search_et)
    EditText searchEt;
    @BindView(R.id.search_rv)
    RecyclerView searchRv;

    private BaseObserver<SearchBean> searchBeanBaseObserver;
    private SearchAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_home_pager_search);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void getExras() {

    }

    @Override
    protected void initData() {
        homePagerTitleBar.setOnTitleBarListener(new OnTitleBarListener() {
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
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        searchRv.setLayoutManager(manager);
        adapter=new SearchAdapter(this,R.layout.adapter_music_online,null);
        searchRv.setAdapter(adapter);
        View view=LayoutInflater.from(this).inflate(R.layout.empty_view2,null);
        adapter.setEmptyView(view);
        searchEt.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
               if(keyCode==KeyEvent.KEYCODE_ENTER){
                   String s=searchEt.getText().toString().trim();
                   getSearch(s);
                return true;
                }
                return false;
            }
        });

    }

    @Override
    protected void setListener() {

    }

    /**
     * 获取搜索结果并展示
     */
    private void getSearch(String text) {
        Map<String ,Object> map=new HashMap<>();
        map.put("token",MatataSPUtils.getToken());
        map.put("text",text);
        searchBeanBaseObserver = new BaseObserver<SearchBean>(this,true,false) {
            @Override
            public void onSuccess(SearchBean searchBean) {

                adapter.setNewData(searchBean.getAll());
                adapter.notifyDataSetChanged();
                adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                        if (searchBean.getAll().get(position).getType().equals("teacher")){
                            Intent intent = new Intent(HomePagerSearchActivity.this, TeacherDetailsActivity.class);
                            String id=String.valueOf(searchBean.getAll().get(position).getId());
                            intent.putExtra("teacher_id",id);
                            startActivity(intent);

                        }else if (searchBean.getAll().get(position).getType().equals("campsite")){
                            Intent intent = new Intent(HomePagerSearchActivity.this, ArtCampAtActivity.class);
                            intent.putExtra("campsite_id", searchBean.getAll().get(position).getId());
                            startActivity(intent);

                        }else if (searchBean.getAll().get(position).getType().equals("offline")){

                            Intent intent = new Intent(HomePagerSearchActivity.this, TheatreCollageCourseDetailsActivity.class);
                            String id =String.valueOf(searchBean.getAll().get(position).getId());
                            intent.putExtra("offlineId",id);
                            startActivity(intent);
                        }else if (searchBean.getAll().get(position).getType().equals("online")){

                            Intent intent = new Intent(HomePagerSearchActivity.this, CourseDetailsTwoActivity.class);
                            String id=String.valueOf(searchBean.getAll().get(position).getId());
                            intent.putExtra("onlineId",id);
                            startActivity(intent);

                        }
                    }
                });
            }
        };
        RetrofitUtil.getInstance().getApiService().searchInfo(map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(searchBeanBaseObserver);

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
