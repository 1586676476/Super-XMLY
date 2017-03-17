package com.jieleo.xmly_plus.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by jie on 2017/3/17.
 */

public class RegisterFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment>  mFragments;
    public RegisterFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setFragments(List<Fragment> fragments) {
        mFragments = fragments;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments!=null?mFragments.size():0;
    }
}
