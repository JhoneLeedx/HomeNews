package com.jhonlee.homenews.presenter;
import com.jhonlee.homenews.contract.DoubanContract;
import com.jhonlee.homenews.model.DoubanModelImpl;
import com.jhonlee.homenews.pojo.DoubanToken;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
* Created by JhoneLee on 2017/02/27
*/

public class DoubanPresenterImpl implements DoubanContract.Presenter{

    private DoubanContract.Model model;
    private DoubanContract.View view;

    public DoubanPresenterImpl(DoubanContract.View view) {
        this.view = view;
        model = new DoubanModelImpl();
    }

    @Override
    public void showNews(String date) {
        view.showProgress();
        Observable<DoubanToken> observable = model.getNews(date);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<DoubanToken>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.dismisProgress();
                        view.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(DoubanToken doubanToken) {
                        view.dismisProgress();
                        view.showNews(doubanToken.getPosts());
                    }
                });
    }
}