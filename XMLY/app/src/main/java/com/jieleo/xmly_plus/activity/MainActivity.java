package com.jieleo.xmly_plus.activity;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.fragment.DiscoverFragment;
import com.jieleo.xmly_plus.fragment.HomeFragment;
import com.jieleo.xmly_plus.fragment.MapFragment;
import com.jieleo.xmly_plus.fragment.UserFragment;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioButton homeRbtn, mapRbtn, discoverRbtn, personRbtn;
    private RadioGroup mRadioGroup;
    private HomeFragment homeFragment;
    private MapFragment mapFragment;
    private DiscoverFragment discoverFragment;
    private UserFragment mUserFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private ImageView playBtn;

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
//        homeRbtn = bindView(R.id.rd_btn_home);
//        mapRbtn = bindView(R.id.rd_btn_map);
//        discoverRbtn = bindView(R.id.rd_btn_discover);
//        personRbtn = bindView(R.id.rd_btn_person);
        playBtn = (ImageView) findViewById(R.id.fa_btn_aty_main);

        mRadioGroup = bindView(R.id.rg_bottom_aty_main);


        homeFragment = new HomeFragment();
        mapFragment = new MapFragment();
        discoverFragment = new DiscoverFragment();
        mUserFragment = new UserFragment();
        fragmentManager = getSupportFragmentManager();
    }

    @Override
    protected void initData() {
        //将所有fragment加入fragmentManager
        fragmentManager.beginTransaction().add(R.id.content, homeFragment).add(R.id.content, mapFragment).
                add(R.id.content, discoverFragment).add(R.id.content, mUserFragment).commit();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //隐藏所有fragment
        hideAll(fragmentTransaction);
        //显示homefragment
        fragmentTransaction.show(homeFragment);
    }

    //隐藏所有fragment
    private void hideAll(FragmentTransaction fragmentTransaction) {
        fragmentTransaction.hide(homeFragment).hide(mapFragment).hide(discoverFragment).hide(mUserFragment);
    }

    @Override
    protected void bindEvent() {
        //设置RadioGroup的监听事件
        mRadioGroup.setOnCheckedChangeListener(this);


        playBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fa_btn_aty_main:
                startActivity(new Intent(this,PlayMusicActivity.class));
                break;
        }
    }

    // RadioGroup的监听
    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        fragmentTransaction = fragmentManager.beginTransaction();
        hideAll(fragmentTransaction);
        switch (checkedId) {
            case R.id.rd_btn_home:
                fragmentTransaction.show(homeFragment);
                break;
            case R.id.rd_btn_map:
                fragmentTransaction.show(mapFragment);
                break;
            case R.id.rd_btn_discover:
                fragmentTransaction.show(discoverFragment);
                break;
            case R.id.rd_btn_person:
                fragmentTransaction.show(mUserFragment);
                break;
        }
        fragmentTransaction.commitAllowingStateLoss();
    }
}


