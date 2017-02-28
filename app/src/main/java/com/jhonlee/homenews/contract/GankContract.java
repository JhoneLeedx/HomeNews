package com.jhonlee.homenews.contract;

import com.jhonlee.homenews.pojo.GankInfoToken;
import com.jhonlee.homenews.pojo.News;
import com.jhonlee.homenews.pojo.ResultBean;

import java.util.List;

import rx.Observable;

/**
 * Created by JhoneLee on 2017/2/20.
 */

public class GankContract {
    public interface View {

        void showError(String error);
        void showProgress();
        void dismisProgress();
        void showPic(List<ResultBean> list);
        void showMorePic(List<ResultBean> list);
    }

    public interface Presenter {

        void showPic(int num);
        void showMorePic(int num);
    }

    public interface Model {

        Observable<GankInfoToken> showPic(int num);
    }


}