package com.example.myapplication.activtiys;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class EditTextTest extends AppCompatActivity {

    private EditText mEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text_test);
        initView();
        setView();
    }

    private void setView() {
        //焦点事件
        mEt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    //获取焦点逻辑
                    Toast.makeText(getApplicationContext(), "输入框获取焦点!", Toast.LENGTH_SHORT).show();
                }else {
                    //失去
                    Toast.makeText(getApplicationContext(), "输入框失去焦点!-------", Toast.LENGTH_SHORT).show();

                }
            }
        });
        //监听事件
        mEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("LOGEDIT",mEt.getText().toString());
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void initView() {
        mEt = findViewById(R.id.edit_et_test);
    }
}