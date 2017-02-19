package com.jhonlee.homenews.model;



import com.jhonlee.homenews.contract.NewsContract;
import com.jhonlee.homenews.network.api.NetworkApi;
import com.jhonlee.homenews.pojo.Token;

import rx.Observable;

/**
 * Created by JhoneLee on 2017/02/17
 */

public class NewsModelImpl implements NewsContract.Model {


    @Override
    public Observable<Token> getNews(String type) {

        return NetworkApi.getNetworkApi().getNews(type);
    }
}