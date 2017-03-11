package com.jieleo.xmly_plus.model;

import com.jieleo.xmly_plus.tools.CallBack;
import com.jieleo.xmly_plus.tools.NetTool;

/**
 * Created by yuyongjie on 17/3/9.
 */


public class TabLayoutModel implements IGetWords{
    @Override
    public void getWords(String url, final IGetWordsListener listener) {
        NetTool.getInstance().startRequest(url, TabWordsBean.class, new CallBack<TabWordsBean>() {
            @Override
            public void onSuccess(TabWordsBean response) {
                listener.onSuccess(response);
            }

            @Override
            public void onError(Throwable throwable) {
                listener.onError();
            }
        });

    }
}
