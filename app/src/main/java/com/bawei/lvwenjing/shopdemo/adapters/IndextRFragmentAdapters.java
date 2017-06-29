package com.bawei.lvwenjing.shopdemo.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bawei.lvwenjing.shopdemo.R;
import com.bawei.lvwenjing.shopdemo.bean.IndextBean;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by lenovo-pc on 2017/6/22.
 */

public class IndextRFragmentAdapters extends RecyclerView.Adapter {
    List<IndextBean.DataBean> list;
    Context context;
















    public IndextRFragmentAdapters(List<IndextBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public static final String base_image = "http://image3.suning.cn";

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.first_onephoto_itme, null);
                viewHolder = new Firstonephotoitme(view);
                break;
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.first_mkill_itme, null);
                viewHolder = new FirstSKillitme(view);
                break;
            case 2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.first_index_huodong_itme, null);
                viewHolder = new FirstHoudong(view);
                break;
            case 3:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.first_pinpai_itne, null);
                viewHolder = new FirstPinpai(view);

                break;
            case 4:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.first_1_7_itme, null);
                viewHolder = new Fist1_7_itme(view);

                break;
            case 5:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.first_1_7_itme, null);
                viewHolder = new Fist1_7_itme(view);

                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        switch (itemViewType) {
            case 0:
                System.out.println("\"aaaa\" = " + "aaaa");
                Firstonephotoitme firstonephotoitme = (Firstonephotoitme) holder;
                String picUrl = list.get(0).get_$88001().getTag().get(0).getPicUrl();
                Glide.with(context).load(base_image + picUrl).into(firstonephotoitme.first_onephoto_itme_iv);
                break;
            case 1:
                System.out.println("\"cccc\" = " + "cccc");
                FirstSKillitme firstfkillitme = (FirstSKillitme) holder;
                String picUrl2 = list.get(1).get_$88003().getTag().get(0).getPicUrl();
                Glide.with(context).load(base_image + picUrl2).into(firstfkillitme.first_mkilll_title);
                int size = list.get(1).get_$88003().getTag().size();

                for (int i = 1; i < size; i++) {
                    //图片对应的路径
                    String item_pic = list.get(1).get_$88003().getTag().get(i).getPicUrl();
                    System.out.println("item_pic = " + base_image + item_pic);
                    LinearLayout linearLayout = new LinearLayout(context);
                    linearLayout.setOrientation(LinearLayout.VERTICAL);
                    linearLayout.setPadding(10, 10, 10, 0);
                    ImageView imageView = new ImageView(context);
                    imageView.setLayoutParams(new LinearLayout.LayoutParams(300, 300));
                    Glide.with(context).load(base_image + item_pic).into(imageView);
                    TextView textView = new TextView(context);
                    textView.setText("$95");
                    textView.setTextColor(Color.RED);
                    textView.setTextSize(20f);
                    textView.setGravity(Gravity.CENTER);
                    linearLayout.addView(imageView);
                    linearLayout.addView(textView);

                    //
                    firstfkillitme.linearLayout.addView(linearLayout);
                }
                break;
            case 2:
                FirstHoudong firstHoudong = (FirstHoudong) holder;
                String picUrl1 = list.get(3).get_$88005().getTag().get(0).getPicUrl();
                Glide.with(context).load(base_image + picUrl1).into(firstHoudong.first_index_houdong_title);
                String picUrl4 = list.get(4).get_$88015().getTag().get(0).getPicUrl();
                Glide.with(context).load(base_image + picUrl4).into(firstHoudong.first_index_houdong_iv1);
                String picUrl6 = list.get(6).get_$88015().getTag().get(0).getPicUrl();
                Glide.with(context).load(base_image + picUrl6).into(firstHoudong.first_index_houdong_iv2);
                String picUrl7 = list.get(7).get_$88014().getTag().get(0).getPicUrl();
                Glide.with(context).load(base_image + picUrl7).into(firstHoudong.first_index_houdong_gengduo);
                String elementName = list.get(4).get_$88015().getTag().get(0).getElementName();
                String substring = elementName.substring(0, 13);
                firstHoudong.first_index_houdong_tv1.setText(substring + "....");
                String elementDesc = list.get(4).get_$88015().getTag().get(0).getElementDesc();
                firstHoudong.first_index_houdong_tv2.setText(elementDesc + "...");
                String elementName1 = list.get(6).get_$88015().getTag().get(0).getElementName();

                firstHoudong.first_index_houdong_tv3.setText(elementName1 + "...");
                String elementDesc1 = list.get(6).get_$88015().getTag().get(0).getElementDesc();
                firstHoudong.first_index_houdong_tv4.setText(elementDesc1 + "...");
                break;
            case 3:
                FirstPinpai firstPinpai = (FirstPinpai) holder;
                String picUrl9 = list.get(9).get_$88005().getTag().get(0).getPicUrl();
                Glide.with(context).load(base_image + picUrl9).into(firstPinpai.pinpai_ivtitle);
                String picUrl1110 = list.get(10).get_$88010().getTag().get(0).getPicUrl();
                Glide.with(context).load(base_image + picUrl1110).into(firstPinpai.pinpai);
                int sizes = list.get(11).get_$88011().getTag().size();

                for (int i = 1; i < sizes; i++) {
                    //图片对应的路径
                    String item_pics = list.get(11).get_$88011().getTag().get(i).getPicUrl();
                    System.out.println("item_pic = " + base_image + item_pics);
                    LinearLayout linearLayout = new LinearLayout(context);
                    linearLayout.setOrientation(LinearLayout.VERTICAL);
                    linearLayout.setPadding(10, 10, 10, 0);
                    ImageView imageView = new ImageView(context);
                    imageView.setLayoutParams(new LinearLayout.LayoutParams(250, 250));
                    Glide.with(context).load(base_image + item_pics).into(imageView);
                    String item_pic = list.get(11).get_$88011().getTag().get(0).getPicUrl();
                    Glide.with(context).load(base_image + item_pic).into(imageView);
                    TextView textView = new TextView(context);
                    textView.setText("$95");
                    textView.setTextColor(Color.RED);
                    textView.setTextSize(20f);
                    textView.setGravity(Gravity.CENTER);
                    linearLayout.addView(imageView);
                    linearLayout.addView(textView);
                    //
                    firstPinpai.pinpailinearLayout.addView(linearLayout);


                }

                break;
            case 4:
                Fist1_7_itme fist1_7_itme = (Fist1_7_itme) holder;
                String picUrl12 = list.get(12).get_$88010().getTag().get(0).getPicUrl();
                Glide.with(context).load(base_image + picUrl12).into(fist1_7_itme.first_1_7_iv);

                int size13 = list.get(13).get_$88011().getTag().size();

                for (int i = 1; i < size13; i++) {
                    //图片对应的路径
                    String item_pics = list.get(13).get_$88011().getTag().get(i).getPicUrl();
                    System.out.println("item_pic = " + base_image + item_pics);
                    LinearLayout linearLayout = new LinearLayout(context);
                    linearLayout.setOrientation(LinearLayout.VERTICAL);
                    linearLayout.setPadding(10, 10, 10, 0);
                    ImageView imageView = new ImageView(context);
                    imageView.setLayoutParams(new LinearLayout.LayoutParams(300, 300));
                    Glide.with(context).load(base_image + item_pics).into(imageView);
                    String item_pic = list.get(11).get_$88011().getTag().get(0).getPicUrl();
                    Glide.with(context).load(base_image + item_pic).into(imageView);
                    TextView textView = new TextView(context);
                    textView.setText("$95");
                    textView.setTextColor(Color.RED);
                    textView.setTextSize(20f);
                    textView.setGravity(Gravity.CENTER);
                    linearLayout.addView(imageView);
                    linearLayout.addView(textView);
                    //
                    fist1_7_itme.first_1_7_horizontal_linearlayout.addView(linearLayout);
                }

                break;
            case 5:
                Fist1_7_itme fist1_7_itmes = (Fist1_7_itme) holder;
                String picUrl14 = list.get(14).get_$88010().getTag().get(0).getPicUrl();
                Glide.with(context).load(base_image + picUrl14).into(fist1_7_itmes.first_1_7_iv);

                int size14 = list.get(15).get_$88011().getTag().size();

                for (int i = 1; i < size14; i++) {
                    //图片对应的路径
                    String item_pics = list.get(15).get_$88011().getTag().get(i).getPicUrl();
                    System.out.println("item_pic = " + base_image + item_pics);
                    LinearLayout linearLayout = new LinearLayout(context);
                    linearLayout.setOrientation(LinearLayout.VERTICAL);
                    linearLayout.setPadding(10, 10, 10, 0);
                    ImageView imageView = new ImageView(context);
                    imageView.setLayoutParams(new LinearLayout.LayoutParams(300, 300));
                    Glide.with(context).load(base_image + item_pics).into(imageView);
                    String item_pic = list.get(11).get_$88011().getTag().get(0).getPicUrl();
                    Glide.with(context).load(base_image + item_pic).into(imageView);
                    TextView textView = new TextView(context);
                    textView.setText("$95");
                    textView.setTextColor(Color.RED);
                    textView.setTextSize(20f);
                    textView.setGravity(Gravity.CENTER);
                    linearLayout.addView(imageView);
                    linearLayout.addView(textView);
                    //
                    fist1_7_itmes.first_1_7_horizontal_linearlayout.addView(linearLayout);
                }

                break;
        }

    }


    @Override
    public int getItemViewType(int position) {
        int i = 0;
        switch (position) {
            case 0:
                i = 0;
                break;
            case 1:
                i = 1;
                break;
            case 2:
                i = 2;
                break;
            case 3:
                i = 3;
                break;
            case 4:
                i = 4;
                break;
            case 5:
                i = 5;
                break;
          
        }
        return i;
    }


    @Override
    public int getItemCount() {
        return 7;
    }


    class Fist1_7_itme extends RecyclerView.ViewHolder {

        private final ImageView first_1_7_iv;
        private final LinearLayout first_1_7_horizontal_linearlayout;

        public Fist1_7_itme(View itemView) {
            super(itemView);
            first_1_7_iv = (ImageView) itemView.findViewById(R.id.first_1_7_iv);
            first_1_7_horizontal_linearlayout = (LinearLayout) itemView.findViewById(R.id.first_1_7_horizontal_linearlayout);

        }
    }


    //多条目类型
    class Firstonephotoitme extends RecyclerView.ViewHolder {
        private final ImageView first_onephoto_itme_iv;

        public Firstonephotoitme(View itemView) {
            super(itemView);
            first_onephoto_itme_iv = (ImageView) itemView.findViewById(R.id.first_onephoto_itme_iv);
        }
    }

    class FirstSKillitme extends RecyclerView.ViewHolder {

        private final ImageView first_mkilll_title;
        private final LinearLayout linearLayout;

        public FirstSKillitme(View itemView) {
            super(itemView);
            first_mkilll_title = (ImageView) itemView.findViewById(R.id.first_mkilll_title);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.horizontal_linearlayout);

        }
    }

    class FirstHoudong extends RecyclerView.ViewHolder {

        private final ImageView first_index_houdong_iv1;
        private final ImageView first_index_houdong_iv2;
        private final ImageView first_index_houdong_title;
        private final TextView first_index_houdong_price;
        private final TextView first_index_houdong_price2;
        private final TextView first_index_houdong_tv1;
        private final TextView first_index_houdong_tv2;
        private final TextView first_index_houdong_tv3;
        private final TextView first_index_houdong_tv4;
        private final ImageView first_index_houdong_gengduo;

        public FirstHoudong(View itemView) {
            super(itemView);
            first_index_houdong_gengduo = (ImageView) itemView.findViewById(R.id.first_index_houdong_gengduo);
            first_index_houdong_iv1 = (ImageView) itemView.findViewById(R.id.first_index_houdong_iv1);
            first_index_houdong_iv2 = (ImageView) itemView.findViewById(R.id.first_index_houdong_iv2);
            first_index_houdong_title = (ImageView) itemView.findViewById(R.id.first_index_houdong_title);
            first_index_houdong_price = (TextView) itemView.findViewById(R.id.first_index_houdong_price);
            first_index_houdong_price2 = (TextView) itemView.findViewById(R.id.first_index_houdong_price2);
            first_index_houdong_tv1 = (TextView) itemView.findViewById(R.id.first_index_houdong_tv1);
            first_index_houdong_tv2 = (TextView) itemView.findViewById(R.id.first_index_houdong_tv2);
            first_index_houdong_tv3 = (TextView) itemView.findViewById(R.id.first_index_houdong_tv3);
            first_index_houdong_tv4 = (TextView) itemView.findViewById(R.id.first_index_houdong_tv4);

        }
    }

    class FirstZhishi extends RecyclerView.ViewHolder {

        private final ImageView zhishi_ivtitle;
        private final ImageView zhishi_iv1;
        private final ImageView zhishi_iv2;
        private final ImageView zhishi_iv3;
        private final ImageView zhishi_iv4;
        private final ImageView zhishi_iv5;
        private final ImageView zhishi_iv6;

        public FirstZhishi(View itemView) {
            super(itemView);
            zhishi_ivtitle = (ImageView) itemView.findViewById(R.id.zhishi_ivtitle);
            zhishi_iv1 = (ImageView) itemView.findViewById(R.id.zhishi_iv1);
            zhishi_iv2 = (ImageView) itemView.findViewById(R.id.zhishi_iv2);
            zhishi_iv3 = (ImageView) itemView.findViewById(R.id.zhishi_iv3);
            zhishi_iv4 = (ImageView) itemView.findViewById(R.id.zhishi_iv4);
            zhishi_iv5 = (ImageView) itemView.findViewById(R.id.zhishi_iv5);
            zhishi_iv6 = (ImageView) itemView.findViewById(R.id.zhishi_iv6);
        }
    }

    class FirstPinpai extends RecyclerView.ViewHolder {

        private final ImageView pinpai;
        private final ImageView pinpai_ivtitle;
        private final LinearLayout pinpailinearLayout;

        public FirstPinpai(View itemView) {
            super(itemView);
            pinpai_ivtitle = (ImageView) itemView.findViewById(R.id.pinpai_ivtitle);
            pinpai = (ImageView) itemView.findViewById(R.id.pinpai);
            pinpailinearLayout = (LinearLayout) itemView.findViewById(R.id.pinpai_horizontal_linearlayout);
        }
    }

    class Firstyuer extends RecyclerView.ViewHolder {

        private final ImageView yuer_ivtitle;
        private final LinearLayout yuer_horizontal_linearlayout;

        public Firstyuer(View itemView) {
            super(itemView);
            yuer_ivtitle = (ImageView) itemView.findViewById(R.id.yuer_ivtitle);
            yuer_horizontal_linearlayout = (LinearLayout) itemView.findViewById(R.id.yuer_horizontal_linearlayout);
        }
    }

}
