package com.jieleo.xmly_plus.service;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Log;

import com.jieleo.xmly_plus.MyApp;
import com.jieleo.xmly_plus.activity.LocalMusicBean;
import com.jieleo.xmly_plus.tools.SPUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuyongjie on 17/3/23.
 */


public class PlayMusicService extends Service{
    private static final String TAG = "PlayMusicService";
    //声明mybinner对象
    private MyBinder mBinder;

    //声明mediapleayer对象
    private MediaPlayer mMediaPlayer;

    //声明记录是否第一次播放
    private boolean mIsFirst=true;

    //播放模式   本地 or 网络
    private boolean PlayMode=true;

    //本地播放位置的变量
    private int index;

    //声明本地MusicBean对象的集合
    private List<LocalMusicBean> mLocalMusicBeen;


    @Override
    public void onCreate() {
        super.onCreate();
        //初始化binner对象
        mBinder =new MyBinder();
        //初始化mediaplayer对象
        mMediaPlayer =new MediaPlayer();
        //初始化本地音乐集合
        mLocalMusicBeen=new ArrayList<>();
        //对MediaPlayer完成播放进行监听
        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (PlayMode){
                index++;
                mMediaPlayer.reset();
                mBinder.playLocal();
                }else {
                    index++;
                    mMediaPlayer.reset();
                    //TODO 播放网络
                }
            }
        });
        if (PlayMode){
            //获取本地音乐
        getMusicData();
        }else {
            //获取网络音乐
        }


    }



    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }


    @Override
    public boolean onUnbind(Intent intent) {
        mMediaPlayer.reset();
        mMediaPlayer.release();
        return super.onUnbind(intent);
    }

    @Override
    public void unbindService(ServiceConnection conn) {
        super.unbindService(conn);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    public void getMusicData() {

        //根据uri找到所有的音频信息
        Cursor cursor = getContentResolver().
                query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                        null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {

            do {
                //获取音乐的名字
                String title = cursor.getString(
                        cursor.getColumnIndex(
                                MediaStore.Audio.Media.TITLE));
                //歌手名字
                String singer = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
                //获取歌曲的url
                String url = cursor.getString
                        (cursor.getColumnIndex
                                (MediaStore.Audio.Media.DATA));
                //获取音乐类型 0 代表不是音乐
                int isMusic = cursor.getInt
                        (cursor.getColumnIndex
                                (MediaStore.Audio.Media.IS_MUSIC));
                //获取音乐的时长
                Long duringTime = cursor.getLong
                        (cursor.getColumnIndex
                                (MediaStore.Audio.Media.DURATION));
                String Id=cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID));
                Log.e(TAG, "getMusicData: "+"++++++++++++++++++++"+Id );
                int id=Integer.valueOf(Id);
                String albumArt=getAlbumArt(id);
                if (isMusic != 0 && duringTime / 60 * 1000 > 1) {
                    LocalMusicBean bean = new LocalMusicBean(title,singer,duringTime,url,albumArt);
                    mLocalMusicBeen.add(bean);
                }


            } while (cursor.moveToNext());
            for (LocalMusicBean bean : mLocalMusicBeen) {
                Log.d(TAG, "SongName:"+bean.getSongName() +"SingerName"+ bean.getSingerName() +"DuringTime"+ bean.getDuringTime() +"封面"+ bean.getAlbumArt());
                 }
        }
        //关闭游标
        cursor.close();
    }






    private String getAlbumArt(int Id) {
        String mUriAlbums = "content://media/external/audio/albums";
        String[] projection = new String[] { "album_art" };
        Cursor cur = this.getContentResolver().query(  Uri.parse(mUriAlbums + "/" + Integer.toString(Id)),  projection, null, null, null);
        String album_art = null;
        if (cur.getCount() > 0 && cur.getColumnCount() > 0)
        {  cur.moveToNext();
            album_art = cur.getString(0);
        }
        cur.close();
        Log.e(TAG, "getAlbumArt: "+"__________-------"+album_art );
        return album_art;
    }
   public class MyBinder extends Binder{
        public MyBinder() {
        }

        /**
         * 播放本地音乐
         */
        public void playLocal(){
            LocalMusicBean musicBean =mLocalMusicBeen.get(index);

            try {
                //设置要播放的音乐资源
                mMediaPlayer.setDataSource(musicBean.getUrl());
                //准备
                mMediaPlayer.prepare();
                //播放
                mMediaPlayer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Intent intent=new Intent("LocalMusic");
            intent.putExtra("LocalMusicBean",musicBean);
            intent.putParcelableArrayListExtra("LocalMusicBeen", (ArrayList<? extends Parcelable>) mLocalMusicBeen);
            intent.putExtra("index",index);
            sendBroadcast(intent);
            Intent playIntent=new Intent("play");
            playIntent.putExtra("LocalMusic",mLocalMusicBeen.get(index));
            sendBroadcast(playIntent);
        }


        public void playNextMusic(){

            if (index==mLocalMusicBeen.size()-1){
                index=0;
            }else {
                index++;
            }
            mMediaPlayer.reset();
            playLocal();
        }

        public void playLastMusic(){
            if (index==0){
                index=mLocalMusicBeen.size()-1;
            }else {
                index--;
            }
            mMediaPlayer.reset();
            playLocal();
        }


       /**
        * 播放网络音乐
        * @return
        */
       public void playOnline(String url){
           try {
               mMediaPlayer.setDataSource(url);
               mMediaPlayer.prepare();
               mMediaPlayer.start();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }

       public void playOnlineNext(String nextUrl){
           mMediaPlayer.reset();
           playOnline(nextUrl);
       }

       public void playOnlineLast(String lastUrl){
           mMediaPlayer.reset();
           playOnline(lastUrl);
       }






       //是否正在播放
       public boolean isPlaying(){
            return mMediaPlayer.isPlaying();
        }
        //暂停
        public void pause(){
            mMediaPlayer.pause();
            Intent intent=new Intent("play");
            intent.putExtra("LocalMusic",mLocalMusicBeen.get(index));
            sendBroadcast(intent);
        }

        public void coutinuePlay(){
            mMediaPlayer.start();
            Intent intent=new Intent("play");
            intent.putExtra("LocalMusic",mLocalMusicBeen.get(index));
            sendBroadcast(intent);
        }

        public boolean isFirst(){
            return mIsFirst;
        }

        public void setFirst(){
            mIsFirst=false;
        }


        public int getDuring(){
            return mMediaPlayer.getDuration();
        }
        public int getCurrentProgress(){
            return mMediaPlayer.getCurrentPosition();
        }

        public void setMediaProgress(int progress){
            mMediaPlayer.seekTo(progress);
        }


    }
}
