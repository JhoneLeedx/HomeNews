package com.jhonlee.homenews.view.nba;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.jhonlee.homenews.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by JhoneLee on 2017/3/8.
 */

public class NBAActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_news)
    Toolbar toolbarNews;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nba);
        ButterKnife.bind(this);
    }
}
