package com.lws.festec.example;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.lws.latte.app.Latte;
import com.lws.latte.ec.icon.FontEcModule;
import com.lws.latte.net.interceptors.DebugInterceptor;

/**
 * Created by Wenshan.Lu on 2017/12/19.
 */

public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withApiHost("http://127.0.0.1/")
                .withInterceptor(new DebugInterceptor("index", R.raw.test))
                .configure();
    }
}
