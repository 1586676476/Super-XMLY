package com.jieleo.xmly_plus.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.amap.api.maps2d.model.Text;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMMessage;
import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.adapter.ChatListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuHao on 17/3/24.
 */
public class ChatActivity extends BaseActivity {
    private TextView tvName,tvImage,tvVideo,tvVoice,tvPaket;
    private ImageView ivLeft,ivRight;
    private EditText mEditText;
    private String userName;
    private ListView mListView;
    private ChatListAdapter mChatListAdapter;
    private List<EMMessage> mMessages;
    private EMMessageListener mMsgListener;
    private static final String TAG = "ChatActivity";
    @Override
    protected int bindLayout() {
        return R.layout.activity_chat;

    }

    @Override
    protected void initView() {
        tvName = (TextView) findViewById(R.id.tv_name_chat);
        ivLeft = (ImageView) findViewById(R.id.iv_left_chat_activity);
        ivRight = (ImageView) findViewById(R.id.iv_right_chat_activity);
        mEditText = (EditText) findViewById(R.id.et_content_chat);
        tvImage = (TextView) findViewById(R.id.tv_image);
        tvVideo = (TextView) findViewById(R.id.tv_video);
        tvVoice = (TextView) findViewById(R.id.tv_voice);
        tvPaket = (TextView) findViewById(R.id.tv_packet);
        mListView = (ListView) findViewById(R.id.list_chat);

    }

    @Override
    protected void initData() {
        mMessages = new ArrayList<>();
        initEMLisener();
        EMClient.getInstance().chatManager().addMessageListener(mMsgListener);
        userName = getIntent().getStringExtra("userName");
        Log.e(TAG, "initData: "+userName );
        EMConversation conversation = EMClient.getInstance().chatManager().getConversation(userName);
        Log.e(TAG, "initData: "+conversation );
        if (conversation!=null){
            mMessages = conversation.getAllMessages();
            Log.e(TAG, "initData: "+conversation.getAllMessages().size() );
        }

        //SDK初始化加载的聊天记录为20条，到顶时需要去DB里获取更多
        //获取startMsgId之前的pagesize条消息，此方法获取的messages SDK会自动存入到此会话                              中，APP中无需再次把获取到的messages添加到会话中
        mChatListAdapter = new ChatListAdapter(this,userName);
        mListView.setAdapter(mChatListAdapter);
        mChatListAdapter.setMessages(mMessages);

    }

    @Override
    protected void bindEvent() {
        ivRight.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_right_chat_activity:
             String s  =  mEditText.getText().toString();
                if (!s.isEmpty()){
                    //创建一条文本消息，content为消息文字内容，toChatUsername为对方用户或者群聊的id，后文皆是如此
                    EMMessage message = EMMessage.createTxtSendMessage(s, userName);
                    //发送消息
                    EMClient.getInstance().chatManager().sendMessage(message);
                    mMessages.add(message);
                    mChatListAdapter.setMessages(mMessages);
                    mListView.setStackFromBottom(true);
                    mEditText.setText("");
                }
                break;

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        记得在不需要的时候移除listener，如在activity的onDestroy()时
        EMClient.getInstance().chatManager().removeMessageListener(mMsgListener);
        Intent i = new Intent("huihua");
        sendBroadcast(i);
    }

    private void initEMLisener(){

        mMsgListener = new EMMessageListener() {

            @Override
            public void onMessageReceived(List<EMMessage> messages) {
                //收到消息
                mMessages.addAll(messages);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mChatListAdapter.setMessages(mMessages);
                    }
                });

            }

            @Override
            public void onCmdMessageReceived(List<EMMessage> messages) {
                //收到透传消息
            }

            @Override
            public void onMessageRead(List<EMMessage> messages) {
                //收到已读回执
            }

            @Override
            public void onMessageDelivered(List<EMMessage> message) {
                //收到已送达回执
            }

            @Override
            public void onMessageChanged(EMMessage message, Object change) {
                //消息状态变动
            }
        };

    }
}
