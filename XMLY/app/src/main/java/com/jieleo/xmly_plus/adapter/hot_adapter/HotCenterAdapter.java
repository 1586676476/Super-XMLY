package com.jieleo.xmly_plus.adapter.hot_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.model.bean.model_hot_page.HotCenterBean;
import com.jieleo.xmly_plus.tools.BaseViewHolder;

/**
 * Created by dllo on 17/3/13.
 */

public class HotCenterAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private static final String TAG = "HotCenterAdapter";
    private HotCenterBean hotCenterBean;
    private Context context;

    public void setHotCenterBean(HotCenterBean hotCenterBean) {
        this.hotCenterBean = hotCenterBean;
        notifyDataSetChanged();
    }

    public HotCenterAdapter(Context context) {

        this.context = context;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return BaseViewHolder.onCreatMyViewHolder(context,parent, R.layout.item_rv_fragment_hot);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.setOnLineImage(R.id.item_rv_fragment_hot_image,hotCenterBean.getDiscoveryColumns().getList().get(position).getCoverPath());
        holder.setText(R.id.item_rv_fragment_hot_text,hotCenterBean.getDiscoveryColumns().getList().get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return hotCenterBean!=null?hotCenterBean.getDiscoveryColumns().getList().size():0;
    }
}
