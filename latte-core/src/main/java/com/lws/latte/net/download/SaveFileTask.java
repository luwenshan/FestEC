package com.lws.latte.net.download;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;

import com.lws.latte.app.Latte;
import com.lws.latte.net.callback.IRequest;
import com.lws.latte.net.callback.ISuccess;
import com.lws.latte.util.file.FileUtils;

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
        if (name == null) {
            return FileUtils.writeToDisk(is, downloadDir, extension.toUpperCase(), extension);
        } else {
            return FileUtils.writeToDisk(is, downloadDir, name);
        }
    }

    @Override
    protected void onPostExecute(File file) {
        super.onPostExecute(file);
        if (mSuccess != null) {
            mSuccess.onSuccess(file.getPath());
        }
        if (mRequest != null) {
            mRequest.onRequestEnd();
        }

        autoInstallApk(file);
    }

    private void autoInstallApk(File file) {
        if (FileUtils.getExtension(file.getPath()).equals("apk")) {
            final Intent install = new Intent();
            install.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            install.setAction(Intent.ACTION_VIEW);
            install.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            Latte.getApplicationContext().startActivity(install);
        }
    }
}
