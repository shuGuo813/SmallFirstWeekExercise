package com.bw.android.smallfirstweekexercise.model;

import android.util.Log;

import com.bw.android.smallfirstweekexercise.RetrofitService;
import com.bw.android.smallfirstweekexercise.bean.FoodBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Model {
    List<FoodBean.DataBean> list = new ArrayList<>();
    Imodel imodel;
    Retrofit retrofit = null;
    RetrofitService retrofitService;
    String baseUrl;
    int id;
    int limit;
    int page;
    public Model(Imodel imodel, String baseUrl,int id,int limit,int page){
        this.imodel = imodel;
        this.baseUrl = baseUrl;
        this.id = id;
        this.limit = limit;
        this.page = page;
    }

    public void getdata(){
        retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        retrofitService = retrofit.create(RetrofitService.class);
        retrofitService.getSearchFood(id + "",limit + "",page + "")
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<FoodBean>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(FoodBean dataBean) {
                                Log.e("LSG","成功传入数据");
                                Log.e("LSG","M层 listData =" + dataBean.getData().size());
                                Log.e("LSG","id =" + id + "limit=" + limit + "page=" + page);
                                imodel.loadSuccess(dataBean.getData());
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e("LSG","没有传入数据");
                            }

                            @Override
                            public void onComplete() {

                            }
                        });

    }
}
