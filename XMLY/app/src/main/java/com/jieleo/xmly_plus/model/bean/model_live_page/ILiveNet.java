package com.jieleo.xmly_plus.model.bean.model_live_page;

/**
 * Created by liuHao on 17/3/13.
 */
public interface ILiveNet {

    void onNetSucceed(LivePageBean livePageBean);
    void onNetFailed(Throwable throwable);


}
