package com.lws.festec.example.generators;

import com.lws.latte.AppRegisterGenerator;
import com.lws.latte.wechat.templates.AppRegisterTemplate;

@AppRegisterGenerator(
        packageName = "com.lws.festec.example",
        registerTemplete = AppRegisterTemplate.class
)
public interface AppRegister {
}
