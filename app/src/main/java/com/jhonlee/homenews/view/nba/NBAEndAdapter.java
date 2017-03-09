package com.jhonlee.homenews.view.nba;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.jhonlee.homenews.R;
import com.jhonlee.homenews.pojo.Tr;
import com.jhonlee.homenews.util.DpiOrPxUtil;

import java.util.List;

/**
 * Created by JhoneLee on 2017/3/9.
 */

public class NBAEndAdapter extends RecyclerView.Adapter<NBAEndHolder> {

    private List<Tr> trs;
    private Context mContext;
    private NBAListener listener;

    public NBAEndAdapter(List<Tr> trs, Context mContext,NBAListener listener) {
        this.trs = trs;
        this.mContext = mContext;
        this.listener = listener;
    }

    @Override
    public NBAEndHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_nba,parent,false);
        return new NBAEndHolder(view);
    }

    @Override
    public void onBindViewHolder(NBAEndHolder holder, int position) {
        final Tr tr = trs.get(position);
            holder.tvNbaPlay1.setText(tr.getPlayer1());
            loadPic(tr.getPlayer1logobig(),holder.tvNbaPlay1);
            holder.tvNbaPlay2.setText(tr.getPlayer2());
            loadPic(tr.getPlayer2logobig(),holder.tvNbaPlay2);
            holder.tvNbaTime.setText("NBA常规赛:"+tr.getTime());
            holder.tvNbaScore.setText(tr.getScore());
            holder.tvNbaJstj.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.showUrl(tr.getLink2url());
                }
            });
            holder.tvNbaSpjj.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.showUrl(tr.getLink1url());
                }
            });
    }

    @Override
    public int getItemCount() {
        return trs == null ? 0 : trs.size();
    }

    public void loadPic(String url, final TextView textView){
        Glide.with(mContext)
                .load(url)
                .asBitmap()
                .placeholder(R.drawable.defaults).dontAnimate()
                .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation glideAnimation) {
                        Drawable drawable =new BitmapDrawable(resource);
                        drawable.setBounds(0, 0,resource.getWidth(), resource.getHeight());
                        textView.setCompoundDrawables(null,drawable,null,null);
                    }

                });
    }
}
