package com.bawei.lvwenjing.shopdemo.activitys;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.bawei.lvwenjing.shopdemo.R;
import com.bawei.lvwenjing.shopdemo.basemvp.IActivity;
import com.bawei.lvwenjing.shopdemo.fragments.FirstFragment;
import com.bawei.lvwenjing.shopdemo.fragments.FourthFragment;
import com.bawei.lvwenjing.shopdemo.fragments.SecondFragment;
import com.bawei.lvwenjing.shopdemo.fragments.ThirdFragment;
import com.bawei.lvwenjing.shopdemo.widget.ButtomLayout;

import java.util.ArrayList;
import java.util.List;


/**
 * 主导航
 */

public class TabActivity extends IActivity implements ButtomLayout.OnSelectListener {

    private ButtomLayout buttomLayout;
    private FragmentManager fragmentManager;

    private List<Fragment> fragments = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        fragmentManager = getSupportFragmentManager();
        createFragment(savedInstanceState);

        buttomLayout = (ButtomLayout) findViewById(R.id.buttom_layout);
        buttomLayout.setOnSelectListener(this);


        switchFragment(0);


    }


    public void createFragment(Bundle savedInstanceState){

        FirstFragment firstFragment = (FirstFragment) fragmentManager.findFragmentByTag("FirstFragment");
        SecondFragment secondFragment = (SecondFragment) fragmentManager.findFragmentByTag("SecondFragment");
        ThirdFragment thirdFragment = (ThirdFragment) fragmentManager.findFragmentByTag("ThirdFragment");
        FourthFragment fourthFragment = (FourthFragment) fragmentManager.findFragmentByTag("FourthFragment");

        if(firstFragment == null){
            firstFragment = new FirstFragment();
        }

        if(secondFragment == null){
            secondFragment = new SecondFragment();
        }
        if(thirdFragment == null){
            thirdFragment = new ThirdFragment();
        }
        if(fourthFragment == null){
            fourthFragment = new FourthFragment();
        }


        fragments.add(firstFragment);
        fragments.add(secondFragment);
        fragments.add(thirdFragment);
        fragments.add(fourthFragment);


    }


    public void switchFragment(int pos){

        FragmentTransaction transaction =  fragmentManager.beginTransaction() ;


        if(!fragments.get(pos).isAdded()){

            transaction.add(R.id.container,fragments.get(pos),fragments.get(pos).getClass().getSimpleName());
        }

        for(int i=0;i<fragments.size();i++){

            if(i == pos){
                transaction.show(fragments.get(pos));
            }else {
                transaction.hide(fragments.get(i));
            }

        }
        transaction.commit();


    }


    /**
     * 底部导航 点击 回调
     * @param index
     */
    @Override
    public void onSelect(int index) {
        switchFragment(index);
    }
}
