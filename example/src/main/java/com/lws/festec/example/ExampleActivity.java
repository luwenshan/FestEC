package com.lws.festec.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;

import com.lws.latte.activities.ProxyActivity;
import com.lws.latte.delegates.LatteDelegate;
import com.lws.latte.ec.launcher.LauncheScrollDelegate;
import com.lws.latte.ec.launcher.LauncherDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    @Override
    public LatteDelegate setRootDelegate() {
        return new LauncherDelegate();
    }
}
