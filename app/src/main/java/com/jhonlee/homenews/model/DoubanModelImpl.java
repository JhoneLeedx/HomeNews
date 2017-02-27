package com.jhonlee.homenews.model;
import com.jhonlee.homenews.contract.DoubanContract;
import com.jhonlee.homenews.network.api.NetworkApi;
import com.jhonlee.homenews.pojo.DoubanToken;

import rx.Observable;

/**
* Created by JhoneLee on 2017/02/27
*/

public class DoubanModelImpl implements DoubanContract.Model{

    @Override
    public Observable<DoubanToken> getNews(String date) {
        return NetworkApi.getNetworkApi().getDouban().getDoubanNews(date);
    }
}