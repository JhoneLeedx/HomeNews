package com.jhonlee.homenews.view.news;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.bumptech.glide.Glide;
import com.jhonlee.homenews.R;
import com.jhonlee.homenews.pojo.News;
import com.jhonlee.homenews.view.holder.ItemOneImgHolder;
import com.jhonlee.homenews.view.holder.ItemThreeImgHolder;
import com.jhonlee.homenews.view.holder.ItemTwoImgHolder;

import java.util.List;

/**
 * Created by JhoneLee on 2017/2/17.
 */

public class NewsItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<News> newses;
    private NewsListener mListener;

    public NewsItemAdapter(Context mContext, List<News> newses,NewsListener listener) {
        this.mContext = mContext;
        this.newses = newses;
        this.mListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int resId;
        View view;
        RecyclerView.ViewHolder holder = null;

        if (viewType == ItemType.ITEM_TYPE_ONE.ordinal()) {
            resId = R.layout.item_news_oneimg;
            view = LayoutInflater.from(mContext).inflate(resId, parent, false);
            holder = new ItemOneImgHolder(view);
        } else if (viewType == ItemType.ITEM_TYPE_TWO.ordinal()) {
            resId = R.layout.item_news_twoimg;
            view = LayoutInflater.from(mContext).inflate(resId, parent, false);
            holder = new ItemTwoImgHolder(view);
        } else {
            resId = R.layout.item_news_threeimg;
            view = LayoutInflater.from(mContext).inflate(resId, parent, false);
            holder = new ItemThreeImgHolder(view);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final News news = newses.get(position);
        if (holder instanceof ItemOneImgHolder){
            ItemOneImgHolder oneImgHolder = (ItemOneImgHolder)holder;
            oneImgHolder.getmTitle().setText(news.getTitle());
            oneImgHolder.getmAuth().setText(news.getAuthor_name());
            oneImgHolder.getmTime().setText(news.getDate());
            Glide.with(mContext)
                    .load(news.getThumbnail_pic_s())
                    .error(R.drawable.ic_error)
                    .placeholder(R.drawable.defaults)
                    .into(oneImgHolder.getImage01());
        }else if (holder instanceof ItemTwoImgHolder){
            ItemTwoImgHolder twoImgHolder = (ItemTwoImgHolder)holder;
            twoImgHolder.getmTitle().setText(news.getTitle());
            twoImgHolder.getmAuth().setText(news.getAuthor_name());
            twoImgHolder.getmTime().setText(news.getDate());
            Glide.with(mContext)
                    .load(news.getThumbnail_pic_s())
                    .error(R.drawable.ic_error)
                    .placeholder(R.drawable.defaults)
                    .into(twoImgHolder.getImage01());
            Glide.with(mContext)
                    .load(news.getThumbnail_pic_s02())
                    .error(R.drawable.ic_error)
                    .placeholder(R.drawable.defaults)
                    .into(twoImgHolder.getImage02());

        }else {
            ItemThreeImgHolder threeImgHolder = (ItemThreeImgHolder)holder;
            threeImgHolder.getmTitle().setText(news.getTitle());
            threeImgHolder.getmAuth().setText(news.getAuthor_name());
            threeImgHolder.getmTime().setText(news.getDate());
            Glide.with(mContext)
                    .load(news.getThumbnail_pic_s())
                    .error(R.drawable.ic_error)
                    .placeholder(R.drawable.defaults)
                    .into(threeImgHolder.getImage01());
            Glide.with(mContext)
                    .load(news.getThumbnail_pic_s02())
                    .error(R.drawable.ic_error)
                    .placeholder(R.drawable.defaults)
                    .into(threeImgHolder.getImage02());
            Glide.with(mContext)
                    .load(news.getThumbnail_pic_s03())
                    .error(R.drawable.ic_error)
                    .placeholder(R.drawable.defaults)
                    .into(threeImgHolder.getImage03());
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.showNews(news);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newses == null ? 0 : newses.size();
    }

    @Override
    public int getItemViewType(int position) {

        News news = newses.get(position);
        if (news != null) {
            if (news.getThumbnail_pic_s02() == null || news.getThumbnail_pic_s02().equals("")) {
                return ItemType.ITEM_TYPE_ONE.ordinal();
            } else if (news.getThumbnail_pic_s02() != null && !news.getThumbnail_pic_s02().equals("")
                    && (news.getThumbnail_pic_s03() == null || news.getThumbnail_pic_s03().equals(""))) {
                return ItemType.ITEM_TYPE_TWO.ordinal();
            } else {
                return ItemType.ITEM_TYPE_THREE.ordinal();
            }
        }else {
            return  super.getItemViewType(position);
        }
    }

}
