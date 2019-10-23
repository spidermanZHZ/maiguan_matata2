package com.example.administrator.matata_android.homepage.adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class MusicPageAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;
    private Context context;
    private List<String> list_Title;
    public MusicPageAdapter(FragmentManager fm, List<Fragment> fragmentList, Context context,List<String> list_Title) {
        super(fm);
        this.fragmentList = fragmentList;
        this.context = context;
        this.list_Title = list_Title;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list_Title.get(position);
    }

}
