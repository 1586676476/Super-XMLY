package com.jieleo.xmly_plus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private RadioButton homeRbtn,mapRbtn,discoverRbtn,personRbtn;
    private RadioGroup mRadioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRadioGroup = (RadioGroup) findViewById(R.id.rg_bottom_aty_main);
        homeRbtn = (RadioButton) findViewById(R.id.rd_btn_home);
        mapRbtn = (RadioButton) findViewById(R.id.rd_btn_map);
        discoverRbtn = (RadioButton) findViewById(R.id.rd_btn_discover);
        personRbtn = (RadioButton) findViewById(R.id.rd_btn_person);
    }
}
