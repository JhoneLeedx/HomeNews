package com.jhonlee.homenews.model;
import com.jhonlee.homenews.contract.NBAContract;
import com.jhonlee.homenews.network.api.NetworkApi;
import com.jhonlee.homenews.pojo.NBAToken;
import com.jhonlee.homenews.util.Constants;

import rx.Observable;

/**
* Created by JhoneLee on 2017/03/08
*/

public class NBAModelImpl implements NBAContract.Model{

    @Override
    public Observable<NBAToken> getNBANews() {
        return NetworkApi.getNetworkApi().getNBA().getNBA(Constants.NBA_APPKEY);
    }
}