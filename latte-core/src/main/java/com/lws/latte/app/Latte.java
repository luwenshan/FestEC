package com.lws.latte.app;

import android.content.Context;
import android.media.JetPlayer;

import java.util.WeakHashMap;

/**
 * Created by Wenshan.Lu on 2017/12/19.
 */

public final class Latte {
    public static Configurator init(Context context) {
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    private static WeakHashMap<String, Object> getConfigurations() {
        return Configurator.getInstance().getLatteConfigs();
    }
}
