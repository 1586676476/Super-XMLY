package com.jieleo.xmly_plus.adapter.hot_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.model.bean.model_hot_page.HotCenterBean;
import com.jieleo.xmly_plus.tools.BaseViewHolder;

/**
 * Created by dllo on 17/3/15.
 */

public class HotBelowItemAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private static final String TAG = "HotBelowItemAdapter";
    private HotCenterBean.HotRecommendsBean.ListBeanXXXXX listBeanXXXXX;
    private Context context;

    public void setHotCenterBean(HotCenterBean.HotRecommendsBean.ListBeanXXXXX listBeanXXXXX) {
        this.listBeanXXXXX = listBeanXXXXX;
        notifyDataSetChanged();
    }

    public HotBelowItemAdapter(Context context) {
        this.context = context;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return BaseViewHolder.onCreatMyViewHolder(context,parent, R.layout.item_rv_fragment_hot_below_item);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {

        holder.setOnLineImage(R.id.item_rv_fragment_hot_below_image,
                listBeanXXXXX.getList().get(position).getAlbumCoverUrl290());
        holder.setText(R.id.item_rv_fragment_hot_below_title,
                listBeanXXXXX.getList().get(position).getTitle());
        holder.setText(R.id.item_rv_fragment_hot_below_content,
                listBeanXXXXX.getList().get(position).getTags());
    }

    @Override
    public int getItemCount() {
        Log.e(TAG, "getItemCount: " +listBeanXXXXX.getList().size());
        return listBeanXXXXX!=null?3:0;
    }
}
