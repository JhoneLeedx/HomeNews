package com.jhonlee.homenews.view.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


import com.jhonlee.homenews.R;
import com.jhonlee.homenews.view.news.NewsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijin on 2017/2/19.
 */

public class MainNewsActivity extends AppCompatActivity {


    @BindView(R.id.tabLayout)
    TabLayout mTab;
    @BindView(R.id.viewpager)
    ViewPager viewPager;

    private NewsFragment topNew;
    private NewsFragment shNew;
    private NewsFragment gnNew;
    private NewsFragment jsNew;
    private NewsFragment gjNew;
    private NewsFragment kjNew;
    private NewsFragment ylNew;
    private NewsFragment tyNew;
    private NewsFragment cjNew;
    private NewsFragment ssNew;

    private String[] tableTitle = {"头条", "娱乐", "体育", "时尚", "社会", "科技", "军事", "财经", "国际", "国内"};
    private ViewpagerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_viewpager);
        ButterKnife.bind(this);
        initTabTitle();
    }

    private void initTabTitle() {
        for (int i = 0; i < tableTitle.length; i++) {
            mTab.addTab(mTab.newTab().setText(tableTitle[i]));
        }
        mTab.setTabMode(TabLayout.MODE_SCROLLABLE);
        adapter = new ViewpagerAdapter(getSupportFragmentManager(), tableTitle, getList(), this);
        viewPager.setAdapter(adapter);

        //将tabLayout和ViewPager绑定
        mTab.setupWithViewPager(viewPager);
    }

    private List<Fragment> getList() {
        List<Fragment> list = new ArrayList<>();
        topNew = new NewsFragment("top");
        ylNew = new NewsFragment("yule");
        tyNew = new NewsFragment("tiyu");
        ssNew = new NewsFragment("shishang");
        shNew = new NewsFragment("shehui");
        kjNew = new NewsFragment("keji");
        jsNew = new NewsFragment("junshi");
        cjNew = new NewsFragment("caijing");
        gjNew = new NewsFragment("guoji");
        gnNew = new NewsFragment("guonei");
        list.add(topNew);
        list.add(ylNew);
        list.add(tyNew);
        list.add(ssNew);
        list.add(shNew);
        list.add(kjNew);
        list.add(jsNew);
        list.add(cjNew);
        list.add(gjNew);
        list.add(gnNew);
        return list;
    }
}
