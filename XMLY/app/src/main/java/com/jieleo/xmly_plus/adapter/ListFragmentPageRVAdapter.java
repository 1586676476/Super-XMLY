package com.jieleo.xmly_plus.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.jieleo.xmly_plus.R;

/**
 * Created by liuHao on 17/3/10.
 */
public class ListFragmentPageRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    class MyViewHoler extends RecyclerView.ViewHolder{
        private RecyclerView recyclerView;
        public MyViewHoler(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.rv_item_rv_list);
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
