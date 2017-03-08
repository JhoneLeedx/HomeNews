package com.jhonlee.homenews.contract;

import com.jhonlee.homenews.pojo.NBAToken;

import rx.Observable;

/**
 * Created by JhoneLee on 2017/3/8.
 */

public class NBAContract {
    
    public interface View{

        void showError(String error);
        void showProgress();
        void dismisProgress();
        void showNBANews();
    }

    public interface Presenter{

        void showNBANews();
    }

    public interface Model{

        Observable<NBAToken> getNBANews();
    }

}