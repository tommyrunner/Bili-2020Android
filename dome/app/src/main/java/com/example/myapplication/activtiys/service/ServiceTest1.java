package com.example.myapplication.activtiys.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.utils.BaseData;

public class ServiceTest1 extends AppCompatActivity implements View.OnClickListener {
    /**
     * 初始化音乐
     */
    private Button mServiceBtInit;
    /**
     * 播放音乐
     */
    private Button mServiceBtPlay;
    /**
     * 停止
     */
    private Button mServiceBtStop;
    /**
     * 跳转test2
     */
    private Button mServiceBtTest2;

    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(getApplicationContext(), MyService.class);
        startService(intent);
        bindService(new Intent(getApplicationContext(), MyService.class), connection, Service.BIND_AUTO_CREATE);
    }

    MyService.PlayMusicBinder playMusicBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test1);
        initView();
        setView();
    }

    private void setView() {
//        startActivity(new Intent(getApplicationContext(),ServiceTset2.class));
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            //连接服务成功
            playMusicBinder = (MyService.PlayMusicBinder) iBinder;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    private void initView() {
        mServiceBtInit = (Button) findViewById(R.id.service_bt_init);
        mServiceBtInit.setOnClickListener(this);
        mServiceBtPlay = (Button) findViewById(R.id.service_bt_play);
        mServiceBtPlay.setOnClickListener(this);
        mServiceBtStop = (Button) findViewById(R.id.service_bt_stop);
        mServiceBtStop.setOnClickListener(this);
        mServiceBtTest2 = (Button) findViewById(R.id.service_bt_test2);
        mServiceBtTest2.setOnClickListener(this);
        sp = getSharedPreferences(BaseData.SP_TEST,MODE_PRIVATE);
        editor = sp.edit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.service_bt_init:
                playMusicBinder.initMusic("伤心太平洋.mp3");
                break;
            case R.id.service_bt_play:
                playMusicBinder.playMusic();
                break;
            case R.id.service_bt_stop:
                playMusicBinder.stopMusic();
                break;
            case R.id.service_bt_test2:
                Intent intent  =new Intent(getApplicationContext(), ServiceTset2.class);
//                UserEntity userEntity = new UserEntity();
//                userEntity.setName("张三");
//                userEntity.setPwd("333");
//                userEntity.setAge("33");
//
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("userValue",userEntity);
//                intent.putExtras(bundle);
                startActivity(intent);
                editor.putString("testSp_userName","张三");
                editor.putString("testSp_userPwd","333");
                editor.apply();
                break;
        }
    }
}