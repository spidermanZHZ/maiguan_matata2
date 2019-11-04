package com.example.administrator.matata_android.homepage.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.MusicHotBean;
import com.example.administrator.matata_android.growup.GrowUpFragment;
import com.example.administrator.matata_android.homepage.HomePageFragment;
import com.example.administrator.matata_android.homepage.fragments.MusicOfflineFragment;
import com.example.administrator.matata_android.homepage.fragments.MusicOnlineFragment;
import com.example.administrator.matata_android.my.MyFragment;
import com.example.administrator.matata_android.zhzbase.base.BaseFragmentActivity;

import java.util.List;

import recycler.coverflow.RecyclerCoverFlow;

public class SingleLayoutHelperCollageAdapter extends DelegateAdapter.Adapter<SingleLayoutHelperCollageAdapter.SingleLayoutHelperViewHolder> {

    private FragmentActivity mContext;
    private LayoutHelper mHelper;
    private int type;

    private MusicOnlineFragment musicOnlineFragment;
    private MusicOfflineFragment musicOfflineFragment;

    public SingleLayoutHelperCollageAdapter(FragmentActivity mContext, LayoutHelper mHelper, int type) {
        this.mContext = mContext;
        this.mHelper = mHelper;
        this.type = type;
    }

    /**
     * 设置显示的fragment
     * @param types
     */
    public void setType(int types){
        this.type=types;
        notifyDataSetChanged();
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mHelper;
    }

    @NonNull
    @Override
    public SingleLayoutHelperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(mContext).inflate(R.layout.single_layout_helper_collage_adapter,parent,false);
        return new SingleLayoutHelperViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SingleLayoutHelperViewHolder singleLayoutHelperViewHolder, int position) {
        onFragmentRbClick(type);
    }



    @Override
    public int getItemCount() {
        return 1;
    }

    /**
     * 切换fragment监听
     * @param type fragment对应角标
     */
    private void onFragmentRbClick(int type){
        //开启事务
        FragmentManager manager = mContext.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        //显示之前将所有的fragment都隐藏起来,在去显示我们想要显示的fragment
        hideFragment(fragmentTransaction);
        switch (type){
            case 0:
                if (musicOnlineFragment==null){
                    musicOnlineFragment=new MusicOnlineFragment();
                    fragmentTransaction.add(R.id.sing_content_frame,musicOnlineFragment);
                }else {
                    fragmentTransaction.show(musicOnlineFragment);
                }
                break;
            case 1:
                if (musicOfflineFragment==null){
                    musicOfflineFragment=new MusicOfflineFragment();
                    fragmentTransaction.add(R.id.sing_content_frame,musicOfflineFragment);
                }else {
                    fragmentTransaction.show(musicOfflineFragment);
                }
                break;
        }
        fragmentTransaction.commit();
    }

    /**
     *  隐藏Fragment的方法
     * @param fragmentTransaction
     */
    private void hideFragment(FragmentTransaction fragmentTransaction){
        //不为空隐藏
        if (musicOnlineFragment!=null){
            fragmentTransaction.hide(musicOnlineFragment);
        }
        if (musicOfflineFragment!=null){
            fragmentTransaction.hide(musicOfflineFragment);
        }

    }



    class SingleLayoutHelperViewHolder extends RecyclerView.ViewHolder{

        public SingleLayoutHelperViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
