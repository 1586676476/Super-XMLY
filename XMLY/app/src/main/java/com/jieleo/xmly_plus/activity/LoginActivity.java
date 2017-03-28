package com.jieleo.xmly_plus.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.jieleo.xmly_plus.MyApp;
import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.tools.SPUtils;
import com.jieleo.xmly_plus.tools.User;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;

public class LoginActivity extends BaseActivity {
    private static final String TAG = "LoginActivity";
    private ImageView ivBack, ivQQ, ivSina;
    private EditText etUsername, etPassword;
    private Button loginBtn;
    private String account, token;
    private TextView mTextView;
    private FinishBroadCastReciver mReciver;


        @Override
        protected int bindLayout() {
            return R.layout.activity_login;
        }

        @Override
        protected void initView() {
            ivBack = (ImageView) findViewById(R.id.iv_back_login_activity);
            ivQQ = (ImageView) findViewById(R.id.iv_qq);
            ivSina = (ImageView) findViewById(R.id.iv_weibo);
            etUsername = bindView(R.id.et_user_name_aty_login);
            etPassword = bindView(R.id.et_password_aty_login);
            loginBtn = bindView(R.id.btn_login_aty_login);
            findViewById(R.id.tv_to_register_aty_login).setOnClickListener(this);
        }

        @Override
        protected void initData() {
            mReciver=new FinishBroadCastReciver();
            IntentFilter intentFilter=new IntentFilter("finish");
            registerReceiver(mReciver,intentFilter);

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


                                SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("name", platDB.getUserName());
                                editor.putString("icon", platDB.getUserIcon());

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
                                Log.e(TAG, "onComplete: " + platDB.getToken() +
                                        platDB.getUserGender() +
                                        platDB.getUserIcon() +
                                        platDB.getUserId() +
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

                    String userName= etUsername.getText().toString();
                    String password = etPassword.getText().toString();
                    EMClient.getInstance().login(userName,password,new EMCallBack() {//回调
                        @Override
                        public void onSuccess() {
                            EMClient.getInstance().groupManager().loadAllGroups();
                            EMClient.getInstance().chatManager().loadAllConversations();
                            Log.d("main", "登录聊天服务器成功！");
                            Intent intent = new Intent(LoginActivity.this,EMchatActivity.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onProgress(int progress, String status) {

                        }

                        @Override
                        public void onError(int code, String message) {
                            Log.d("main", "登录聊天服务器失败！");
                        }
                    });





                    break;

                case R.id.tv_to_register_aty_login:
//                    Intent intent =new Intent(this,RegisterActivity.class);
//                    if (!etUsername.getText().toString().isEmpty()){
//                        SPUtils.put(MyApp.getContext(),"phoneNum",etUsername.getText().toString());
//                    }else {
//                    SPUtils.put(MyApp.getContext(),"phoneNum","");
//                    }
//                    startActivity(intent);
                    Intent intent = new Intent(this,EMRegisterActivity.class);
                    startActivityForResult(intent,100);
                    break;
            }
        }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReciver);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==100&& resultCode ==100){
            User user = data.getParcelableExtra("user");
            if (!user.getName().isEmpty()&&!user.getPsd().isEmpty()){
                etUsername.setText(user.getName());
                etPassword.setText(user.getPsd());
            }

        }
    }

    class FinishBroadCastReciver extends BroadcastReceiver{

            @Override
            public void onReceive(Context context, Intent intent) {
                finish();
            }
        }

}


