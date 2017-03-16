package com.jieleo.xmly_plus.model.bean.model_groom_page;

import com.jieleo.xmly_plus.tools.CallBack;
import com.jieleo.xmly_plus.tools.NetTool;

/**
 * Created by liuHao on 17/3/15.
 */
public class GroomModel implements IGroom{


    @Override
    public void getVideoData(String url, final IGroomListener iGroomListener) {
        NetTool.getInstance().startRequest(url, VideoListBean.class, new CallBack<VideoListBean>() {
            @Override
            public void onSuccess(VideoListBean response) {
                iGroomListener.onGroomSucceed(response);
            }

            @Override
            public void onError(Throwable throwable) {
                iGroomListener.onGroomError(throwable);
            }
        });
    }
}
