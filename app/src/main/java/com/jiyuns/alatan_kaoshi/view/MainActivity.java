package com.jiyuns.alatan_kaoshi.view;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.jiyuns.alatan_kaoshi.R;
import com.jiyuns.alatan_kaoshi.adapter.MyPagerAdapter;
import com.jiyuns.alatan_kaoshi.fragment.AFragment;
import com.jiyuns.alatan_kaoshi.fragment.BFragment;

import java.util.ArrayList;

/**
 * @author 阿拉坦    H1810B
 * @date 2019-6-13 11:07:35
 */

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initTabLayout();
    }

    private void initTabLayout() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new AFragment());
        fragments.add(new BFragment());
        ArrayList<String> strings = new ArrayList<>();
        strings.add(new String("我的"));
        strings.add(new String("关注"));
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), fragments, strings);
        mViewPager.setAdapter(myPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }

    private void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
    }
}
