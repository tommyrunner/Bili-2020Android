package com.example.myapplication.activtiys;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.entity.ListViewEntity;

import java.util.ArrayList;
import java.util.List;

public class ListViewTest extends AppCompatActivity {

    private ListView mListviewLvTest;
    private List<ListViewEntity> listViewEntities;
    private AdapterListviewTestAdapter adapterListviewTestAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_test);
        initView();
        setView();
    }

    private void setView() {

    }

    private void initView() {
        mListviewLvTest = (ListView) findViewById(R.id.listview_lv_test);
        listViewEntities = new ArrayList<>();
        listViewEntities.add(new ListViewEntity("张三",12));
        listViewEntities.add(new ListViewEntity("李四",13));
        listViewEntities.add(new ListViewEntity("王五",14));
        adapterListviewTestAdapter = new AdapterListviewTestAdapter();
        mListviewLvTest.setAdapter(adapterListviewTestAdapter);
    }

    public class AdapterListviewTestAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return listViewEntities.size();
        }

        @Override
        public ListViewEntity getItem(int position) {
            return listViewEntities.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.adapter_listview_test, null);
                convertView.setTag(new ViewHolder(convertView));
            }
            initializeViews((ListViewEntity)getItem(position), (ViewHolder) convertView.getTag());
            return convertView;
        }

        private void initializeViews(final ListViewEntity object, final ViewHolder holder) {
            //TODO implement
            //处理数据
            holder.adapterListviewTvAge.setText("年龄:"+object.getAge());
            holder.adapterListviewTvName.setText("名字:"+object.getName());
            holder.adapterListviewLayout.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(),ImageViewTest.class);
                    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(
                            ListViewTest.this, new Pair[]{Pair.<View, String>create(holder.ivTest, "activtyImageTest_image")}
                    ).toBundle());
                }
            });
        }

        protected class ViewHolder {
            private LinearLayout adapterListviewLayout;
            private TextView adapterListviewTvName;
            private TextView adapterListviewTvAge;
            private ImageView ivTest;

            public ViewHolder(View view) {
                adapterListviewLayout = (LinearLayout) view.findViewById(R.id.adapter_listview_layout);
                adapterListviewTvName = (TextView) view.findViewById(R.id.adapter_listview_tv_name);
                adapterListviewTvAge = (TextView) view.findViewById(R.id.adapter_listview_tv_age);
                ivTest = view.findViewById(R.id.adapter_listview_iv_test);
            }
        }
    }

}