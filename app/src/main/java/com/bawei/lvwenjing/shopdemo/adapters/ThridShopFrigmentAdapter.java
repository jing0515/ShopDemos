package com.bawei.lvwenjing.shopdemo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bawei.lvwenjing.shopdemo.R;
import com.bawei.lvwenjing.shopdemo.bean.ShopBean;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by lenovo-pc on 2017/6/22.
 */

public class ThridShopFrigmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ShopBean.OrderDataBean.CartlistBean> list;
    Context context;

    public ThridShopFrigmentAdapter(List<ShopBean.OrderDataBean.CartlistBean> list, Context context) {
        this.list = list;
        this.context = context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.third_fragment_list, null);
        RecyclerView.ViewHolder viewHolder = new ShopInfor(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final ShopInfor shopInfor = (ShopInfor) holder;
        if (position > 0) {
            //判断是否为头布局 若店铺得的商品的 店铺id相同的话 头布局消失 否则显示
            if (list.get(position).getShopId() == list.get(position - 1).getShopId()) {
                shopInfor.ll_shopcart_header.setVisibility(View.GONE);
            } else {
                shopInfor.ll_shopcart_header.setVisibility(View.VISIBLE);
            }
        } else {
            // position = 0
            shopInfor.ll_shopcart_header.setVisibility(View.VISIBLE);
        }
        shopInfor.tv_item_shopcart_cloth_color.setText("颜色：" + list.get(position).getColor());
        shopInfor.tv_item_shopcart_cloth_size.setText("尺寸：" + list.get(position).getSize());
        shopInfor.tv_item_shopcart_clothname.setText(list.get(position).getProductName());
        shopInfor.tv_item_shopcart_shopname.setText(list.get(position).getShopName());
        shopInfor.tv_item_shopcart_cloth_price.setText("¥" + list.get(position).getPrice());
        shopInfor.et_item_shopcart_cloth_num.setText(list.get(position).getCount() + "");
        Glide.with(context).load(list.get(position).getDefaultPic()).into(shopInfor.iv_item_shopcart_cloth_pic);
        shopInfor.iv_item_shopcart_cloth_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //调用删除方法
                onDeleteClickListener.onDeleteClick(v, position, list.get(position).getId());
                notifyDataSetChanged();
            }
        });


        //标记 商品是否被选中 图片的选择器
        if (list.get(position).isSelect()) {
            shopInfor.tv_item_shopcart_clothselect.setImageDrawable(context.getResources().getDrawable(R.drawable.cpt_filter_check_on));
        } else {
            shopInfor.tv_item_shopcart_clothselect.setImageDrawable(context.getResources().getDrawable(R.drawable.cpt_filter_check_off));
        }
        //标记商店是否被选中
        if (list.get(position).isShopSelect()) {
            shopInfor.iv_item_shopcart_shopselect.setImageDrawable(context.getResources().getDrawable(R.drawable.cpt_filter_check_on));
        } else {
            shopInfor.iv_item_shopcart_shopselect.setImageDrawable(context.getResources().getDrawable(R.drawable.cpt_filter_check_off));
        }
        //传图片选择的结果
        if (onRefershListener != null) {
            boolean isSelect = false;
            for (int i = 0; i < list.size(); i++) {
                if (!list.get(i).isSelect()) {
                    isSelect = false;
                    // 只要有一个商品是 未选中的状态 ，全选按钮就是未选中
                    break;
                } else {
                    isSelect = true;
                }
            }
            onRefershListener.onRefersh(isSelect, list);

        }
        //商品 选中和未选中 事件点击
        ((ShopInfor) holder).tv_item_shopcart_clothselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //标记 当前 item 的选中状态
                list.get(position).setSelect(!list.get(position).isSelect());

                for (int i = 0; i < list.size(); i++) {
                    for (int j = 0; j < list.size(); j++) {
                        //如果是同一家商铺的商品，并且其中一个商品是未选中，那么商铺的全选勾选取消
                        if (list.get(j).getShopId() == list.get(i).getShopId() && !list.get(j).isSelect()) {
                            list.get(i).setShopSelect(false);
                            break;
                        } else {
                            //如果是同一家商铺的商品，并且所有商品是选中，那么商铺的选中全选勾选
                            list.get(i).setShopSelect(true);
                        }
                    }
                }
                notifyDataSetChanged();
            }
        });

        // 店铺 选中 yu 未选中
        ((ShopInfor) holder).iv_item_shopcart_shopselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (list.get(position).getIsFirst() == 2) {
                    list.get(position).setShopSelect(!list.get(position).isShopSelect());
                    for (int i = 0; i < list.size(); i++) {
                        onItemClickListener.onItemClick(v, position);
                        if (list.get(i).getShopId() == list.get(position).getShopId()) {
                            list.get(i).setSelect(list.get(position).isShopSelect());

                        }
                    }
                    notifyDataSetChanged();
                }
            }
        });


        //加减
        final int[] count = {list.get(position).getCount()};
        shopInfor.iv_item_shopcart_cloth_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count[0] += 1;
                shopInfor.et_item_shopcart_cloth_num.setText("" + count[0]);
                onEditListener.onEditListener(position, list.get(position).getId(), count[0]);
                list.get(position).setCount(count[0]);
                notifyDataSetChanged();
            }
        });
        shopInfor.iv_item_shopcart_cloth_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count[0] -= 1;
                if (count[0] >= 1) {
                    shopInfor.et_item_shopcart_cloth_num.setText("" + count[0]);
                    list.get(position).setCount(count[0]);
                    System.out.println("-----------------" + list.get(position).getCount());
                    notifyDataSetChanged();
                }
            }
        });
    }

    // 点击事件
    public OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    //删除
    public OnDeleteClickListener onDeleteClickListener;

    public interface OnDeleteClickListener {
        void onDeleteClick(View view, int position, int cartid);
    }

    public void setOnDeleteClickListener(OnDeleteClickListener deleteClickListener) {
        this.onDeleteClickListener = deleteClickListener;
    }

    public OnEditListener onEditListener;

    //添加 减少
    public interface OnEditListener {
        void onEditListener(int position, int cartid, int count);
    }

    public void setOnEditListener(OnEditListener onEditListener) {
        this.onEditListener = onEditListener;
    }


    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    // 商品 选中状态发生变化
    public OnRefershListener onRefershListener;

    public interface OnRefershListener {
        //isSelect true 表示商品全部选中 false 未全部选中
        void onRefersh(boolean isSelect, List<ShopBean.OrderDataBean.CartlistBean> list);
    }

    public void setOnRefershListener(OnRefershListener listener) {
        this.onRefershListener = listener;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ShopInfor extends RecyclerView.ViewHolder {


        private final ImageView iv_item_shopcart_shopselect;
        private final View view;
        private final TextView tv_item_shopcart_shopname;
        private final LinearLayout ll_shopcart_header;
        private final TextView tv_item_shopcart_clothname;
        private final ImageView tv_item_shopcart_clothselect;
        private final ImageView iv_item_shopcart_cloth_pic;
        private final TextView tv_item_shopcart_cloth_price;
        private final TextView tv_item_shopcart_cloth_color;
        private final TextView tv_item_shopcart_cloth_size;
        private final ImageView iv_item_shopcart_cloth_minus;
        private final TextView et_item_shopcart_cloth_num;
        private final ImageView iv_item_shopcart_cloth_add;
        private final ImageView iv_item_shopcart_cloth_delete;

        public ShopInfor(View itemView) {
            super(itemView);
            view = itemView.findViewById(R.id.view);
            iv_item_shopcart_shopselect = (ImageView) itemView.findViewById(R.id.iv_item_shopcart_shopselect);
            tv_item_shopcart_shopname = (TextView) itemView.findViewById(R.id.tv_item_shopcart_shopname);
            ll_shopcart_header = (LinearLayout) itemView.findViewById(R.id.ll_shopcart_header);
            tv_item_shopcart_clothname = (TextView) itemView.findViewById(R.id.tv_item_shopcart_clothname);
            tv_item_shopcart_clothselect = (ImageView) itemView.findViewById(R.id.tv_item_shopcart_clothselect);
            iv_item_shopcart_cloth_pic = (ImageView) itemView.findViewById(R.id.iv_item_shopcart_cloth_pic);
            tv_item_shopcart_cloth_price = (TextView) itemView.findViewById(R.id.tv_item_shopcart_cloth_price);
            tv_item_shopcart_cloth_color = (TextView) itemView.findViewById(R.id.tv_item_shopcart_cloth_color);
            tv_item_shopcart_cloth_size = (TextView) itemView.findViewById(R.id.tv_item_shopcart_cloth_size);
            iv_item_shopcart_cloth_minus = (ImageView) itemView.findViewById(R.id.iv_item_shopcart_cloth_minus);
            et_item_shopcart_cloth_num = (TextView) itemView.findViewById(R.id.et_item_shopcart_cloth_num);
            iv_item_shopcart_cloth_add = (ImageView) itemView.findViewById(R.id.iv_item_shopcart_cloth_add);
            iv_item_shopcart_cloth_delete = (ImageView) itemView.findViewById(R.id.iv_item_shopcart_cloth_delete);


        }
    }
}
