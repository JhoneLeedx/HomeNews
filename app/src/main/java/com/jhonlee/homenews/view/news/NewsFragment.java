package com.jhonlee.homenews.view.news;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.jhonlee.homenews.R;
import com.jhonlee.homenews.contract.NewsContract;
import com.jhonlee.homenews.pojo.News;
import com.jhonlee.homenews.presenter.NewsPresenterImpl;
import com.jhonlee.homenews.util.RecyclerViewDivider;
import com.jhonlee.homenews.util.SharedPreferenceUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by JhoneLee on 2017/2/17.
 */

public class NewsFragment extends Fragment implements NewsContract.View,NewsListener {

    @BindView(R.id.recycle)
    protected RecyclerView mRecycle;
    @BindView(R.id.refresh)
    protected SwipeRefreshLayout mRefresh;
    @BindView(R.id.loading)
    protected ProgressBar mLoading;


    private List<News> mList;
    private NewsContract.Presenter presenter;
    private String mType;
    private NewsItemAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    public NewsFragment(String mType) {
        this.mType = mType;
    }

    public NewsFragment() {

    }

    private void initView() {
        if (mType==null)
        mType = SharedPreferenceUtil.getSharedpreference(getContext());
        presenter = new NewsPresenterImpl(this);
        mList = new ArrayList<>();
        adapter = new NewsItemAdapter(getContext(),mList,this);
        presenter.showNews(mType);

        LinearLayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        mRecycle.addItemDecoration(new RecyclerViewDivider(getContext(),LinearLayoutManager.VERTICAL,1,android.R.color.darker_gray));
        mRecycle.setLayoutManager(manager);
        mRecycle.setAdapter(adapter);

        mRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.showNews(mType);
                mRefresh.setRefreshing(false);
            }
        });

    }
    @Override
    public void showError(String error) {
        Toast.makeText(getContext(),error+"dsadsad",Toast.LENGTH_SHORT).show();
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
    public void showNews(List<News> list) {
        if (mList.size()>0){
            mList.clear();
        }
        mList.addAll(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showNews(News news) {
        Intent intent = new Intent(getContext(),NewsDetailActivity.class);
        intent.putExtra("url",news.getUrl());
        intent.putExtra("imgurl",news.getThumbnail_pic_s());
        startActivity(intent);
    }
}
