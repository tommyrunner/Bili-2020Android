package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setView();
    }

    private void setView() {
        //点击事件
        mTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击的逻辑
                mTv.setText("你点击了这个文本!");
            }
        });
        //长按事件
        mTv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                //长按逻辑
                mTv.setText("你长按了这个文本---------------------!");
                return true;
            }
        });
    }

    private void initView() {
        mTv = findViewById(R.id.main_tv_test);
        mTv.setSelected(true);
    }
}