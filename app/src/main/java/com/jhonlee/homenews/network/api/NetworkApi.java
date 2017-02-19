package com.jhonlee.homenews.network.api;

import android.util.Log;

import com.jhonlee.homenews.network.INewsRequest;
import com.jhonlee.homenews.pojo.Token;
import com.jhonlee.homenews.util.Constants;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by JhoneLee on 2017/2/17.
 */

public class NetworkApi {

    private static NetworkApi api;

    private Retrofit newRf;
    private Retrofit nbaRf;
    private Retrofit robotRf;

    private INewsRequest news;

    private NetworkApi(){
        newRf = getRetrofit(Constants.NEWS_URL);
        nbaRf = getRetrofit(Constants.NBA_URL);
        robotRf = getRetrofit(Constants.ROBOT_URL);


        news = newRf.create(INewsRequest.class);
    }

    public Observable<Token> getNews(String type){

        Observable<Token> observable = news.getNews(Constants.NEWS_APPKEY,type);
        return observable;
    }


    public synchronized static NetworkApi getNetworkApi(){
        if (api==null)
            return  api = new NetworkApi();
        else
            return  api;
    }

    private Retrofit getRetrofit(String url){
        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl(url)
                .client(genericClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }
    //快速添加header。。和打印请求地址
    private   OkHttpClient genericClient() {

        HttpLoggingInterceptor.Level level= HttpLoggingInterceptor.Level.BODY;
        //新建log拦截器
        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("Jhon Lee","OkHttp====Message:"+message);
            }
        });
        loggingInterceptor.setLevel(level);
        //定制OkHttp
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient
                .Builder();
        //OkHttp进行添加拦截器loggingInterceptor
        httpClientBuilder.addInterceptor(loggingInterceptor);
        httpClientBuilder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request()
                        .newBuilder()
                        .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                        .build();
                return chain.proceed(request);
            }
        });
        return httpClientBuilder.build();
    }
}
