package com.example.myapplication.activtiys.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.example.myapplication.R;
import com.example.myapplication.utils.BaseData;

public class ServiceTset2 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }

    @Override
    protected void onStart() {
        super.onStart();
        intentFilter = new IntentFilter();
        intentFilter.addAction(BaseData.Service_Log);
        localReceiver = new LocalReceiver();
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(getApplicationContext());
        localBroadcastManager.registerReceiver(localReceiver,intentFilter);
    }

    private IntentFilter intentFilter;
    private LocalReceiver localReceiver;
    /**
     * 歌曲
     */
    private TextView mServiceTvName;
    /**
     * 播放
     */
    private Button mServiceBt2Play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_tset2);
        initView();
        setView();
    }

    private MyService.PlayMusicBinder playMusicBinder;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            //连接服务成功
            playMusicBinder = (MyService.PlayMusicBinder) iBinder;
            playMusicBinder.send();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
    private void setView() {
        bindService(new Intent(getApplicationContext(),MyService.class),connection, Service.BIND_ABOVE_CLIENT);
    }

    private void initView() {
        mServiceTvName = (TextView) findViewById(R.id.service_tv_name);
        mServiceBt2Play = (Button) findViewById(R.id.service_bt2_play);
        mServiceBt2Play.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.service_bt2_play:
                playMusicBinder.playMusic();
                break;
        }
    }

    class LocalReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            try {
                String musicName = intent.getStringExtra("musicName");
                mServiceTvName.setText(musicName);
            } catch (Exception e) {
                Log.d(BaseData.LOG_TOAST, "ServiceTset2---广播接受器错误");
            }
        }
    }
}