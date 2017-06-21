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
import com.bawei.lvwenjing.shopdemo.bean.InforBean;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by lenovo-pc on 2017/6/21.
 */

public class FirstIndexFragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    int i = 0;
    List<InforBean.DataBean> list;
    Context context;
    public static final String base_image = "http://image3.suning.cn";

    public FirstIndexFragmentAdapter(List<InforBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case 0:
                System.out.println("\"0000\" = " + "0000");
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.first_onephoto_itme, null);
                viewHolder = new Firstonephotoitme(view);
                break;
            case 1:
                System.out.println("\"1111\" = " + "1111");
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.first_shangxin_itme, null);
                viewHolder = new FirstShangxin(view);
                break;
            case 2:
                System.out.println("\"2222\" = " + "2222");
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.first_mkill_itme, null);
                viewHolder = new FirstSKillitme(view);
                break;
            case 3:
                System.out.println("\"2222\" = " + "2222");
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.first_huodong_itme, null);
                viewHolder = new FirstHoudong(view);
                break;
            case 4:
                System.out.println("\"2222\" = " + "2222");
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.first_zhishi_itme, null);
                viewHolder = new FirstZhishi(view);
                break;
            case 5:
                System.out.println("\"2222\" = " + "2222");
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.first_pinpai_itne, null);
                viewHolder = new FirstPinpai(view);

                break;
            case 6:
                System.out.println("\"2222\" = " + "2222");
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.first_yuer_itme, null);
                viewHolder = new Firstyuer(view);

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
                String picUrl = list.get(1).getTag().get(0).getPicUrl();
                System.out.println("picUrl = 0 " + picUrl);
                Glide.with(context).load(base_image + "/uimg/cms/img/149800512463275204.jpg").into(firstonephotoitme.first_onephoto_itme_iv);
                break;
            case 1:
                System.out.println("\"bbbb\" = " + "bbbb");
                FirstShangxin firstshangxin = (FirstShangxin) holder;
                String picUrl1 = list.get(2).getTag().get(0).getPicUrl();
                String picUrl11 = list.get(2).getTag().get(1).getPicUrl();
                String picUrl12 = list.get(2).getTag().get(2).getPicUrl();
                String picUrl13 = list.get(2).getTag().get(3).getPicUrl();
                String picUrl14 = list.get(2).getTag().get(4).getPicUrl();
                String elementName = list.get(2).getTag().get(0).getElementName();
                String elementName1 = list.get(2).getTag().get(1).getElementName();
                String elementName2 = list.get(2).getTag().get(2).getElementName();
                String elementName3 = list.get(2).getTag().get(3).getElementName();
                String elementName4 = list.get(2).getTag().get(4).getElementName();
                firstshangxin.first_shangxin_tv1.setText(elementName);
                firstshangxin.first_shangxin_tv2.setText(elementName1);
                firstshangxin.first_shangxin_tv3.setText(elementName2);
                firstshangxin.first_shangxin_tv4.setText(elementName3);
                firstshangxin.first_shangxin_tv5.setText(elementName4);
                Glide.with(context).load(base_image + picUrl1).into(firstshangxin.first_shangxin_iv1);
                Glide.with(context).load(base_image + picUrl11).into(firstshangxin.first_shangxin_iv2);
                Glide.with(context).load(base_image + picUrl12).into(firstshangxin.first_shangxin_iv3);
                Glide.with(context).load(base_image + picUrl13).into(firstshangxin.first_shangxin_iv4);
                Glide.with(context).load(base_image + picUrl14).into(firstshangxin.first_shangxin_iv5);
                break;
            case 2:
                System.out.println("\"cccc\" = " + "cccc");
                FirstSKillitme firstfkillitme = (FirstSKillitme) holder;
                String picUrl2 = list.get(3).getTag().get(0).getPicUrl();
                Glide.with(context).load(base_image + picUrl2).into(firstfkillitme.first_mkilll_title);
                int size = list.get(3).getTag().size();

                for (int i = 1; i < size; i++) {
                    //图片对应的路径
                    String item_pic = list.get(3).getTag().get(i).getPicUrl();
                    System.out.println("item_pic = " + base_image + item_pic);
                    LinearLayout linearLayout = new LinearLayout(context);
                    linearLayout.setOrientation(LinearLayout.VERTICAL);
                    linearLayout.setPadding(10, 10, 10, 0);
                    ImageView imageView = new ImageView(context);
                    imageView.setLayoutParams(new LinearLayout.LayoutParams(200, 200));
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
            case 3:
                FirstHoudong firsthoudong = (FirstHoudong) holder;
                String picUrl3 = list.get(5).getTag().get(0).getPicUrl();
                Glide.with(context).load(base_image + picUrl3).into(firsthoudong.huodong_ivtitle);
                String picUrl4 = list.get(6).getTag().get(0).getPicUrl();
                Glide.with(context).load("http://image3.suning.cn/uimg/cms/img/148784143275773477.png").into(firsthoudong.huodong_iv1);
                String picUrl5 = list.get(6).getTag().get(1).getPicUrl();
                Glide.with(context).load(base_image + picUrl5).into(firsthoudong.huodong_iv2);
                break;
            case 4:
                FirstZhishi firstZhishi = (FirstZhishi) holder;
                String picUrl6 = list.get(8).getTag().get(0).getPicUrl();
                Glide.with(context).load(base_image + picUrl6).into(firstZhishi.zhishi_ivtitle);
                String picUrl7 = list.get(9).getTag().get(0).getPicUrl();
                Glide.with(context).load(base_image + picUrl7).into(firstZhishi.zhishi_iv1);
                String picUrl8 = list.get(9).getTag().get(1).getPicUrl();
                Glide.with(context).load(base_image + picUrl8).into(firstZhishi.zhishi_iv2);
                String picUrl9 = list.get(10).getTag().get(0).getPicUrl();
                Glide.with(context).load(base_image + picUrl9).into(firstZhishi.zhishi_iv3);
                String picUrl10 = list.get(10).getTag().get(1).getPicUrl();
                Glide.with(context).load(base_image + picUrl10).into(firstZhishi.zhishi_iv4);
                String picUrl111 = list.get(11).getTag().get(0).getPicUrl();
                Glide.with(context).load(base_image + picUrl111).into(firstZhishi.zhishi_iv5);
                String picUrl1112 = list.get(11).getTag().get(1).getPicUrl();
                Glide.with(context).load(base_image + picUrl1112).into(firstZhishi.zhishi_iv6);
                break;
            case 5:
                FirstPinpai firstPinpai = (FirstPinpai) holder;
                String picUrl1113 = list.get(13).getTag().get(0).getPicUrl();
                Glide.with(context).load(base_image + picUrl1113).into(firstPinpai.pinpai_ivtitle);
                String picUrl1114 = list.get(14).getTag().get(0).getPicUrl();
                Glide.with(context).load(base_image + picUrl1114).into(firstPinpai.pinpai);
                int sizes = list.get(15).getTag().size();

                for (int i = 1; i < sizes; i++) {
                    //图片对应的路径
                    String item_pics = list.get(15).getTag().get(i).getPicUrl();
                    System.out.println("item_pic = " + base_image + item_pics);
                    LinearLayout linearLayout = new LinearLayout(context);
                    linearLayout.setOrientation(LinearLayout.VERTICAL);
                    linearLayout.setPadding(10, 10, 10, 0);
                    ImageView imageView = new ImageView(context);
                    imageView.setLayoutParams(new LinearLayout.LayoutParams(250, 250));
                    Glide.with(context).load(base_image + item_pics).into(imageView);
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
            case 6:
                Firstyuer firstyuer = (Firstyuer) holder;
                String picUrl1116 = list.get(16).getTag().get(0).getPicUrl();
                Glide.with(context).load(base_image + picUrl1116).into(firstyuer.yuer_ivtitle);
                int size7= list.get(17).getTag().size();
                for (int i = 0; i < size7; i++) {
                    //图片对应的路径
                    String item_pic7 = list.get(17).getTag().get(i).getPicUrl();
                    System.out.println("item_pic = " + base_image + item_pic7);
                    LinearLayout linearLayout = new LinearLayout(context);
                    linearLayout.setOrientation(LinearLayout.VERTICAL);
                    linearLayout.setPadding(10, 10, 10, 0);
                    ImageView imageView = new ImageView(context);
                    imageView.setLayoutParams(new LinearLayout.LayoutParams(300, 300));
                    Glide.with(context).load(base_image + item_pic7).into(imageView);
                    TextView textView = new TextView(context);
                    textView.setText("$95");
                    textView.setTextColor(Color.RED);
                    textView.setTextSize(20f);
                    textView.setGravity(Gravity.CENTER);
                    linearLayout.addView(imageView);
                    linearLayout.addView(textView);
                    //
                    firstyuer.yuer_horizontal_linearlayout.addView(linearLayout);


                }
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {

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
            case 6:
                i = 6;
                break;
        }
        return i;
    }

    @Override
    public int getItemCount() {
        return 7;
    }


    //多条目类型
    class Firstonephotoitme extends RecyclerView.ViewHolder {
        private final ImageView first_onephoto_itme_iv;

        public Firstonephotoitme(View itemView) {
            super(itemView);
            first_onephoto_itme_iv = (ImageView) itemView.findViewById(R.id.first_onephoto_itme_iv);
        }
    }

    class FirstShangxin extends RecyclerView.ViewHolder {

        private final ImageView first_shangxin_iv1;
        private final ImageView first_shangxin_iv2;
        private final ImageView first_shangxin_iv3;
        private final ImageView first_shangxin_iv4;
        private final TextView first_shangxin_tv1;
        private final TextView first_shangxin_tv3;
        private final TextView first_shangxin_tv2;
        private final TextView first_shangxin_tv4;
        private final ImageView first_shangxin_iv5;
        private final TextView first_shangxin_tv5;

        public FirstShangxin(View itemView) {
            super(itemView);
            first_shangxin_iv1 = (ImageView) itemView.findViewById(R.id.first_shangxin_iv1);
            first_shangxin_iv2 = (ImageView) itemView.findViewById(R.id.first_shangxin_iv2);
            first_shangxin_iv3 = (ImageView) itemView.findViewById(R.id.first_shangxin_iv3);
            first_shangxin_iv4 = (ImageView) itemView.findViewById(R.id.first_shangxin_iv4);
            first_shangxin_iv5 = (ImageView) itemView.findViewById(R.id.first_shangxin_iv5);
            first_shangxin_tv5 = (TextView) itemView.findViewById(R.id.first_shangxin_tv5);
            first_shangxin_tv1 = (TextView) itemView.findViewById(R.id.first_shangxin_tv1);
            first_shangxin_tv2 = (TextView) itemView.findViewById(R.id.first_shangxin_tv2);
            first_shangxin_tv3 = (TextView) itemView.findViewById(R.id.first_shangxin_tv3);
            first_shangxin_tv4 = (TextView) itemView.findViewById(R.id.first_shangxin_tv4);
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

        private final ImageView huodong_iv1;
        private final ImageView huodong_iv2;
        private final ImageView huodong_ivtitle;

        public FirstHoudong(View itemView) {
            super(itemView);
            huodong_ivtitle = (ImageView) itemView.findViewById(R.id.huodong_ivtitle);
            huodong_iv2 = (ImageView) itemView.findViewById(R.id.huodong_iv2);
            huodong_iv1 = (ImageView) itemView.findViewById(R.id.huodong_iv1);
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