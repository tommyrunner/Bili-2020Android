package com.example.myapplication.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SqliteHelper extends SQLiteOpenHelper {

    private static  final String SQL_NAME = "testSql.db";
    private static final int SQL_VERSION = 1;
    public static final String SQL_TABLE_USER1 = "tb_user";

    public SqliteHelper(@Nullable Context context) {
        super(context, SQL_NAME, null, SQL_VERSION);
    }

    //只执行一次
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table "+SQL_TABLE_USER1+"(name varchar(20),pwd varchar(20))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
