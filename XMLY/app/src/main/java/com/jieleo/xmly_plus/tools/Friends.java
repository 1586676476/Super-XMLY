package com.jieleo.xmly_plus.tools;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by liuHao on 17/3/23.
 */
public class Friends implements Parcelable{
    private String userName;
    private String reason;

    protected Friends(Parcel in) {
        userName = in.readString();
        reason = in.readString();
    }

    public Friends(String userName, String reason) {
        this.userName = userName;
        this.reason = reason;
    }

    public Friends() {
    }

    public static final Creator<Friends> CREATOR = new Creator<Friends>() {
        @Override
        public Friends createFromParcel(Parcel in) {
            return new Friends(in);
        }

        @Override
        public Friends[] newArray(int size) {
            return new Friends[size];
        }
    };

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userName);
        dest.writeString(reason);
    }
}
