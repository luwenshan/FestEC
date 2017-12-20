package com.lws.festec.example;

import android.app.Application;

import com.lws.latte.app.Latte;

/**
 * Created by Wenshan.Lu on 2017/12/19.
 */

public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withApiHost("http://127.0.0.1/")
                .configure();
    }
}
