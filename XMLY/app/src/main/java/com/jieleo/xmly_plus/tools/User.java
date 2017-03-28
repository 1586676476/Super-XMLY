package com.jieleo.xmly_plus.tools;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by liuHao on 17/3/21.
 */
public class User implements Parcelable{

    private  String name;
    private String psd;

    public User() {
    }

    public User(String name, String psd) {
        this.name = name;
        this.psd = psd;
    }

    protected User(Parcel in) {
        name = in.readString();
        psd = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPsd() {
        return psd;
    }

    public void setPsd(String psd) {
        this.psd = psd;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(psd);
    }
}
