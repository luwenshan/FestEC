package com.lws.latte.util.timer;

import java.util.TimerTask;

public class BaseTimerTask extends TimerTask {

    private ITimerListener mTimerListener;

    public BaseTimerTask(ITimerListener timerListener) {
        mTimerListener = timerListener;
    }

    @Override
    public void run() {
        if (mTimerListener != null) {
            mTimerListener.onTimer();
        }
    }
}
