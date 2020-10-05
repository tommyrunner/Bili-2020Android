package com.example.myapplication.activtiys;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.fragment.Fragment01;
import com.example.myapplication.fragment.Fragment02;

import java.util.List;

public class FragmentTest extends AppCompatActivity {

    private LinearLayout mFragmentLayoutTest;   //占位
    /**
     * 第一个
     */
    private Button mFragmentBtBt1;
    /**
     * 第二个
     */
    private Button mFragmentBtBt2;
    private List<View> pageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);
        initView();
        setView();
    }

    private void setView() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout_test, new Fragment01()).commit();
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout_test, new Fragment02()).commit();
        mFragmentBtBt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout_test, new Fragment01()).commit();
            }
        });
        mFragmentBtBt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout_test, new Fragment02()).commit();
            }
        });
    }

    private void initView() {
        mFragmentLayoutTest = (LinearLayout) findViewById(R.id.fragment_layout_test);
        mFragmentBtBt1 = (Button) findViewById(R.id.fragment_bt_bt1);
        mFragmentBtBt2 = (Button) findViewById(R.id.fragment_bt_bt2);
    }



}