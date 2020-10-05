package com.example.myapplication.activtiys;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.customView.HorizontalListView;

import java.util.ArrayList;
import java.util.List;

public class HorizontalListViewTest extends AppCompatActivity {

    private HorizontalListView mHorizontalLvTest;
    private List<String> lists;
    private AdapterHlistviewTestAdapter adapterHlistviewTestAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_list_view_test);
        initView();
    }

    private void initView() {
        mHorizontalLvTest = (HorizontalListView) findViewById(R.id.horizontal_lv_test);
        lists = new ArrayList<>();
        lists.add("列表1");
        lists.add("列表2");
        lists.add("列表3");
        lists.add("列表4");
        lists.add("列表5");
        lists.add("列表6");
        lists.add("列表7");
        adapterHlistviewTestAdapter = new AdapterHlistviewTestAdapter();
        mHorizontalLvTest.setAdapter(adapterHlistviewTestAdapter);
    }

    public class AdapterHlistviewTestAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return lists.size();
        }

        @Override
        public String getItem(int position) {
            return lists.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.adapter_hlistview_test, null);
                convertView.setTag(new ViewHolder(convertView));
            }
            initializeViews((String) getItem(position), (ViewHolder) convertView.getTag());
            return convertView;
        }

        private void initializeViews(String title, ViewHolder holder) {
            //TODO implement
            holder.adapterHlistviewTv.setText(title);
        }

        protected class ViewHolder {
            private TextView adapterHlistviewTv;

            public ViewHolder(View view) {
                adapterHlistviewTv = (TextView) view.findViewById(R.id.adapter_hlistview_tv);
            }
        }
    }
}