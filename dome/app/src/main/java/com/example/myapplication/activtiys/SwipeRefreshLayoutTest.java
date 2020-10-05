package com.example.myapplication.activtiys;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.myapplication.R;

public class SwipeRefreshLayoutTest extends AppCompatActivity implements View.OnClickListener {

    /**
     * 按钮1
     */
    private Button mSrlBtBt1;
    private SwipeRefreshLayout mSrlLayoutTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh_layout_test);
        initView();
        setView();
    }

    private void setView() {
        mSrlLayoutTest.setEnabled(false);   //设置不可滑动
        mSrlLayoutTest.setRefreshing(true); //刚进界面出现动画
        mSrlLayoutTest.setColorSchemeResources(R.color.mainColor,R.color.mainColor2);
        mSrlLayoutTest.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //下拉触发

                //获取数据...
                new Thread(){
                    @Override
                    public void run() {
                        try {
                            sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //获取数据成功
                        mSrlLayoutTest.setRefreshing(false);
                    }
                }.start();
            }
        });
    }

    private void initView() {
        mSrlBtBt1 = (Button) findViewById(R.id.srl_bt_bt1);
        mSrlBtBt1.setOnClickListener(this);
        mSrlLayoutTest = (SwipeRefreshLayout) findViewById(R.id.srl_Layout_test);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.srl_bt_bt1:
                break;
        }
    }
}