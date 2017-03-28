package com.jieleo.xmly_plus.model.bean.model_search_;

import com.jieleo.xmly_plus.tools.CallBack;
import com.jieleo.xmly_plus.tools.CallBackNew;
import com.jieleo.xmly_plus.tools.NetTool;

/**
 * Created by dllo on 17/3/16.
 */

public class SearchModel implements Search{

    @Override
    public void getSearchData(String url, final SearchListener searchListener) {
        NetTool.getInstance().startRequest(url, SearchBean[].class, new CallBackNew() {

            @Override
            public void onSuccess(SearchBean[] response) {
                searchListener.getSearchOnSuccess(response);
            }

            @Override
            public void onError(Throwable throwable) {
                searchListener.getSearchOnError();
            }
        });
    }
}
