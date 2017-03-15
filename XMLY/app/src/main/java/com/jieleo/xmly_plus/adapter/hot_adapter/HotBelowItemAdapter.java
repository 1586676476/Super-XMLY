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
    private HotCenterBean hotCenterBean;
    private Context context;

    public void setHotCenterBean(HotCenterBean hotCenterBean) {
        this.hotCenterBean = hotCenterBean;
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
                hotCenterBean.getHotRecommends().getList().get(0).getList().get(position).getAlbumCoverUrl290());
        holder.setText(R.id.item_rv_fragment_hot_below_text,
                hotCenterBean.getHotRecommends().getList().get(position).getTitle());
        holder.setText(R.id.item_rv_fragment_hot_below_title,
                hotCenterBean.getHotRecommends().getList().get(0).getList().get(position).getTitle());
        holder.setText(R.id.item_rv_fragment_hot_below_content,
                hotCenterBean.getHotRecommends().getList().get(0).getList().get(position).getTags());
    }

    @Override
    public int getItemCount() {
        Log.e(TAG, "getItemCount: " );
        return hotCenterBean!=null?3:0;
    }
}
