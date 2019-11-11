package com.example.administrator.matata_android.homepage.adapters;


import android.os.Bundle;
import android.support.annotation.NonNull;

import android.support.v4.app.FragmentActivity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.administrator.matata_android.R;

import com.example.administrator.matata_android.bean.OnLineCourseBean;
import com.example.administrator.matata_android.homepage.fragments.CourseDetailsCatalogFragment;
import com.example.administrator.matata_android.homepage.fragments.CourseDetailsFragment;
import com.example.administrator.matata_android.homepage.fragments.CourseDetailsOneFragment;
import com.example.administrator.matata_android.homepage.fragments.CourseDetailsRemarkFragment;

import com.shizhefei.view.indicator.ScrollIndicatorView;


/**
 * 课程详情适配器2
 */
public class DetailSingleLayoutTwoAdapter extends DelegateAdapter.Adapter<DetailSingleLayoutTwoAdapter.DetailSingleLayoutTwoAdapterViewHolder> {

    private FragmentActivity mContext;
    private LayoutHelper mHelper;
    private int type;
    private OnLineCourseBean  onLineCourseBean;
    private  String onlineId;

    private CourseDetailsFragment courseDetailsFragment ;
    private CourseDetailsCatalogFragment courseDetailsCatalogFragment ;
    private CourseDetailsRemarkFragment courseDetailsRemarkFragment ;

    private CourseDetailsOneFragment courseDetailsOneFragment;

    /**
     * 添加数据
     * @param onLineCourseBean
     */
    public void addData(OnLineCourseBean onLineCourseBean){
        this.onLineCourseBean=onLineCourseBean;
        notifyDataSetChanged();
    }

    public DetailSingleLayoutTwoAdapter(FragmentActivity mContext, LayoutHelper mHelper,int type,OnLineCourseBean onLineCourseBean,String onlineId) {
        this.mContext = mContext;
        this.mHelper = mHelper;
        this.type=type;
        this.onLineCourseBean=onLineCourseBean;
        this.onlineId=onlineId;


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
        if (onlineId!=null){
            onFragmentRbClick(type);

        }else {
            Toast.makeText(mContext,"onlineId的值为空", Toast.LENGTH_SHORT).show();
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
                if (courseDetailsFragment==null){
                    courseDetailsFragment=new CourseDetailsFragment();
                    fragmentTransaction.add(R.id.sing_content_frame,courseDetailsFragment);

                    //往fragment传递数据
                    Bundle bundle1= new Bundle();
                    bundle1.putString("CourseDetailsFragment_url", onlineId);
                    courseDetailsFragment.setArguments(bundle1);

                }else {
                    fragmentTransaction.show(courseDetailsFragment);
                }
                break;
            case 1:
                if (courseDetailsCatalogFragment==null){
                    courseDetailsCatalogFragment=new CourseDetailsCatalogFragment();
                    fragmentTransaction.add(R.id.sing_content_frame,courseDetailsCatalogFragment);
                    //往fragment传递数据
                    Bundle bundle2= new Bundle();
                    bundle2.putSerializable("CourseDetailsCatalogFragment_Online",onLineCourseBean);
                    courseDetailsCatalogFragment.setArguments(bundle2);

                }else {
                    fragmentTransaction.show(courseDetailsCatalogFragment);
                }
                break;
            case 2:
                if (courseDetailsRemarkFragment==null){
                    courseDetailsRemarkFragment=new CourseDetailsRemarkFragment();
                    fragmentTransaction.add(R.id.sing_content_frame,courseDetailsRemarkFragment);
                    //往fragment传递数据
                    Bundle bundle3= new Bundle();
                    bundle3.putSerializable("CourseDetailsRemarkFragment_Online",onLineCourseBean);
                    courseDetailsRemarkFragment.setArguments(bundle3);

                }else {
                    fragmentTransaction.show(courseDetailsRemarkFragment);
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
        if (courseDetailsFragment!=null){
            fragmentTransaction.hide(courseDetailsFragment);
        }
        if (courseDetailsCatalogFragment!=null){
            fragmentTransaction.hide(courseDetailsCatalogFragment);
        }
        if (courseDetailsRemarkFragment!=null){
            fragmentTransaction.hide(courseDetailsRemarkFragment);
        }
    }
}
