package com.jieleo.xmly_plus.fragment.register;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jieleo.xmly_plus.MyApp;
import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.fragment.BaseFragment;
import com.jieleo.xmly_plus.tools.SPUtils;

import cn.smssdk.SMSSDK;

/**
 * Created by jie on 2017/3/17.
 */

public class RegisterCodeFeagment extends BaseFragment implements View.OnClickListener {
    private EditText codeEt;
    private Button completeRegisterBtn;
    private MoveToFirst mToFirst;

    public void setToFirst(MoveToFirst toFirst) {
        mToFirst = toFirst;
    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_register_code;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        codeEt= (EditText) view.findViewById(R.id.et_code_fragment_code);
        completeRegisterBtn= (Button) view.findViewById(R.id.btn_complete_register_fragment_code);
        view.findViewById(R.id.iv_back_fragment_register_code).setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void bindEvent() {
        completeRegisterBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_complete_register_fragment_code:
                SMSSDK.submitVerificationCode("+86", SPUtils.get(MyApp.getContext(),"phoneNum","").toString(),codeEt.getText().toString());
                break;
            case R.id.iv_back_fragment_register_code:
                mToFirst.moveToFirst();
                break;
        }
    }




    public interface MoveToFirst{
        void moveToFirst();
    }
}
