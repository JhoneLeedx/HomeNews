package com.jhonlee.homenews.presenter;
import com.jhonlee.homenews.contract.GankContract;
import com.jhonlee.homenews.model.GankModelImpl;
import com.jhonlee.homenews.pojo.GankInfoToken;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
* Created by JhoneLee on 2017/02/20
*/

public class GankPresenterImpl implements GankContract.Presenter{

    private GankContract.Model model;
    private GankContract.View view;

    public GankPresenterImpl(GankContract.View view) {

        this.model = new GankModelImpl();
        this.view = view;
    }

    @Override
    public void showPic(int num) {
        view.showProgress();
        Observable<GankInfoToken> observable = model.showPic(num);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GankInfoToken>() {
            @Override
            public void onCompleted() {
                view.dismisProgress();
            }

            @Override
            public void onError(Throwable e) {
                view.dismisProgress();
                view.showError(e.getMessage());
            }

            @Override
            public void onNext(GankInfoToken gankInfoToken) {
                view.dismisProgress();
                view.showPic(gankInfoToken.getResults());
            }
        });
    }
}