package com.jieleo.xmly_plus.model.bean.play_online_music;

import com.jieleo.xmly_plus.tools.CallBack;
import com.jieleo.xmly_plus.tools.NetTool;

/**
 * Created by yuyongjie on 17/3/24.
 */


public class PlayOnlineModel implements IGetOnlineData{


    @Override
    public void getOnlineMusic(String url, final IGetDataListener listener) {
        NetTool.getInstance().startRequest(url, OnlineMusicBean.class, new CallBack<OnlineMusicBean>() {
            @Override
            public void onSuccess(OnlineMusicBean response) {
                listener.OnSuccess(response);
            }

            @Override
            public void onError(Throwable throwable) {
                listener.OnFailed(throwable);
            }
        });
    }
}
