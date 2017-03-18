package com.jieleo.xmly_plus;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Environment;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;

import cn.sharesdk.framework.ShareSDK;

import cn.smssdk.SMSSDK;

/**
 * Created by liuHao on 17/3/9.
 */
public class MyApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        ShareSDK.initSDK(context);
        SpeechUtility.createUtility(this, SpeechConstant.APPID+"=58ca851b");

    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }


    public static Context getContext() {
        return context;
    }


}
