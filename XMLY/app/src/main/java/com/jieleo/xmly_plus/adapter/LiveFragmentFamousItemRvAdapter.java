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

import java.util.List;

/**
 * Created by liuHao on 17/3/10.
 */
public class LiveFragmentFamousItemRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<LivePageBean.FamousBean> famousBeen;

    public LiveFragmentFamousItemRvAdapter(Context context) {
        this.context = context;
    }

    public void setFamousBeen(List<LivePageBean.FamousBean> famousBeen) {
        this.famousBeen = famousBeen;
    }

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
        famousViewHolder.textView.setText(famousBeen.get(position).getTitle());
        if (position==4){
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
            LiveFragmentFamousSingerItemRvAdapter liveFragmentFamousSingerItemRvAdapter = new LiveFragmentFamousSingerItemRvAdapter(context);
            famousViewHolder.recyclerView.setLayoutManager(linearLayoutManager);
            famousViewHolder.recyclerView.setAdapter(liveFragmentFamousSingerItemRvAdapter);
            liveFragmentFamousSingerItemRvAdapter.setListBean(famousBeen.get(position).getList());

        }else {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context,3,LinearLayoutManager.VERTICAL,false);
            LiveFragmentFamousItemItemRvAdapter liveFragmentFamousItemItemRvAdapter = new LiveFragmentFamousItemItemRvAdapter(context);
            famousViewHolder.recyclerView.setLayoutManager(gridLayoutManager);
            famousViewHolder.recyclerView.setAdapter(liveFragmentFamousItemItemRvAdapter);
            liveFragmentFamousItemItemRvAdapter.setListBean(famousBeen.get(position).getList());
        }

    }

    @Override
    public int getItemCount() {
        return famousBeen==null?0:famousBeen.size();
    }
}
