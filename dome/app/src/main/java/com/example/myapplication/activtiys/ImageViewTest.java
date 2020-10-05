package com.example.myapplication.activtiys;

import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;

public class ImageViewTest extends AppCompatActivity {

    private ImageView mIv;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view_test);

        initView();
        setView();
    }

    private void setView() {
        String url = "https://www.baidu.com/img/flexible/logo/pc/result.png";
        Glide.with(getApplicationContext()).load(url).into(mIv);
    }

    private void initView() {
        mIv = findViewById(R.id.image_iv_test);
    }
}