package com.jieleo.xmly_plus.fragment.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.jieleo.xmly_plus.MyApp;
import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.adapter.list_adapter.ListFragmentPageRVAdapter;
import com.jieleo.xmly_plus.fragment.BaseFragment;
import com.jieleo.xmly_plus.model.bean.model_list_page.ListPageBean;
import com.jieleo.xmly_plus.presenter.presenter_list_page.ListPagePresenter;
import com.jieleo.xmly_plus.view.view_list_page.IlistPageView;
import com.jieleo.xmly_plus.tools.MyUrl;

/**
 * Created by jie on 2017/3/9.
 */

public class ListPageFragment extends BaseFragment implements IlistPageView{
    private RecyclerView recyclerView;
    private ListPagePresenter listPagePresenter;
    private ListFragmentPageRVAdapter listFragmentPageRVAdapter;
    private static final String TAG = "ListPageFragment";
    @Override
    protected int bindLayout() {
        return R.layout.fragment_list;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_fragment_list);
        listPagePresenter = new ListPagePresenter(this);
        listFragmentPageRVAdapter = new ListFragmentPageRVAdapter(MyApp.getContext());
        listPagePresenter.setListPageUrl(MyUrl.LIST_PAGE_FRAGMENT_URL);
        recyclerView.setLayoutManager(new LinearLayoutManager(MyApp.getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(listFragmentPageRVAdapter);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void bindEvent() {

    }

    @Override
    public void onViewSucceed(ListPageBean listPageBean) {
        Log.e(TAG, "onViewSucceed: "+listPageBean );
        listFragmentPageRVAdapter.setListPageBean(listPageBean);
    }

    @Override
    public void onViewFailed() {

    }


}
