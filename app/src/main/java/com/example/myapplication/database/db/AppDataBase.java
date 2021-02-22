package com.example.myapplication.database.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.myapplication.database.dao.ClassDao;
import com.example.myapplication.database.dao.StudentDao;
import com.example.myapplication.database.entity.ClassDesc;
import com.example.myapplication.database.entity.Student;

/**
 * Copyright (C), 2017-2021, 宝能有限公司
 * Author: jayce.feng
 * Date: 2021/2/18
 * Description: 数据库
 * version v1.0
 */
@Database(entities = {Student.class, ClassDesc.class}, version = 3, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    public abstract StudentDao getStudentDao();

    public abstract ClassDao getClassDao();

}
