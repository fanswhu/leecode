package com.example.myapplication.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.myapplication.database.entity.ClassDesc;

/**
 * Copyright (C), 2017-2021, 宝能有限公司
 * Author: jayce.feng
 * Date: 2021/2/19
 * Description: dao
 * version v1.0
 */
@Dao
public interface ClassDao {
    @Insert
    void insert(ClassDesc classDesc);

    @Query("select * from class")
    ClassDesc[] query();
}
