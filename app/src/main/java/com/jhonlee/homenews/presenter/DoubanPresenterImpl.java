package com.jhonlee.homenews.presenter;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;
import com.jhonlee.homenews.contract.DoubanContract;
import com.jhonlee.homenews.model.DoubanModelImpl;
import com.jhonlee.homenews.pojo.DoubanToken;
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
* Created by JhoneLee on 2017/02/27
*/

public class DoubanPresenterImpl implements DoubanContract.Presenter{

    private DoubanContract.Model model;
    private DoubanContract.View view;

    private DBHelper dbHelper;
    private Context context;
    private SQLiteDatabase db;
    private Gson gson =  new Gson();;

    public DoubanPresenterImpl(DoubanContract.View view,Context context) {
        this.context = context;
        this.view = view;
        model = new DoubanModelImpl();
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    @Override
    public void showNews(String date) {

        if (NetworkState.networkConnected(context)){
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
                            db.execSQL("DELETE FROM douban");
                            ContentValues values = new ContentValues();
                            for (DoubanToken.PostsBean bean : doubanToken.getPosts()){
                                if ( !queryIfIDExists(bean.getId())) {
                                    db.beginTransaction();
                                    try {
                                        values.put("douban_id", bean.getId());
                                        values.put("douban_news", gson.toJson(bean));
                                        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                                        Date date = format.parse(bean.getPublished_time());
                                        values.put("douban_time", date.getTime() / 1000);
                                        values.put("douban_content", "");
                                        db.insert("douban", null, values);
                                        values.clear();
                                        db.setTransactionSuccessful();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    } finally {
                                        db.endTransaction();
                                    }
                                }

                            }

                            view.showNews(doubanToken.getPosts());
                        }
                    });
        }else {
            Cursor cursor = db.query("douban", null, null, null, null, null, null);
            List<DoubanToken.PostsBean> list = new ArrayList<>();
            if (cursor.moveToFirst()) {
                do{
                   String json =  cursor.getString(cursor.getColumnIndex("douban_news"));
                    DoubanToken.PostsBean bean = gson.fromJson(json,DoubanToken.PostsBean.class);
                    list.add(bean);
                }while (cursor.moveToNext());
            }
            cursor.close();
            if (list.size()>0){
                view.dismisProgress();
                view.showNews(list);
            }else {
                view.dismisProgress();
                view.showError("网络没有，缓存也没有");
            }

        }
    }

    @Override
    public void showMoreNews(String date) {
        if (NetworkState.networkConnected(context)){
            Observable<DoubanToken> observable = model.getNews(date);
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<DoubanToken>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            // view.dismisProgress();
                            view.showError(e.getMessage());
                        }

                        @Override
                        public void onNext(DoubanToken doubanToken) {
                            // view.dismisProgress();
                            view.showMoreNews(doubanToken.getPosts());
                        }
                    });
        }else {
            view.showError("当前没有网络");
        }
    }

    private boolean queryIfIDExists(int id){

        Cursor cursor = db.query("douban",null,null,null,null,null,null);
        if (cursor.moveToFirst()){
            do {
                if (id == cursor.getInt(cursor.getColumnIndex("douban_id"))){
                    return true;
                }
            } while (cursor.moveToNext());
        }
        cursor.close();

        return false;
    }
}