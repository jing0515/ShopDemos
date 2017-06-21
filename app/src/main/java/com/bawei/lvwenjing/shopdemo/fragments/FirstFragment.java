package com.bawei.lvwenjing.shopdemo.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bawei.lvwenjing.shopdemo.R;
import com.bawei.lvwenjing.shopdemo.adapters.IndextFragmentAdapters;
import com.xys.libzxing.zxing.activity.CaptureActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        init(view);
        return view;
    }

    public void init(View view) {
        ImageView erweima = (ImageView) view.findViewById(R.id.erweima);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.fragment_tab);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.Firstfragment_viewpager);
        IndextFragmentAdapters adapters = new IndextFragmentAdapters(getChildFragmentManager());
        viewPager.setAdapter(adapters);
//绑定
        tabLayout.setupWithViewPager(viewPager);
//字体颜色
        tabLayout.setTabTextColors(getResources().getColor(R.color.baclk), getResources().getColor(R.color.red));
//指示器颜色
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.red));
//模式
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        erweima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CaptureActivity.class));
            }
        });
    }

}
