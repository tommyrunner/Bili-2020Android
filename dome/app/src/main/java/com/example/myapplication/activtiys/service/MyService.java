package com.example.myapplication.activtiys.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.example.myapplication.R;
import com.example.myapplication.utils.BaseData;

public class MyService extends Service {
    MediaPlayer mediaPlayer;
    String musicObj = "暂无";
    private LocalBroadcastManager localBroadcastManager;
    @Override
    public void onDestroy() {
        Log.d(BaseData.LOG_TOAST,"MyService销毁");
        super.onDestroy();
    }

    @Override
    public void onCreate() {
        Log.d(BaseData.LOG_TOAST,"MyService创建");
        localBroadcastManager =LocalBroadcastManager.getInstance(getApplicationContext());
        super.onCreate();
    }


    public MyService() {
        Log.d(BaseData.LOG_TOAST,"MyService实例");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.d(BaseData.LOG_TOAST,"MyService绑定成功");
        return  new PlayMusicBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(BaseData.LOG_TOAST,"MyService解除绑定");
        return super.onUnbind(intent);
    }
    public class  PlayMusicBinder extends Binder{
        public PlayMusicBinder() {
            mediaPlayer =  MediaPlayer.create(getApplication(), R.raw.test_mp3);
        }
        public void send(){
            Intent serviceIntent = new Intent(BaseData.Service_Log);
            serviceIntent.putExtra("musicName",musicObj);
            localBroadcastManager.sendBroadcast(serviceIntent);
        }
        public void initMusic(String name){
            musicObj = name;
            Log.d(BaseData.LOG_TOAST,"你初始化了"+name);
        }
        public void playMusic(){
            if (mediaPlayer !=null){
                mediaPlayer.start();
                Log.d(BaseData.LOG_TOAST,"你播放了"+musicObj);
            }
        }
        public void stopMusic(){
            if (mediaPlayer !=null){
                mediaPlayer.stop();
                Log.d(BaseData.LOG_TOAST,"你停止了"+musicObj);
            }
        }
    }
}
