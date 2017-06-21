package com.bawei.lvwenjing.shopdemo.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bawei.lvwenjing.shopdemo.fragments.indexfragment.FirstIndexFragment;
import com.bawei.lvwenjing.shopdemo.fragments.indexfragment.IndextFragment;
import com.bawei.lvwenjing.shopdemo.fragments.indexfragment.LastIndextFragment;

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
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new FirstIndexFragment();
                break;
            case 1:
                fragment = new LastIndextFragment();
                break;
            default:
                fragment = new IndextFragment();
                break;
        }


        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return PATH[position];
    }


}