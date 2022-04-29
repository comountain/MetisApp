package com.example.activity.service;
import android.app.Activity;
import android.util.Log;

import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class MyHttpClientRespenseHandler extends TextHttpResponseHandler {
    private String TAG = "respensehandler";

    private Activity context;

    public MyHttpClientRespenseHandler(Activity context) {
        this.context = context;
    }


    @Override
    public void onSuccess(int i, cz.msebera.android.httpclient.Header[] headers, String s) {
        Log.i(TAG, "请求成功");
        try {
            JSONObject jsonObject = new JSONObject(s);
            success(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFailure(int i, cz.msebera.android.httpclient.Header[] headers, String s, Throwable throwable) {
        Log.i(TAG, "请求失败");
        faile();
    }


    public abstract  void success(JSONObject json);
    public abstract  void faile();
}
