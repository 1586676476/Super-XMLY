package com.jieleo.xmly_plus.model.bean.model_ju_neng_wan;

import com.jieleo.xmly_plus.tools.CallBack;
import com.jieleo.xmly_plus.tools.NetPostTool;

import okhttp3.FormBody;

/**
 * Created by yuyongjie on 17/3/22.
 */


public class JuNengWanBannerModel implements IGetJuNengWanBanner{


    private String url="http://appserver.jnwtv.com:8080/jnwtv-client/common/listbanner";

    String key1="token";
    String value1="2017032120582053991929865106003240101099717";

    String key2="account" ;
    String value2="40101099717";
    @Override
    public void getBannerData(String url, final IBannerListener listener) {
        FormBody formBody=new FormBody.Builder().add(key1,value1).add(key2,value2).build();
        NetPostTool.getInstance().startPostRequest(url, formBody, JuNengWanBannerBean.class, new CallBack<JuNengWanBannerBean>() {
            @Override
            public void onSuccess(JuNengWanBannerBean response) {
                listener.onSuccess(response);
            }

            @Override
            public void onError(Throwable throwable) {
                listener.onFailed(throwable);
            }
        });
    }
}
