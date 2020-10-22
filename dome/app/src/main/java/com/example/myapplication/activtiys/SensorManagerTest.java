package com.example.myapplication.activtiys;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.io.File;

public class SensorManagerTest extends AppCompatActivity implements SensorEventListener, View.OnClickListener {

    /**
     * 获取中...
     */
    private TextView mSmTvT1;
    /**
     * 隐式跳转
     */
    private Button mSmBtTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_manager_test);
        initView();
        setView();
    }

    private void setView() {
        //传感器
        //创建一个SensorManager来获取系统的传感器服务
        SensorManager sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        //注册传感器
        sm.registerListener((SensorEventListener) this, sm.getDefaultSensor(Sensor.TYPE_GRAVITY), SensorManager.SENSOR_DELAY_NORMAL);

        // 为光传感器注册监听器
        sm.registerListener(this, sm.getDefaultSensor(Sensor.TYPE_LIGHT), SensorManager.SENSOR_DELAY_NORMAL);

    }

    private void initView() {
        mSmTvT1 = (TextView) findViewById(R.id.sm_tv_t1);
        mSmBtTo = (Button) findViewById(R.id.sm_bt_to);
        mSmBtTo.setOnClickListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == Sensor.TYPE_GRAVITY) {
            float X = sensorEvent.values[0];
            float Y = sensorEvent.values[1];
            float Z = sensorEvent.values[2];

        } else if (sensorEvent.sensor.getType() == Sensor.TYPE_LIGHT) {
            float X = sensorEvent.values[0];
            mSmTvT1.setText("当前光照：" + X);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.sm_bt_to:

                //隐式跳转
//                Intent Intent =  new Intent(android.content.Intent.ACTION_DIAL, Uri.parse("tel:" + "123123123"));//跳转到拨号界面，同时传递电话号码
//                startActivity(Intent);

                //指定联系人
//                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:我是指定联系人"));
//                intent.putExtra("sms_body", "内容");
//                startActivity(intent);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
                    StrictMode.setVmPolicy(builder.build());
                }
                toCamera();
                break;
        }
    }
    //跳转相机
    private void toCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);  //跳转到 ACTION_IMAGE_CAPTURE
        //判断内存卡是否可用，可用的话就进行存储
        //putExtra：取值，Uri.fromFile：传一个拍照所得到的文件，fileImg.jpg：文件名
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(Environment.getExternalStorageDirectory(),"fileImg.jpg")));
        startActivityForResult(intent,101); // 101: 相机的返回码参数（随便一个值就行，只要不冲突就好）
    }
}