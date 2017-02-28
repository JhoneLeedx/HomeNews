package com.jhonlee.homenews.presenter;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;
import com.jhonlee.homenews.contract.GankContract;
import com.jhonlee.homenews.model.DoubanModelImpl;
import com.jhonlee.homenews.model.GankModelImpl;
import com.jhonlee.homenews.pojo.DoubanToken;
import com.jhonlee.homenews.pojo.GankInfoToken;
import com.jhonlee.homenews.pojo.ResultBean;
import com.jhonlee.homenews.util.DBHelper;
import com.jhonlee.homenews.util.NetworkState;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    private DBHelper dbHelper;
    private Context context;
    private SQLiteDatabase db;
    private Gson gson =  new Gson();;

    public GankPresenterImpl(GankContract.View view,Context context) {

        this.model = new GankModelImpl();
        this.view = view;
        this.context = context;
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    @Override
    public void showPic(int num) {
        if (NetworkState.networkConnected(context)){
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
                            db.execSQL("DELETE FROM benefit");
                            ContentValues values = new ContentValues();
                            for(ResultBean bean: gankInfoToken.getResults()){
                                db.beginTransaction();//开启事务，
                                try {
                                    values.put("benefit_url", gson.toJson(bean));
                                    db.insert("benefit", null, values);
                                    values.clear();
                                    db.setTransactionSuccessful();//事务成功
                                } catch (Exception e) {
                                    e.printStackTrace();
                                } finally {
                                    db.endTransaction();
                                }
                            }
                        }
                    });
        }else {
            view.dismisProgress();
            Cursor cursor = db.query("benefit", null, null, null, null, null, null);
            List<ResultBean> list = new ArrayList<>();
            if (cursor.moveToFirst()) {
                do{
                    String json =  cursor.getString(cursor.getColumnIndex("benefit_url"));
                    ResultBean bean = gson.fromJson(json,ResultBean.class);
                    list.add(bean);
                }while (cursor.moveToNext());
            }
            cursor.close();
            view.dismisProgress();
            view.showError("没有网络");
            if (list.size()>0){
                view.showPic(list);
            }else {
                view.showError("网络没有，缓存也没有");
            }
        }

    }

    @Override
    public void showMorePic(int num) {
        if (NetworkState.networkConnected(context)){
            Observable<GankInfoToken> observable = model.showPic(num);
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<GankInfoToken>() {
                        @Override
                        public void onCompleted() {
                        }

                        @Override
                        public void onError(Throwable e) {
                            view.showError(e.getMessage());
                        }

                        @Override
                        public void onNext(GankInfoToken gankInfoToken) {
                            view.showMorePic(gankInfoToken.getResults());
                        }
                    });
        }else {
            view.showError("当前网络异常");
        }

    }
}