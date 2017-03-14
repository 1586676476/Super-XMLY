package com.jieleo.xmly_plus.model.bean.model_play_music;

import com.jieleo.xmly_plus.tools.CallBack;
import com.jieleo.xmly_plus.tools.NetTool;

/**
 * Created by yuyongjie on 17/3/13.
 */


public class PlayMusicModel implements IPlayMusic{


    @Override
    public void getMusicData(String url, final IPlayMusicListener listener) {
        NetTool.getInstance().startRequest(url, PlayMusicBean.class, new CallBack<PlayMusicBean>() {
            @Override
            public void onSuccess(PlayMusicBean response) {
                listener.getMusicDataSuccess(response);
            }

            @Override
            public void onError(Throwable throwable) {
                listener.getMusicDataFailed();
            }
        });
    }
}
