package com.jieleo.xmly_plus.activity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by yuyongjie on 17/3/23.
 */


public class LocalMusicBean implements Parcelable {
    private String songName;
    private String singerName;
    private Long duringTime;
    private String url;
    private String albumArt;



    public String getSongName() {
        return songName;
    }

    public LocalMusicBean setSongName(String songName) {
        this.songName = songName;
        return this;
    }

    public String getSingerName() {
        return singerName;
    }

    public LocalMusicBean setSingerName(String singerName) {
        this.singerName = singerName;
        return this;
    }

    public Long getDuringTime() {
        return duringTime;
    }

    public LocalMusicBean setDuringTime(Long duringTime) {
        this.duringTime = duringTime;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public LocalMusicBean setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getAlbumArt() {
        return albumArt;
    }

    public LocalMusicBean setAlbumArt(String albumArt) {
        this.albumArt = albumArt;
        return this;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.songName);
        dest.writeString(this.singerName);
        dest.writeValue(this.duringTime);
        dest.writeString(this.url);
        dest.writeString(this.albumArt);
    }

    public LocalMusicBean() {
    }

    public LocalMusicBean(String songName, String singerName, Long duringTime, String url, String albumArt) {
        this.songName = songName;
        this.singerName = singerName;
        this.duringTime = duringTime;
        this.url = url;
        this.albumArt = albumArt;
    }

    protected LocalMusicBean(Parcel in) {
        this.songName = in.readString();
        this.singerName = in.readString();
        this.duringTime = (Long) in.readValue(Long.class.getClassLoader());
        this.url = in.readString();
        this.albumArt = in.readString();
    }

    public static final Parcelable.Creator<LocalMusicBean> CREATOR = new Parcelable.Creator<LocalMusicBean>() {
        @Override
        public LocalMusicBean createFromParcel(Parcel source) {
            return new LocalMusicBean(source);
        }

        @Override
        public LocalMusicBean[] newArray(int size) {
            return new LocalMusicBean[size];
        }
    };
}
