package com.jhonlee.homenews.model;
import com.jhonlee.homenews.contract.RobotContract;
import com.jhonlee.homenews.network.api.NetworkApi;
import com.jhonlee.homenews.pojo.Robot;
import com.jhonlee.homenews.util.Constants;

import rx.Observable;

/**
* Created by JhoneLee on 2017/02/20
*/

public class RobotModelImpl implements RobotContract.Model{


    @Override
    public Observable<Robot> getMessage(String message) {
        return NetworkApi.getNetworkApi().getRobot().getMessage("Jhon Lee",message, Constants.ROBOT_APPKEY);
    }
}