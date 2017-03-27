package com.jieleo.xmly_plus.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.mob.tools.gui.ViewPagerAdapter;

import java.util.List;

/**
 * Created by liuHao on 17/3/21.
 */
public class EMchatVPadapter extends FragmentPagerAdapter {

    private List<Fragment> mFragmentList;
    private String[] mStrings = {"会话","通讯录","设置"};

    public EMchatVPadapter(FragmentManager fm) {
        super(fm);
    }

    public void setFragmentList(List<Fragment> fragmentList) {
        mFragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList==null?0:mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mStrings[position];
    }
}
