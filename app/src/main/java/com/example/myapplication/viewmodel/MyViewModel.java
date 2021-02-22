package com.example.myapplication.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.database.db.AppDataBaseManager;
import com.example.myapplication.database.entity.Student;

import io.reactivex.MaybeObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Copyright (C), 2017-2021, 宝能有限公司
 * Author: jayce.feng
 * Date: 2021/2/20
 * Description: view model
 * version v1.0
 */
public class MyViewModel  extends ViewModel {
    LiveData<Student[]> liveData ;

    public MyViewModel() {
       getData();
    }

    public LiveData<Student[]> getLiveData() {
        return liveData;
    }

    public void getData(){
       liveData =  AppDataBaseManager.getInstance().getStudentDao().query();
    }
}
