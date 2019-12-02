package com.example.administrator.matata_android.my.adapters;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.administrator.matata_android.R;
import com.example.administrator.matata_android.bean.MyFollowBean;
import com.example.administrator.matata_android.bean.OffLineCourseBean;
import com.example.administrator.matata_android.homepage.fragments.MusicOfflineFragment;
import com.example.administrator.matata_android.homepage.fragments.MusicOnlineFragment;
import com.example.administrator.matata_android.homepage.fragments.TheatreCourseDetailsFragment;
import com.example.administrator.matata_android.homepage.fragments.TheatreCourseDetailsRemarkFragment;
import com.example.administrator.matata_android.my.fragments.FollowOfflineFragment;
import com.example.administrator.matata_android.my.fragments.FollowOnlineFragment;
import com.example.administrator.matata_android.my.fragments.FollowTeacherFragment;


/**
 * 课程详情适配器2
 */
public class MyFollowSingleLayoutAdapter extends DelegateAdapter.Adapter<MyFollowSingleLayoutAdapter.DetailSingleLayoutTwoAdapterViewHolder> {

    private FragmentActivity mContext;
    private LayoutHelper mHelper;
    private int type;
    private MyFollowBean myFollowBean;

    private FollowOnlineFragment followOnlineFragment;
    private FollowOfflineFragment followOfflineFragment;
    private FollowTeacherFragment followTeacherFragment;
    /**
     * 添加数据
     * @param  myFollowBean
     */
    public void addData(MyFollowBean myFollowBean){
        this.myFollowBean=myFollowBean;
        notifyDataSetChanged();
    }

    public MyFollowSingleLayoutAdapter(FragmentActivity mContext, LayoutHelper mHelper, int type, MyFollowBean myFollowBean) {
        this.mContext = mContext;
        this.mHelper = mHelper;
        this.type=type;
        this.myFollowBean=myFollowBean;



    }
    public void setType(int type){
        this.type=type;
        notifyDataSetChanged();
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mHelper;
    }

    @NonNull
    @Override
    public DetailSingleLayoutTwoAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.single_layout_helper_collage_adapter,parent,false);
        return new DetailSingleLayoutTwoAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailSingleLayoutTwoAdapterViewHolder holder, int position) {
            if (myFollowBean!=null){
                onFragmentRbClick(type);
            }

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class  DetailSingleLayoutTwoAdapterViewHolder extends RecyclerView.ViewHolder{

        public DetailSingleLayoutTwoAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

        }
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
                if (followTeacherFragment==null){
                    followTeacherFragment=new FollowTeacherFragment();
                    fragmentTransaction.add(R.id.sing_content_frame,followTeacherFragment);
                    //往fragment传递数据
                    Bundle bundle1= new Bundle();
                    bundle1.putSerializable("FollowTeacherFragment",myFollowBean);
                    followTeacherFragment.setArguments(bundle1);
                }else {
                    fragmentTransaction.show(followTeacherFragment);
                }
                break;

            case 1://线上课程
                if (followOnlineFragment==null){
                    followOnlineFragment=new FollowOnlineFragment();
                    fragmentTransaction.add(R.id.sing_content_frame,followOnlineFragment);
                    //往fragment传递数据
                    Bundle bundle1= new Bundle();
                    bundle1.putSerializable("FollowOnlineFragment",myFollowBean);
                    followOnlineFragment.setArguments(bundle1);
                }else {
                    fragmentTransaction.show(followOnlineFragment);
                }
                break;
            case 2://线下课程
                if (followOfflineFragment==null){
                    followOfflineFragment=new FollowOfflineFragment();
                    fragmentTransaction.add(R.id.sing_content_frame,followOfflineFragment);
                    //往fragment传递数据
                    Bundle bundle1= new Bundle();
                    bundle1.putSerializable("followOfflineFragment",myFollowBean);
                    followOfflineFragment.setArguments(bundle1);
                }else {
                    fragmentTransaction.show(followOfflineFragment);
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
        if (followTeacherFragment!=null){
            fragmentTransaction.hide(followTeacherFragment );
        }
        if (followOnlineFragment!=null){
            fragmentTransaction.hide(followOnlineFragment );
        }

        if (followOfflineFragment!=null){
            fragmentTransaction.hide(followOfflineFragment);
        }
    }
}
