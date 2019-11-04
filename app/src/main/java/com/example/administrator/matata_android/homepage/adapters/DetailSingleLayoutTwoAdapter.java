package com.example.administrator.matata_android.homepage.adapters;


import android.support.annotation.NonNull;

import android.support.v4.app.FragmentActivity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.administrator.matata_android.R;

import com.example.administrator.matata_android.homepage.fragments.CourseDetailsOneFragment;
import com.example.administrator.matata_android.homepage.fragments.CourseDetailsThreeFragment;
import com.example.administrator.matata_android.homepage.fragments.CourseDetailsTwoFragment;
import com.example.administrator.matata_android.homepage.fragments.MusicOfflineFragment;
import com.example.administrator.matata_android.homepage.fragments.MusicOnlineFragment;
import com.shizhefei.view.indicator.ScrollIndicatorView;


/**
 * 课程详情适配器2
 */
public class DetailSingleLayoutTwoAdapter extends DelegateAdapter.Adapter<DetailSingleLayoutTwoAdapter.DetailSingleLayoutTwoAdapterViewHolder> {

    private FragmentActivity mContext;
    private LayoutHelper mHelper;
    private int type;

    private CourseDetailsOneFragment courseDetailsOneFragment;
    private CourseDetailsTwoFragment courseDetailsTwoFragment;
    private CourseDetailsThreeFragment courseDetailsThreeFragment;

    public DetailSingleLayoutTwoAdapter(FragmentActivity mContext, LayoutHelper mHelper) {
        this.mContext = mContext;
        this.mHelper = mHelper;
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
    public void onBindViewHolder(@NonNull DetailSingleLayoutTwoAdapterViewHolder holder, int i) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class  DetailSingleLayoutTwoAdapterViewHolder extends RecyclerView.ViewHolder{
        private ScrollIndicatorView spring_indicator;
        private ViewPager viewPager;
        public DetailSingleLayoutTwoAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            spring_indicator=(ScrollIndicatorView) itemView.findViewById(R.id.spring_indicator);
            viewPager=(ViewPager)itemView.findViewById(R.id.spring_viewPager);
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
                if (courseDetailsOneFragment==null){
                    courseDetailsOneFragment=new CourseDetailsOneFragment();
                    fragmentTransaction.add(R.id.sing_content_frame,courseDetailsOneFragment);
                }else {
                    fragmentTransaction.show(courseDetailsOneFragment);
                }
                break;
            case 1:
                if (courseDetailsTwoFragment==null){
                    courseDetailsTwoFragment=new CourseDetailsTwoFragment();
                    fragmentTransaction.add(R.id.sing_content_frame,courseDetailsTwoFragment);
                }else {
                    fragmentTransaction.show(courseDetailsTwoFragment);
                }
                break;
            case 2:
                if (courseDetailsThreeFragment==null){
                    courseDetailsThreeFragment=new CourseDetailsThreeFragment();
                    fragmentTransaction.add(R.id.sing_content_frame,courseDetailsThreeFragment);
                }else {
                    fragmentTransaction.show(courseDetailsThreeFragment);
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
        if (courseDetailsOneFragment!=null){
            fragmentTransaction.hide(courseDetailsOneFragment);
        }
        if (courseDetailsTwoFragment!=null){
            fragmentTransaction.hide(courseDetailsTwoFragment);
        }
        if (courseDetailsThreeFragment!=null){
            fragmentTransaction.hide(courseDetailsThreeFragment);
        }

    }
}
