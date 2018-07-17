package com.lws.latte.net;

import android.content.Context;

import com.lws.latte.net.callback.IError;
import com.lws.latte.net.callback.IFailure;
import com.lws.latte.net.callback.IRequest;
import com.lws.latte.net.callback.ISuccess;
import com.lws.latte.net.callback.RequestCallbacks;
import com.lws.latte.ui.LatteLoader;
import com.lws.latte.ui.LoaderStyle;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Wenshan.Lu on 2018/1/4.
 */

public class RestClient {
    private final String mUrl;
    private static final Map<String, Object> PARAMS = RestCreator.getParams();
    private final IRequest mRequest;
    private final ISuccess mSuccess;
    private final IFailure mFailure;
    private final IError mError;
    private final RequestBody mBody;
    private final LoaderStyle mLoaderStyle;
    private final Context mContext;

    public RestClient(String url, Map<String, Object> params,
                      IRequest request, ISuccess success,
                      IFailure failure, IError error, RequestBody body,
                      Context context, LoaderStyle loaderStyle) {
        this.mUrl = url;
        params.putAll(params);
        this.mRequest = request;
        this.mSuccess = success;
        this.mFailure = failure;
        this.mError = error;
        this.mBody = body;
        this.mLoaderStyle = loaderStyle;
        this.mContext = context;
    }

    public static RestClientBuilder builder() {
        return new RestClientBuilder();
    }

    private void request(HttpMethod method) {
        final RestService service = RestCreator.getRestService();
        Call<String> call = null;

        if (mRequest != null) {
            mRequest.onRequestStart();
        }

        if (mLoaderStyle != null) {
            LatteLoader.showLoading(mContext, mLoaderStyle);
        }

        switch (method) {
            case GET:
                call = service.get(mUrl, PARAMS);
                break;
            case POST:
                call = service.post(mUrl, PARAMS);
                break;
            case PUT:
                call = service.put(mUrl, PARAMS);
                break;
            case DELETE:
                call = service.delete(mUrl, PARAMS);
                break;
            default:
                break;
        }

        if (call != null) {
            call.enqueue(getRequestCallbacks());
        }
    }

    private Callback<String> getRequestCallbacks() {
        return new RequestCallbacks(mRequest, mSuccess, mFailure, mError, mLoaderStyle);
    }

    public final void get() {
        request(HttpMethod.GET);
    }

    public final void post() {
        request(HttpMethod.POST);
    }

    public final void put() {
        request(HttpMethod.PUT);
    }

    public final void delete() {
        request(HttpMethod.DELETE);
    }
}
