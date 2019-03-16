package com.bw.android.smallfirstweekexercise;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    private Context context;
    private String baseUrl;
    private static RetrofitHelper instance = null;
    private Retrofit retrofit = null;

    private RetrofitHelper(Context context,String baseUrl){
        this.context = context;
        this.baseUrl = baseUrl;
        initdata();
    }

    private void initdata() {
        retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
    }

    public RetrofitService getService(){
        return retrofit.create(RetrofitService.class);
    }

    public static synchronized RetrofitHelper getInstance(Context context,String baseUrl){
        if(instance == null){
            instance = new RetrofitHelper(context,baseUrl);
        }
        return instance;
    }
}
