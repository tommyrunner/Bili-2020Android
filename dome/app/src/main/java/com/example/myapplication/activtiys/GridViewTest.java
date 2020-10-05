package com.example.myapplication.activtiys;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class GridViewTest extends AppCompatActivity {

    private GridView mGridViewGvTest;
    private List<String> lists;
    private AdapterGridviewTestAdapter adapterGridviewTestAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_test);
        initView();
        setView();
    }

    private void setView() {
        mGridViewGvTest.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), ""+lists.get(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        mGridViewGvTest = (GridView) findViewById(R.id.gridView_gv_test);
        lists = new ArrayList<>();
        lists.add("gridView(1)");
        lists.add("gridView(2)");
        lists.add("gridView(3)");
        lists.add("gridView(4)");
        lists.add("gridView(5)");
        lists.add("gridView(6)");
        lists.add("gridView(7)");
        lists.add("gridView(8)");
        adapterGridviewTestAdapter = new AdapterGridviewTestAdapter();
        mGridViewGvTest.setAdapter(adapterGridviewTestAdapter);

    }

    public class AdapterGridviewTestAdapter extends BaseAdapter {

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
                convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.adapter_gridview_test, null);
                convertView.setTag(new ViewHolder(convertView));
            }
            initializeViews((String)getItem(position), (ViewHolder) convertView.getTag());
            return convertView;
        }

        private void initializeViews(String object, ViewHolder holder) {
            //TODO implement
            holder.adapterGridviewTv .setText(object);
        }

        protected class ViewHolder {
            private TextView adapterGridviewTv;

            public ViewHolder(View view) {
                adapterGridviewTv = (TextView) view.findViewById(R.id.adapter_gridview_tv);
            }
        }
    }
}