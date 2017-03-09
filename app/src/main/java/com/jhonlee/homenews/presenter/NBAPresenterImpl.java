package com.jhonlee.homenews.presenter;
import com.jhonlee.homenews.contract.NBAContract;
import com.jhonlee.homenews.model.NBAModelImpl;
import com.jhonlee.homenews.pojo.ListBean;
import com.jhonlee.homenews.pojo.NBAToken;
import com.jhonlee.homenews.pojo.Tr;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
* Created by JhoneLee on 2017/03/08
*/

public class NBAPresenterImpl implements NBAContract.Presenter{

    private NBAContract.View view;
    private NBAContract.Model model = new NBAModelImpl();

    public NBAPresenterImpl(NBAContract.View view) {
        this.view = view;
    }

    @Override
    public void showNBANews() {
        view.showProgress();
        Observable<NBAToken> observable = model.getNBANews();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<NBAToken>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.dismisProgress();
                        view.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(NBAToken nbaToken) {
                        view.dismisProgress();
                        view.showNBANews(nbaToken);
                        }


                });
    }
}