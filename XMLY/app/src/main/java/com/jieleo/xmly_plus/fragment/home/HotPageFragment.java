package com.jieleo.xmly_plus.fragment.home;

import android.content.Context;
import android.graphics.Picture;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.adapter.hot_adapter.HotAdapter;
import com.jieleo.xmly_plus.adapter.hot_adapter.HotCenterAdapter;
import com.jieleo.xmly_plus.fragment.BaseFragment;
import com.jieleo.xmly_plus.model.bean.model_hot_page.HotBean;
import com.jieleo.xmly_plus.model.bean.model_hot_page.HotCenterBean;
import com.jieleo.xmly_plus.presenter.persenter_hot_page.HotPagePresenter;
import com.jieleo.xmly_plus.tools.CallBack;
import com.jieleo.xmly_plus.tools.DemoRecyclerView;
import com.jieleo.xmly_plus.tools.MyUrl;
import com.jieleo.xmly_plus.tools.NetTool;
import com.jieleo.xmly_plus.view.HotView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jie on 2017/3/9.
 */

public class HotPageFragment extends BaseFragment implements HotView {
    private static final String TAG = "HotPageFragment";

    private HotPagePresenter hotPagePresenter;
    private RecyclerView recyclerView;
    private HotAdapter hotAdapter;

    @Override
    protected int bindLayout() {
        return R.layout.fragment_hot;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycleView_fragment_hot);
        hotAdapter = new HotAdapter(getContext());

        hotPagePresenter = new HotPagePresenter(this);
        hotPagePresenter.getHotdata(MyUrl.HOT_CENTER);
    }

    @Override
    protected void initData() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(hotAdapter);
    }

    @Override
    protected void bindEvent() {

    }

    @Override
    public void getHotSuccess(HotCenterBean hotCenterBean) {
        hotAdapter.setHotCenterBean(hotCenterBean);
    }

    @Override
    public void getHotError() {

    }
}
