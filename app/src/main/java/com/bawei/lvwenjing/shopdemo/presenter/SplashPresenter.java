package com.bawei.lvwenjing.shopdemo.presenter;

import com.bawei.lvwenjing.shopdemo.basemvp.BasePresenter;
import com.bawei.lvwenjing.shopdemo.moder.SplashModelImpl;
import com.bawei.lvwenjing.shopdemo.view.SplashView;

/**
 * Created by lenovo-pc on 2017/6/19.
 */

public class SplashPresenter extends BasePresenter<SplashView> {


    private SplashModelImpl splashModel;
    public SplashPresenter() {
        splashModel = new SplashModelImpl();
    }

    public void getDatas() {
        //调用moder中的方法
        splashModel.getData();
    }

}
