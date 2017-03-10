package com.jieleo.xmly_plus.model.bean;

import com.jieleo.xmly_plus.tools.CallBack;
import com.jieleo.xmly_plus.tools.NetTool;

/**
 * Created by dllo on 17/3/10.
 */

public class DisCoverModel implements IDisCover {

    @Override
    public void getData(String url, final IDisCoverListener iDisCoverListener) {

        NetTool.getInstance().startRequest(url, DisCoverBean.class, new CallBack<DisCoverBean>() {
            @Override
            public void onSuccess(DisCoverBean response) {
                iDisCoverListener.onSuccess(response);
            }

            @Override
            public void onError(Throwable throwable) {
                iDisCoverListener.Error();
            }
        });
    }
}
