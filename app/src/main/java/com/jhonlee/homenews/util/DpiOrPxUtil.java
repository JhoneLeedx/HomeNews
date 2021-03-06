package com.jhonlee.homenews.util;

import android.content.Context;

/**
 * Created by JhoneLee on 2017/3/9.
 */

public class DpiOrPxUtil {

    public static int dip2px(Context context, float dipValue){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dipValue * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(pxValue / scale + 0.5f);
    }
}
