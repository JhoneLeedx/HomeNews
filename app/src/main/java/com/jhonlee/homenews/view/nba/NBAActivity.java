package com.jhonlee.homenews.view.nba;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.jhonlee.homenews.R;
import com.jhonlee.homenews.contract.NBAContract;
import com.jhonlee.homenews.pojo.ListBean;
import com.jhonlee.homenews.pojo.NBAToken;
import com.jhonlee.homenews.pojo.Tr;
import com.jhonlee.homenews.presenter.NBAPresenterImpl;
import com.jhonlee.homenews.view.main.ViewpagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by JhoneLee on 2017/3/8.
 */

public class NBAActivity extends AppCompatActivity implements NBAContract.View{

    @BindView(R.id.toolbar_news)
    Toolbar toolbarNews;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    private String[] tableTitle = {"未开赛", "直播中", "已结束"};
    private NBAContract.Presenter presenter;
    private ViewpagerAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nba);
        ButterKnife.bind(this);
        setSupportActionBar(toolbarNews);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//返回按钮
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter = new NBAPresenterImpl(this);
        presenter.showNBANews();
        adapter = new ViewpagerAdapter(getSupportFragmentManager(),tableTitle,getList());

        viewpager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewpager);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home){
            finish();
            overridePendingTransition(R.anim.anim_activity_in, R.anim.anim_activity_out);
        }
        return super.onOptionsItemSelected(item);
    }

    private List<Fragment> getList(){
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new NBAFutureFragment());
        fragments.add(new NBALivingFragment());
        fragments.add(new NBAEndFragment());
        return fragments;
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismisProgress() {

    }

    @Override
    public void showNBANews(NBAToken nbaToken) {
        Message msg = new Message();
        msg.obj = nbaToken.getResult().getTitle();
        handler.sendMessage(msg);
        if (nbaToken.getResult().getList()!=null&&nbaToken.getResult().getList().size()>0) {
            List<Tr> list = new ArrayList<Tr>();
            for (ListBean bean : nbaToken.getResult().getList()) {
                list.addAll(bean.getTr());
            }
        }
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String title = (String) msg.obj;
            toolbarNews.setTitle(title);
        }
    };
}
