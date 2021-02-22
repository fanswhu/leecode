// IMyAidlInterface.aidl
package com.example.myapplication;
import  com.example.myapplication.IRemoteServiceCallback;

// Declare any non-default types here with import statements

interface IMyAidlInterface {
     void sendMessage(String msg);

     void registerCallBack(IRemoteServiceCallback cb);

      void unRegisterCallBack(IRemoteServiceCallback cb);

}