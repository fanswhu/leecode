package com.example.myapplication.database.db;

import android.content.Context;

import androidx.room.Room;

import com.example.myapplication.database.dao.ClassDao;
import com.example.myapplication.database.dao.StudentDao;

/**
 * Copyright (C), 2017-2021, 宝能有限公司
 * Author: jayce.feng
 * Date: 2021/2/18
 * Description: 管理类
 * version v1.0
 */
public class AppDataBaseManager {

    private static final String DB_NAME = "app_db";
    private static AppDataBaseManager instance;

    private AppDataBase mDataBase;

    private AppDataBaseManager() {

    }

    public static AppDataBaseManager getInstance() {
        if (instance == null) {
            synchronized (AppDataBaseManager.class) {
                if (instance == null) {
                    instance = new AppDataBaseManager();
                }
            }
        }
        return instance;
    }


    public void init(Context context) {
        mDataBase = Room.databaseBuilder(context, AppDataBase.class, DB_NAME)
                .allowMainThreadQueries()
                .addMigrations(DbUpdateHelper.MIGRATION_2_3)
                .build();

    }

    public StudentDao getStudentDao() {
        return mDataBase.getStudentDao();
    }


    public ClassDao getClassDao() {
        return mDataBase.getClassDao();
    }


}
