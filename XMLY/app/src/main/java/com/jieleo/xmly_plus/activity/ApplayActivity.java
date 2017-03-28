package com.jieleo.xmly_plus.activity;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.hyphenate.EMContactListener;
import com.hyphenate.chat.EMClient;
import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.adapter.ApplyListAdapter;
import com.jieleo.xmly_plus.tools.Friends;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuHao on 17/3/23.
 */
public class ApplayActivity extends BaseActivity {
    private ListView mListView;
    private ApplyListAdapter mApplyListAdapter;
    private ImageView ivBack;
    private List<Friends> mFriendsList;
    private static final String TAG = "ApplayActivity";
    @Override
    protected int bindLayout() {
        return R.layout.activity_apply;
    }

    @Override
    protected void initView() {
        mListView = (ListView) findViewById(R.id.list_apply);
        ivBack = (ImageView) findViewById(R.id.iv_back_apply_activity);
    }
    @Override
    protected void initData() {
        mFriendsList = getIntent().getParcelableArrayListExtra("shenqing");
        mApplyListAdapter = new ApplyListAdapter(this);
        mListView.setAdapter(mApplyListAdapter);
        mApplyListAdapter.setFriendsList(mFriendsList);

    }

    @Override
    protected void bindEvent() {
        ivBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back_apply_activity:
                finish();
                break;
        }
    }

}
