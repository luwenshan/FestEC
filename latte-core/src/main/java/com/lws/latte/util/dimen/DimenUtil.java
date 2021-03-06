package com.lws.latte.util.dimen;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.lws.latte.app.Latte;

/**
 * Created by Wenshan.Lu on 2018/7/17.
 */
public class DimenUtil {
    public static int getScreenWidth() {
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight() {
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
