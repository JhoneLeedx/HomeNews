package com.jhonlee.homenews.presenter;

import android.util.Log;


import com.jhonlee.homenews.contract.NewsContract;
import com.jhonlee.homenews.model.NewsModelImpl;
import com.jhonlee.homenews.pojo.Token;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by JhoneLee on 2017/02/17
 */

public class NewsPresenterImpl implements NewsContract.Presenter {

    private NewsContract.View view;
    private NewsContract.Model model;

    public NewsPresenterImpl(NewsContract.View view) {

        this.view = view;
        this.model = new NewsModelImpl();
    }

    @Override
    public void showNews(String type) {

        Observable<Token> observable = model.getNews(type);
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Token>() {
                    @Override
                    public void onCompleted() {
                        Log.d("Jhoe Lee","onCompleted() ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.dismisProgress();
                        view.showError(e.getMessage());

                    }

                    @Override
                    public void onNext(Token token) {
                        view.dismisProgress();
                        if (token.getError_code()==0){
                            if (token.getResult()==null||token.getResult().equals("")){
                                view.showError("tokenResults数据不存在");
                            }else {
                                view.showNews(token.getResult().getData());
                            }

                        }else {
                            view.showError(token.getReason());
                        }
                    }
                });

    }
}