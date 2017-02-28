package com.jhonlee.homenews.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;

import com.jhonlee.homenews.util.DBHelper;

/**
 * Created by JhoneLee on 2017/2/28.
 */

public class CacheService extends Service {


    private DBHelper dbHelper;
    private SQLiteDatabase db;

    private static final String TAG = CacheService.class.getSimpleName();

    public static final int TYPE_ZHIHU = 0x00;
    public static final int TYPE_GUOKR = 0x01;
    public static final int TYPE_DOUBAN = 0x02;

    @Override
    public void onCreate() {
        super.onCreate();
        dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();

        IntentFilter filter = new IntentFilter();
        filter.addAction("com.marktony.zhihudaily.LOCAL_BROADCAST");
        LocalBroadcastManager manager = LocalBroadcastManager.getInstance(this);
        manager.registerReceiver(new LocalReceiver(), filter);

    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    class LocalReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            int id = intent.getIntExtra("id", 0);
            switch (intent.getIntExtra("type", -1)) {
                case TYPE_ZHIHU:
                  //  startZhihuCache(id);
                    break;
                case TYPE_GUOKR:
                   // startGuokrCache(id);
                    break;
                case TYPE_DOUBAN:
                   // startDoubanCache(id);
                    break;
                default:
                case -1:
                    break;
            }
        }
    }
    /**
     * 网络请求豆瓣精选的内容主体并储存
     * @param id 消息对应的id
     */
    private void startDoubanCache(final int id) {

        Cursor cursor = db.query("Douban", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                if ((cursor.getInt(cursor.getColumnIndex("douban_id")) == id)
                        && (cursor.getString(cursor.getColumnIndex("douban_content")).equals(""))) {

                }
            } while (cursor.moveToNext());
        }
        cursor.close();
    }
}
