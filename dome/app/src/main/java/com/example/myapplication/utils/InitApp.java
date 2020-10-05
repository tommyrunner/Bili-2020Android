package com.example.myapplication.utils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class InitApp {
    public static void  getPermissions(Activity activity){
        //判断sdk版本
        if (Build.VERSION.SDK_INT>=23) {
            //获取管理器
            int request= ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA);
            if (request!= PackageManager.PERMISSION_GRANTED)//如果缺少权限，进行权限申请
            {
                //准备缺少权限的集合,并准备一个回调id
                ActivityCompat.requestPermissions(activity,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE},20);
                return;//
            }
        }
    }
}
