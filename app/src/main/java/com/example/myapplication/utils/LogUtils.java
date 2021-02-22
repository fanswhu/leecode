package com.example.myapplication.utils;

import android.util.Log;

import com.example.myapplication.BuildConfig;

/**
 * Copyright (C), 2017-2021, 宝能有限公司
 * Author: jayce.feng
 * Date: 2021/2/18
 * Description: 日志工具类
 * version v1.0
 */
public class LogUtils {
    private static final boolean LOG_OPEN = true;

    public static void i(String tag, String message) {
        if (LOG_OPEN || BuildConfig.DEBUG) {
            Log.i(tag, message);
        }
    }
}
