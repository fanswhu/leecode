package com.example.myapplication.database.dao;

import androidx.lifecycle.ComputableLiveData;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.database.entity.Student;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Copyright (C), 2017-2021, 宝能有限公司
 * Author: jayce.feng
 * Date: 2021/2/18
 * Description: 数据库接口
 * version v1.0
 */
@Dao
public interface StudentDao {

    @Insert
    void insert(Student student);

    @Delete
    void delete(Student student);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(Student student);

    @Query("select * from student ")
    LiveData<Student[]> query();
}
