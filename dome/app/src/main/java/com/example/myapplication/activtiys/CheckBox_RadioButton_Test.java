package com.example.myapplication.activtiys;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class CheckBox_RadioButton_Test extends AppCompatActivity {

    private CheckBox mCb1;
    private CheckBox mCb2;
    private RadioGroup mRg;
    private RadioButton mRb1;
    private RadioButton mRb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box__radio_button__test);
        initView();
        setView();
    }

    private void setView() {
        Toast.makeText(getApplicationContext(), mCb1.isChecked()+"", Toast.LENGTH_SHORT).show();

        //---------------------------
        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.crb_rb_rb1:
                        //选中第一个单选框的时候
                        Toast.makeText(getApplicationContext(), mRb1.getText().toString(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.crb_rb_rb2:
                        //选中第二个单选框的时候
                        Toast.makeText(getApplicationContext(), mRb2.getText().toString(), Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    private void initView() {
        mCb1 = findViewById(R.id.crb_cb_test1);
        mCb2 = findViewById(R.id.crb_cb_test2);
        mRg = findViewById(R.id.crb_rg_test);
        mRb1 = findViewById(R.id.crb_rb_rb1);
        mRb2 = findViewById(R.id.crb_rb_rb2);

    }
}