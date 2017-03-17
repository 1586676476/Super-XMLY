package com.jieleo.xmly_plus.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.adapter.RegisterFragmentAdapter;
import com.jieleo.xmly_plus.fragment.register.PhoneNumFragment;
import com.jieleo.xmly_plus.fragment.register.RegisterCodeFeagment;

import java.util.ArrayList;
import java.util.List;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

/**
 * Created by jie on 2017/3/17.
 */

public class RegisterActivity extends BaseActivity implements PhoneNumFragment.MoveToNext {
    private ViewPager mViewPager;
    private List<Fragment>  mFragments;
    private RegisterFragmentAdapter mFragmentAdapter;
    private EventHandler mEventHandler;

    Handler mHandler =new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.arg2==SMSSDK.RESULT_COMPLETE){
                //完成回掉
                if (msg.arg1==SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE){
                    //提交验证码成功
                }else if (msg.arg1==SMSSDK.EVENT_GET_VERIFICATION_CODE){
                    //获取验证码成功
                }else if (msg.arg1== SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES){
                    //返回支持的国家的列表
                }
            }
            return false;
        }
    });
    private PhoneNumFragment mPhoneNumFragment;

    @Override
    protected int bindLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        mViewPager= (ViewPager) findViewById(R.id.vp_aty_register);
    }

    @Override
    protected void initData() {
        mFragments=new ArrayList<>();
        mPhoneNumFragment = new PhoneNumFragment();
        mFragments.add(mPhoneNumFragment);
        mFragments.add(new RegisterCodeFeagment());
        mFragmentAdapter=new RegisterFragmentAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mFragmentAdapter);
        mFragmentAdapter.setFragments(mFragments);

        //注册短信的回掉
        SMSSDK.registerEventHandler(mEventHandler);
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
    }

    @Override
    protected void bindEvent() {
        mPhoneNumFragment.setMoveToNext(this);
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
}
