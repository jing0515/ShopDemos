package com.bawei.lvwenjing.shopdemo.fragments;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.lvwenjing.shopdemo.R;
import com.bawei.lvwenjing.shopdemo.adapters.ThridShopFrigmentAdapter;
import com.bawei.lvwenjing.shopdemo.bean.ShopBean;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFragment extends Fragment {
    //存放购物车中所有的商品
    private List<ShopBean.OrderDataBean.CartlistBean> mAllOrderList = new ArrayList<>();
    private TextView third_totalnum;
    private ImageView third_allselect;
    private TextView third_totalnum1;
    boolean isSelects = true;
    private int money;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        init(view);
        getInfor();
        return view;

    }

    public void init(View view) {
        third_allselect = (ImageView) view.findViewById(R.id.third_allselect);
        third_totalnum = (TextView) view.findViewById(R.id.third_totalnum);
        third_totalnum1 = (TextView) view.findViewById(R.id.third_totalprice);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.third_recyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        final ThridShopFrigmentAdapter adapter = new ThridShopFrigmentAdapter(mAllOrderList, getActivity());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);


        //删除数据回调
        adapter.setOnDeleteClickListener(new ThridShopFrigmentAdapter.OnDeleteClickListener() {
            @Override
            public void onDeleteClick(View view, int position, int cartid) {
                mAllOrderList.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
        third_allselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSelects == true) {
                    third_allselect.setImageResource(R.drawable.check_box_bg_on);
                    isSelects = false;
                    for (int i = 0; i < mAllOrderList.size(); i++) {
                        if (mAllOrderList.get(i).isSelect() == true) {
                            mAllOrderList.get(i).setSelect(false);
                        }
                        adapter.notifyDataSetChanged();
                        if (mAllOrderList.get(i).isShopSelect() == true) {
                            mAllOrderList.get(i).setShopSelect(false);
                        }
                        adapter.notifyDataSetChanged();
                    }

                } else {
                    third_allselect.setImageResource(R.drawable.check_box_bg_off);
                    isSelects = true;
                    for (int i = 0; i < mAllOrderList.size(); i++) {
                        if (mAllOrderList.get(i).isSelect()==false) {
                            mAllOrderList.get(i).setSelect(true);
                        }
                        adapter.notifyDataSetChanged();
                        if (mAllOrderList.get(i).isShopSelect()==false) {
                            mAllOrderList.get(i).setShopSelect(true);
                        }
                        adapter.notifyDataSetChanged();
                    }

                }


            }
        });
        //
        adapter.setOnRefershListener(new ThridShopFrigmentAdapter.OnRefershListener() {

            private int m;

            @Override
            public void onRefersh(boolean isSelect, List<ShopBean.OrderDataBean.CartlistBean> list) {
                //标记底部 全选按钮
                if (isSelect == true) {
                    Drawable left = getResources().getDrawable(R.drawable.check_box_bg_on);
                    third_allselect.setImageResource(R.drawable.check_box_bg_on);
                } else {
                    Drawable left = getResources().getDrawable(R.drawable.check_box_bg_off);
                    third_allselect.setImageResource(R.drawable.check_box_bg_off);
                }

                //总价
                float mTotlaPrice = 0f;
                int mTotalNum = 0;
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).isSelect()) {
                        mTotlaPrice += list.get(i).getPrice() * list.get(i).getCount();
                        mTotalNum += list.get(i).getCount();
                        if (list.size() == 0) {
                            mTotalNum = 0;
                            mTotlaPrice = 0;
                        }

                    }
                }

                third_totalnum1.setText("总价 : " + mTotlaPrice);

                third_totalnum.setText("共" + mTotalNum + "件商品");
            }
        });


    }

    public void getInfor() {

        try {
            InputStream inputStream = getActivity().getAssets().open("shop.json");
            String data = com.bawei.lvwenjing.shopdemo.utils.StringUtils.convertStreamToString(inputStream);
            Gson gson = new Gson();
            ShopBean shopBean = gson.fromJson(data, ShopBean.class);
            List<ShopBean.OrderDataBean> orderData = shopBean.getOrderData();

            for (int i = 0; i < shopBean.getOrderData().size(); i++) {
                int length = shopBean.getOrderData().get(i).getCartlist().size();
                for (int j = 0; j < length; j++) {
                    mAllOrderList.add(shopBean.getOrderData().get(i).getCartlist().get(j));
                }
            }

        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 商品 选中状态发生变化
    public ThridShopFrigmentAdapter.OnRefershListener onRefershListeners;

    public interface OnRefershListeners {
        //isSelect true 表示商品全部选中 false 未全部选中
        void onRefersh(boolean isSelect, List<ShopBean.OrderDataBean.CartlistBean> list);
    }
}
