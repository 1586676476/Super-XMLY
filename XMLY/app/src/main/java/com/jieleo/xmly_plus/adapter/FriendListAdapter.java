package com.jieleo.xmly_plus.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.hyphenate.chat.EMConversation;
import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.tools.BaseViewHolder;

import java.util.List;

/**
 * Created by liuHao on 17/3/21.
 */
public class FriendListAdapter extends BaseAdapter{

    private Context context;
    private List<EMConversation> mStringList;

    public FriendListAdapter(Context context) {
        this.context = context;
    }

    public void setStringList(List<EMConversation> stringList) {
        mStringList = stringList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mStringList==null?0:mStringList.size();
    }

    @Override
    public Object getItem(int position) {
        return mStringList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseViewHolder baseViewHolder = BaseViewHolder.onCreatMyListViewHoler(convertView,parent, R.layout.item_friend);
        baseViewHolder.setText(R.id.tv_name_item_friend,mStringList.get(position).conversationId());
        return baseViewHolder.getView();
    }
}
