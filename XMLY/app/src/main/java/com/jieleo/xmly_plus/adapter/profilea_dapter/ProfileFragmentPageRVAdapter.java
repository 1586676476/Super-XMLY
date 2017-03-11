package com.jieleo.xmly_plus.adapter.profilea_dapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.adapter.profilea_dapter.ProfileFragmentItemAdapter;
import com.jieleo.xmly_plus.model.bean.model_list_profile.ProfileBean;
import com.jieleo.xmly_plus.tools.BaseViewHolder;
import com.jieleo.xmly_plus.tools.BaseViewHolder;
import com.jieleo.xmly_plus.tools.DemoRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 17/3/11.
 */

public class ProfileFragmentPageRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "ProfileFragmentPageRVAd";
    private Context context;
    private ProfileBean profileBean;
    private static final int HEAD_TYPE = 0;
    private static final int PROGRAM = 1;
    private static final int ANCHOR = 2;

    public void setProfileBean(ProfileBean profileBean) {
        this.profileBean = profileBean;
        notifyDataSetChanged();
    }

    public ProfileFragmentPageRVAdapter(Context context) {

        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEAD_TYPE;
        } else if (position == 1) {
            return PROGRAM;
        } else {
            return ANCHOR;
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //加载不同行布局
        RecyclerView.ViewHolder viewHolder = null;
        if (viewHolder == null) {
            if (viewType == HEAD_TYPE) {
                viewHolder = BaseViewHolder.onCreatMyViewHolder(context, parent, R.layout.item_head_rv_fragment_profile);
            } else if (viewType == PROGRAM) {
                View view = LayoutInflater.from(context).inflate(R.layout.item_rv_fragment_profile, parent, false);
                viewHolder = new ProfilePageViewHolder(view);
            } else {
                View view = LayoutInflater.from(context).inflate(R.layout.item_rv_fragment_profile_anchor, parent, false);
                viewHolder = new ProfileAnchorPageViewHolder(view);
            }
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        int type = getItemViewType(position);
        //加载头布局
        if (type == HEAD_TYPE) {
            BaseViewHolder myViewHolder = (BaseViewHolder) holder;
            myViewHolder.setOnLineImage(R.id.iv_adv_head_fragment_profile, profileBean.getFocusImages().getList().get(position).getPic());
        } else if (type == PROGRAM) {
            //加载节目榜单recycleView
            ProfilePageViewHolder profilePageViewHolder = (ProfilePageViewHolder) holder;
            ProfileFragmentItemAdapter profileFragmentItemAdapter = new ProfileFragmentItemAdapter(context);
            profilePageViewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
            profilePageViewHolder.recyclerView.setAdapter(profileFragmentItemAdapter);
            profileFragmentItemAdapter.setDatasBeen(profileBean);
            Log.e(TAG, "onBindViewHolder1: "+ profileBean);
        } else {
            //加载主播榜单recycleview
            ProfileAnchorPageViewHolder profileAnchorPageViewHolder = (ProfileAnchorPageViewHolder) holder;
            ProfileFragmentItemAnchorAdapter profileFragmentItemAnchorAdapter = new ProfileFragmentItemAnchorAdapter(context);
            profileAnchorPageViewHolder.anchor.setLayoutManager(new LinearLayoutManager(context));
            profileAnchorPageViewHolder.anchor.setAdapter(profileFragmentItemAnchorAdapter);
            profileFragmentItemAnchorAdapter.setDatasBeen(profileBean.getDatas().get(position-1));
            Log.e(TAG, "onBindViewHolder: "+profileBean.getDatas().get(position-1).getCount());
        }

    }

    @Override
    public int getItemCount() {
        return profileBean != null ? profileBean.getDatas().size()+1 : 0;
    }


    class ProfilePageViewHolder extends RecyclerView.ViewHolder {
        private DemoRecyclerView recyclerView;

        public ProfilePageViewHolder(View itemView) {
            super(itemView);
            recyclerView = (DemoRecyclerView) itemView.findViewById(R.id.rv_item_rv_profile_recycleView);
        }
    }

    class ProfileAnchorPageViewHolder extends RecyclerView.ViewHolder {
        private DemoRecyclerView anchor;

        public ProfileAnchorPageViewHolder(View itemView) {
            super(itemView);
            anchor = (DemoRecyclerView) itemView.findViewById(R.id.rv_item_rv_profile_anchor_recycleView);
        }
    }
}
