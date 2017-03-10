package com.jieleo.xmly_plus.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.model.bean.model_live_page.LivePageBean;

/**
 * Created by liuHao on 17/3/10.
 */
public class LiveFragmentFamousItemRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private LivePageBean.FamousBean famousBean;
    class FamousViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        private RecyclerView recyclerView;
        public FamousViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_title_famous_fragment_live);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.rv_item_famous_fragment_live);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        FamousViewHolder famousViewHolder =null;
        if (famousViewHolder==null){
            View view = LayoutInflater.from(context).inflate(R.layout.item_famous_fragment_live,parent,false);
            famousViewHolder = new FamousViewHolder(view);
        }


        return famousViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FamousViewHolder famousViewHolder = (FamousViewHolder) holder;
        famousViewHolder.textView.setText(famousBean.getTitle());
        if (position==4){

        }else {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context,3,LinearLayoutManager.VERTICAL,false);
            LiveFragmentFamousItemItemRvAdapter liveFragmentFamousItemItemRvAdapter = new LiveFragmentFamousItemItemRvAdapter(context);
            famousViewHolder.recyclerView.setLayoutManager(gridLayoutManager);
            famousViewHolder.recyclerView.setAdapter(liveFragmentFamousItemItemRvAdapter);
        }

    }

    @Override
    public int getItemCount() {
        return famousBean==null?0:famousBean.getList().size();
    }
}
