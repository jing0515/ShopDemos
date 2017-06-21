package com.bawei.lvwenjing.shopdemo.basemvp;

/**
 * Created by lenovo-pc on 2017/6/19.
 */

/**
 * 由于项目搭建的过程中使用MVP每个Activity都要绑定与销毁
 * 为了代码的简洁性建立一个公用的persenter
 */
public abstract class BasePresenter<T> {
    public T view;

    //建立绑定的方法
    public void acctach(T view) {
        this.view = view;
    }

    //建立销毁的方法
    public void dettach() {
        view = null;
    }

}
