package com.jhonlee.homenews.presenter;
import android.os.Parcel;
import android.os.Parcelable;

import com.jhonlee.homenews.contract.RobotContract;
import com.jhonlee.homenews.model.RobotModelImpl;
import com.jhonlee.homenews.pojo.Message;
import com.jhonlee.homenews.pojo.Robot;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
* Created by JhoneLee on 2017/02/20
*/

public class RobotPresenterImpl implements RobotContract.Presenter{

    private RobotContract.View view;
    private RobotContract.Model model;

    public RobotPresenterImpl(RobotContract.View view) {
        this.view = view;
        model = new RobotModelImpl();
    }

    @Override
    public void getMessage(final String message) {
        Observable<Robot> observable = model.getMessage(message);
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Robot>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                view.showError(e.getMessage());
            }
            @Override
            public void onNext(Robot robot) {
                Message msg = new Message(Parcel.obtain());
                msg.setmType(1);
                msg.setmMessage(robot.getResult().getText());
                view.getMessage(msg);
            }
        });
    }
}