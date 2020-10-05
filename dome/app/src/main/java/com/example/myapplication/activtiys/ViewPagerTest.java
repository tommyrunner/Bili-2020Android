package com.example.myapplication.activtiys;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.R;
import com.example.myapplication.fragment.Fragment01;
import com.example.myapplication.fragment.Fragment02;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerTest extends AppCompatActivity {

    private ViewPager mPageViewVpTest;
    private List<Fragment> fragments;
    private List<String> titles;
    private TabLayout mPageViewTlTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_test);
        initView();
        setView();
    }

    private void setView() {
        mPageViewVpTest.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
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
        mPageViewTlTest.setupWithViewPager(mPageViewVpTest);    //关联
    }

    private void initView() {
        mPageViewVpTest = (ViewPager) findViewById(R.id.pageView_vp_test);
        fragments = new ArrayList<>();
        fragments.add(new Fragment01());
        fragments.add(new Fragment02());
        mPageViewTlTest = (TabLayout) findViewById(R.id.pageView_tl_test);
        titles = new ArrayList<>();
        titles.add("第一个");
        titles.add("第二个");
    }
}