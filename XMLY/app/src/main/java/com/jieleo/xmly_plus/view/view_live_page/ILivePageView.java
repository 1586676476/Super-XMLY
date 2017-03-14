package com.jieleo.xmly_plus.view.view_live_page;

import com.jieleo.xmly_plus.model.bean.model_list_page.ListPageBean;
import com.jieleo.xmly_plus.model.bean.model_live_page.LivePageBean;

/**
 * Created by liuHao on 17/3/13.
 */
public interface ILivePageView {

    void onViewSucceed(LivePageBean livePageBean);
    void onViewFailed();


}
