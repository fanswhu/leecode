package com.example.myapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.widget.ListView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerParallaxSnap extends Activity {
    ViewPager mViewPager;
    List<Fragment> mFragments;
    Toolbar mToolbar;

    String[]  mTitles=new String[]{
            "主页","微博","相册"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_parallax_snap);

        mToolbar= (Toolbar) findViewById(R.id.toolbar);

        mToolbar.setTitle("唐嫣");
        CollapsingToolbarLayout layout;

        //setSupportActionBar(mToolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        setupViewPager();



    }

    private void setupViewPager() {





    }

    private void setupViewPager(ViewPager viewPager) {
        mFragments=new ArrayList<>();

    }
}
