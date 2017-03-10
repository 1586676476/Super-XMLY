package com.jieleo.xmly_plus.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.model.bean.model_list_profile.ProfileBean;
import com.jieleo.xmly_plus.tools.MyViewHolder;

/**
 * Created by dllo on 17/3/10.
 */

public class ProfileAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private ProfileBean profileBean;
    protected Context context;

    public void setProfileBean(ProfileBean profileBean) {
        this.profileBean = profileBean;
    }

    public ProfileAdapter(Context context) {

        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return MyViewHolder.onCreatMyViewHolder(context,parent, R.layout.profile_recycleview_item);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
