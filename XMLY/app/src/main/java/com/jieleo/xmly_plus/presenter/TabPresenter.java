package com.jieleo.xmly_plus.presenter;

import com.jieleo.xmly_plus.model.IGetWordsListener;
import com.jieleo.xmly_plus.model.TabLayoutModel;
import com.jieleo.xmly_plus.model.TabWordsBean;
import com.jieleo.xmly_plus.view.TabView;

/**
 * Created by yuyongjie on 17/3/9.
 */


public class TabPresenter {
    private TabLayoutModel tabLayoutModel;
    private TabView tabView;

    public TabPresenter( TabView tabView) {
        tabLayoutModel =new TabLayoutModel();
        this.tabView = tabView;
    }

    public void getTabWord(String url){
        tabLayoutModel.getWords(url, new IGetWordsListener() {
            @Override
            public void onSuccess(TabWordsBean tabWordsBean) {
               tabView.showTabWords(tabWordsBean);
            }

            @Override
            public void onError() {

            }
        });

    }

}
