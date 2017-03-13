package com.jieleo.xmly_plus.model.bean.model_hot_page;

import com.jieleo.xmly_plus.tools.CallBack;
import com.jieleo.xmly_plus.tools.NetTool;

/**
 * Created by dllo on 17/3/13.
 */

public class HotModel implements IHot {
    @Override
    public void getIHotData(String url, final IHotListener iHotListener) {
        NetTool.getInstance().startRequest(url, HotCenterBean.class, new CallBack<HotCenterBean>() {
            @Override
            public void onSuccess(HotCenterBean response) {
                iHotListener.onIHotSuccess(response);
            }

            @Override
            public void onError(Throwable throwable) {
                iHotListener.onIHotError();
            }
        });
    }
}
