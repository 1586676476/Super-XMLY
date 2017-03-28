package com.jieleo.xmly_plus.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;
import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.tools.User;

/**
 * Created by liuHao on 17/3/20.
 */
public class EMRegisterActivity extends BaseActivity {
    private Handler mHandler;
    private EditText etName,etPsd;
    private Button registBtn;
    private ImageView ivBack;
    private static final String TAG = "EMRegisterActivity";
    @Override
    protected int bindLayout() {
        return R.layout.activity_em_regist;
    }

    @Override
    protected void initView() {
       etName =  bindView(R.id.et_user_name_aty_em);
       etPsd =  bindView(R.id.et_password_aty_em);
       registBtn =  bindView(R.id.btn_register_aty_em);
       ivBack =  bindView(R.id.iv_back_EM_activity);
    }

    @Override
    protected void initData() {
        mHandler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what==100){

                    Toast.makeText(EMRegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    SharedPreferences sharedPreferences = getSharedPreferences("emlogin",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("isLogin",true);
                    Intent data = new Intent();
                    User user = new User();
                    user.setName(etName.getText().toString());
                    user.setPsd(etPsd.getText().toString());
                    data.putExtra("user",user);
                    setResult(100,data);

                    finish();
                }else if (msg.what==200){
                    Snackbar.make(etName,"注册失败",Snackbar.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }

    @Override
    protected void bindEvent() {
        ivBack.setOnClickListener(this);
        registBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back_EM_activity:
                finish();
                break;
            case R.id.btn_register_aty_em:
                final String username = etName.getText().toString();
                final String pwd = etPsd.getText().toString();
                if (username.isEmpty()||pwd.isEmpty()){
                    Snackbar.make(etName,"用户名和密码不能为空",Snackbar.LENGTH_SHORT).show();
                    Log.e(TAG, "run: "+"用户名和密码不能为空" );
//                    Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                }
                else {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            //注册失败会抛出HyphenateException
                            try {
                                EMClient.getInstance().createAccount(username, pwd);//同步方法
                                Log.e(TAG, "run: "+"注册成功" );
                                mHandler.sendEmptyMessage(100);

                                        Log.e(TAG, "run: "+"注册成功" );

                            } catch (HyphenateException e) {
                                e.printStackTrace();
                                Log.e(TAG, "run: "+e.getMessage()+e.getErrorCode());
                                Message message = new Message();
                                message.what=200;
                                message.obj = e.getMessage();
                                mHandler.sendMessage(message);
                            }
                        }
                    }).start();

                }
                break;
        }
    }


}
