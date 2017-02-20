package com.jhonlee.homenews.network;

import com.jhonlee.homenews.pojo.GankInfoToken;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by JhoneLee on 2017/2/20.
 */

public interface IGankInfo {

    @GET("福利/{num}")
    Observable<GankInfoToken> showFulipicture(@Path("num")int num);
}
