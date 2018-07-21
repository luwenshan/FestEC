package com.lws.latte.net.download;

import com.lws.latte.net.RestCreator;
import com.lws.latte.net.callback.IError;
import com.lws.latte.net.callback.IFailure;
import com.lws.latte.net.callback.IRequest;
import com.lws.latte.net.callback.ISuccess;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Wenshan.Lu on 2018/7/21.
 */
public class DownloadHandler {

    private final String mUrl;
    private static final Map<String, Object> PARAMS = RestCreator.getParams();
    private final IRequest mRequest;
    private final String mDownloadDir;
    private final String mExtension;
    private final String mName;
    private final ISuccess mSuccess;
    private final IFailure mFailure;
    private final IError mError;

    public DownloadHandler(String url, IRequest request, String downloadDir, String extension, String name, ISuccess success, IFailure failure, IError error) {
        mUrl = url;
        mRequest = request;
        mDownloadDir = downloadDir;
        mExtension = extension;
        mName = name;
        mSuccess = success;
        mFailure = failure;
        mError = error;
    }

    public void handleDownload() {
        if (mRequest != null) {
            mRequest.onRequestStart();
        }

        RestCreator.getRestService().download(mUrl, PARAMS)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
    }
}
