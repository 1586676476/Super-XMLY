package com.jieleo.xmly_plus.model.bean.model_play_music;

/**
 * Created by yuyongjie on 17/3/13.
 */


public interface IPlayMusicListener {
    void getMusicDataSuccess(PlayMusicBean bean);
    void getMusicDataFailed();
}
