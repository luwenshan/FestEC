package com.lws.festec.example.generators;

import com.lws.latte.EntryGenerator;
import com.lws.latte.wechat.templates.WXEntryTemplate;

@EntryGenerator(
        packageName = "com.lws.festec.example",
        entryTemplete = WXEntryTemplate.class
)
public interface WeChatEntry {
}
