package com.jieleo.xmly_plus.presenter.presenter_ju_neng_wan_banner;

import com.jieleo.xmly_plus.model.bean.model_ju_neng_wan.IBannerListener;
import com.jieleo.xmly_plus.model.bean.model_ju_neng_wan.JuNengWanBannerBean;
import com.jieleo.xmly_plus.model.bean.model_ju_neng_wan.JuNengWanBannerModel;
import com.jieleo.xmly_plus.tools.CallBack;
import com.jieleo.xmly_plus.tools.NetPostTool;
import com.jieleo.xmly_plus.view.view_ju_neng_wan.JuNengWanBannerView;

import okhttp3.FormBody;

/**
 * Created by jie on 2017/3/22.
 */

public class JuNengWanBannerPresenter {
    private JuNengWanBannerModel mJuNengWanBannerModel;
    private JuNengWanBannerView mJuNengWanBannerView;

    private String key1="token";
    private String value1="2017032120582053991929865106003240101099717";

    private String key2="account";
    private String value2 ="40101099717";

    public JuNengWanBannerPresenter(JuNengWanBannerView juNengWanBannerView) {
        mJuNengWanBannerView = juNengWanBannerView;
        mJuNengWanBannerModel=new JuNengWanBannerModel();
    }

    public void getBannerData(String url){
        FormBody formBody=new FormBody.Builder().add(key1,value1).add(key2, value2).build();
        mJuNengWanBannerModel.getBannerData(url, new IBannerListener() {
            @Override
            public void onSuccess(JuNengWanBannerBean bean) {
                mJuNengWanBannerView.getBanner(bean);
            }

            @Override
            public void onFailed(Throwable throwable) {

            }
        });
    }


}
