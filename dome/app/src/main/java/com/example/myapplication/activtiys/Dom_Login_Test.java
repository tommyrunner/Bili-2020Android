package com.example.myapplication.activtiys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class Dom_Login_Test extends AppCompatActivity implements View.OnClickListener {

    private EditText mLoginEtUser;
    private EditText mLoginEtPwd;
    /**
     * 登录
     */
    private Button mLoginBtLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }
    private void initView() {
        mLoginEtUser = (EditText) findViewById(R.id.login_et_user);
        mLoginEtPwd = (EditText) findViewById(R.id.login_et_pwd);
        mLoginBtLogin = (Button) findViewById(R.id.login_bt_login);
        mLoginBtLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.login_bt_login:
                String user = mLoginEtUser.getText().toString();
                String pwd = mLoginEtPwd.getText().toString();
                if(user.equals("")||pwd.equals("")){
                    Toast.makeText(this, "不能为空!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (user.equals("admin")&&pwd.equals("123")){
                    //登录成功
                    startActivity(new Intent(Dom_Login_Test.this,ButtonTest.class));
                }else {
                    Toast.makeText(this, "账号密码不正确!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}