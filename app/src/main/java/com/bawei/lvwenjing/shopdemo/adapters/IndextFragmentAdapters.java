package com.bawei.lvwenjing.shopdemo.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bawei.lvwenjing.shopdemo.fragments.indexfragment.IndextFragment;

public class IndextFragmentAdapters extends FragmentPagerAdapter {
    String[] PATH = {"上新", "纸尿裤", "奶粉", "洗护喂养", "玩具", "服饰", "图书", "车床座椅"};

    public IndextFragmentAdapters(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PATH.length;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new IndextFragment();

        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return PATH[position];
    }


}