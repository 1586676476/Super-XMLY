package com.jieleo.xmly_plus.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jieleo.xmly_plus.R;

public class JuNengWanActivity extends BaseActivity {
    private RecyclerView mRecyclerView;
    @Override
    protected int bindLayout() {
        return R.layout.activity_ju_neng_wan;
    }

    @Override
    protected void initView() {
        mRecyclerView=bindView(R.id.rv_activity_ju_neng_wan);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void bindEvent() {

    }

    @Override
    public void onClick(View v) {

    }
}
