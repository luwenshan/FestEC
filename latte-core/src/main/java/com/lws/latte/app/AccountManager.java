package com.lws.latte.app;

import com.lws.latte.util.storage.LattePreference;

public class AccountManager {
    private static final String SIGN_TAG = "sign_tag";

    //保存登录用户状态
    public static void setSignState(boolean state) {
        LattePreference.setAppFlag(SIGN_TAG, state);
    }

    public static boolean isSignIn() {
        return LattePreference.getAppFlag(SIGN_TAG);
    }

    public static void checkAccount(IUserChecker userChecker) {
        if (isSignIn()) {
            userChecker.onSignIn();
        } else {
            userChecker.onNotSignIn();
        }
    }
}
