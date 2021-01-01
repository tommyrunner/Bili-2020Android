package com.example.tommynews.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Response;
import com.example.tommynews.MainActivity;
import com.example.tommynews.R;
import com.example.tommynews.activity.BodyActivity;
import com.example.tommynews.activity.SetAtivity;
import com.example.tommynews.entity.NewsEntity;
import com.example.tommynews.utils.MyHttp;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ModeFragment extends Fragment {
    View view;
    int mode;
    private ListView mModeLv;
    private List<NewsEntity.DataEntity> newsEntities;
    private ItemModeLvAdapter itemModeLvAdapter;
    private Gson gson;
    private Bundle bundle;
    private Intent intent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_mode_fragment, container, false);
        initView();
        setView();
        return view;
    }

    private void setView() {
        MyHttp.Call(getContext(), "getData",true, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                gson = new Gson();
                newsEntities.clear();
                NewsEntity newsEntity = gson.fromJson(jsonObject.toString(), NewsEntity.class);
                for(NewsEntity.DataEntity entity : newsEntity.getData()){
                    if (entity.getMode() == mode){
                        newsEntities.add(entity);
                    }
                }
                itemModeLvAdapter.notifyDataSetChanged();
            }
        });
        mModeLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                bundle = new Bundle();
                bundle.putSerializable("newsEntity",newsEntities.get(i));
                intent = new Intent();
                intent.putExtras(bundle);
                intent.setClass(getContext(), BodyActivity.class);
                startActivity(intent);
            }
        });
    }

    public ModeFragment(int mode) {
        this.mode = mode;
    }

    private void initView() {
        mModeLv = view.findViewById(R.id.mode_lv);
        newsEntities = new ArrayList<>();
        itemModeLvAdapter = new ItemModeLvAdapter();
        mModeLv.setAdapter(itemModeLvAdapter);
    }

    public class ItemModeLvAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return newsEntities.size();
        }

        @Override
        public NewsEntity.DataEntity getItem(int position) {
            return newsEntities.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_mode_lv, null);
                convertView.setTag(new ViewHolder(convertView));
            }
            initializeViews((NewsEntity.DataEntity)getItem(position), (ViewHolder) convertView.getTag());
            return convertView;
        }

        private void initializeViews(NewsEntity.DataEntity object, ViewHolder holder) {
            //TODO implement
            try {
                holder.itemModeTvTitle.setText(object.getTitle()+"");
                holder.itemModeTvEmail.setText(object.getEmail()+"");
                holder.itemModeTvLove.setText(object.getLive()+"");
                holder.itemModeTvNameTv.setText(object.getName()+"     "+object.getSignature());
                holder.itemModeTvText.setText(object.getBody()+"");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        protected class ViewHolder {
            private TextView itemModeTvTitle;
            private TextView itemModeTvNameTv;
            private TextView itemModeTvText;
            private TextView itemModeTvLove;
            private TextView itemModeTvEmail;

            public ViewHolder(View view) {
                itemModeTvTitle = (TextView) view.findViewById(R.id.item_mode_tv_title);
                itemModeTvNameTv = (TextView) view.findViewById(R.id.item_mode_tv_nameTv);
                itemModeTvText = (TextView) view.findViewById(R.id.item_mode_tv_text);
                itemModeTvLove = (TextView) view.findViewById(R.id.item_mode_tv_love);
                itemModeTvEmail = (TextView) view.findViewById(R.id.item_mode_tv_email);
            }
        }
    }

}