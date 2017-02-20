package com.jhonlee.homenews.view.main;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.bumptech.glide.Glide;
import com.jhonlee.homenews.R;
import com.jhonlee.homenews.util.SharedPreferenceUtil;
import com.jhonlee.homenews.view.benefit.BenefitActivity;
import com.jhonlee.homenews.view.news.NewsFragment;
import com.jhonlee.homenews.view.send.SendActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

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

    private Fragment isFragment;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.tabLayout)
    TabLayout mTab;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.fab)
    FloatingActionButton mFabtn;


    private String[] tableTitle = {"头条", "娱乐", "体育", "时尚", "社会", "科技", "军事", "财经", "国际", "国内"};
    private ViewpagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbar.setTitle("新闻");
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        //initNavigationView();
        initTabTitle();
       // initFragment(savedInstanceState);
        View view = navigationView.getHeaderView(0);
        ImageView ImgTitle = (ImageView)(view).findViewById(R.id.imageView);
        Glide.with(this).load(R.drawable.test).bitmapTransform(new CropCircleTransformation(this)).into(ImgTitle);
    }
    private void initTabTitle() {

        mTab.setTabMode(TabLayout.MODE_SCROLLABLE);
        adapter = new ViewpagerAdapter(getSupportFragmentManager(), tableTitle, getList(), this);
        viewPager.setAdapter(adapter);

        //将tabLayout和ViewPager绑定
        mTab.setupWithViewPager(viewPager);

        mFabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),SendActivity.class));
            }
        });
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
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            //取消提示框
            new AlertDialog.Builder(this)
                    .setMessage("是否退出应用？")
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            }).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (item.getItemId()) {
            case R.id.nav_pic:
                startActivity(new Intent(this,BenefitActivity.class));
                break;
            case R.id.nav_nba:
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void startIntent(Activity activity){
        Intent intent = new Intent(this,activity.getClass());
        startActivity(intent);
    }
}
