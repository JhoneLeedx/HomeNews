package com.jhonlee.homenews.contract;

import com.jhonlee.homenews.pojo.NBAToken;
import com.jhonlee.homenews.pojo.Tr;

import java.util.List;

import rx.Observable;

/**
 * Created by JhoneLee on 2017/3/8.
 */

public class NBAContract {
    
    public interface View{

        void showError(String error);
        void showProgress();
        void dismisProgress();
        void showNBANews(NBAToken nab);
    }

    public interface Presenter{

        void showNBANews();
    }

    public interface Model{

        Observable<NBAToken> getNBANews();
    }

}