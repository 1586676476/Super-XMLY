package com.jieleo.xmly_plus.presenter.view_list_page;

import com.jieleo.xmly_plus.model.bean.model_list_page.ListPageBean;

/**
 * Created by liuHao on 17/3/10.
 */
public interface IlistPageView {
    void onViewSucceed(ListPageBean listPageBean);
    void onViewFailed();

}
