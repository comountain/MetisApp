package com.example.activity;
import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.activity.utils.LogUtils;
import com.lzy.okgo.OkGo;

import org.greenrobot.greendao.AbstractDaoSession;


public class MainApplication extends Application{
    private static MainApplication instance;
    @Override
    public void onCreate()
    {
        super.onCreate();
        instance = this;
        OkGo.getInstance().init(this);
    }

    private void setupDatabase()
    {
        LogUtils.e("配置数据库中...");

    }
}
