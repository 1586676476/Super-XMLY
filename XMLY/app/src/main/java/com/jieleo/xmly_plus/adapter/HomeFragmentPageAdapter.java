package com.jieleo.xmly_plus.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jieleo.xmly_plus.model.bean.TabWordsBean;

import java.util.List;

/**
 * Created by jie on 2017/3/9.
 */

public class HomeFragmentPageAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;
    private TabWordsBean bean;

    public void setBean(TabWordsBean bean) {
        this.bean = bean;
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
        if (bean!=null){
            return bean.getTabs().getList().get(position).getTitle();
        }
        return null;
    }
}
