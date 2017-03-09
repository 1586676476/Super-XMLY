package com.jieleo.xmly_plus.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.jieleo.xmly_plus.R;

public class MainActivity extends BaseActivity{
    private RadioButton homeRbtn,mapRbtn,discoverRbtn,personRbtn;
    private RadioGroup mRadioGroup;
    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        homeRbtn=bindView(R.id.rd_btn_home);
        mapRbtn=bindView(R.id.rd_btn_map);
        discoverRbtn=bindView(R.id.rd_btn_discover);
        personRbtn=bindView(R.id.rd_btn_person);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void bindEvent() {

    }

    @Override
    public void onClick(View v) {

    }
}

//
//{
//    private RadioButton homeRbtn,mapRbtn,discoverRbtn,personRbtn;
//    private RadioGroup mRadioGroup;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        mRadioGroup = (RadioGroup) findViewById(R.id.rg_bottom_aty_main);
//        homeRbtn = (RadioButton) findViewById(R.id.rd_btn_home);
//        mapRbtn = (RadioButton) findViewById(R.id.rd_btn_map);
//        discoverRbtn = (RadioButton) findViewById(R.id.rd_btn_discover);
//        personRbtn = (RadioButton) findViewById(R.id.rd_btn_person);
//    }
//}
