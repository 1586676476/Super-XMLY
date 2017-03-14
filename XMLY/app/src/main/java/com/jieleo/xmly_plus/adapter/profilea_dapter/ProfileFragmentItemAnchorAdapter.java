package com.jieleo.xmly_plus.adapter.profilea_dapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.model.bean.model_list_profile.ProfileBean;
import com.jieleo.xmly_plus.tools.BaseViewHolder;

/**
 * Created by dllo on 17/3/11.
 */

public class ProfileFragmentItemAnchorAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private Context context;
    private ProfileBean.DatasBean datasBeen;

    public void setDatasBeen(ProfileBean.DatasBean datasBeen) {
        this.datasBeen = datasBeen;
        notifyDataSetChanged();
    }

    public ProfileFragmentItemAnchorAdapter(Context context) {

        this.context = context;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return BaseViewHolder.onCreatMyViewHolder(context,parent, R.layout.item_rv_item_fragment_rv_anchor);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.setOnLineImage(R.id.item_rv_item_fragment_rv_anchor_image,datasBeen.getList().get(position).getCoverPath());
        holder.setText(R.id.item_rv_item_fragment_rv_anchor_title,datasBeen.getList().get(position).getTitle());
        holder.setText(R.id.item_rv_item_fragment_rv_anchor_firstContent,datasBeen.getList().get(position).getFirstKResults().get(0).getTitle());
    }

    @Override
    public int getItemCount() {
        return datasBeen!=null?datasBeen.getCount():0;
    }
}
