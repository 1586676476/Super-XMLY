package com.jieleo.xmly_plus.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.adapter.RegisterFragmentAdapter;
import com.jieleo.xmly_plus.custromview.MyViewPage;
import com.jieleo.xmly_plus.fragment.register.PhoneNumFragment;
import com.jieleo.xmly_plus.fragment.register.RegisterCodeFeagment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

/**
 * Created by jie on 2017/3/17.
 */

public class RegisterActivity extends BaseActivity implements PhoneNumFragment.MoveToNext, RegisterCodeFeagment.MoveToFirst {
    private MyViewPage mViewPager;
    private List<Fragment>  mFragments;
    private RegisterFragmentAdapter mFragmentAdapter;
    private EventHandler mEventHandler;


    Handler mHandler =new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.arg2==SMSSDK.RESULT_COMPLETE){
                //完成回掉
                if (msg.arg1==SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE){
                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    Log.d("RegisterActivity", "提交验证码成功");
                    sendBroadcast(new Intent("finish"));
                    finish();
                    //提交验证码成功
                }else if (msg.arg1==SMSSDK.EVENT_GET_VERIFICATION_CODE){
                    Toast.makeText(RegisterActivity.this, "获取验证码成功", Toast.LENGTH_SHORT).show();
                    //获取验证码成功
                }else if (msg.arg1== SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES){
                    //返回支持的国家的列表
                    ArrayList<HashMap<String ,Object>>   maps= (ArrayList<HashMap<String, Object>>) msg.obj;

                }
            }
            return false;
        }
    });
    private PhoneNumFragment mPhoneNumFragment;
    private RegisterCodeFeagment mRegisterCodeFeagment;

    @Override
    protected int bindLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        mViewPager= (MyViewPage) findViewById(R.id.vp_aty_register);
    }

    @Override
    protected void initData() {



        mFragments=new ArrayList<>();
        mPhoneNumFragment = new PhoneNumFragment();
        mRegisterCodeFeagment = new RegisterCodeFeagment();
        mFragments.add(mPhoneNumFragment);
        mFragments.add(mRegisterCodeFeagment);
        mFragmentAdapter=new RegisterFragmentAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mFragmentAdapter);
        mFragmentAdapter.setFragments(mFragments);
        SMSSDK.initSDK(this,"1c2e614253121","04b030b1431b12b815a028c90da8ef2f");

              mEventHandler=  new EventHandler(){
            @Override
            public void afterEvent(int event, int result, Object data) {
                super.afterEvent(event, result, data);
                Message msg =new Message();
                msg.arg1=event;
                msg.arg2=result;
                msg.obj=data;
                mHandler.sendMessage(msg);
            }
        };
        //注册短信的回掉
        SMSSDK.registerEventHandler(mEventHandler);
        SMSSDK.getSupportedCountries();
    }

    @Override
    protected void bindEvent() {
        mPhoneNumFragment.setMoveToNext(this);
        mRegisterCodeFeagment.setToFirst(this);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SMSSDK.unregisterEventHandler(mEventHandler);
    }

    @Override
    public void moveToSecond() {
        mViewPager.setCurrentItem(1,true);
    }


    @Override
    public void moveToFirst() {
        mViewPager.setCurrentItem(0,true);
    }

    @Override

    public void onBackPressed() {
        Log.d("RegisterActivity", "mViewPager.getCurrentItem():" + mViewPager.getCurrentItem());
        if (mViewPager.getCurrentItem() == 0) {
            super.onBackPressed();
        }
        mViewPager.setCurrentItem(0, true);
    }


}
