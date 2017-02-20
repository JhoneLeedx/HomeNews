package com.jhonlee.homenews.model;
import com.jhonlee.homenews.contract.GankContract;
import com.jhonlee.homenews.network.api.NetworkApi;
import com.jhonlee.homenews.pojo.GankInfoToken;
import com.jhonlee.homenews.util.Constants;

import rx.Observable;

/**
* Created by JhoneLee on 2017/02/20
*/

public class GankModelImpl implements GankContract.Model{

    @Override
    public Observable<GankInfoToken> showPic(int num) {

        return NetworkApi.getNetworkApi().getInfo().showFulipicture(num);
    }
}