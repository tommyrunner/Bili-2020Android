package com.example.tommynews.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tommynews.R;
import com.example.tommynews.entity.AppEntity;

public class SetAtivity extends AppCompatActivity {

    private TextView mSetTvReturn;
    private LinearLayout mSetLayoutBreak;
    private TextView mSetLvVerstion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_ativity);
        initView();
        setView();
    }

    private void setView() {
        try {
            Bundle bundle = getIntent().getExtras();
            if (bundle != null) {
                AppEntity.DataEntity entity = (AppEntity.DataEntity) bundle.getSerializable("appEntity");
                if (entity != null) {
                  mSetLvVerstion.setText("版本:"+entity.getVerstion());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initView() {
        mSetTvReturn = findViewById(R.id.set_tv_return);
        mSetTvReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mSetLayoutBreak = findViewById(R.id.set_layout_break);
        mSetLvVerstion = findViewById(R.id.set_lv_verstion);
    }
}