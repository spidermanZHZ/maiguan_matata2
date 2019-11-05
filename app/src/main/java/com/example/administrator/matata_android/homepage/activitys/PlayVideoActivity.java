package com.example.administrator.matata_android.homepage.activitys;


import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.OnLineCourseBean;
import com.example.administrator.matata_android.zhzbase.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

/**
 * 视频播放页面
 */
public class PlayVideoActivity extends BaseActivity {

    @BindView(R.id.video_player)
    JzvdStd videoPlayer;

    private OnLineCourseBean onLineCourseBean;
    private int position;
    private static final String URL = "https://www.maiguanjy.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_play_video);

        Window window = PlayVideoActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);



    }

    @Override
    protected void getExras() {

        Bundle bundle=new Bundle();
        bundle=this.getIntent().getBundleExtra("video_player_intent");
        onLineCourseBean=(OnLineCourseBean) bundle.getSerializable("video_player_bundle");
        position=bundle.getInt("position");

    }

    @Override
    protected void initData() {

        if (onLineCourseBean!=null){
            //播放视频
            videoPlayer.setUp(URL+onLineCourseBean.getCatalog().get(position).getVideo(),onLineCourseBean.getCatalog().get(position).getName(),JzvdStd.SCREEN_NORMAL);
            videoPlayer.startVideo();
            //视频缩略图
            Glide.with(this).load(URL+onLineCourseBean.getCatalog().get(position).getCover_pic()).into(videoPlayer.thumbImageView);

        }

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
     * Home键退出界面暂停播放，返回界面继续播放
     */
    @Override
    protected void onResume() {
        super.onResume();
        //home back
        JzvdStd.goOnPlayOnResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //     Jzvd.clearSavedProgress(this, null);
        //home back
        JzvdStd.goOnPlayOnPause();

    }

    @Override
    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        super.onBackPressed();
    }

}
