package com.jieleo.xmly_plus.activity;

import android.view.View;

import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.tools.MyUrl;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by dllo on 17/3/20.
 */

public class JieCaoPlayerActivity extends BaseActivity {
    private JCVideoPlayerStandard jcVideoPlayerStandard;
    private String url= MyUrl.JIECAO;
    @Override
    protected int bindLayout() {
        return R.layout.activity_jiecaoplayer;
    }

    @Override
    protected void initView() {
        jcVideoPlayerStandard= (JCVideoPlayerStandard) findViewById(R.id.jiecao);
        jcVideoPlayerStandard.setUp(url, JCVideoPlayer.SCREEN_LAYOUT_NORMAL,"喜马拉雅");

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void bindEvent() {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()){
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

}
