package com.jieleo.xmly_plus.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.jieleo.xmly_plus.R;

/**
 * Created by yuyongjie on 17/3/9.
 */


public class HomeFragment extends BaseFragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected int bindLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        tabLayout = (TabLayout) view.findViewById(R.id.ty_fragment_home);
        viewPager = (ViewPager) view.findViewById(R.id.vp_fragment_home);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void bindEvent() {

    }
}
