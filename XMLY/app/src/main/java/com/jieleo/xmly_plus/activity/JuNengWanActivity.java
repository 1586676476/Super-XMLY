package com.jieleo.xmly_plus.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.adapter.ju_neng_wan__recycler_view_adapter.JuNengWanActivityRecyclerViewAdapter;
import com.jieleo.xmly_plus.model.bean.model_ju_neng_wan.JuNengWanBannerBean;
import com.jieleo.xmly_plus.presenter.presenter_ju_neng_wan_banner.JuNengWanBannerPresenter;
import com.jieleo.xmly_plus.view.view_ju_neng_wan.JuNengWanBannerView;

import java.util.ArrayList;
import java.util.List;

public class JuNengWanActivity extends BaseActivity implements JuNengWanBannerView {
    private RecyclerView mRecyclerView;
    private JuNengWanBannerPresenter mJuNengWanBannerPresenter;
    private JuNengWanActivityRecyclerViewAdapter mRecyclerViewAdapter;
    @Override
    protected int bindLayout() {
        return R.layout.activity_ju_neng_wan;
    }

    @Override
    protected void initView() {
        mRecyclerView=bindView(R.id.rv_activity_ju_neng_wan);
    }

    @Override
    protected void initData() {
        mJuNengWanBannerPresenter=new JuNengWanBannerPresenter(this);
        mRecyclerViewAdapter=new JuNengWanActivityRecyclerViewAdapter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
    }

    @Override
    protected void bindEvent() {
        mJuNengWanBannerPresenter.getBannerData("http://appserver.jnwtv.com:8080/jnwtv-client/common/listbanner");
    }

    @Override
    public void onClick(View v) {

    }


    @Override
    public void getBanner(JuNengWanBannerBean bean) {
        List<String>  bannerUrls=new ArrayList<>();
        for (int i = 0; i < bean.getData().size(); i++) {
            String url=bean.getData().get(i).getUrl();
            bannerUrls.add(url);
        }
            mRecyclerViewAdapter.setBannerUrls(bannerUrls);
    }
}
