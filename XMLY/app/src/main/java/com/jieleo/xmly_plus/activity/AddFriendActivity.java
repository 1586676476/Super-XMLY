package com.jieleo.xmly_plus.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;
import com.jieleo.xmly_plus.R;

/**
 * Created by liuHao on 17/3/21.
 */
public class AddFriendActivity extends BaseActivity {
    private TextView tvAdd;
    private ImageView ivBack;
    private EditText etUser;
    private static final String TAG = "AddFriendActivity";

    @Override
    protected int bindLayout() {
        return R.layout.activity_add_friend;
    }

    @Override
    protected void initView() {
        tvAdd = (TextView) findViewById(R.id.tv_add_add);
        ivBack = (ImageView) findViewById(R.id.iv_back_add_activity);
        etUser = (EditText) findViewById(R.id.et_add_add);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void bindEvent() {
         tvAdd.setOnClickListener(this);
        ivBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_add_add:
                String toAddUsername  = etUser.getText().toString();
                String reason = "111";
                if (!toAddUsername.isEmpty()){
                    //参数为要添加的好友的username和添加理由
                    try {
                        EMClient.getInstance().contactManager().addContact(toAddUsername, reason);
                        setResult(100);
                        finish();
                    } catch (HyphenateException e) {
                        e.printStackTrace();
                        Log.e(TAG, "onClick: "+e.getMessage()+e.getErrorCode() );
                        Toast.makeText(this, "添加失败", Toast.LENGTH_SHORT).show();
                    }
                }
        }
    }
}
