package com.bawei.lvwenjing.shopdemo.fragments.indexfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.lvwenjing.shopdemo.R;
import com.bawei.lvwenjing.shopdemo.adapters.FirstIndexFragmentAdapter;
import com.bawei.lvwenjing.shopdemo.bean.InforBean;
import com.bawei.lvwenjing.shopdemo.network.BaseObServer;
import com.bawei.lvwenjing.shopdemo.network.RetrofitFactory;
import com.google.gson.Gson;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstIndexFragment extends Fragment {

    private RecyclerView recyclerView;

    public FirstIndexFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getInfor();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first_index, container, false);

        init(view);
        return view;

    }

    private void init(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.firstindextfragment_re);


    }

    public void getInfor() {
        RetrofitFactory.get("http://lib.suning.com/app/redbaby/80000_8.2.0-155.json").subscribe(new BaseObServer() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                InforBean inforBean = gson.fromJson(result, InforBean.class);
                List<InforBean.DataBean> data = inforBean.getData();
                FirstIndexFragmentAdapter adapter = new FirstIndexFragmentAdapter(data,getActivity());
                LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailed() {

            }
        });
    }
}
