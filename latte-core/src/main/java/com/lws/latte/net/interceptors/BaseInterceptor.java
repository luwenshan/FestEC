package com.lws.latte.net.interceptors;

import java.util.LinkedHashMap;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;

public abstract class BaseInterceptor implements Interceptor {
    /**
     * 获取GET请求的所有参数
     */
    protected LinkedHashMap<String, String> getUrlParameters(Chain chain) {
        HttpUrl url = chain.request().url();
        int size = url.querySize();
        final LinkedHashMap<String, String> params = new LinkedHashMap<>();
        for (int i = 0; i < size; i++) {
            params.put(url.queryParameterName(i), url.queryParameterValue(i));
        }
        return params;
    }

    protected String getUrlParameters(Chain chain, String key) {
        return chain.request().url().queryParameter(key);
    }

    /**
     * 获取POST请求体中的所有参数
     */
    protected LinkedHashMap<String, String> getBodyParameters(Chain chain) {
        FormBody formBody = (FormBody) chain.request().body();
        final LinkedHashMap<String, String> params = new LinkedHashMap<>();
        for (int i = 0; i < formBody.size(); i++) {
            params.put(formBody.name(i), formBody.value(i));
        }
        return params;
    }

    protected String getBodyParameters(Chain chain, String key) {
        return getBodyParameters(chain).get(key);
    }
}
