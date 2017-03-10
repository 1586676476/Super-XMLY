package com.jieleo.xmly_plus.presenter.presenter_list_page;

import com.jieleo.xmly_plus.model.bean.model_list_page.IlistNet;
import com.jieleo.xmly_plus.model.bean.model_list_page.ListPageBean;
import com.jieleo.xmly_plus.model.bean.model_list_page.ListPageModel;
import com.jieleo.xmly_plus.view.view_list_page.IlistPageView;

/**
 * Created by liuHao on 17/3/10.
 */
public class ListPagePresenter {

    private ListPageModel listPageModel;
    private IlistPageView ilistPageView;

    public ListPagePresenter(IlistPageView ilistPageView) {
        this.ilistPageView = ilistPageView;
        listPageModel = new ListPageModel();
    }


    public void setListPageUrl(String url){
        listPageModel.getListPageBean(url, new IlistNet() {
            @Override
            public void onSucceed(ListPageBean listPageBean) {
                ilistPageView.onViewSucceed(listPageBean);
            }

            @Override
            public void onFailed() {
                ilistPageView.onViewFailed();
            }
        });


    }



}
