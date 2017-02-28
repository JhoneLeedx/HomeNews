package com.jhonlee.homenews.contract;

import com.jhonlee.homenews.pojo.DoubanToken;
import com.jhonlee.homenews.pojo.News;
import com.jhonlee.homenews.pojo.Token;

import java.util.List;

import rx.Observable;

/**
 * Created by JhoneLee on 2017/2/27.
 */

public class DoubanContract {


    public interface View {

        void showError(String error);
        void showProgress();
        void dismisProgress();
        void showNews(List<DoubanToken.PostsBean> list);
        void showMoreNews(List<DoubanToken.PostsBean> list);
    }

    public interface Presenter {

        void showNews(String date);
        void showMoreNews(String date);
    }

    public interface Model {

        Observable<DoubanToken> getNews(String date);
    }


}