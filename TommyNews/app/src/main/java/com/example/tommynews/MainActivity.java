package com.example.tommynews;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.Response;
import com.example.tommynews.activity.SetAtivity;
import com.example.tommynews.entity.AppEntity;
import com.example.tommynews.fragment.ModeFragment;
import com.example.tommynews.utils.MyHttp;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * Tommy新闻
     */
    private TextView mMainTvName;
    private ImageView mMainIvSet;
    private TabLayout mMainLayoutTabs;
    private ViewPager mMainVp;
    private List<Fragment> fragments;
    private List<String> titles;
    private AppEntity appEntity;
    private Intent intent;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setView();
    }

    private void setView() {
        MyHttp.Call(MainActivity.this, "getApp", false, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                Gson gson = new Gson();
                appEntity = gson.fromJson(jsonObject.toString(), AppEntity.class);
            }
        });
        mMainIvSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle = new Bundle();
                bundle.putSerializable("appEntity",appEntity.getData());
                intent = new Intent();
                intent.putExtras(bundle);
                intent.setClass(MainActivity.this, SetAtivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        mMainTvName = (TextView) findViewById(R.id.main_tv_name);
        mMainIvSet = (ImageView) findViewById(R.id.main_iv_set);
        mMainIvSet.setOnClickListener(this);
        mMainLayoutTabs = (TabLayout) findViewById(R.id.main_layout_tabs);
        mMainVp = (ViewPager) findViewById(R.id.main_vp);
        fragments = new ArrayList<>();
        fragments.add(new ModeFragment(0));
        fragments.add(new ModeFragment(1));
        fragments.add(new ModeFragment(2));
        fragments.add(new ModeFragment(3));
        titles = new ArrayList<>();
        titles.add("推荐");
        titles.add("热点");
        titles.add("口碑");
        titles.add("科技");
        mMainVp.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager(),1) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titles.get(position);
            }
        });
        mMainLayoutTabs.setupWithViewPager(mMainVp);
        mMainVp.setOffscreenPageLimit(fragments.size());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.main_iv_set:
                break;
        }
    }
}