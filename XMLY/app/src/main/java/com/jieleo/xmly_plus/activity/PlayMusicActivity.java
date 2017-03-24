package com.jieleo.xmly_plus.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RemoteViews;
import android.widget.SeekBar;
import android.widget.TextView;

import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.adapter.playmusic_adapter.PlayMusicRecommendRecyclerViewAdapter;
import com.jieleo.xmly_plus.model.bean.model_play_music.PlayMusicBean;
import com.jieleo.xmly_plus.presenter.playmusic.PlayMusicPresenter;
import com.jieleo.xmly_plus.service.PlayMusicService;
import com.jieleo.xmly_plus.tools.MyUrl;
import com.jieleo.xmly_plus.view.IPlayMusicView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yuyongjie on 17/3/11.
 */


public class PlayMusicActivity extends BaseActivity implements IPlayMusicView {
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

    //绑定服务用的Intent
    private Intent mIntent;

    private PlayMusicBroadCastReceiver   mBroadCastReceiver;


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

    }

    @Override
    protected void initData() {
        id = getIntent().getIntExtra("id", 0);
        mPlayMusicPresenter = new PlayMusicPresenter(this);
        mPlayMusicPresenter.getMusicDatas(MyUrl.getMusicUrl(id));
        recmmendAdapter=new PlayMusicRecommendRecyclerViewAdapter(this);
        mRvRecommendActivityPlayMusic.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mRvRecommendActivityPlayMusic.setAdapter(recmmendAdapter);
    }

    @Override
    protected void bindEvent() {

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
                break;
            case R.id.iv_play_last_activity_play_music:
                break;
            case R.id.iv_play_next_activity_play_music:
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


    class PlayMusicBroadCastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {

        }
    }
}
