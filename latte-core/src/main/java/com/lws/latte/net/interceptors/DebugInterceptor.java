package com.lws.latte.net.interceptors;

import android.support.annotation.RawRes;

import com.lws.latte.util.file.FileUtils;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class DebugInterceptor extends BaseInterceptor {
    private final String mDebugUrl;
    private final int mDebugRawId;

    public DebugInterceptor(String debugUrl, int debugRawId) {
        mDebugUrl = debugUrl;
        mDebugRawId = debugRawId;
    }

    private Response getResponse(Chain chain, String json) {
        return new Response.Builder()
                .code(200)
                .addHeader("Content-Type", "application/json")
                .body(ResponseBody.create(MediaType.parse("application/json"), json))
                .message("OK")
                .protocol(Protocol.HTTP_1_1)
                .request(chain.request())
                .build();
    }

    private Response debugResponse(Chain chain, @RawRes int rawId) {
        String json = FileUtils.getRawFile(rawId);
        return getResponse(chain, json);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        String url = chain.request().url().toString();
        if (url.contains(mDebugUrl)) {
            return debugResponse(chain, mDebugRawId);
        }
        return chain.proceed(chain.request());
    }
}
