package com.lws.festec.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.lws.latte.delegates.LatteDelegate;

/**
 * Created by Wenshan.Lu on 2018/1/4.
 */

public class ExampleDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
