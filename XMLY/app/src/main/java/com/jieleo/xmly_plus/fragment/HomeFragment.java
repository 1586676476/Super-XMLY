package com.jieleo.xmly_plus.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.adapter.HomeFragmentPageAdapter;
import com.jieleo.xmly_plus.fragment.home.GroomPageFragment;
import com.jieleo.xmly_plus.fragment.home.HotPageFragment;
import com.jieleo.xmly_plus.fragment.home.LivePageFragment;
import com.jieleo.xmly_plus.fragment.home.ProfilePageFragment;
import com.jieleo.xmly_plus.presenter.TabPresenter;
import com.jieleo.xmly_plus.view.TabView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuyongjie on 17/3/9.
 */


public class HomeFragment extends BaseFragment implements TabView{
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private HomeFragmentPageAdapter homeFragmentPageAdapter;
    private List<Fragment>  fragments;
    private TabPresenter tabPresenter;
    @Override
    protected int bindLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        tabLayout = (TabLayout) view.findViewById(R.id.ty_fragment_home);
        viewPager = (ViewPager) view.findViewById(R.id.vp_fragment_home);
        homeFragmentPageAdapter=new HomeFragmentPageAdapter(getChildFragmentManager());
    }

    @Override
    protected void initData() {
        fragments=new ArrayList<>();
        tabPresenter=new TabPresenter(this);
        fragments.add(new GroomPageFragment());
        fragments.add(new HotPageFragment());
        fragments.add(new ProfilePageFragment());
        fragments.add(new ListFragment());
        fragments.add(new LivePageFragment());
        viewPager.setAdapter(homeFragmentPageAdapter);
        tabLayout.setupWithViewPager(viewPager,true);
        homeFragmentPageAdapter.setFragments(fragments);
        homeFragmentPageAdapter.setTitle(tabPresenter.getTabWord());
    }

    @Override
    protected void bindEvent() {

    }

    @Override
    public String getTabUrl() {
        return "http://mobile.ximalaya.com/mobile/discovery/v2/tabs?device=android&version=5.4.87";
    }
}
