package com.jhonlee.homenews.view.douban;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.jhonlee.homenews.R;
import com.jhonlee.homenews.pojo.DoubanToken;
import com.jhonlee.homenews.view.holder.ItemOneImgHolder;
import com.jhonlee.homenews.view.news.NewsListener;

import java.util.List;

/**
 * Created by JhoneLee on 2017/2/27.
 */

public class DoubanAdapter extends RecyclerView.Adapter<ItemOneImgHolder> {

    private List<DoubanToken.PostsBean> mList;
    private Context mContext;
    private NewsListener listener;

    public DoubanAdapter(Context mContext, List<DoubanToken.PostsBean> mList,NewsListener listener) {
        this.mContext = mContext;
        this.mList = mList;
        this.listener = listener;
    }

    @Override
    public ItemOneImgHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        int resId;
        View view;
        resId = R.layout.item_news_oneimg;
        view = LayoutInflater.from(mContext).inflate(resId, parent, false);
        ItemOneImgHolder holder = new ItemOneImgHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ItemOneImgHolder holder, int position) {
        final DoubanToken.PostsBean bean = mList.get(position);
        if (bean!=null) {
            holder.getmTitle().setText(bean.getAbstractX());
            holder.getmAuth().setText(bean.getAuthor()==null||bean.getAuthor().equals("")?"":bean.getAuthor().getName());
            holder.getmTime().setText(bean.getDate());
            if (bean.getThumbs().size() > 0) {
                Glide.with(mContext)
                        .load(bean.getThumbs().get(0).getSmall().getUrl())
                        .error(R.drawable.ic_error)
                        .placeholder(R.drawable.defaults)
                        .into(holder.getImage01());
            }
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.showNews(bean);
            }
        });
    }
    @Override
    public int getItemCount() {
        return mList==null?0:mList.size();
    }
}
