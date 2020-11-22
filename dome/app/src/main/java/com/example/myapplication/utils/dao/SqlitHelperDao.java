package com.example.myapplication.utils.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.myapplication.utils.BaseData;
import com.example.myapplication.utils.SqliteHelper;

public class SqlitHelperDao {
    Context context ;
    public SqlitHelperDao(Context context) {
        this.context = context;
    }

    //插入
    public void insert(){
        SqliteHelper sqliteHelper = new SqliteHelper(context);
        SQLiteDatabase sqLiteDatabase = sqliteHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name","张三2");
        values.put("pwd","0000");
        sqLiteDatabase.insert(SqliteHelper.SQL_TABLE_USER1,null,values);
        Log.d(BaseData.LOG_TOAST,"插入数据成功-----------");
    }
    //查询
    public void select(){
        SqliteHelper sqliteHelper = new SqliteHelper(context);
        SQLiteDatabase sqLiteDatabase = sqliteHelper.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.query(SqliteHelper.SQL_TABLE_USER1,new String[]{"name","pwd"},null,null,null,null,null);
        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String pwd = cursor.getString(cursor.getColumnIndex("pwd"));
            Log.d(BaseData.LOG_TOAST,"数据:姓名"+name+"密码:"+pwd);
        }
    }
}
