package com.jieleo.xmly_plus.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.model.bean.model_live_page.LivePageBean;

/**
 * Created by liuHao on 17/3/10.
 */
public class LiveFragmentPageRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private LivePageBean livePageBean;
    class LiveViewHolder extends RecyclerView.ViewHolder{
        private RecyclerView recyclerView;
        public LiveViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.rv_item_rv_live);
        }
    }

    public LiveFragmentPageRvAdapter(Context context) {
        this.context = context;
    }

    public void setLivePageBean(LivePageBean livePageBean) {
        this.livePageBean = livePageBean;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LiveViewHolder liveViewHolder = null;
        if (liveViewHolder==null){
            View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_fragment_live,parent,false);
            liveViewHolder = new LiveViewHolder(view);
        }


        return liveViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        LiveViewHolder liveViewHolder = (LiveViewHolder) holder;
        if (position==0){

        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
