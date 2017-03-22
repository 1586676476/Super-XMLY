package com.jieleo.xmly_plus.tools;

import okhttp3.FormBody;

/**
 * Created by yuyongjie on 17/3/22.
 */


public class NetPostTool implements NetPostInterface {
    private static  NetPostTool ourInstance ;

    private NetPostInterface mNetPostInterface;

    public static NetPostTool getInstance() {
        if (ourInstance==null){
            synchronized (NetPostTool.class){
                if (ourInstance==null){
                    ourInstance=new NetPostTool();
                }
            }
        }
        return ourInstance;
    }

    private NetPostTool() {
        mNetPostInterface=new NetPostTool();
    }

    @Override
    public <T> void startPostRequest(String url, FormBody formBody, Class<T> tClass, CallBack callBack) {
            mNetPostInterface.startPostRequest(url,formBody,tClass,callBack);
    }
}
