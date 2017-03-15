package com.jieleo.xmly_plus.adapter.live_adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.adapter.live_adapter.LiveFragmentNormalItemItemRvAdapter;
import com.jieleo.xmly_plus.model.bean.model_live_page.LivePageBean;

import java.util.List;

/**
 * Created by liuHao on 17/3/13.
 */
public class LiveFragmentNormalRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<LivePageBean.NormalBean> normalBean;

    public LiveFragmentNormalRvAdapter(Context context) {
        this.context = context;
    }

    public void setNormalBean(List<LivePageBean.NormalBean> normalBean) {
        this.normalBean = normalBean;
        notifyDataSetChanged();
    }

    class NormalViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        private RecyclerView recyclerView;
        public NormalViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_title_famous_fragment_live);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.rv_item_famous_fragment_live);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        NormalViewHolder normalViewHolder = null;
        if (normalViewHolder==null){
            View view = LayoutInflater.from(context).inflate(R.layout.item_famous_fragment_live,parent,false);
            normalViewHolder = new NormalViewHolder(view);
        }


        return normalViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            NormalViewHolder normalViewHolder = (NormalViewHolder) holder;
        normalViewHolder.textView.setText(normalBean.get(position).getTitle());

            GridLayoutManager gridLayoutManager = new GridLayoutManager(context,3,LinearLayoutManager.VERTICAL,false);
           LiveFragmentNormalItemItemRvAdapter liveFragmentNormalItemItemRvAdapter = new LiveFragmentNormalItemItemRvAdapter(context);
            normalViewHolder.recyclerView.setLayoutManager(gridLayoutManager);
            normalViewHolder.recyclerView.setAdapter(liveFragmentNormalItemItemRvAdapter);
            liveFragmentNormalItemItemRvAdapter.setListBean(normalBean.get(position).getList());
        }



    @Override
    public int getItemCount() {
        return normalBean==null?0:normalBean.size();
    }
}

