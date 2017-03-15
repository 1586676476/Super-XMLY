package com.jieleo.xmly_plus.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.jieleo.xmly_plus.R;
import com.netease.nimlib.sdk.AbortableFuture;
import com.netease.nimlib.sdk.auth.LoginInfo;

public class LoginActivity extends BaseActivity {
    private ImageView ivBack, ivQQ, ivSina;
    private EditText usernameTv, passwordTv;
    private Button loginBtn;

    private AbortableFuture<LoginInfo> loginRequest;
    private String account, token;

    private String account,token;



    public void doLogin() {
        LoginInfo loginInfo = new LoginInfo(account, token);
        RequestCallback<LoginInfo> callback = new RequestCallback<LoginInfo>() {
            @Override
            public void onSuccess(LoginInfo param) {

            }

            @Override
            public void onFailed(int code) {

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
                usernameTv = bindView(R.id.et_user_name_aty_login);
                passwordTv = bindView(R.id.et_password_aty_login);
                loginBtn = bindView(R.id.btn_login_aty_login);
            }

            @Override
            protected void initData() {


            }

            @Override
            protected void bindEvent() {
                ivBack.setOnClickListener(this);
                ivQQ.setOnClickListener(this);
                ivSina.setOnClickListener(this);
                loginBtn.setOnClickListener(this);
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
                    case R.id.btn_login_aty_login:
                        doLogin();
                        break;
                }
            }

            public void doLogin() {
                String account = usernameTv.getText().toString().toLowerCase();
                String token = passwordTv.getText().toString();
                LoginInfo loginInfo = new LoginInfo(account, token, "04b97284171397f0d6f626e3ae8d047f");
                RequestCallback<LoginInfo> callback = new RequestCallback<LoginInfo>() {
                    @Override
                    public void onSuccess(LoginInfo param) {
                        Toast.makeText(LoginActivity.this, "成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailed(int code) {
                        Toast.makeText(LoginActivity.this, "失败", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onException(Throwable exception) {
                        Toast.makeText(LoginActivity.this, "异常", Toast.LENGTH_SHORT).show();
                    }
                };
                NIMClient.getService(AuthService.class).login(loginInfo).setCallback(callback);
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
            case R.id.btn_login_aty_login:
                break;
        }
    }







        }
    }
}
