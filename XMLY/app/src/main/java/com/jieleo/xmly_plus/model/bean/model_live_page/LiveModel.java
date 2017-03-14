package com.jieleo.xmly_plus.model.bean.model_live_page;

import com.jieleo.xmly_plus.tools.CallBack;
import com.jieleo.xmly_plus.tools.NetTool;

/**
 * Created by liuHao on 17/3/13.
 */
public class LiveModel implements ILiveListener{


    @Override
    public void getLivePageBean(String url, final ILiveNet iLiveNet) {
        NetTool.getInstance().startRequest(url, LivePageBean.class, new CallBack<LivePageBean>() {
            @Override
            public void onSuccess(LivePageBean response) {
                iLiveNet.onNetSucceed(response);
            }

            @Override
            public void onError(Throwable throwable) {
                iLiveNet.onNetFailed(throwable);
            }
        });
    }
}
