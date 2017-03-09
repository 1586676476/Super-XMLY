package com.jieleo.xmly_plus.presenter;

import com.jieleo.xmly_plus.model.bean.IGetWordsListener;
import com.jieleo.xmly_plus.model.bean.TabLayoutModel;
import com.jieleo.xmly_plus.model.bean.TabWordsBean;
import com.jieleo.xmly_plus.view.IView;

/**
 * Created by yuyongjie on 17/3/9.
 */


public class TabPresenter {
    private TabLayoutModel tabLayoutModel;
    private IView iView;

    public TabPresenter( IView iView) {
        tabLayoutModel =new TabLayoutModel();
        this.iView = iView;
    }

    public void getTabWord(){
        tabLayoutModel.getWords(iView.getTabUrl(), new IGetWordsListener() {
            @Override
            public void onSuccess(TabWordsBean tabWordsBean) {

            }

            @Override
            public void onError() {

            }
        });
    }

}
