package com.lws.latte.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.lws.latte.app.Latte;

/**
 * Created by Wenshan.Lu on 2018/7/17.
 */
public class DimenUtil {
    public static int getScreenWidth() {
        final Resources resources = Latte.getApplication().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight() {
        final Resources resources = Latte.getApplication().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}