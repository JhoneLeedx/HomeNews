package com.jhonlee.homenews.view.benefit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jhonlee.homenews.R;
import com.jhonlee.homenews.contract.GankContract;
import com.jhonlee.homenews.pojo.ResultBean;
import com.jhonlee.homenews.presenter.GankPresenterImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by JhoneLee on 2017/2/20.
 * @author JhoneLee
 */

public class BenefitActivity extends AppCompatActivity implements GankContract.View,BenefitListener{


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;
    @BindView(R.id.loading)
    ProgressBar mLoading;

    private GankContract.Presenter presenter;
    private List<ResultBean> mList;
    private BenefitAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benefit);
        ButterKnife.bind(this);
        toolbar.setTitle("福利");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//返回按钮
        initView();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                overridePendingTransition(R.anim.anim_activity_left_in, R.anim.anim_activity_left_out);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
    private void initView(){
        presenter = new GankPresenterImpl(this,this);
        presenter.showPic(20);
        mList = new ArrayList<>();
        adapter = new BenefitAdapter(this,mList,this);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recycle.setLayoutManager(manager);
       // recycle.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recycle.setAdapter(adapter);
        recycle.setItemAnimator(new DefaultItemAnimator());
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.showPic(20);
                refresh.setRefreshing(false);
            }
        });

        recycle.setOnScrollListener(new RecyclerView.OnScrollListener() {
            boolean isSlidingToLast = false;
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                StaggeredGridLayoutManager manager = (StaggeredGridLayoutManager) recyclerView.getLayoutManager();
                // 当不滚动时
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    // 获取最后一个完全显示的item position
                    int column = manager.getColumnCountForAccessibility(null,null);
                    int[] positions = new int[column];
                    manager.findLastCompletelyVisibleItemPositions(positions);

                    for (int i =0;i<positions.length;i++){
                        if (positions[i]>=manager.getItemCount()-column
                                && manager.findViewByPosition(positions[i]).getBottom()<=
                                manager.getHeight()){
                           // Log.d("log","到底了");
                            presenter.showMorePic(20);
                            break;
                        }
                    }
                }
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }
    @Override
    public void showError(String error) {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show();
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
    public void showPic(List<ResultBean> list) {
        if (mList!=null&&mList.size()>0){
            mList.clear();
            }
        if (list.size()>0){
            mList.addAll(list);
            adapter.notifyDataSetChanged();
        }
    }
    @Override
    public void showMorePic(List<ResultBean> list) {
        if (list!=null&&list.size()>0){
            mList.addAll(list);
            adapter.notifyDataSetChanged();
        }

    }

    @Override
    public void showPic(ResultBean resultBean) {
        Intent intent = new Intent(this,BenefitDetailActivity.class);
        intent.putExtra("url",resultBean.getUrl());
        intent.putExtra("author",resultBean.getWho());
        startActivity(intent);
        overridePendingTransition(R.anim.anim_activity_right_in,R.anim.anim_activity_right_out);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter!=null)
            presenter = null;
    }
}
