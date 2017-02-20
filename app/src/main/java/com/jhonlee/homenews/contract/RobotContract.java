package com.jhonlee.homenews.contract;

import com.jhonlee.homenews.pojo.Message;
import com.jhonlee.homenews.pojo.Robot;

import java.util.List;

import rx.Observable;

/**
 * Created by JhoneLee on 2017/2/20.
 */

public class RobotContract {

    public interface View {

        void showError(String error);
        void getMessage(Message message);
    }
    public interface Presenter {
       void getMessage(String message);
    }

    public interface Model {

        Observable<Robot> getMessage(String message);
    }


}