package com.jieleo.xmly_plus.activity;

import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.tools.MyUrl;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

/**
 * Created by dllo on 17/3/20.
 */

public class VatimaioActivity extends BaseActivity {
    private VideoView videoView;
    private MediaController mediaController;
    private TextView percentTv, netSpeedTv;

    @Override
    protected int bindLayout() {
        return R.layout.activity_vatimio;
    }

    @Override
    protected void initView() {
        percentTv = (TextView) findViewById(R.id.buffer_percent);
        netSpeedTv = (TextView) findViewById(R.id.net_speed);


        videoView = (VideoView) findViewById(R.id.vitamio);
        videoView.setVideoURI(Uri.parse(MyUrl.JIECAO));
        mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        videoView.start();

    }

    @Override
    protected void initData() {
        //控制器显示5s自动隐藏
        mediaController.show(5000);
        //绑定控制器
        videoView.setMediaController(mediaController);
        //设置播放画质 高画质
        videoView.setVideoQuality(MediaPlayer.VIDEOQUALITY_HIGH);
        //取得焦点
        videoView.requestFocus();
        //设置缓冲进度
        videoView.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
            @Override
            public void onBufferingUpdate(MediaPlayer mp, int percent) {
                percentTv.setText("已缓冲" + percent + "%");
            }
        });

        videoView.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(MediaPlayer mp, int what, int extra) {
                switch (what) {
                    //开始缓冲
                    case MediaPlayer.MEDIA_INFO_BUFFERING_START:
                        percentTv.setVisibility(View.VISIBLE);
                        netSpeedTv.setVisibility(View.VISIBLE);
                        mp.pause();
                        break;
                    //缓冲结束
                    case MediaPlayer.MEDIA_INFO_BUFFERING_END:
                        percentTv.setVisibility(View.GONE);
                        netSpeedTv.setVisibility(View.GONE);
                        mp.start();
                        break;
                    case MediaPlayer.MEDIA_INFO_DOWNLOAD_RATE_CHANGED:
                        netSpeedTv.setText("当前网速" + extra + "kb/s");
                }
                return true;
            }
        });
    }

    @Override
    protected void bindEvent() {

    }

    @Override
    public void onClick(View v) {

    }
}
