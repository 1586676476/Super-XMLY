package com.jieleo.xmly_plus.presenter.presenter_search;

import com.jieleo.xmly_plus.model.bean.model_search_.SearchBean;
import com.jieleo.xmly_plus.model.bean.model_search_.SearchListener;
import com.jieleo.xmly_plus.model.bean.model_search_.SearchModel;
import com.jieleo.xmly_plus.view.view_search.SearchView;

/**
 * Created by dllo on 17/3/16.
 */

public class SearchPresenter {
    private SearchModel searchModel;
    private SearchView searchView;

    public SearchPresenter(SearchView searchView) {
        this.searchView = searchView;
        searchModel=new SearchModel();
    }

    public void getSearch(String url){
        searchModel.getSearchData(url, new SearchListener() {
            @Override
            public void getSearchOnSuccess(SearchBean searchBean) {
                searchView.Success(searchBean);
            }

            @Override
            public void getSearchOnError() {
                searchView.Failed();
            }
        });
    }
}
