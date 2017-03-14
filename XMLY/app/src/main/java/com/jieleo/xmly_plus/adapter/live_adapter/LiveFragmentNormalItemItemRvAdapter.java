package com.jieleo.xmly_plus.adapter.live_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.model.bean.model_live_page.LivePageBean;
import com.jieleo.xmly_plus.tools.BaseViewHolder;

import java.util.List;

/**
 * Created by liuHao on 17/3/10.
 */
public class LiveFragmentNormalItemItemRvAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private Context context;
    private List<LivePageBean.NormalBean.ListBeanX> listBean;

    public LiveFragmentNormalItemItemRvAdapter(Context context) {
        this.context = context;
    }

    public void setListBean(List<LivePageBean.NormalBean.ListBeanX> listBean) {
        this.listBean = listBean;
        notifyDataSetChanged();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return BaseViewHolder.onCreatMyViewHolder(context,parent, R.layout.item_famous_nomal_fragment_live);

    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.setOnLineImage(R.id.iv_normal_famous_item,listBean.get(position).getSmallLogo());
        holder.setText(R.id.tv_name_normal_famous_item,listBean.get(position).getNickname());
        holder.setText(R.id.tv_introduc_normal_famous_item,listBean.get(position).getVerifyTitle());

    }

    @Override
    public int getItemCount() {
        return listBean==null?0:3;
    }
}
