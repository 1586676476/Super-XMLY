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

public class LoginActivity extends BaseActivity{
    private ImageView ivBack,ivQQ,ivSina;
    private EditText usernameTv, passwordTv;
    private Button loginBtn;
    private String account,token;

//


//

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
                break;
        }
    }






}
