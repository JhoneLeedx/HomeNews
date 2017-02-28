package com.jhonlee.homenews.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by JhoneLee on 2017/2/28.
 */

public class DBHelper extends SQLiteOpenHelper {

    //数据库版本号
    private static final int DATABASE_VERSION=1;
    //数据库名称
    private static final String DATABASE_NAME="news.db";
    //数据库表名
    private static final String TABLE_NEWS_NAME = "news";
    private static final String TABLE_DOUBAN_NAME = "douban";
    private static final String TABLE_BENEFIT_NAME = "benefit";
    //创建表语句字符串
    //private static final String CREATE_TABLE_NEWS_SQL = "create table news(id integer primary key,news text)";
    private static final String CREATE_TABLE_DOUBAN_SQL = "create table if not exists douban("
            + "id integer primary key autoincrement,"
            + "douban_id integer not null,"
            + "douban_news text,"
            + "douban_time real,"
            + "douban_content text)";
    //private static final String CREATE_TABLE_BENEFIT_SQL = "";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
       // sqLiteDatabase.execSQL(CREATE_TABLE_NEWS_SQL);
        sqLiteDatabase.execSQL(CREATE_TABLE_DOUBAN_SQL);
        //sqLiteDatabase.execSQL(CREATE_TABLE_BENEFIT_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

       // sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_NEWS_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_DOUBAN_NAME);
       // sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_BENEFIT_NAME);

        onCreate(sqLiteDatabase);
    }
}
