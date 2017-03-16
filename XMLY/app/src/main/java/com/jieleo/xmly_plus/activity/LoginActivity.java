package com.jieleo.xmly_plus.activity;

import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
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





<<<<<<< HEAD
import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;

public class LoginActivity extends BaseActivity{
    private ImageView ivBack,ivQQ,ivSina;
    private static final String TAG = "LoginActivity";
=======
>>>>>>> f2482c7ab1e7485db37ea03ef32cd1697729cd10

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

                Platform qq = ShareSDK.getPlatform(QQ.NAME);
//回调信息，可以在这里获取基本的授权返回的信息，但是注意如果做提示和UI操作要传到主线程handler里去执行
                qq.setPlatformActionListener(new PlatformActionListener() {

                    @Override
                    public void onError(Platform arg0, int arg1, Throwable arg2) {
                        // TODO Auto-generated method stub
                        arg2.printStackTrace();
                        Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete(Platform arg0, int arg1, HashMap<String, Object> arg2) {
                        // TODO Auto-generated method stub
                        //输出所有授权信息
//                        arg0.getDb().exportData();
                        if (arg1 == Platform.ACTION_USER_INFOR) {
                            PlatformDb platDB = arg0.getDb();//获取数平台数据DB
                            //通过DB获取各种数据
//                            platDB.getToken();
//                            platDB.getUserGender();
//                            platDB.getUserIcon();
//                            platDB.getUserId();


                            SharedPreferences sharedPreferences = getSharedPreferences("login",MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("name",platDB.getUserName());
                            editor.putString("icon",platDB.getUserIcon());

                            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                           finish();
                        }
                    }


                    @Override
                    public void onCancel(Platform arg0, int arg1) {
                        // TODO Auto-generated method stub

                    }
                });
//authorize与showUser单独调用一个即可
                qq.authorize();//单独授权,OnComplete返回的hashmap是空的
                qq.showUser(null);//授权并获取用户信息
//移除授权
                Log.e(TAG, "onClick: "+"111111" );
//weibo.removeAccount(true);
                break;
            case R.id.iv_weibo:
                Platform weibo = ShareSDK.getPlatform(SinaWeibo.NAME);
//回调信息，可以在这里获取基本的授权返回的信息，但是注意如果做提示和UI操作要传到主线程handler里去执行
                weibo.setPlatformActionListener(new PlatformActionListener() {

                    @Override
                    public void onError(Platform arg0, int arg1, Throwable arg2) {
                        // TODO Auto-generated method stub
                        arg2.printStackTrace();
                    }

                    @Override
                    public void onComplete(Platform arg0, int arg1, HashMap<String, Object> arg2) {
                        // TODO Auto-generated method stub
                        //输出所有授权信息
//                        arg0.getDb().exportData();
                        //用户资源都保存到res
//通过打印res数据看看有哪些数据是你想要的
                        if (arg1 == Platform.ACTION_USER_INFOR) {
                            PlatformDb platDB = arg0.getDb();//获取数平台数据DB
                            //通过DB获取各种数据
                            platDB.getToken();
                            platDB.getUserGender();
                            platDB.getUserIcon();
                            platDB.getUserId();
                            platDB.getUserName();
                            Log.e(TAG, "onComplete: "+platDB.getToken()+
                            platDB.getUserGender()+
                            platDB.getUserIcon()+
                            platDB.getUserId()+
                            platDB.getUserName());
                        }
                    }

                    @Override
                    public void onCancel(Platform arg0, int arg1) {
                        // TODO Auto-generated method stub

                    }
                });
//authorize与showUser单独调用一个即可
                weibo.authorize();//单独授权,OnComplete返回的hashmap是空的
                weibo.showUser(null);//授权并获取用户信息
//移除授权
//weibo.removeAccount(true);
                break;
            case R.id.btn_login_aty_login:
                break;
        }
    }



}
