package com.example.myapplication.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * Copyright (C), 2017-2021, 宝能有限公司
 * Author: jayce.feng
 * Date: 2021/2/18
 * Description: 学生数据库
 * version v1.0
 */
@Entity(tableName = "student")
public class Student {
    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo
    private String name;

    @ColumnInfo
    private int age;

    @ColumnInfo
    private String classDesc;

    public Student(){

    }

    @Ignore
    public Student(String name, int age, String classDesc) {

        this.name = name;
        this.age = age;
        this.classDesc = classDesc;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClassDesc() {
        return classDesc;
    }

    public void setClassDesc(String classDesc) {
        this.classDesc = classDesc;
    }

    @Override
    public String toString() {
        return "Student{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", classDesc='" + classDesc + '\'' +
                '}';
    }
}
