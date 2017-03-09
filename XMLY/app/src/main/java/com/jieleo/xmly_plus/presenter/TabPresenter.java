package com.jieleo.xmly_plus.presenter;

import com.jieleo.xmly_plus.model.bean.IGetWordsListener;
import com.jieleo.xmly_plus.model.bean.TabLayoutModel;
import com.jieleo.xmly_plus.model.bean.TabWordsBean;
import com.jieleo.xmly_plus.view.TabView;

import java.util.ArrayList;
import java.util.List;

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

    public List<String> getTabWord(){
        tabLayoutModel.getWords(tabView.getTabUrl(), new IGetWordsListener() {
            @Override
            public List<String> onSuccess(TabWordsBean tabWordsBean) {
                List<String> title=new ArrayList<String>();
                for (int i = 0; i < tabWordsBean.getTabs().getList().size(); i++) {
                    title.add(tabWordsBean.getTabs().getList().get(i).getTitle());
                }
                return title;
            }

            @Override
            public void onError() {

            }
        });
        return null;
    }

}
