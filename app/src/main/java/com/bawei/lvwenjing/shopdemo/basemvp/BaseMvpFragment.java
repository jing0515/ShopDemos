package com.bawei.lvwenjing.shopdemo.basemvp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.lvwenjing.shopdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract  class BaseMvpFragment<V,T extends BasePresenter<V>> extends Fragment {

    public T presenter ;

    public abstract T initPresenter();

    public BaseMvpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        presenter = initPresenter();
        presenter.acctach((V) this);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_base_mvp, container, false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.dettach();
    }
}
