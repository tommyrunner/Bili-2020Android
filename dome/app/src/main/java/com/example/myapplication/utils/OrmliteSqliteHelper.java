package com.example.myapplication.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.entity.UserSqlEntity;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class OrmliteSqliteHelper extends OrmLiteSqliteOpenHelper {

    private static  final String SQL_NAME = "testSql.db";
    private static final int SQL_VERSION = 1;

    public OrmliteSqliteHelper(Context context) {
        super(context, SQL_NAME, null, SQL_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, UserSqlEntity.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {

    }
}
