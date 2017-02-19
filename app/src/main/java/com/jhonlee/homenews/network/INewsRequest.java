package com.jhonlee.homenews.network;



import com.jhonlee.homenews.pojo.Token;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by JhoneLee on 2017/2/17.
 */

public interface INewsRequest {

    @GET("index")
    Observable<Token> getNews(@Query("key") String appkey, @Query("type") String type);
}
