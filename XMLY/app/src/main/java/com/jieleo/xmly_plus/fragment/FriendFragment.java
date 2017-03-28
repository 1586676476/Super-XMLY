package com.jieleo.xmly_plus.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.activity.ChatActivity;
import com.jieleo.xmly_plus.adapter.FriendListAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Created by liuHao on 17/3/21.
 */
public class FriendFragment extends BaseFragment {

    private ListView mListView;
    private FriendListAdapter mFriendListAdapter;
    private List<EMConversation> mEMConversationList;
    private static final String TAG = "EMchatActivity";
    private ConversationReciver mConversationReciver;
    @Override
    protected int bindLayout() {
        return R.layout.fragment_friend;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mListView = (ListView) view.findViewById(R.id.list_friend_activity);
        IntentFilter intentFilter = new IntentFilter();
        mConversationReciver = new ConversationReciver();
        getActivity().registerReceiver(mConversationReciver,intentFilter);
    }

    @Override
    protected void initData() {

        //得到好友列表
        mEMConversationList = loadConversationList();

        mFriendListAdapter = new FriendListAdapter(getContext());
        mListView.setAdapter(mFriendListAdapter);
        mFriendListAdapter.setStringList(mEMConversationList);
    }

    @Override
    protected void bindEvent() {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent toChat = new Intent(getActivity(), ChatActivity.class);

                toChat.putExtra("userName",mEMConversationList.get(position).conversationId());
                startActivity(toChat);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getActivity().unregisterReceiver(mConversationReciver);
    }

    protected List<EMConversation> loadConversationList() {
        // get all conversations
        Map<String, EMConversation> conversations = EMClient.getInstance().chatManager().getAllConversations();
        List<Pair<Long, EMConversation>> sortList = new ArrayList<Pair<Long, EMConversation>>();
        /**
         * lastMsgTime will change if there is new message during sorting
         * so use synchronized to make sure timestamp of last message won't change.
         */
        synchronized (conversations) {
            for (EMConversation conversation : conversations.values()) {
                if (conversation.getAllMessages().size() != 0) {
                    sortList.add(new Pair<Long, EMConversation>(conversation.getLastMessage().getMsgTime(), conversation));
                }
            }
        }
        try {
            // Internal is TimSort algorithm, has bug
            sortConversationByLastChatTime(sortList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<EMConversation> list = new ArrayList<EMConversation>();
        for (Pair<Long, EMConversation> sortItem : sortList) {
            list.add(sortItem.second);
        }
        return list;
    }

    private void sortConversationByLastChatTime(List<Pair<Long, EMConversation>> conversationList) {
        Collections.sort(conversationList, new Comparator<Pair<Long, EMConversation>>() {
            @Override
            public int compare(final Pair<Long, EMConversation> con1, final Pair<Long, EMConversation> con2) {

                if (con1.first.equals(con2.first)) {
                    return 0;
                } else if (con2.first.longValue() > con1.first.longValue()) {
                    return 1;
                } else {
                    return -1;
                }
            }

        });
    }

    class ConversationReciver extends BroadcastReceiver{


        @Override
        public void onReceive(Context context, Intent intent) {
            mEMConversationList.clear();
            mEMConversationList = loadConversationList();
            mListView.setAdapter(mFriendListAdapter);
        }
    }
}
