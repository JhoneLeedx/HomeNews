package com.jhonlee.homenews.network;

import com.jhonlee.homenews.pojo.Robot;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by JhoneLee on 2017/2/20.
 */

public interface IRobot {

    @GET("index")
    Observable<Robot> getMessage(@Query("userid")String userId,@Query("info")String message,@Query("key") String appkey);
}
