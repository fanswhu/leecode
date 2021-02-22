package com.example.myapplication.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.myapplication.IMyAidlInterface;
import com.example.myapplication.IRemoteServiceCallback;
import com.example.myapplication.utils.LogUtils;

/**
 * Copyright (C), 2017-2021, 宝能有限公司
 * Author: jayce.feng
 * Date: 2021/2/18
 * Description: 测试aidl
 * version v1.0
 */
public class AidlService extends Service {

    private static final String TAG = "AidlService";
    private MyBinder mBinder;

    private IRemoteServiceCallback mCallback;


    @Override
    public void onCreate() {
        super.onCreate();
        mBinder = new MyBinder();
        LogUtils.i(TAG, "onCreate");
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    SystemClock.sleep(2000);
                    if (mCallback != null) {
                        try {
                            Log.i(TAG,"notify");
                            mCallback.notifyCilent("nice to meet you");
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtils.i(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public boolean onUnbind(Intent intent) {
        LogUtils.i(TAG, "onUnbind");
        mCallback = null;
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        LogUtils.i(TAG, "onDestroy");
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        LogUtils.i(TAG, "onBind");
        return mBinder;
    }

    class MyBinder extends IMyAidlInterface.Stub {

        @Override
        public void sendMessage(String msg) throws RemoteException {
            LogUtils.i(TAG, "server getData--" + msg);
        }

        @Override
        public void registerCallBack(IRemoteServiceCallback cb) throws RemoteException {
            mCallback = cb;
        }

        @Override
        public void unRegisterCallBack(IRemoteServiceCallback cb) throws RemoteException {
            mCallback = null;
        }
    }
}
