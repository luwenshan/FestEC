package com.lws.latte.net.callback;

import com.lws.latte.ui.LatteLoader;
import com.lws.latte.ui.LoaderStyle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestCallbacks implements Callback<String> {

    private final IRequest mRequest;
    private final ISuccess mSuccess;
    private final IFailure mFailure;
    private final IError mError;
    private final LoaderStyle mLoaderStyle;

    public RequestCallbacks(IRequest request, ISuccess success, IFailure failure, IError error, LoaderStyle loaderStyle) {
        mRequest = request;
        mSuccess = success;
        mFailure = failure;
        mError = error;
        mLoaderStyle = loaderStyle;
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        if (response.isSuccessful()) {
            if (call.isExecuted()) {
                if (mSuccess != null) {
                    mSuccess.onSuccess(response.body());
                }
            }
        } else {
            if (mError != null) {
                mError.onError(response.code(), response.message());
            }
        }
        if (mLoaderStyle != null) {
            LatteLoader.stopLoading();
        }
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        if (mFailure != null) {
            mFailure.onFailure();
        }

        if (mRequest != null) {
            mRequest.onRequestEnd();
        }

        if (mLoaderStyle != null) {
            LatteLoader.stopLoading();
        }
    }
}
