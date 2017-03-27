package com.jieleo.xmly_plus.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hyphenate.EMContactListener;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;
import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.activity.AddFriendActivity;
import com.jieleo.xmly_plus.activity.ApplayActivity;
import com.jieleo.xmly_plus.activity.ChatActivity;
import com.jieleo.xmly_plus.adapter.search_adapter.ContactListAdapter;
import com.jieleo.xmly_plus.fragment.BaseFragment;
import com.jieleo.xmly_plus.tools.Friends;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by liuHao on 17/3/21.
 */
public class ContactFragment extends BaseFragment implements View.OnClickListener {

    private static final String TAG = "ContactFragment";
    private List<String> mUsernames;
    private ListView mListView;
    private ContactListAdapter mContactListAdapter;
    private TextView tvAdd,tvNum,tvApply;
    private MyReceiver mMyReceiver;
    private RelativeLayout mRelativeLayout;
    private ArrayList<Friends> mFriendses;
    private Handler mHandler;
    @Override
    protected int bindLayout() {
        return R.layout.fragment_contact;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mMyReceiver = new MyReceiver();
        IntentFilter intentFilter = new IntentFilter("tongyi");
        getActivity().registerReceiver(mMyReceiver,intentFilter);


        mRelativeLayout = (RelativeLayout) view.findViewById(R.id.rela_contact_fragment);
        tvAdd = (TextView) view.findViewById(R.id.tv_add_contact);
        mListView = (ListView) view.findViewById(R.id.list_contact);
        tvNum = (TextView) view.findViewById(R.id.tv_num_contact);
        tvApply = (TextView) view.findViewById(R.id.tv_apply);
    }

    @Override
    protected void initData() {
        mFriendses = new ArrayList<>();

        mHandler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what==100){
                    mUsernames = new ArrayList<>();
                    mUsernames = (List<String>) msg.obj;
                    Log.e(TAG, "handleMessage: "+mUsernames.size() );
                    mContactListAdapter.setStringList(mUsernames);
                }

                return false;
            }
        });


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    Message message = Message.obtain();
                    message.obj=EMClient.getInstance().contactManager().getAllContactsFromServer();
                    message.what=100;
                    mHandler.sendMessage(message);
                } catch (HyphenateException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        mContactListAdapter = new ContactListAdapter(getContext());
        mListView.setAdapter(mContactListAdapter);

        EMContactListener();


    }

    @Override
    protected void bindEvent() {
        tvAdd.setOnClickListener(this);
        mRelativeLayout.setOnClickListener(this);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent toChat = new Intent(getActivity(), ChatActivity.class);
                toChat.putExtra("userName",mUsernames.get(position));
                startActivity(toChat);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getActivity().unregisterReceiver(mMyReceiver);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_add_contact:
                Intent intent = new Intent(getActivity(),AddFriendActivity.class);
                startActivityForResult(intent,100);
                break;
            case R.id.rela_contact_fragment:
                Intent toApply = new Intent(getActivity(),ApplayActivity.class);
                toApply.putExtra("shenqing",mFriendses);
                startActivity(toApply);
                break;
        }
    }

   private void EMContactListener(){
       EMClient.getInstance().contactManager().setContactListener(new EMContactListener() {
           @Override
           public void onContactAdded(String s) {
                //增加了联系人
               Log.e(TAG, "onContactAdded:增加了联系人 "+ s);

           }

           @Override
           public void onContactDeleted(String s) {
                //被删除
               Log.e(TAG, "onContactAdded:被删除 "+ s);
           }

           @Override
           public void onContactInvited(final String s, final String s1) {
                //收到好友邀请
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                            if (s != null && s1 != null){
                                tvApply.setText("  1");
                            }



                    }
                });

               Friends friends = new Friends();
               friends.setUserName(s);
               friends.setReason(s1);
               mFriendses.add(friends);
               Log.e(TAG, "onContactInvited: 收到好友邀请"+s+s1);

           }

           @Override
           public void onFriendRequestAccepted(String s) {
               //好友请求被同意
               Log.e(TAG, "onContactAdded:好友请求被同意 "+ s);
           }

           @Override
           public void onFriendRequestDeclined(String s) {
               //好友请求被拒绝
               Log.e(TAG, "onContactAdded:好友请求被拒绝 "+ s);
           }
       });

   }
   class MyReceiver extends BroadcastReceiver{

       @Override
       public void onReceive(Context context, Intent intent) {
          new Thread(new Runnable() {
              @Override
              public void run() {
                  try {
                      Message message = Message.obtain();
                      message.obj=EMClient.getInstance().contactManager().getAllContactsFromServer();
                      message.what=100;
                      mHandler.sendMessage(message);

                  } catch (HyphenateException e) {
                      e.printStackTrace();
                      Log.e(TAG, "onReceive: "+e.getMessage()+e.getErrorCode() );
                  }
              }
          }).start();


       }
   }
}
