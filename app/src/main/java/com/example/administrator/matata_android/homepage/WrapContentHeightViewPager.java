package com.example.administrator.matata_android.homepage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Viewpager高度自适应
 */
public class WrapContentHeightViewPager extends ViewPager {
    private int currentIndex;
    private int height=0;
    //保存view对应的索引
    private HashMap<Integer,View> mChildrenViews=new LinkedHashMap<Integer, View>();


    public WrapContentHeightViewPager(Context context) {
        super(context);
    }

    public WrapContentHeightViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (mChildrenViews.size()>currentIndex){
            View child=mChildrenViews.get(currentIndex);
            child.measure(widthMeasureSpec,MeasureSpec.makeMeasureSpec(0,MeasureSpec.UNSPECIFIED));
            height=child.getMeasuredHeight();
        }
        if (mChildrenViews.size()!=0){
            heightMeasureSpec=MeasureSpec.makeMeasureSpec(height,MeasureSpec.EXACTLY);
        }

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /**
     * 重新设置高度
     * @param current
     */
    public void resetHeight(int current){
        currentIndex=current;
        if (mChildrenViews.size()>current){
            LinearLayout.LayoutParams layoutParams=(LinearLayout.LayoutParams)getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, height);
            } else {
                layoutParams.height = height;
            }
            setLayoutParams(layoutParams);

        }

    }

    /**
     * 保存View对应的索引,需要自适应高度的一定要设置这个
     */
    public void setViewForPosition(View view, int position) {
        mChildrenViews.put(position, view);
    }

}
