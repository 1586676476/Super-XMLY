package com.jieleo.xmly_plus.presenter.playmusic;
import com.jieleo.xmly_plus.model.bean.model_play_music.IPlayMusicListener;
import com.jieleo.xmly_plus.model.bean.model_play_music.PlayMusicBean;
import com.jieleo.xmly_plus.model.bean.model_play_music.PlayMusicModel;
import com.jieleo.xmly_plus.view.IPlayMusicView;

/**
 * Created by yuyongjie on 17/3/13.
 */


public class PlayMusicPresenter {

    private PlayMusicModel mPlayMusicModel;
    private IPlayMusicView mIPlayMusicView;

    public PlayMusicPresenter(IPlayMusicView IPlayMusicView) {
        mIPlayMusicView = IPlayMusicView;
        mPlayMusicModel=new PlayMusicModel();
    }

    public void getMusicDatas(String url){
        mPlayMusicModel.getMusicData(url, new IPlayMusicListener() {
            @Override
            public void getMusicDataSuccess(PlayMusicBean bean) {
                mIPlayMusicView.showMusicData(bean);
            }

            @Override
            public void getMusicDataFailed() {

            }
        });
    }
}
