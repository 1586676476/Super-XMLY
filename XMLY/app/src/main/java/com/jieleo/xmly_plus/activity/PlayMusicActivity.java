package com.jieleo.xmly_plus.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.jieleo.xmly_plus.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yuyongjie on 17/3/11.
 */


public class PlayMusicActivity extends BaseActivity {
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
//    private ImageView mBgImageView,playIv,playLastIv,playNextIv,smallCoverIv,backIv,titlePlayIv,playDynamicIv,showMoreIv,shareImmIv;
//    private SeekBar mSeekBar;
//    private TextView duationStartTv,durationEndTv,showListTv,timeOffTv,ablumTitleTv,albumSubscribesTv,trackInfoTitleTv,playTimesTv,createTimeTv,stateTv;
//    private RecyclerView recommendRecyclerView,commentRecyclerView;

    @Override
    protected int bindLayout() {
        return R.layout.activity_play_music;
    }

    @Override
    protected void initView() {
//        mBgImageView = (ImageView) findViewById(R.id.iv_bg_activity_play_music);
//        playIv = (ImageView) findViewById(R.id.iv_play_btn_activity_play_music);
//        playLastIv = (ImageView) findViewById(R.id.iv_play_last_activity_play_music);
//        playNextIv = (ImageView) findViewById(R.id.iv_play_next_activity_play_music);
//        smallCoverIv = (ImageView) findViewById(R.id.iv_small_cover_activity_play_music);
//        backIv = (ImageView) findViewById(R.id.iv_back_activity_play_music);
//        titlePlayIv = (ImageView) findViewById(R.id.iv_title_play_btn_activity_play_music);
//        playDynamicIv = (ImageView) findViewById(R.id.iv_play_dynamic_activity_play_music);
//
//        recommendRecyclerView = (RecyclerView) findViewById(R.id.rv_recommend_activity_play_music);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void bindEvent() {

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
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
}
