package com.jhonlee.homenews.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.jhonlee.homenews.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by JhoneLee on 2017/2/20.
 */

public class ItemBenefitImgHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.item_img)
    ImageView mImg;

    public ItemBenefitImgHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public ImageView getmImg() {
        return mImg;
    }
}
