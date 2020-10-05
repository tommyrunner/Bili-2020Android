package com.example.myapplication.activtiys;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class ButtonTest extends AppCompatActivity {

    private Button mBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_test);
        initView();
        setView();
    }

    private void setView() {
        //点击事件
        mBt.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                //处理点击逻辑
                Toast.makeText(ButtonTest.this, "提示：你点击了按钮", Toast.LENGTH_LONG).show();
            }
        });
        //长按事件
        mBt.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                //处理点击逻辑
                Toast.makeText(ButtonTest.this, "提示：你长按了按钮-------", Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }

    private void initView() {
        mBt = findViewById(R.id.button_bt_test);
    }
}