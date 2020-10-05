package com.example.myapplication.activtiys;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class SpinnerTest extends AppCompatActivity {

    private Spinner mSp;
    private List<String> lists;
    private ArrayAdapter<String> arrayAdapter;
    private Button mBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_test);
        initView();
        setView();
    }

    private void setView() {
        mSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SpinnerTest.this, ""+lists.get(i).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        mBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //添加
                lists.add("添加数据");
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }

    private void initView() {
        mSp = findViewById(R.id.spinner_sp_test);
        mBt = findViewById(R.id.spinner_bt_test);
        lists = new ArrayList<>();
        lists.add("管理人员");
        lists.add("普通用户");
        arrayAdapter = new ArrayAdapter<String>(
                SpinnerTest.this,android.R.layout.simple_expandable_list_item_1,lists
        );
    }
}