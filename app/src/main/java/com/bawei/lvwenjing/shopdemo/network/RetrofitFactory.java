package com.bawei.lvwenjing.shopdemo.network;

import com.bawei.lvwenjing.shopdemo.network.cookie.CookiesManager;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by lenovo-pc on 2017/6/20.
 */

public class RetrofitFactory {
// Retrofit的底层每次都会默认new 一个Okhttpclient所以 我们自己建立个
    //建立Okhttpclient

    public static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            //建立唯一标识
            .cookieJar(new CookiesManager())
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            //建立拦截器
            .addInterceptor(new LoggingInterceptor())
            .build();

    //建立Retrofit
    public static ApiServer apiService = new Retrofit.Builder()
            .baseUrl("http://qbh.2dyt.com")
            //设置返回类型
            .addConverterFactory(ScalarsConverterFactory.create())
            .client(okHttpClient)
            //把 以前的 call 转化成 Observable
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(ApiServer.class);

       //建立方法让其返回 Observable
    public static Observable<String> get(String url) {
        //返回apiService的方法 同样 将返回apiService的方法当成Observable
        return apiService.get(url).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public static Observable<String> gets(String url, Map<String, String> map) {
        return apiService.gets(url, map).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public static Observable<String> post(String url, Map<String, String> map) {
        return apiService.post(url, map).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
