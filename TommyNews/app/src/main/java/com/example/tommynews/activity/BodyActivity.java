package com.example.tommynews.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tommynews.R;
import com.example.tommynews.entity.AppEntity;
import com.example.tommynews.entity.NewsEntity;

public class BodyActivity extends AppCompatActivity {

    private TextView mBodyTvReturn;
    private TextView mBodyTvTitle;
    private TextView mBodyTvNameTv;
    private ImageView mBodyIvIcon1;
    private TextView mBodyTvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body);
        initView();
        setView();
    }

    private void setView() {
        try {
            Bundle bundle = getIntent().getExtras();
            if (bundle != null) {
                NewsEntity.DataEntity entity = (NewsEntity.DataEntity) bundle.getSerializable("newsEntity");
                if (entity != null) {
                    mBodyTvTitle.setText(entity.getTitle()+"");
                    mBodyTvNameTv.setText(entity.getName()+"     "+entity.getSignature());
                    mBodyTvText.setText(entity.getBody());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initView() {
        mBodyTvReturn = findViewById(R.id.body_tv_return);
        mBodyTvReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mBodyTvTitle = findViewById(R.id.body_tv_title);
        mBodyTvNameTv = findViewById(R.id.body_tv_nameTv);
        mBodyIvIcon1 = findViewById(R.id.body_iv_icon1);
        mBodyTvText = findViewById(R.id.body_tv_text);
    }
}