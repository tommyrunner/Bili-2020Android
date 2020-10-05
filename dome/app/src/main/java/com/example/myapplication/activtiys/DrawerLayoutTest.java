package com.example.myapplication.activtiys;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.myapplication.R;
import com.example.myapplication.fragment.Fragment01;

public class DrawerLayoutTest extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mSiliLayoutLayoutContent;
    private DrawerLayout mSliLayoutLayoutTest;
    /**
     * 打开
     */
    private Button mSliLayoutBtOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout_test);
        initView();
        setView();
    }

    private void setView() {
        getSupportFragmentManager().beginTransaction().replace(R.id.siliLayout_layout_content, new Fragment01()).commit();
        //定义样式
        final View leftView = mSliLayoutLayoutTest.getChildAt(0);
    }

    private void initView() {
        mSiliLayoutLayoutContent = (LinearLayout) findViewById(R.id.siliLayout_layout_content);
        mSliLayoutLayoutTest = (DrawerLayout) findViewById(R.id.sliLayout_layout_test);
        mSliLayoutBtOpen = (Button) findViewById(R.id.sliLayout_bt_open);
        mSliLayoutBtOpen.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.sliLayout_bt_open:
                mSliLayoutLayoutTest.openDrawer(Gravity.LEFT);
                break;
        }
    }
}