package com.dyj.dim.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.dyj.dim.R;
import com.dyj.dim.base.activity.BaseActivity;
import com.dyj.dim.login.LoginActivity;

import java.util.ArrayList;

public class SplashActivity extends BaseActivity {

    private ViewPager viewPager;
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash);
        init();
    }

    private void init() {
        fragments = new ArrayList<>();
        fragments.add(SplashItemFragment.newInstance(R.layout.splash_item));
        fragments.add(SplashItemFragment.newInstance(R.layout.splash_item));
        fragments.add(SplashItemFragment.newInstance(R.layout.splash_item));
        fragments.add(SplashItemFragment.newInstance(R.layout.splash_item_in));

        viewPager = (ViewPager) findViewById(R.id.vp_splash_view);
        viewPager.setAdapter(new SplashPagerAdapter(getSupportFragmentManager()));
    }

    public void startMain(View view) {
//        AppUtil.shareToOtherApp(this, "分享标题", "分享内容", null);
        finish();
        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
    }

    class SplashPagerAdapter extends FragmentPagerAdapter {


        public SplashPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments == null ? 0 : fragments.size();
        }
    }

}

