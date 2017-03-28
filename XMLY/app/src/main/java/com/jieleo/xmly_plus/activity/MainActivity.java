package com.jieleo.xmly_plus.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.provider.SyncStateContract;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RemoteViews;

import com.jieleo.xmly_plus.Manifest;
import com.jieleo.xmly_plus.MyApp;
import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.fragment.DiscoverFragment;
import com.jieleo.xmly_plus.fragment.HomeFragment;
import com.jieleo.xmly_plus.fragment.MapFragment;
import com.jieleo.xmly_plus.fragment.UserFragment;
import com.jieleo.xmly_plus.service.PlayMusicService;
import com.jieleo.xmly_plus.tools.SPUtils;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioButton homeRbtn, mapRbtn, discoverRbtn, personRbtn;
    private RadioGroup mRadioGroup;
    private HomeFragment homeFragment;
    private MapFragment mapFragment;
    private DiscoverFragment discoverFragment;
    private UserFragment mUserFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private ImageView playBtn;
    private MyBroadcastReceiver mBroadcastReceiver;
    private LocalMusicBean mLocalMusicBean;

    //用于绑定服务的intent
    private Intent mIntent;


    private Notification.Builder mBuilder;
    private ServiceConnection mServiceConnection;
    private PlayMusicService.MyBinder mBinder;
    private NotificationManager mNotificationManager;
    private RemoteViews mRemoteViews;


    private static final  int REQUEST_PERMISSION_CAMERA_CODE=1;

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        playBtn = (ImageView) findViewById(R.id.fa_btn_aty_main);
        mRadioGroup = bindView(R.id.rg_bottom_aty_main);
        homeFragment = new HomeFragment();
        mapFragment = new MapFragment();
        discoverFragment = new DiscoverFragment();
        mUserFragment = new UserFragment();
        fragmentManager = getSupportFragmentManager();

        mRemoteViews = new RemoteViews(getPackageName(), R.layout.item_play_music_notification);
        mBuilder = new Notification.Builder(MainActivity.this);
        mIntent = new Intent(this, PlayMusicService.class);
        mServiceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                mBinder = (PlayMusicService.MyBinder) service;
                SPUtils.put(MyApp.getContext(), "progress", 0);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };

        bindService(mIntent, mServiceConnection, Service.BIND_AUTO_CREATE);

        //初始化notification对象
        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //绑定notification布局
//        remoteViews = new RemoteViews(getPackageName(), R.layout.notification);
        mBroadcastReceiver = new MyBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("play");
        intentFilter.addAction("playNow");
        intentFilter.addAction("lastNow");
        intentFilter.addAction("nextNow");
        registerReceiver(mBroadcastReceiver, intentFilter);
    }

    @Override
    protected void initData() {
        //将所有fragment加入fragmentManager
        fragmentManager.beginTransaction().add(R.id.content, homeFragment).add(R.id.content, mapFragment).
                add(R.id.content, discoverFragment).add(R.id.content, mUserFragment).commit();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //隐藏所有fragment
        hideAll(fragmentTransaction);
        //显示homefragment
        fragmentTransaction.show(homeFragment);

        //设置notification的相关内容
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
//        Intent intent = new Intent(this, PlayMusicActivity.class);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//        remoteViews.setOnClickPendingIntent(R.id.notice, pendingIntent);


    }

    //隐藏所有fragment
    private void hideAll(FragmentTransaction fragmentTransaction) {
        fragmentTransaction.hide(homeFragment).hide(mapFragment).hide(discoverFragment).hide(mUserFragment);
    }

    @Override
    protected void bindEvent() {
        //设置RadioGroup的监听事件
        mRadioGroup.setOnCheckedChangeListener(this);


        playBtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fa_btn_aty_main:
                Intent intent = new Intent(this, PlayMusicActivity.class);
                intent.putExtra("id", 5890260);
                startActivity(intent);
                break;
        }
    }




    // RadioGroup的监听
    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        fragmentTransaction = fragmentManager.beginTransaction();
        hideAll(fragmentTransaction);
        switch (checkedId) {
            case R.id.rd_btn_home:
                fragmentTransaction.show(homeFragment);
                break;
            case R.id.rd_btn_map:
                fragmentTransaction.show(mapFragment);
                break;
            case R.id.rd_btn_discover:
                fragmentTransaction.show(discoverFragment);
                break;
            case R.id.rd_btn_person:
                fragmentTransaction.show(mUserFragment);
                break;
        }
        fragmentTransaction.commit();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(mServiceConnection);
    }



    class MyBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("play")) {
                mLocalMusicBean = intent.getParcelableExtra("LocalMusic");
                Log.d("MyBroadcastReceiver", mLocalMusicBean.getAlbumArt());


                mRemoteViews.setTextViewText(R.id.tv_song_name_notification, mLocalMusicBean.getSongName());
                mRemoteViews.setTextViewText(R.id.tv_singer_name_nitification,mLocalMusicBean.getSingerName());


                mRemoteViews.setImageViewBitmap(R.id.iv_notification,BitmapFactory.decodeFile(mLocalMusicBean.getAlbumArt()));
                mRemoteViews.setImageViewResource(R.id.iv_last_notification,R.mipmap.player_toolbar_previous_pressed);
                mRemoteViews.setImageViewResource(R.id.iv_next_notification,R.mipmap.player_toolbar_next_pressed);
                if (mBinder.isPlaying()){
                    mRemoteViews.setImageViewResource(R.id.iv_play_notification,R.mipmap.player_toolbar_pause_normal);
                }else {
                    mRemoteViews.setImageViewResource(R.id.iv_play_notification,R.mipmap.player_toolbar_play_normal);
                }

                Intent playIntent = new Intent("playNow");
                PendingIntent playPendingIntent = PendingIntent.getBroadcast(MainActivity.this, 2, playIntent, PendingIntent.FLAG_CANCEL_CURRENT);
                mRemoteViews.setOnClickPendingIntent(R.id.iv_play_notification, playPendingIntent);

                Intent nextIntent=new Intent("nextNow");
                PendingIntent nextPendingIntent=PendingIntent.getBroadcast(MainActivity.this,3,nextIntent,PendingIntent.FLAG_CANCEL_CURRENT);
                mRemoteViews.setOnClickPendingIntent(R.id.iv_next_notification,nextPendingIntent);

                Intent playLast =new Intent("lastNow");
                PendingIntent lastPendingIntent=PendingIntent.getBroadcast(MainActivity.this,1,playLast,PendingIntent.FLAG_CANCEL_CURRENT);
                mRemoteViews.setOnClickPendingIntent(R.id.iv_last_notification,lastPendingIntent);


                mBuilder.setSmallIcon(R.mipmap.icon).setCustomContentView(mRemoteViews).setOngoing(true);
                mNotificationManager.notify(1, mBuilder.build());
            } else if (intent.getAction().equals("playNow")) {
                if (mBinder.isPlaying()) {
                    mBinder.pause();
                } else {
                    if (mBinder.isFirst()) {
                        mBinder.playLocal();
                    } else {
                        mBinder.coutinuePlay();
                    }

                }
            }else if (intent.getAction().equals("nextNow")){
                mBinder.playNextMusic();
            }else if (intent.getAction().equals("lastNow")){
                mBinder.playLastMusic();
            }


        }
    }
}


