package com.lws.latte.ec.launcher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.lws.latte.delegates.LatteDelegate;
import com.lws.latte.ec.R;
import com.lws.latte.ec.R2;
import com.lws.latte.util.storage.LattePreference;
import com.lws.latte.util.timer.BaseTimerTask;
import com.lws.latte.util.timer.ITimerListener;

import java.text.MessageFormat;
import java.util.Timer;

import butterknife.BindView;
import butterknife.OnClick;

public class LauncherDelegate extends LatteDelegate implements ITimerListener {
    @BindView(R2.id.tv_launcher_timer)
    AppCompatTextView mTvTimer;

    @OnClick(R2.id.tv_launcher_timer)
    public void onClickTimerView() {
        checkIsShowScroll();
    }

    private Timer mTimer;

    private int mCount = 5;

    private void initTimer() {
        mTimer = new Timer();
        final BaseTimerTask task = new BaseTimerTask(this);
        mTimer.schedule(task, 0, 1000);
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_launcher;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initTimer();
    }

    private void checkIsShowScroll() {
        if (!LattePreference.getAppFlag("hasFirstLaunch")) {
            start(new LauncheScrollDelegate(), SINGLETASK);
        } else {
            // 检查用户是否登录

        }
    }

    @Override
    public void onTimer() {
        getProxyActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mTvTimer != null) {
                    mTvTimer.setText(MessageFormat.format("跳过\n{0}s", mCount));
                    mCount--;
                    if (mCount < 0) {
                        if (mTimer != null) {
                            mTimer.cancel();
                            mTimer = null;
                            checkIsShowScroll();
                        }
                    }
                }
            }
        });
    }

}
