package com.bawei.lvwenjing.shopdemo.network;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public abstract class BaseObServer  implements Observer<String> {


    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull String s) {

        onSuccess(s);

    }

    @Override
    public void onError(@NonNull Throwable e) {

    }

    @Override
    public void onComplete() {

    }


    public abstract void onSuccess(String result);
    public abstract void onFailed();

}