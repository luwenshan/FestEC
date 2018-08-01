package com.lws.festec.example.generators;

import com.lws.latte.PayEntryGenerator;
import com.lws.latte.wechat.templates.WXPayEntryTemplate;

@PayEntryGenerator(
        packageName = "com.lws.festec.example",
        payEntryTemplete = WXPayEntryTemplate.class
)
public interface WeChatPayEntry {
}
