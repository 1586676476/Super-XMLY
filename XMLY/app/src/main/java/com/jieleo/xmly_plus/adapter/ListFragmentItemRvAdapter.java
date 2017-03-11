package com.jieleo.xmly_plus.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.model.bean.model_list_page.ListPageBean;
import com.jieleo.xmly_plus.tools.BaseViewHolder;

import java.util.List;

/**
 * Created by liuHao on 17/3/10.
 */
public class ListFragmentItemRvAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private Context context;
    private List<ListPageBean.ListBean> listBeen;

    public ListFragmentItemRvAdapter(Context context) {
        this.context = context;
    }

    public void setListBeen(List<ListPageBean.ListBean> listBeen) {
        this.listBeen = listBeen;
        notifyDataSetChanged();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return BaseViewHolder.onCreatMyViewHolder(context,parent, R.layout.item_recycler_item_fragment_list);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.setOnLineImage(R.id.iv_icon_item_fragment_list,listBeen.get(position).getCoverPath());
        holder.setText(R.id.tv_icon_item_fragment_list,listBeen.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return listBeen==null?0:listBeen.size();
    }
}
