package com.jieleo.xmly_plus.fragment.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.androidkun.PullToRefreshRecyclerView;
import com.jieleo.xmly_plus.MyApp;
import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.adapter.live_adapter.LiveFragmentPageRvAdapter;
import com.jieleo.xmly_plus.fragment.BaseFragment;
import com.jieleo.xmly_plus.model.bean.model_live_page.LivePageBean;
import com.jieleo.xmly_plus.presenter.presenter_live_page.LivePagePresenter;
import com.jieleo.xmly_plus.tools.MyUrl;
import com.jieleo.xmly_plus.view.view_live_page.ILivePageView;

/**
 * Created by jie on 2017/3/9.
 */

public class LivePageFragment extends BaseFragment implements ILivePageView{
    private PullToRefreshRecyclerView recyclerView;
    private LiveFragmentPageRvAdapter liveFragmentPageRvAdapter;
    private LivePagePresenter livePagePresenter;
    @Override
    protected int bindLayout() {
        return R.layout.fragment_live;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        recyclerView = (PullToRefreshRecyclerView) view.findViewById(R.id.rv_fragment_live);
    }

    @Override
    protected void initData() {
        livePagePresenter = new LivePagePresenter(this);
        liveFragmentPageRvAdapter = new LiveFragmentPageRvAdapter(MyApp.getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(MyApp.getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(liveFragmentPageRvAdapter);
        livePagePresenter.livePageData(MyUrl.LIVE_PAGE_FRAGMENT_URL);
    }

    @Override
    protected void bindEvent() {

    }

    @Override
    public void onViewSucceed(LivePageBean livePageBean) {
        liveFragmentPageRvAdapter.setLivePageBean(livePageBean);
    }

    @Override
    public void onViewFailed() {

    }
}
