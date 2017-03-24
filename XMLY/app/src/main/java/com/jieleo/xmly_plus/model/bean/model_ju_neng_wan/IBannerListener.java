package com.jieleo.xmly_plus.model.bean.model_ju_neng_wan;

/**
 * Created by yuyongjie on 17/3/22.
 */


public interface IBannerListener {
    void onSuccess(JuNengWanBannerBean bean);
    void onFailed(Throwable throwable);
}
