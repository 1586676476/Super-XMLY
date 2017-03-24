package com.jieleo.xmly_plus.model.bean.play_online_music;

/**
 * Created by yuyongjie on 17/3/24.
 */


public interface IGetDataListener {
    void OnSuccess(OnlineMusicBean bean);
    void OnFailed(Throwable throwable);
}
