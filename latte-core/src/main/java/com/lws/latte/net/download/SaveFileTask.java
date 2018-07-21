package com.lws.latte.net.download;

import android.os.AsyncTask;
import android.text.TextUtils;

import com.lws.latte.net.callback.IRequest;
import com.lws.latte.net.callback.ISuccess;

import java.io.File;
import java.io.InputStream;

import okhttp3.ResponseBody;

/**
 * Created by Wenshan.Lu on 2018/7/21.
 */
public class SaveFileTask extends AsyncTask<Object, Void, File> {

    private final IRequest mRequest;
    private final ISuccess mSuccess;

    public SaveFileTask(IRequest request, ISuccess success) {
        mRequest = request;
        mSuccess = success;
    }

    @Override
    protected File doInBackground(Object... objects) {
        String downloadDir = (String) objects[0];
        String extension = (String) objects[1];
        ResponseBody body = (ResponseBody) objects[2];
        String name = (String) objects[3];
        InputStream is = body.byteStream();
        if (TextUtils.isEmpty(downloadDir)) {
            downloadDir = "down_loads";
        }
        if (TextUtils.isEmpty(extension)) {
            extension = "";
        }
        return null;
    }
}
