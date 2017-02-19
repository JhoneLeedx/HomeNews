package com.jhonlee.homenews.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.jhonlee.homenews.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by JhoneLee on 2017/2/17.
 */

public class ItemThreeImgHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_titile)
    protected TextView mTitle;
    @BindView(R.id.tv_time)
    protected TextView mTime;
    @BindView(R.id.tv_auth)
    protected TextView mAuth;
    @BindView(R.id.image_01)
    protected ImageView image01;
    @BindView(R.id.image_02)
    protected ImageView image02;
    @BindView(R.id.image_03)
    protected ImageView image03;
    public ItemThreeImgHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public TextView getmTitle() {
        return mTitle;
    }

    public TextView getmTime() {
        return mTime;
    }

    public TextView getmAuth() {
        return mAuth;
    }

    public ImageView getImage01() {
        return image01;
    }

    public ImageView getImage02() {
        return image02;
    }

    public ImageView getImage03() {
        return image03;
    }
}
