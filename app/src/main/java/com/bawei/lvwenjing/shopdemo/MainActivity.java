package com.bawei.lvwenjing.shopdemo;

import android.content.Intent;
import android.os.Bundle;

import com.bawei.lvwenjing.shopdemo.activitys.TabActivity;
import com.bawei.lvwenjing.shopdemo.basemvp.BaseMVPActivity;
import com.bawei.lvwenjing.shopdemo.presenter.SplashPresenter;
import com.bawei.lvwenjing.shopdemo.view.SplashView;

public class MainActivity extends BaseMVPActivity<SplashView, SplashPresenter> {
    @Override
    public SplashPresenter initPersenter() {
        return new SplashPresenter();
    }
                //xxxxx xxxsaasassa
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // fddddddddddggggggfffffffffffffffffffffffffffffffff
        startActivity(new Intent(MainActivity.this, TabActivity.class));
    }
}
