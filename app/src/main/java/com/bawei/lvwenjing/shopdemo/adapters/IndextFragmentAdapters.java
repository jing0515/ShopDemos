package com.bawei.lvwenjing.shopdemo.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bawei.lvwenjing.shopdemo.fragments.indexfragment.FirstIndexFragment;
import com.bawei.lvwenjing.shopdemo.fragments.indexfragment.IndextFragment;

public class IndextFragmentAdapters extends FragmentPagerAdapter {
    String[] PATH = {"上新", "纸尿裤", "奶粉", "洗护喂养", "玩具", "服饰", "图书", "车床座椅"};

    String[] URL = {"", "http://lib.suning.com/api/app/babydiapers.json",
            "http://lib.suning.com/api/app/babymilk.json",
            "http://lib.suning.com/api/app/BabyBottles.json",
            "http://lib.suning.com/api/app/babytoys.json",
            "http://lib.suning.com/api/app/babyclothes.json"
            , "http://lib.suning.com/api/app/babybooks.json", "lib.suning.com/api/app/babycarriage.json"};

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
            default:
                fragment = new IndextFragment();
                System.out.println("=====" + position);
                Bundle bundle=new Bundle();
                fragment.setArguments(bundle);
                bundle.putString("PATH",URL[position]);
                break;

        }


        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return PATH[position];
    }


}