package com.example.myapplication.database.db;

import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/**
 * Copyright (C), 2017-2021, 宝能有限公司
 * Author: jayce.feng
 * Date: 2021/2/19
 * Description: 数据库更新
 * version v1.0
 */
public class DbUpdateHelper {


    public static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("create table IF NOT EXISTS class ('classId' INTEGER  AUTO_INCREMENT," +
                    "'className' TEXT  , 'studentNum' INTEGER not null, PRIMARY KEY ('classId'))");
        }
    };




    public static final Migration MIGRATION_3_4 = new Migration(3, 4) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("AlTER TABLE student ADD COLUMN scroe INTEGER");
        }
    };
}
