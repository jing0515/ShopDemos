package com.bawei.lvwenjing.shopdemo;

import android.os.Bundle;

import com.bawei.lvwenjing.shopdemo.basemvp.BaseMVPActivity;
import com.bawei.lvwenjing.shopdemo.presenter.SplashPresenter;
import com.bawei.lvwenjing.shopdemo.view.SplashView;
public class SplashActivity extends BaseMVPActivity<SplashView,SplashPresenter> {
    @Override
    public SplashPresenter initPersenter() {

        return new SplashPresenter();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
