package com.jhonlee.homenews.view.nba;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.jhonlee.homenews.R;
import com.jhonlee.homenews.contract.NBAContract;
import com.jhonlee.homenews.pojo.ListBean;
import com.jhonlee.homenews.pojo.NBAToken;
import com.jhonlee.homenews.pojo.Tr;
import com.jhonlee.homenews.presenter.NBAPresenterImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by JhoneLee on 2017/3/9.
 */

public class NBALivingFragment extends Fragment implements NBAContract.View, NBAListener {

    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;
    @BindView(R.id.loading)
    ProgressBar loading;
    @BindView(R.id.tv_nothing)
    TextView tvNothing;

    private NBAContract.Presenter presenter;
    private List<Tr> mList;
    private NBAEndAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_nba_liveing, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {

        presenter = new NBAPresenterImpl(this);
        mList = new ArrayList<>();
        adapter = new NBAEndAdapter(mList, getContext(), this);
        presenter.showNBANews();

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        // recycle.addItemDecoration(new RecyclerViewDivider(getContext(),LinearLayoutManager.VERTICAL,1,android.R.color.darker_gray));
        recycle.setLayoutManager(manager);
        recycle.setAdapter(adapter);

        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.showNBANews();
                refresh.setRefreshing(false);
            }
        });

    }

    @Override
    public void showError(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismisProgress() {
        loading.setVisibility(View.GONE);
    }

    @Override
    public void showNBANews(NBAToken nab) {

        //Message msg = new Message();

        if (nab.getResult().getList() != null && nab.getResult().getList().size() > 0) {
            List<Tr> list = new ArrayList<Tr>();
            for (ListBean bean : nab.getResult().getList()) {
                for (Tr tr : bean.getTr()) {
                    if (tr.getStatus() == 1) {
                        list.add(tr);
                    }
                }

            }
            mList.clear();
            mList.addAll(list);
            if (mList.size() > 0) {
                //msg.what = 0;
                handler.sendEmptyMessage(0);
            }
            adapter.notifyDataSetChanged();
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                tvNothing.setVisibility(View.GONE);
            }else {
                tvNothing.setVisibility(View.VISIBLE);
            }
        }
    };

    @Override
    public void showUrl(String url) {
        Toast.makeText(getContext(), url, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getContext(),NBADetailActivity.class);
        intent.putExtra("url",url);
        // intent.putExtra("imgurl",((News)news).getThumbnail_pic_s());
        startActivity(intent);
    }
}
