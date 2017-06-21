package com.bawei.lvwenjing.shopdemo.basemvp;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.bawei.lvwenjing.shopdemo.R;

/**
 * 由于简单的实现效果要使用mvp模式就不会让代码反而变得复杂 所以建立一个默认Acticity各个布局能够继承他
 * 来实现效果就行
 */
public class IActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i);
    }
}
