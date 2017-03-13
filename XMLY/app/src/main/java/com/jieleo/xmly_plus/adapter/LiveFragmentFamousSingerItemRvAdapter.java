package com.jieleo.xmly_plus.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.model.bean.model_live_page.LivePageBean;
import com.jieleo.xmly_plus.tools.MyViewHolder;

import java.util.List;

/**
 * Created by liuHao on 17/3/10.
 */
public class LiveFragmentFamousSingerItemRvAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private Context context;
    private List<LivePageBean.FamousBean.ListBean> listBean;

    public LiveFragmentFamousSingerItemRvAdapter(Context context) {
        this.context = context;
    }

    public void setListBean(List<LivePageBean.FamousBean.ListBean> listBean) {
        this.listBean = listBean;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        return MyViewHolder.onCreatMyViewHolder(context,parent, R.layout.item_famous_singer_fragment_live);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.setOnLineImage(R.id.iv_singer_item_famous,listBean.get(position).getSmallLogo());
        holder.setText(R.id.tv_name_singer_item,listBean.get(position).getNickname());
        holder.setText(R.id.tv_sounds_count_item," "+listBean.get(position).getTracksCounts());
        holder.setText(R.id.tv_fans_item," "+listBean.get(position).getFollowersCounts());

    }

    @Override
    public int getItemCount() {
        return listBean.size();
    }
}
