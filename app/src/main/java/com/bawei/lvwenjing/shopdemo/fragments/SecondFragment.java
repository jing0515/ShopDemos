package com.bawei.lvwenjing.shopdemo.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.bawei.lvwenjing.shopdemo.R;
import com.bawei.lvwenjing.shopdemo.fragments.secondfragment.SecondInforFragment01;
import com.bawei.lvwenjing.shopdemo.fragments.secondfragment.SecondInforFragment010;
import com.bawei.lvwenjing.shopdemo.fragments.secondfragment.SecondInforFragment02;
import com.bawei.lvwenjing.shopdemo.fragments.secondfragment.SecondInforFragment03;
import com.bawei.lvwenjing.shopdemo.fragments.secondfragment.SecondInforFragment04;
import com.bawei.lvwenjing.shopdemo.fragments.secondfragment.SecondInforFragment05;
import com.bawei.lvwenjing.shopdemo.fragments.secondfragment.SecondInforFragment06;
import com.bawei.lvwenjing.shopdemo.fragments.secondfragment.SecondInforFragment07;
import com.bawei.lvwenjing.shopdemo.fragments.secondfragment.SecondInforFragment08;
import com.bawei.lvwenjing.shopdemo.fragments.secondfragment.SecondInforFragment09;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {


    private RadioGroup rg;
    private ViewPager viewpager;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        init(view);
        // Inflate the layout for this fragment
        return view;
    }

    private void init(final View view) {

        viewpager = (ViewPager) view.findViewById(R.id.fragmentsecond_view);
        rg = (RadioGroup) view.findViewById(R.id.fragmentsecond_rg);
        viewpager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                switch (position) {
                    case 0:
                        fragment = new SecondInforFragment01();
                        break;
                    case 1:
                        fragment = new SecondInforFragment02();
                        break;
                    case 2:
                        fragment = new SecondInforFragment03();
                        break;
                    case 3:
                        fragment = new SecondInforFragment04();
                        break;
                    case 4:
                        fragment = new SecondInforFragment05();
                        break;
                    case 5:
                        fragment = new SecondInforFragment06();
                        break;
                    case 6:
                        fragment = new SecondInforFragment07();
                        break;
                    case 7:
                        fragment = new SecondInforFragment08();
                        break;
                    case 8:
                        fragment = new SecondInforFragment09();
                        break;
                    case 9:
                        fragment = new SecondInforFragment010();
                        break;
                }

                return fragment;
            }

            @Override
            public int getCount() {
                return 10;
            }
        });
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                rg.check(rg.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for (int i = 0; i < 10; i++) {
                    if (rg.getChildAt(i).getId() == checkedId) {
                        viewpager.setCurrentItem(i);
                    }
                }
            }
        });
    }

}
