package com.example.myapplication.activtiys;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class SeekProBarRatingTest extends AppCompatActivity {

    private SeekBar mBarSeekTest;
    private String LOG_BAR = "BARLOGTEST";
    ;
    private ProgressBar mBarProTest;
    private RatingBar mBarRatingTest;
    private int pro = 0;
    private final int MESSAGE_TEST1 = 0x01;
    /**
     * 0%
     */
    private TextView mBarTvProValue;


    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case MESSAGE_TEST1:
                    //接受的是test1的消息
                    mBarSeekTest.setProgress(pro);
                    mBarTvProValue.setText(pro + "%");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spbr_bar_test);
        initView();
        setView();
    }

    private void setView() {
        //监听事件
        mBarSeekTest.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                Log.d(LOG_BAR, "Seek发生改变了");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d(LOG_BAR, "Seek被按住了");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d(LOG_BAR, "Seek被放开了");
            }
        });
        //pro方法
        Log.d(LOG_BAR, "pro的进度是多少:" + mBarProTest.getProgress());
        //rating方法
        Log.d(LOG_BAR, "rating的当前星星是多少:" + (int) mBarRatingTest.getRating());

        //动态线程进度条
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (pro < mBarSeekTest.getMax()) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //逻辑代码
                    pro += 10;
                    Message message = new Message();
                    message.what = MESSAGE_TEST1;
                    handler.sendMessage(message);
                }
            }
        };
        thread.start();
    }

    private void initView() {
        mBarSeekTest = (SeekBar) findViewById(R.id.bar_seek_test);
        mBarProTest = (ProgressBar) findViewById(R.id.bar_pro_test);
        mBarRatingTest = (RatingBar) findViewById(R.id.bar_rating_test);
        mBarTvProValue = (TextView) findViewById(R.id.bar_tv_proValue);
    }
}