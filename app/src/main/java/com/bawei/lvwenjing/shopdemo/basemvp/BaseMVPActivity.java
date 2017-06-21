package com.bawei.lvwenjing.shopdemo.basemvp;

import android.os.Bundle;

import com.bawei.lvwenjing.shopdemo.R;

//建立mvp公用activity的类  V当前view T
public abstract class BaseMVPActivity<V, T extends BasePresenter<V>> extends IActivity {
    public T persenter;
    public abstract T initPersenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_mvp);
        persenter = initPersenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //绑定
        persenter.acctach((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //销毁
        persenter.dettach();
    }
}
