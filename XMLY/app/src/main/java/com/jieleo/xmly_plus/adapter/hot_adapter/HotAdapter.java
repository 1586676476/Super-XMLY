package com.jieleo.xmly_plus.adapter.hot_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.jieleo.xmly_plus.tools.BaseViewHolder;

/**
 * Created by dllo on 17/3/13.
 */

public class HotAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;

    public HotAdapter(Context context) {
        this.context = context;
    }

    private int HEAD=0;
    private int CENTER=1;
    private int BLOW=2;


    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return HEAD;
        }else if (position==1){
            return CENTER;
        }else {
            return BLOW;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
