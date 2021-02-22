package com.example.myapplication.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * Copyright (C), 2017-2021, 宝能有限公司
 * Author: jayce.feng
 * Date: 2021/2/19
 * Description: 班级
 * version v1.0
 */
@Entity(tableName = "class")
public class ClassDesc {
    @ColumnInfo
    private String className;

    @ColumnInfo
    private int studentNum;


    @PrimaryKey(autoGenerate = true)
    private int classId;


    public ClassDesc() {
    }


    @Ignore
    public ClassDesc(String className, int studentNum, int classId) {
        this.className = className;
        this.studentNum = studentNum;
        this.classId = classId;
    }


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "ClassDesc{" +
                "className='" + className + '\'' +
                ", studentNum=" + studentNum +
                ", classId=" + classId +
                '}';
    }
}
