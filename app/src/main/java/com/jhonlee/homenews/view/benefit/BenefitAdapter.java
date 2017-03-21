package com.jhonlee.homenews.view.benefit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.jhonlee.homenews.R;
import com.jhonlee.homenews.pojo.News;
import com.jhonlee.homenews.pojo.ResultBean;
import com.jhonlee.homenews.view.douban.DoubanAdapter;
import com.jhonlee.homenews.view.holder.FooterViewHolder;
import com.jhonlee.homenews.view.holder.ItemBenefitImgHolder;
import com.jhonlee.homenews.view.holder.ItemOneImgHolder;
import com.jhonlee.homenews.view.news.NewsListener;

import java.util.List;

/**
 * Created by JhoneLee on 2017/2/20.
 */

public class BenefitAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

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
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        int resId;
        View view;
        RecyclerView.ViewHolder holder = null;
        if (viewType == 1) {
            resId = R.layout.item_benefit;
            view = LayoutInflater.from(mContext).inflate(resId,parent,false);
            holder = new ItemBenefitImgHolder(view);
        } else if (viewType == 0) {
            resId = R.layout.list_footer;
            view = LayoutInflater.from(mContext).inflate(resId, parent, false);
            holder = new FooterViewHolder(view);
        }
        return holder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (!(holder instanceof FooterViewHolder)){
            final ResultBean bean = list.get(position);
            Glide.with(mContext)
                    .load(bean.getUrl())
                    .placeholder(R.drawable.defaults)
                    .into(((ItemBenefitImgHolder)holder).getmImg());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.showPic(bean);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return list==null?1:list.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == list.size())
            return 0;
        return 1;
    }
    //  解决StaggeredGridLayoutManager占满一行
    @Override
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        int index = holder.getLayoutPosition();
        if (index == 0){
            ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
            if (lp != null
                    && lp instanceof StaggeredGridLayoutManager.LayoutParams)
            {
                StaggeredGridLayoutManager.LayoutParams p =
                        (StaggeredGridLayoutManager.LayoutParams) lp;
                p.setFullSpan(true);
            }
        }
    }
}
