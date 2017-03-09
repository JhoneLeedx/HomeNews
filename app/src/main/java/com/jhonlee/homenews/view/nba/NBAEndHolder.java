package com.jhonlee.homenews.view.nba;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.jhonlee.homenews.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by JhoneLee on 2017/3/9.
 */

public class NBAEndHolder extends RecyclerView.ViewHolder {


    @BindView(R.id.tv_nba_time)
    public TextView tvNbaTime;
    @BindView(R.id.tv_nba_play1)
    public TextView tvNbaPlay1;
    @BindView(R.id.tv_nba_score)
    public TextView tvNbaScore;
    @BindView(R.id.tv_nba_play2)
    public TextView tvNbaPlay2;
    @BindView(R.id.tv_nba_jstj)
    public TextView tvNbaJstj;
    @BindView(R.id.tv_nba_spjj)
    public TextView tvNbaSpjj;

    public NBAEndHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
