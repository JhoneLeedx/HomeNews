package com.jhonlee.homenews.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by JhoneLee on 2017/2/17.
 */

public class SharedPreferenceUtil {

    public static void setSharedPreference(Context context, String type) {

        SharedPreferences preferences = context.getSharedPreferences("news", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("type", type);
        editor.commit();
    }

    public static String getSharedpreference(Context context) {

        SharedPreferences preferences = context.getSharedPreferences("news", Context.MODE_PRIVATE);
        String type = preferences.getString("type", "top");
        return type;
    }
}
