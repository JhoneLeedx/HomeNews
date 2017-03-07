package com.jhonlee.homenews.network;

import com.jhonlee.homenews.pojo.NBAToken;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by JhoneLee on 2017/3/7.
 */

public interface INBARequest {

    @GET("nba")
    Observable<NBAToken> getNBA(@Query("key") String appkey);
}
