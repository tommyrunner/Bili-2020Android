package com.example.myapplication.activtiys;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Response;
import com.example.myapplication.R;
import com.example.myapplication.utils.InitApp;
import com.example.myapplication.utils.MyHttp;
import com.google.gson.Gson;

import org.json.JSONObject;

public class NetworkTest extends AppCompatActivity {



    private Gson gson;
    /**
     * 还未获取数据
     */
    private TextView mNetworkTvDate;
    private String testLog = "TestLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);
        initView();
        setView();
        Log.d(testLog,"入口");
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            if(msg.what == 001){
                mNetworkTvDate.setText(msg.obj+"");
            }
        }
    };
    private void setView() {
        InitApp.getPermissions(this);
        String url = "https://v1.hitokoto.cn/";
        MyHttp.get(url, getApplicationContext(), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.d("NetWork",jsonObject.toString());
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 20:
                if (grantResults.length > 0 && (grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                        grantResults[1] == PackageManager.PERMISSION_GRANTED)) {
                    //同意了

                } else {
                    //拒绝权限
                    finish();
                }
                break;
        }
    }

    private void initView() {
        mNetworkTvDate = (TextView) findViewById(R.id.network_tv_date);
    }
}