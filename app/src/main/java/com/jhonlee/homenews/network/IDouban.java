package com.jhonlee.homenews.network;

import com.jhonlee.homenews.pojo.DoubanToken;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by JhoneLee on 2017/2/27.
 */

public interface IDouban {

    @GET("{data}")
    Observable<DoubanToken> getDoubanNews(@Path("data")String data);
}
