package com.lws.festec.example;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.dumpapp.DumperPlugin;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.lws.latte.app.Latte;
import com.lws.latte.ec.database.DatabaseManager;
import com.lws.latte.ec.icon.FontEcModule;
import com.lws.latte.net.interceptors.DebugInterceptor;

import javax.annotation.Nullable;

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
        initStetho();
        DatabaseManager.getInstance().init(this);
    }

    private void initStetho() {
        Stetho.initializeWithDefaults(this);
    }
}
