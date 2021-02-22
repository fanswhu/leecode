package com.example.myapplication;

import android.app.Application;

import com.example.myapplication.database.db.AppDataBaseManager;

/**
 * Copyright (C), 2017-2021, 宝能有限公司
 * Author: jayce.feng
 * Date: 2021/2/18
 * Description: application
 * version v1.0
 */
public class AppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppDataBaseManager.getInstance().init(this);
    }
}
