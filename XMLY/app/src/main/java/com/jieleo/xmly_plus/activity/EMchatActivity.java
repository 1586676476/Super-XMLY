package com.jieleo.xmly_plus.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.adapter.EMchatVPadapter;
import com.jieleo.xmly_plus.fragment.ContactFragment;
import com.jieleo.xmly_plus.fragment.FriendFragment;
import com.jieleo.xmly_plus.fragment.SetFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by liuHao on 17/3/21.
 */
public class EMchatActivity extends BaseActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private EMchatVPadapter mEMchatVPadapter;
    private List<Fragment> mFragmentList;
    @Override
    protected int bindLayout() {
        return R.layout.activity_friend;
    }

    @Override
    protected void initView() {

        mViewPager = (ViewPager) findViewById(R.id.vp_em_activity);
        mTabLayout = (TabLayout) findViewById(R.id.tab_em_activity);
    }

    @Override
    protected void initData() {
        mEMchatVPadapter = new EMchatVPadapter(getSupportFragmentManager());
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new FriendFragment());
        mFragmentList.add(new ContactFragment());
        mFragmentList.add(new SetFragment());
        mEMchatVPadapter.setFragmentList(mFragmentList);

        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setAdapter(mEMchatVPadapter);


    }

    @Override
    protected void bindEvent() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.iv_back_friend_activity:
//                finish();
//                break;
        }
    }



    }






