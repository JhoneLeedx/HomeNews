package com.jhonlee.homenews.view.main;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by lijin on 2017/2/19.
 */

public class  ViewpagerAdapter extends FragmentStatePagerAdapter {

    private String[] tabTitleArray;
    private  List<Fragment> fragmentList;
    private Context mContext;

    public ViewpagerAdapter(FragmentManager fm, String[] tabTitleArray, List<Fragment> fragmentList, Context mContext) {
        super(fm);
        this.tabTitleArray = tabTitleArray;
        this.fragmentList = fragmentList;
        this.mContext = mContext;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitleArray[position % tabTitleArray.length];
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }
    @Override
    public void destroyItem(View container, int position, Object object) {

    }
}
