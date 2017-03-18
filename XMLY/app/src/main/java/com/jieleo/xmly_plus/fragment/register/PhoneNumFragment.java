package com.jieleo.xmly_plus.fragment.register;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jieleo.xmly_plus.MyApp;
import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.fragment.BaseFragment;
import com.jieleo.xmly_plus.model.EventBusBean;
import com.jieleo.xmly_plus.tools.SPUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import cn.smssdk.SMSSDK;

/**
 * Created by jie on 2017/3/17.
 */

public class PhoneNumFragment extends BaseFragment implements View.OnClickListener {
    private static final String TAG = "PhoneNumFragment";
    private EditText mNumberText;
    private Button  msgBtn,callBtn;
    private MoveToNext mMoveToNext;

    public void setMoveToNext(MoveToNext moveToNext) {
        mMoveToNext = moveToNext;
    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_register_phone_num;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mNumberText= (EditText) view.findViewById(R.id.et_phone_num_fragment_phone_num);
        msgBtn= (Button) view.findViewById(R.id.btn_send_msg_fragment_phone_num);
        callBtn= (Button) view.findViewById(R.id.btn_make_call_fragment_phone_num);
    }

    @Override
    protected void initData() {
        mNumberText.setText(SPUtils.get(MyApp.getContext(),"phoneNum","").toString());
    }

    @Override
    protected void bindEvent() {
            msgBtn.setOnClickListener(this);
        callBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send_msg_fragment_phone_num:
                SPUtils.put(MyApp.getContext(),"phoneNum",mNumberText.getText().toString());
                SMSSDK.getVerificationCode("+86",mNumberText.getText().toString());
                mMoveToNext.moveToSecond();
                break;
            case R.id.btn_make_call_fragment_phone_num:
                SPUtils.put(MyApp.getContext(),"phoneNum",mNumberText.getText().toString());
                SMSSDK.getVoiceVerifyCode("+86",mNumberText.getText().toString());
                mMoveToNext.moveToSecond();
                break;
        }
    }


    public interface MoveToNext{
        void moveToSecond();
    }


    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }





}
