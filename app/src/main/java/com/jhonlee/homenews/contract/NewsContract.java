package com.jhonlee.homenews.contract;



import com.jhonlee.homenews.pojo.News;
import com.jhonlee.homenews.pojo.Token;

import java.util.List;

import rx.Observable;

/**
 * Created by JhoneLee on 2017/2/17.
 */

public class NewsContract {

    public interface View {

        void showError(String error);
        void showProgress();
        void dismisProgress();
        void showNews(List<News> list);
    }

    public interface Presenter {

        void showNews(String type);
    }

    public interface Model {

        Observable<Token> getNews(String type);
    }


}