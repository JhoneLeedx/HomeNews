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

public class DoubanAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<DoubanToken.PostsBean> mList;
    private Context mContext;
    private NewsListener listener;

    private static final int TYPE_NORMAL = 0x00;
    private static final int TYPE_FOOTER = 0x02;

    public DoubanAdapter(Context mContext, List<DoubanToken.PostsBean> mList, NewsListener listener) {
        this.mContext = mContext;
        this.mList = mList;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int resId;
        View view;
        RecyclerView.ViewHolder holder = null;
        if (viewType == TYPE_NORMAL) {
            resId = R.layout.item_news_oneimg;
            view = LayoutInflater.from(mContext).inflate(resId, parent, false);
            holder = new ItemOneImgHolder(view);
        } else if (viewType == TYPE_FOOTER) {
            resId = R.layout.list_footer;
            view = LayoutInflater.from(mContext).inflate(resId, parent, false);
            holder = new FooterViewHolder(view);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ItemOneImgHolder) {
            final DoubanToken.PostsBean bean = mList.get(position);
            if (bean != null) {
                ((ItemOneImgHolder) holder).getmTitle().setText(bean.getTitle());
                ((ItemOneImgHolder) holder).getmAuth().setText(bean.getAuthor() == null || bean.getAuthor().equals("") ? "" : bean.getAuthor().getName());
                ((ItemOneImgHolder) holder).getmTime().setText(bean.getDate());
                if (bean.getThumbs().size() > 0) {
                    Glide.with(mContext)
                            .load(bean.getThumbs().get(0).getSmall().getUrl())
                            .error(R.drawable.ic_error)
                            .placeholder(R.drawable.defaults)
                            .into(((ItemOneImgHolder) holder).getImage01());
                } else {
                    ((ItemOneImgHolder) holder).getImage01().setVisibility(View.GONE);
                }
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.showNews(bean);
                    }
                });
            }
        }else {

        }

    }

    @Override
    public int getItemCount() {
        return mList.size()==0?1:mList.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == mList.size()) {
            return TYPE_FOOTER;
        }
            return TYPE_NORMAL;
    }

    private class FooterViewHolder extends RecyclerView.ViewHolder {

        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }
}
