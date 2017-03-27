package com.jieleo.xmly_plus.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;
import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.tools.BaseViewHolder;
import com.jieleo.xmly_plus.tools.Friends;

import java.util.List;

/**
 * Created by liuHao on 17/3/23.
 */
public class ApplyListAdapter extends BaseAdapter {

    private Activity mActivity;
    private List<Friends> mFriendsList;

    public ApplyListAdapter(Activity activity) {
        mActivity = activity;
    }

    public void setFriendsList(List<Friends> friendsList) {
        mFriendsList = friendsList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mFriendsList==null?0:mFriendsList.size();
    }

    @Override
    public Object getItem(int position) {
        return mFriendsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        BaseViewHolder baseViewHolder = BaseViewHolder.onCreatMyListViewHoler(convertView,parent, R.layout.item_list_apply);
        baseViewHolder.setText(R.id.tv_user_apply_activity,mFriendsList.get(position).getUserName());
        baseViewHolder.setText(R.id.tv_reason_apply_activity,mFriendsList.get(position).getReason());
        baseViewHolder.getView(R.id.btn_apply).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    EMClient.getInstance().contactManager().acceptInvitation(mFriendsList.get(position).getUserName());
                    Intent intent = new Intent("tongyi");
                    mActivity.sendBroadcast(intent);
                    Toast.makeText(mActivity, "同意", Toast.LENGTH_SHORT).show();
                } catch (HyphenateException e) {
                    e.printStackTrace();
                }
            }
        });

        return baseViewHolder.getView();
    }
}
