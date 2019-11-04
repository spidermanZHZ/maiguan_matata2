package com.example.administrator.matata_android.homepage.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.matata_android.R;
import com.shizhefei.view.indicator.IndicatorViewPager;

import java.util.List;

public class CourseDetailsIndicatorPagerAdapter extends IndicatorViewPager.IndicatorFragmentPagerAdapter {

    private List<Fragment> fragmentList;
    private FragmentActivity mContext;
    private LayoutInflater inflate;


    public CourseDetailsIndicatorPagerAdapter(FragmentManager fragmentManager, List<Fragment> fragments, FragmentActivity mContext) {
        super(fragmentManager);
        this.fragmentList = fragments;
        this.mContext=mContext;
    }

    @Override
    public int getCount() {
        return fragmentList.size();//2个fragment
    }

    @Override
    public View getViewForTab(int position, View convertView, ViewGroup container) {
        inflate=LayoutInflater.from(mContext);
        if (convertView == null) {
            convertView = inflate.inflate(R.layout.tab_top, container, false);
        }
        TextView textView = (TextView) convertView;
        textView.setText(names[position % names.length]);
        int padding = dipToPix(10);
        textView.setPadding(padding, 0, padding, 0);
        return convertView;
    }


    @Override
    public Fragment getFragmentForPage(int position) {
        return fragmentList.get(position);
    }

    private String[] names = {"课程介绍", "课程目录","课程评价"};

    /**
     * 根据dip值转化成px值
     *
     * @param dip
     * @return
     */
    private int dipToPix(float dip) {
        int size = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, mContext.getResources().getDisplayMetrics());
        return size;
    }
}
