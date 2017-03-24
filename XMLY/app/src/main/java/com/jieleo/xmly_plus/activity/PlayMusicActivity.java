package com.jieleo.xmly_plus.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RemoteViews;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jieleo.xmly_plus.MyApp;
import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.adapter.playmusic_adapter.PlayMusicRecommendRecyclerViewAdapter;
import com.jieleo.xmly_plus.model.bean.model_play_music.PlayMusicBean;
import com.jieleo.xmly_plus.model.bean.play_online_music.OnlineMusicBean;
import com.jieleo.xmly_plus.presenter.play_online_music.PlayOnlineMusicPresenter;
import com.jieleo.xmly_plus.presenter.playmusic.PlayMusicPresenter;
import com.jieleo.xmly_plus.service.PlayMusicService;
import com.jieleo.xmly_plus.tools.MyUrl;
import com.jieleo.xmly_plus.tools.SPUtils;
import com.jieleo.xmly_plus.view.IPlayMusicView;
import com.jieleo.xmly_plus.view.PlayOnlineMusicView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yuyongjie on 17/3/11.
 */


public class PlayMusicActivity extends BaseActivity implements IPlayMusicView, SeekBar.OnSeekBarChangeListener,PlayOnlineMusicView {
    @BindView(R.id.iv_bg_activity_play_music)
    ImageView mIvBgActivityPlayMusic;
    @BindView(R.id.seek_bar_activity_play_music)
    SeekBar mSeekBarActivityPlayMusic;
    @BindView(R.id.tv_duration_start_activity_play_music)
    TextView mTvDurationStartActivityPlayMusic;
    @BindView(R.id.tv_duration_end_activity_play_music)
    TextView mTvDurationEndActivityPlayMusic;
    @BindView(R.id.tv_show_list_activity_play_music)
    TextView mTvShowListActivityPlayMusic;
    @BindView(R.id.tv_time_off_btn_activity_play_music)
    TextView mTvTimeOffBtnActivityPlayMusic;
    @BindView(R.id.iv_play_btn_activity_play_music)
    ImageView mIvPlayBtnActivityPlayMusic;
    @BindView(R.id.iv_play_last_activity_play_music)
    ImageView mIvPlayLastActivityPlayMusic;
    @BindView(R.id.iv_play_next_activity_play_music)
    ImageView mIvPlayNextActivityPlayMusic;
    @BindView(R.id.rl_toolbar_activity_play_music)
    RelativeLayout mRlToolbarActivityPlayMusic;
    @BindView(R.id.iv_small_cover_activity_play_music)
    ImageView mIvSmallCoverActivityPlayMusic;
    @BindView(R.id.tv_album_title_activity_play_music)
    TextView mTvAlbumTitleActivityPlayMusic;
    @BindView(R.id.tv_album_subscribes_activity_play_music)
    TextView mTvAlbumSubscribesActivityPlayMusic;
    @BindView(R.id.rl_album_info_activity_play_music)
    RelativeLayout mRlAlbumInfoActivityPlayMusic;
    @BindView(R.id.tv_trackInfo_title_activity_play_music)
    TextView mTvTrackInfoTitleActivityPlayMusic;
    @BindView(R.id.tv_play_times_activity_play_music)
    TextView mTvPlayTimesActivityPlayMusic;
    @BindView(R.id.tv_create_time_activity_play_music)
    TextView mTvCreateTimeActivityPlayMusic;
    @BindView(R.id.rl_trackInfo_activity_play_music)
    RelativeLayout mRlTrackInfoActivityPlayMusic;
    @BindView(R.id.tv_recommend_activity_play_music)
    TextView mTvRecommendActivityPlayMusic;
    @BindView(R.id.rv_recommend_activity_play_music)
    RecyclerView mRvRecommendActivityPlayMusic;
    @BindView(R.id.rl_recommend_activity_play_music)
    RelativeLayout mRlRecommendActivityPlayMusic;
    @BindView(R.id.rl_commentInfo_top_activity_play_music)
    RelativeLayout mRlCommentInfoTopActivityPlayMusic;
    @BindView(R.id.rv_comment_activity_play_music)
    RecyclerView mRvCommentActivityPlayMusic;
    @BindView(R.id.tv_commentInfo_activity_play_music)
    RelativeLayout mTvCommentInfoActivityPlayMusic;
    @BindView(R.id.iv_back_activity_play_music)
    ImageView mIvBackActivityPlayMusic;
    @BindView(R.id.tv_state_activity_play_music)
    TextView mTvStateActivityPlayMusic;
    @BindView(R.id.iv_title_play_btn_activity_play_music)
    ImageView mIvTitlePlayBtnActivityPlayMusic;
    @BindView(R.id.iv_play_dynamic_activity_play_music)
    ImageView mIvPlayDynamicActivityPlayMusic;
    @BindView(R.id.iv_show_more_activity_play_music)
    ImageView mIvShowMoreActivityPlayMusic;
    @BindView(R.id.iv_share_immediately_activity_play_music)
    ImageView mIvShareImmediatelyActivityPlayMusic;

    private int id;

    private PlayMusicService.MyBinder mBinder;

    private ServiceConnection mServiceConnection;

    //绑定服务用的Intent
    private Intent mIntent;
    //声明接收音乐信息的广播接收器
    private PlayMusicBroadCastReceiver mBroadCastReceiver;
    //声明当前播放歌曲的播放位置
    private int position;
    //声明本地音乐实体类集合
    private List<LocalMusicBean> mLocalMusicBeen;
    private boolean isAlive = true;

    private boolean playMode=false;

    private PlayOnlineMusicPresenter mOnlineMusicPresenter;

    private int trackId=5890260;

    private OnlineMusicBean mOnlineMusicBean;

    private PlayMusicPresenter mPlayMusicPresenter;
    private PlayMusicRecommendRecyclerViewAdapter recmmendAdapter;
    private Notification.Builder builder;
    private NotificationManager notificationManager;
    private RemoteViews remoteViews;
    private Notification notification;
    private MediaPlayer mediaPlayer;


    @Override
    protected int bindLayout() {
        return R.layout.activity_play_music;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        //创建绑定服务的intent
        mIntent = new Intent(this, PlayMusicService.class);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (isAlive) {
                    if (mBinder != null && mBinder.isPlaying()) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mSeekBarActivityPlayMusic.setMax(mBinder.getDuring());
                                mSeekBarActivityPlayMusic.setProgress(mBinder.getCurrentProgress());
                            }
                        });
                        try {
                            Thread.sleep(200);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
        mServiceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                mBinder = (PlayMusicService.MyBinder) service;
                if (mBinder.isPlaying()) {
                    mIvPlayBtnActivityPlayMusic.setImageResource(R.mipmap.live_btn_pause);
                } else {
                    mSeekBarActivityPlayMusic.setMax((Integer) SPUtils.get(MyApp.getContext(), "during", 100));
                    mSeekBarActivityPlayMusic.setProgress((Integer) SPUtils.get(MyApp.getContext(), "progress", 0));
                }

                mOnlineMusicPresenter.getOnlineMusicData("http://140.207.215.242/v1/track/ca/playpage/"+trackId+"?device=android&trackId="+trackId);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
        //绑定服务
        bindService(mIntent, mServiceConnection, Service.BIND_AUTO_CREATE);
        //注册广播接收器
        IntentFilter intentFilter = new IntentFilter("LocalMusic");
        mBroadCastReceiver = new PlayMusicBroadCastReceiver();
        registerReceiver(mBroadCastReceiver, intentFilter);

    }

    @Override
    protected void initData() {
        id = getIntent().getIntExtra("id", 0);
        mPlayMusicPresenter = new PlayMusicPresenter(this);
        mPlayMusicPresenter.getMusicDatas(MyUrl.getMusicUrl(id));
        recmmendAdapter = new PlayMusicRecommendRecyclerViewAdapter(this);
        mRvRecommendActivityPlayMusic.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRvRecommendActivityPlayMusic.setAdapter(recmmendAdapter);

        mOnlineMusicPresenter =new PlayOnlineMusicPresenter(this);
    }

    @Override
    protected void bindEvent() {
        mSeekBarActivityPlayMusic.setOnSeekBarChangeListener(this);

    }


    @OnClick({R.id.iv_bg_activity_play_music, R.id.seek_bar_activity_play_music, R.id.tv_duration_start_activity_play_music, R.id.tv_duration_end_activity_play_music, R.id.tv_show_list_activity_play_music, R.id.tv_time_off_btn_activity_play_music, R.id.iv_play_btn_activity_play_music, R.id.iv_play_last_activity_play_music, R.id.iv_play_next_activity_play_music, R.id.rl_toolbar_activity_play_music, R.id.iv_small_cover_activity_play_music, R.id.tv_album_title_activity_play_music, R.id.tv_album_subscribes_activity_play_music, R.id.rl_album_info_activity_play_music, R.id.tv_trackInfo_title_activity_play_music, R.id.tv_play_times_activity_play_music, R.id.tv_create_time_activity_play_music, R.id.rl_trackInfo_activity_play_music, R.id.tv_recommend_activity_play_music, R.id.rv_recommend_activity_play_music, R.id.rl_recommend_activity_play_music, R.id.rl_commentInfo_top_activity_play_music, R.id.rv_comment_activity_play_music, R.id.tv_commentInfo_activity_play_music, R.id.iv_back_activity_play_music, R.id.tv_state_activity_play_music, R.id.iv_title_play_btn_activity_play_music, R.id.iv_play_dynamic_activity_play_music, R.id.iv_show_more_activity_play_music, R.id.iv_share_immediately_activity_play_music})
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.iv_bg_activity_play_music:
                break;
            case R.id.seek_bar_activity_play_music:
                break;
            case R.id.tv_duration_start_activity_play_music:
                break;
            case R.id.tv_duration_end_activity_play_music:
                break;
            case R.id.tv_show_list_activity_play_music:
                break;
            case R.id.tv_time_off_btn_activity_play_music:
                break;
            case R.id.iv_play_btn_activity_play_music:
                //播放音乐
                if (mBinder.isPlaying()) {
                    SPUtils.put(MyApp.getContext(), "progress", mBinder.getCurrentProgress());
                    SPUtils.put(MyApp.getContext(), "during", mBinder.getDuring());
                    mBinder.pause();
                    mIvPlayBtnActivityPlayMusic.setImageResource(R.drawable.activity_play_music_toolbar_play_btn_seclector);
                } else {
                    if (playMode) {
                        //是否是第一次播放
                        if (mBinder.isFirst()) {
                            mBinder.playLocal();
                            mBinder.setFirst();
                            mIvPlayBtnActivityPlayMusic.setImageResource(R.mipmap.live_btn_pause);
                            mSeekBarActivityPlayMusic.setProgress((Integer) SPUtils.get(MyApp.getContext(), "progress", 0));
                        } else {
                            //如果已经播放过 则继续播放
                            mBinder.coutinuePlay();
                            mIvPlayBtnActivityPlayMusic.setImageResource(R.mipmap.live_btn_pause);
                            mSeekBarActivityPlayMusic.setProgress((Integer) SPUtils.get(MyApp.getContext(), "progress", 0));
                        }
                    }else {
                        if (mBinder.isFirst()){
                            mBinder.playOnline(mOnlineMusicBean.getTrackInfo().getPlayUrl64());
                            mBinder.setFirst();
                            mIvPlayBtnActivityPlayMusic.setImageResource(R.mipmap.live_btn_pause);
                            mSeekBarActivityPlayMusic.setProgress((Integer) SPUtils.get(MyApp.getContext(), "progress", 0));
                        }else {
                            mBinder.coutinuePlay();
                            mIvPlayBtnActivityPlayMusic.setImageResource(R.mipmap.live_btn_pause);

                        }
                    }
                }
                break;
            case R.id.iv_play_last_activity_play_music:
                mBinder.playLastMusic();
                break;
            case R.id.iv_play_next_activity_play_music:
                mBinder.playNextMusic();
                break;
            case R.id.rl_toolbar_activity_play_music:
                break;
            case R.id.iv_small_cover_activity_play_music:
                break;
            case R.id.tv_album_title_activity_play_music:
                break;
            case R.id.tv_album_subscribes_activity_play_music:
                break;
            case R.id.rl_album_info_activity_play_music:
                break;
            case R.id.tv_trackInfo_title_activity_play_music:
                break;
            case R.id.tv_play_times_activity_play_music:
                break;
            case R.id.tv_create_time_activity_play_music:
                break;
            case R.id.rl_trackInfo_activity_play_music:
                break;
            case R.id.tv_recommend_activity_play_music:
                break;
            case R.id.rv_recommend_activity_play_music:
                break;
            case R.id.rl_recommend_activity_play_music:
                break;
            case R.id.rl_commentInfo_top_activity_play_music:
                break;
            case R.id.rv_comment_activity_play_music:
                break;
            case R.id.tv_commentInfo_activity_play_music:
                break;
            case R.id.iv_back_activity_play_music:
                break;
            case R.id.tv_state_activity_play_music:
                break;
            case R.id.iv_title_play_btn_activity_play_music:
                break;
            case R.id.iv_play_dynamic_activity_play_music:
                break;
            case R.id.iv_show_more_activity_play_music:
                break;
            case R.id.iv_share_immediately_activity_play_music:
                break;
        }
    }

    @Override
    public void showMusicData(PlayMusicBean bean) {
        recmmendAdapter.setBeen(bean.getAssociationAlbumsInfo());
    }

    //显示notification
    @Override
    public void showNotification(PlayMusicBean bean) {
//        //设置notification
//        builder=new Notification.Builder(this);
//        notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//        remoteViews=new RemoteViews(getPackageName(),R.layout.notification);
//        //这个notification会一直呆在通知栏上面
//        notification.flags=Notification.FLAG_ONGOING_EVENT;


    }


    @Override
    protected void onPause() {
        super.onPause();
        isAlive = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解绑服务
        unbindService(mServiceConnection);
        //解绑广播接收器
        unregisterReceiver(mBroadCastReceiver);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    /**
     * SeekBar监听  获取进度 设置到播放歌曲的进度中
     *
     * @param seekBar
     */
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        mBinder.setMediaProgress(seekBar.getProgress());
    }

    @Override
    public void getOnlineMusicData(OnlineMusicBean bean) {
            mOnlineMusicBean=bean;
        Glide.with(MyApp.getContext()).load(mOnlineMusicBean.getAlbumInfo().getCoverLarge()).into(mIvBgActivityPlayMusic);
        Glide.with(MyApp.getContext()).load(mOnlineMusicBean.getAlbumInfo().getCoverSmall()).into(mIvSmallCoverActivityPlayMusic);
        mTvAlbumTitleActivityPlayMusic.setText(mOnlineMusicBean.getAlbumInfo().getTitle());
    }


    class PlayMusicBroadCastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            mLocalMusicBeen = intent.getParcelableArrayListExtra("LocalMusicBeen");//得到音乐数据
            position = intent.getIntExtra("index", 0);//当前播放歌曲的位置
            mIvSmallCoverActivityPlayMusic.setImageDrawable(new BitmapDrawable(BitmapFactory.decodeFile(mLocalMusicBeen.get(position).getAlbumArt())));
            mIvBgActivityPlayMusic.setImageDrawable(new BitmapDrawable(BitmapFactory.decodeFile(mLocalMusicBeen.get(position).getAlbumArt())));
            mTvAlbumTitleActivityPlayMusic.setText(mLocalMusicBeen.get(position).getSongName());
        }
    }
}
