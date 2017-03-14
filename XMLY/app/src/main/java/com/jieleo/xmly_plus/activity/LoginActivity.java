package com.jieleo.xmly_plus.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.jieleo.xmly_plus.R;

public class LoginActivity extends BaseActivity{
    private ImageView ivBack,ivQQ,ivSina;

    @Override
    protected int bindLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        ivBack = (ImageView) findViewById(R.id.iv_back_login_activity);
        ivQQ = (ImageView) findViewById(R.id.iv_qq);
        ivSina = (ImageView) findViewById(R.id.iv_weibo);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void bindEvent() {
        ivBack.setOnClickListener(this);
        ivQQ.setOnClickListener(this);
        ivSina.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back_login_activity:
                finish();
                break;
            case R.id.iv_qq:
                break;
            case R.id.iv_weibo:
                break;
        }
    }
}
