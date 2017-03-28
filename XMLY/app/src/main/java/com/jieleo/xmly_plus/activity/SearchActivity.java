package com.jieleo.xmly_plus.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.adapter.search_adapter.SearchAdapter;
import com.jieleo.xmly_plus.model.bean.model_search_.SearchBean;
import com.jieleo.xmly_plus.presenter.presenter_search.SearchPresenter;
import com.jieleo.xmly_plus.tools.MyUrl;
import com.jieleo.xmly_plus.view.view_search.SearchView;

/**
 * Created by dllo on 17/3/16.
 */

public class SearchActivity extends BaseActivity implements SearchView {
    private RecyclerView recyclerView;
    private SearchAdapter searchAdapter;
    private SearchPresenter searchPresenter;

    @Override
    protected int bindLayout() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.activity_search_recycleView);
        searchAdapter = new SearchAdapter(this);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setAdapter(searchAdapter);
        searchPresenter=new SearchPresenter(this);
        searchPresenter.getSearch(MyUrl.SEARCH);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void bindEvent() {

    }

    @Override
    public void onClick(View v) {

    }



    @Override
    public void Success(SearchBean[] searchBeanList) {
        searchAdapter.setSearchBeanList(searchBeanList);
    }

    @Override
    public void Failed() {

    }
}
