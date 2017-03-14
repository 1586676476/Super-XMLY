package com.jieleo.xmly_plus.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.jieleo.xmly_plus.R;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.auth.AuthService;
import com.netease.nimlib.sdk.auth.LoginInfo;

public class LoginActivity extends BaseActivity{
    private ImageView ivBack,ivQQ,ivSina;

    private String account,token;

//
    public void doLogin(){
        LoginInfo loginInfo =new LoginInfo(account,token);
        RequestCallback<LoginInfo> callback=new RequestCallback<LoginInfo>() {
            @Override
            public void onSuccess(LoginInfo param) {

            }

            @Override
            public void onFailed(int code) {

            }

            @Override
            public void onException(Throwable exception) {

            }
        };
        NIMClient.getService(AuthService.class).login(loginInfo).setCallback(callback);
    }

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
