package com.jieleo.xmly_plus.adapter.discover_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidkun.adapter.ViewHolder;
import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.model.bean.model_discover.DisCoverBean;
import com.jieleo.xmly_plus.tools.BaseViewHolder;

/**
 * Created by dllo on 17/3/10.
 */

public class DisCoverAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private DisCoverBean disCoverBean;
    private Context context;

    public final int ONE=0;
    public final int TWO=1;
    public final int THREE=2;
    public final int FOUR=3;
    public final int FIVE=4;

    public void setDisCoverBean(DisCoverBean disCoverBean) {
        this.disCoverBean = disCoverBean;
        notifyDataSetChanged();
    }

    public DisCoverAdapter(Context context) {
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=null;
        ViewHolder holder=null;
        switch (viewType){
            case 0:
                view= LayoutInflater.from(context).inflate(R.layout.discover_recyclerview_item,parent,false);
                holder=new ViewHolder(context,view);
                break;
            case 1:
                view= LayoutInflater.from(context).inflate(R.layout.discover_recyclerview_item,parent,false);
                holder=new ViewHolder(context,view);
                break;
            case 2:
                view= LayoutInflater.from(context).inflate(R.layout.discover_recycleview_item_two,parent,false);
                holder=new ViewHolder(context,view);
                break;
            case 3:
                view= LayoutInflater.from(context).inflate(R.layout.discover_recyclerview_item,parent,false);
                holder=new ViewHolder(context,view);
                break;
            case 4:
                view= LayoutInflater.from(context).inflate(R.layout.discover_recyclerview_item_three,parent,false);
                holder=new ViewHolder(context,view);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            

    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return ONE;
        }else if (position==1){
            return TWO;
        }else if (position==2){
            return THREE;
        }else if (position==3){
            return FOUR;
        }else {
            return FIVE;
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
