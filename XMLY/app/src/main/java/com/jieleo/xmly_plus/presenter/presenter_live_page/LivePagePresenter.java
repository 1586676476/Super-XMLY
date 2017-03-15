package com.jieleo.xmly_plus.presenter.presenter_live_page;

import com.jieleo.xmly_plus.model.bean.model_live_page.ILiveNet;
import com.jieleo.xmly_plus.model.bean.model_live_page.LiveModel;
import com.jieleo.xmly_plus.model.bean.model_live_page.LivePageBean;
import com.jieleo.xmly_plus.view.view_live_page.ILivePageView;

/**
 * Created by liuHao on 17/3/13.
 */
public class LivePagePresenter {
    private LiveModel liveModel;
    private ILivePageView iLivePageView;

    public LivePagePresenter(ILivePageView iLivePageView) {
        this.iLivePageView = iLivePageView;
        liveModel = new LiveModel();
    }

    public void livePageData(String url){
        liveModel.getLivePageBean(url, new ILiveNet() {
            @Override
            public void onNetSucceed(LivePageBean livePageBean) {
                iLivePageView.onViewSucceed(livePageBean);
            }

            @Override
            public void onNetFailed(Throwable throwable) {
                iLivePageView.onViewFailed();
            }
        });


    }

}
