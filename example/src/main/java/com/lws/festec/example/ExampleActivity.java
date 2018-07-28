package com.lws.festec.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.widget.Toast;

import com.lws.latte.activities.ProxyActivity;
import com.lws.latte.delegates.LatteDelegate;
import com.lws.latte.ec.launcher.LauncheScrollDelegate;
import com.lws.latte.ec.launcher.LauncherDelegate;
import com.lws.latte.ec.sign.ISignListener;
import com.lws.latte.ec.sign.SignInDelegate;
import com.lws.latte.ec.sign.SignUpDelegate;
import com.lws.latte.ui.launcher.ILauncherListener;
import com.lws.latte.ui.launcher.OnLauncherFinishTag;

public class ExampleActivity extends ProxyActivity implements ISignListener, ILauncherListener {

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

    @Override
    public void onSignInSuccess() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSignUpSuccess() {
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLauncherFinish(OnLauncherFinishTag tag) {
        switch (tag) {
            case SIGNED:
                Toast.makeText(this, "启动结束，用户登录了", Toast.LENGTH_SHORT).show();
                startWithPop(new ExampleDelegate());
                break;
            case NOT_SIGNED:
                Toast.makeText(this, "启动结束，用户未登录", Toast.LENGTH_SHORT).show();
                startWithPop(new SignUpDelegate());
                break;
            default:
                break;
        }
    }
}
