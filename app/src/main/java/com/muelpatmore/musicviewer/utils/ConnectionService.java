package com.muelpatmore.musicviewer.utils;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.muelpatmore.musicviewer.utils.RequestInterface;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Samuel on 27/11/2017.
 */

public class ConnectionService {

    private static OkHttpClient mOkHttpClient;
    private static Retrofit mRetrofit;

    public static RequestInterface getConnection(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        mOkHttpClient= new OkHttpClient.Builder().
                addInterceptor(httpLoggingInterceptor).build();

        mRetrofit= new Retrofit.Builder()
                .baseUrl(API_Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(mOkHttpClient)
                .build();

        return mRetrofit.create(RequestInterface.class);
    }

}
