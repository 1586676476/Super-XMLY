package com.jieleo.xmly_plus;

import android.app.Application;
import android.content.Context;

import cn.sharesdk.framework.ShareSDK;

/**
 * Created by liuHao on 17/3/9.
 */
public  class MyApp extends Application{

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        ShareSDK.initSDK(context);

    }

    public static Context getContext(){
        return context;
    }
}
