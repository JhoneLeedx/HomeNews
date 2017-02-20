package com.jhonlee.homenews.view.send;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jhonlee.homenews.R;
import com.jhonlee.homenews.contract.RobotContract;
import com.jhonlee.homenews.pojo.Message;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by JhoneLee on 2017/2/20.
 */

public class SendAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<Message> messages;

    public SendAdapter(Context mContext, List<Message> messages) {
        this.mContext = mContext;
        this.messages = messages;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        int resId;
        View view ;
        RecyclerView.ViewHolder holder = null;
        switch (viewType){
            case 0:
                resId = R.layout.item_send_right;
                view = LayoutInflater.from(mContext).inflate(resId,parent,false);
                holder = new RightViewHolder(view);
                break;
            case 1:
                resId = R.layout.item_send_left;
                view = LayoutInflater.from(mContext).inflate(resId,parent,false);
                holder = new LeftViewHolder(view);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Message msg = messages.get(position);
        if (holder instanceof LeftViewHolder){
            ((LeftViewHolder)holder).mLeft.setText(msg.getmMessage());
        }else if (holder instanceof RightViewHolder){
            ((RightViewHolder)holder).mRight.setText(msg.getmMessage());
        }
    }

    @Override
    public int getItemCount() {

        return messages.size();
    }

    @Override
    public int getItemViewType(int position) {

        return messages.get(position).getmType();
    }

    protected class LeftViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_left)
        TextView mLeft;

        public LeftViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    protected class RightViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_right)
        TextView mRight;

        public RightViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
