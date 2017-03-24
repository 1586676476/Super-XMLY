package com.jieleo.xmly_plus.presenter.play_online_music;

import com.jieleo.xmly_plus.model.bean.play_online_music.IGetDataListener;
import com.jieleo.xmly_plus.model.bean.play_online_music.OnlineMusicBean;
import com.jieleo.xmly_plus.model.bean.play_online_music.PlayOnlineModel;
import com.jieleo.xmly_plus.view.PlayOnlineMusicView;

/**
 * Created by yuyongjie on 17/3/24.
 */


public class PlayOnlineMusicPresenter {
    private PlayOnlineModel mPlayOnlineModel;
    private PlayOnlineMusicView mPlayOnlineMusicView;

    public PlayOnlineMusicPresenter(PlayOnlineMusicView playOnlineMusicView) {
        mPlayOnlineMusicView = playOnlineMusicView;
        mPlayOnlineModel=new PlayOnlineModel();
    }

    public  void getOnlineMusicData(String url){
        mPlayOnlineModel.getOnlineMusic(url, new IGetDataListener() {
            @Override
            public void OnSuccess(OnlineMusicBean bean) {
                mPlayOnlineMusicView.getOnlineMusicData(bean);
            }

            @Override
            public void OnFailed(Throwable throwable) {

            }
        });
    }
}
