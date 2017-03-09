package com.jieleo.xmly_plus.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by jie on 2017/3/9.
 */

public class HomeFragmentPageAdapter extends FragmentPagerAdapter {
    private List<String>  title;
    private List<Fragment> fragments;

    public void setTitle(List<String> title) {
        this.title = title;
        notifyDataSetChanged();
    }

    public void setFragments(List<Fragment> fragments) {
        this.fragments = fragments;
        notifyDataSetChanged();
    }

    public HomeFragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments!=null?fragments.size():0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (title!=null){
        return title.get(position);
        }
        return null;
    }
}
