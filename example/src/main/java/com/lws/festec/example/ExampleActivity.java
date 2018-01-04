package com.lws.festec.example;

import com.lws.latte.activities.ProxyActivity;
import com.lws.latte.delegates.LatteDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new ExampleDelegate();
    }
}
