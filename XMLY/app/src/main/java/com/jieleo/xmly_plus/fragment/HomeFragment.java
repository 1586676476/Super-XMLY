package com.jieleo.xmly_plus.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.adapter.HomeFragmentPageAdapter;
import com.jieleo.xmly_plus.fragment.home.GroomPageFragment;
import com.jieleo.xmly_plus.fragment.home.HotPageFragment;
import com.jieleo.xmly_plus.fragment.home.ListPageFragment;
import com.jieleo.xmly_plus.fragment.home.LivePageFragment;
import com.jieleo.xmly_plus.fragment.home.ProfilePageFragment;
import com.jieleo.xmly_plus.model.TabWordsBean;
import com.jieleo.xmly_plus.presenter.TabPresenter;
import com.jieleo.xmly_plus.tools.MyUrl;
import com.jieleo.xmly_plus.view.TabView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuyongjie on 17/3/9.
 */


public class HomeFragment extends BaseFragment implements TabView, View.OnClickListener {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private HomeFragmentPageAdapter homeFragmentPageAdapter;
    private List<Fragment> fragments;
    private TabPresenter tabPresenter;
    private TextView searchTv,downLoadTv,historyTv;

    @Override
    protected int bindLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        searchTv = (TextView) view.findViewById(R.id.tv_search_fragment_home);
        historyTv = (TextView) view.findViewById(R.id.tv_history_fragment_home);
        downLoadTv= (TextView) view.findViewById(R.id.tv_download_fragment_home);
        tabLayout = (TabLayout) view.findViewById(R.id.ty_fragment_home);
        viewPager = (ViewPager) view.findViewById(R.id.vp_fragment_home);
        homeFragmentPageAdapter = new HomeFragmentPageAdapter(getChildFragmentManager());
    }

    @Override
    protected void initData() {
        fragments = new ArrayList<>();
        tabPresenter = new TabPresenter(this);
        fragments.add(new GroomPageFragment());
        fragments.add(new HotPageFragment());
        fragments.add(new ListPageFragment());
        fragments.add(new ProfilePageFragment());
        fragments.add(new LivePageFragment());
        viewPager.setAdapter(homeFragmentPageAdapter);
        tabLayout.setupWithViewPager(viewPager, true);
        homeFragmentPageAdapter.setFragments(fragments);

        tabPresenter.getTabWord(MyUrl.TAB_WORDS);
        //设置tabLayout的url
        tabPresenter.getTabWord(MyUrl.TAB_WORDS);


    }

    @Override
    protected void bindEvent() {
        searchTv.setOnClickListener(this);
        historyTv.setOnClickListener(this);
        downLoadTv.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_search_fragment_home:
                break;
            case R.id.tv_download_fragment_home:
                break;
            case R.id.tv_history_fragment_home:
                break;
        }
    }

    @Override
    public void showTabWords(TabWordsBean bean) {
        homeFragmentPageAdapter.setBean(bean);
    }
}
