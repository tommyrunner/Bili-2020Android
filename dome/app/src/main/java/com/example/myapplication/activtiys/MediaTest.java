package com.example.myapplication.activtiys;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.io.IOException;

public class MediaTest extends AppCompatActivity {

    private SeekBar mMediaSbarTest;
    Message message;
    MediaPlayer mediaPlayer;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            mMediaSbarTest.setProgress(mediaPlayer.getCurrentPosition());
        }
    };
    private VideoView mMediaVvMp4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_test);
        initView();
        setView();
    }

    private void setView() {
        //播放音频
        String mp3Url = "https://freetyst.nf.migu.cn/public%2Fringmaker01%2Fdailyring05%2F2016%2F04%2F2015%E5%B9%B411%E6%9C%8819%E6%97%A511%E7%82%B956%E5%88%86%E5%86%85%E5%AE%B9%E5%87%86%E5%85%A5%E5%8D%83%E6%98%93%E7%9B%9F%E9%A2%84%E7%95%99999%E9%A6%96%2F%E5%BD%A9%E9%93%83%2F6_mp3-128kbps%2F%E6%8E%A8%E8%8D%90-Various+Artists.mp3";
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(mp3Url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.prepareAsync();
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
//                mediaPlayer.start();
//                mMediaSbarTest.setMax(mediaPlayer.getDuration());
            }
        });
        mediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
            @Override
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {

            }
        });

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        message = new Message();
                        handler.sendMessage(message);
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        mMediaSbarTest.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });
        //播放视频
        mMediaVvMp4.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.test_mp4);
        mMediaVvMp4.start();
        MediaController mediaController = new MediaController(MediaTest.this);
        mMediaVvMp4.setMediaController(mediaController);    //关联视频播放器
    }

    private void initView() {
        mMediaSbarTest = (SeekBar) findViewById(R.id.media_sbar_test);
        mMediaVvMp4 = (VideoView) findViewById(R.id.media_vv_mp4);
    }
}