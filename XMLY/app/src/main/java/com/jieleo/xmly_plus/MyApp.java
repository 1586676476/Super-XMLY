package com.jieleo.xmly_plus;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Environment;
import com.baidu.mapapi.SDKInitializer;

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

        SDKInitializer.initialize(getContext());


//        if(inMainProcess()){
//            // 1、UI相关初始化操作
//            // 2、相关Service调用
//        }

//        if(inMainProcess()){
//            // 1、UI相关初始化操作
//            // 2、相关Service调用
//        }
    }



    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }


    public static Context getContext(){
        return context;
    }


}
