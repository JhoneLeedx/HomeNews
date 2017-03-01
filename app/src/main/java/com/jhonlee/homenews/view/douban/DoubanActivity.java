package com.jhonlee.homenews.view.douban;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jhonlee.homenews.R;
import com.jhonlee.homenews.contract.DoubanContract;
import com.jhonlee.homenews.pojo.DoubanToken;
import com.jhonlee.homenews.presenter.DoubanPresenterImpl;
import com.jhonlee.homenews.view.news.NewsDetailActivity;
import com.jhonlee.homenews.view.news.NewsListener;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by JhoneLee on 2017/2/27.
 */

public class DoubanActivity extends AppCompatActivity implements DoubanContract.View, NewsListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;
    @BindView(R.id.loading)
    ProgressBar mLoading;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    private DoubanContract.Presenter presenter;
    private List<DoubanToken.PostsBean> mList;
    private DoubanAdapter adapter;

    private int mYear = Calendar.getInstance().get(Calendar.YEAR);
    private int mMonth = Calendar.getInstance().get(Calendar.MONTH);
    private int mDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_douban);
        ButterKnife.bind(this);
        toolbar.setTitle("豆瓣一刻");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//返回按钮
    }

    @Override
    protected void onStart() {
        super.onStart();
        initView();
    }

    private void initView() {
        presenter = new DoubanPresenterImpl(this,this);
        final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        presenter.showNews(format.format(Calendar.getInstance().getTimeInMillis()));
        mList = new ArrayList<>();
        adapter = new DoubanAdapter(this, mList, this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recycle.setLayoutManager(manager);
        //recycle.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recycle.setAdapter(adapter);
        recycle.setItemAnimator(new DefaultItemAnimator());
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.showNews(format.format(Calendar.getInstance().getTimeInMillis()));
                refresh.setRefreshing(false);
            }
        });
        //recyclerview 滑动到底部时监听事件
        recycle.setOnScrollListener(new RecyclerView.OnScrollListener() {

            boolean isSlidingToLast = false;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

                LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
                // 当不滚动时
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    // 获取最后一个完全显示的item position
                    int lastVisibleItem = manager.findLastCompletelyVisibleItemPosition();
                    int totalItemCount = manager.getItemCount();

                    // 判断是否滚动到底部并且是向下滑动
                    if (lastVisibleItem == (totalItemCount - 1) && isSlidingToLast) {
                        Calendar c = Calendar.getInstance();
                        c.set(mYear, mMonth, --mDay);
                         presenter.showMoreNews(new SimpleDateFormat("yyyy-MM-dd").format(c.getTimeInMillis()));
                    }
                }

                super.onScrollStateChanged(recyclerView, newState);
            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                isSlidingToLast = dy > 0;

                // 隐藏或者显示fab
                if(dy > 0) {
                    fab.hide();
                } else {
                    fab.show();
                }
            }
        });
    }

    @OnClick(R.id.fab)
    public void fabClick() {
        Calendar now = Calendar.getInstance();
        now.set(mYear, mMonth, mDay);
        DatePickerDialog dialog = DatePickerDialog.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
                mYear = year;
                mMonth = monthOfYear;
                mDay = dayOfMonth;
                Calendar temp = Calendar.getInstance();
                temp.clear();
                temp.set(year, monthOfYear, dayOfMonth);
                presenter.showNews(new SimpleDateFormat("yyyy-MM-dd").format(temp.getTimeInMillis()));
            }
        }, now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));
        dialog.setMaxDate(Calendar.getInstance());
        Calendar minDate = Calendar.getInstance();
        // 2013.5.20是知乎日报api首次上线
        minDate.set(2013, 5, 20);
        dialog.setMinDate(minDate);
        dialog.vibrate(false);

        dialog.show(getFragmentManager(), "DatePickerDialog");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        mLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismisProgress() {
        mLoading.setVisibility(View.GONE);
    }


    @Override
    public void showNews(List<DoubanToken.PostsBean> list) {
        if (mList.size() > 0) {
            mList.clear();
        }
        if (list.size()>0){
            mList.addAll(list);
            adapter.notifyDataSetChanged();
        }

    }

    @Override
    public void showMoreNews(List<DoubanToken.PostsBean> list) {
        if (list!=null&&list.size()>0){
            mList.addAll(list);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showNews(Object news) {
        Intent intent = new Intent(this, NewsDetailActivity.class);

        intent.putExtra("url", ((DoubanToken.PostsBean) news).getUrl());
        intent.putExtra("imgurl", ((DoubanToken.PostsBean) news).getThumbs().size() == 0 ? "" : ((DoubanToken.PostsBean) news).getThumbs().get(0).getLarge().getUrl());
        startActivity(intent);
    }
}
