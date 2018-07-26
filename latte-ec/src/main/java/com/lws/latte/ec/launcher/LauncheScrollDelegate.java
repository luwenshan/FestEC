package com.lws.latte.ec.launcher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.lws.latte.delegates.LatteDelegate;
import com.lws.latte.ec.R;
import com.lws.latte.ui.launcher.LauncherHolderCreator;
import com.lws.latte.util.storage.LattePreference;

import java.util.ArrayList;
import java.util.List;

public class LauncheScrollDelegate extends LatteDelegate implements OnItemClickListener {

    private ConvenientBanner<Integer> mBanner;
    private static final List<Integer> RES_IDS = new ArrayList<>();

    @Override
    public Object setLayout() {
        mBanner = new ConvenientBanner<>(getContext());
        return mBanner;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initBanner();
    }

    private void initBanner() {
        RES_IDS.add(R.mipmap.launcher_01);
        RES_IDS.add(R.mipmap.launcher_02);
        RES_IDS.add(R.mipmap.launcher_03);
        RES_IDS.add(R.mipmap.launcher_04);
        RES_IDS.add(R.mipmap.launcher_05);
        mBanner.setPages(new LauncherHolderCreator(), RES_IDS)
                .setPageIndicator(new int[]{R.drawable.dot_normal, R.drawable.dot_focus})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setOnItemClickListener(this)
                .setCanLoop(true);
    }

    @Override
    public void onItemClick(int position) {
        // 如果点击的是最后一个
        if (position == RES_IDS.size() - 1) {
            LattePreference.setAppFlag("hasFirstLaunch", true);
            // 检查用户是否已经登录
        }
    }
}
