package com.jieleo.xmly_plus.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMTextMessageBody;
import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.tools.BaseViewHolder;

import java.util.List;

/**
 * Created by liuHao on 17/3/24.
 */
public class ChatListAdapter extends BaseAdapter {
    private List<EMMessage> messages;
    private Context context;
    private String userName;

    public ChatListAdapter(Context context, String userName) {
        this.context = context;
        this.userName = userName;
    }

    public void setMessages(List<EMMessage> messages) {
        this.messages = messages;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return messages==null?0:messages.size();
    }

    @Override
    public Object getItem(int position) {
        return messages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseViewHolder baseViewHolder = null;
        if (messages.get(position).getFrom().equals(userName)){
            baseViewHolder = BaseViewHolder.onCreatMyListViewHoler(convertView,parent,R.layout.item_receive_chat);
            baseViewHolder.setText(R.id.tv_item_receive,((EMTextMessageBody)(messages.get(position).getBody())).getMessage());
        }else {

            baseViewHolder = BaseViewHolder.onCreatMyListViewHoler(convertView,parent,R.layout.item_send_chat);
            baseViewHolder.setText(R.id.tv_item_left, ((EMTextMessageBody)(messages.get(position).getBody())).getMessage());
        }



        return baseViewHolder.getView();
    }
}
