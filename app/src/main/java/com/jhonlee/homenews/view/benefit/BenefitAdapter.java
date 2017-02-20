package com.jhonlee.homenews.view.benefit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.jhonlee.homenews.R;
import com.jhonlee.homenews.pojo.News;
import com.jhonlee.homenews.pojo.ResultBean;
import com.jhonlee.homenews.view.holder.ItemBenefitImgHolder;
import com.jhonlee.homenews.view.news.NewsListener;

import java.util.List;

/**
 * Created by JhoneLee on 2017/2/20.
 */

public class BenefitAdapter extends RecyclerView.Adapter<ItemBenefitImgHolder> {

    private Context mContext;
    private List<ResultBean> list;
    private BenefitListener listener;

    public BenefitAdapter(Context mContext, List<ResultBean> been) {
        this.mContext = mContext;
        this.list = been;
    }

    public BenefitAdapter(Context mContext, List<ResultBean> list, BenefitListener listener) {
        this.mContext = mContext;
        this.list = list;
        this.listener = listener;
    }

    @Override
    public ItemBenefitImgHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int resId = R.layout.item_benefit;
        View view = LayoutInflater.from(mContext).inflate(resId,parent,false);
        ItemBenefitImgHolder holder = new ItemBenefitImgHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ItemBenefitImgHolder holder, int position) {
        final ResultBean bean = list.get(position);
        Glide.with(mContext)
                .load(bean.getUrl())
                .placeholder(R.drawable.defaults)
                .into(holder.getmImg());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.showPic(bean);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }
}
