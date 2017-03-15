package com.jieleo.xmly_plus.presenter;

import com.jieleo.xmly_plus.model.bean.model_groom_page.GroomModel;
import com.jieleo.xmly_plus.model.bean.model_groom_page.IGroomListener;
import com.jieleo.xmly_plus.model.bean.model_groom_page.VideoListBean;
import com.jieleo.xmly_plus.view.GroomView;

/**
 * Created by liuHao on 17/3/15.
 */
public class GroomPagePresenter {

    private GroomModel groomModel;
    private GroomView groomView;

    public GroomPagePresenter(GroomView groomView) {
        this.groomView = groomView;
      groomModel = new GroomModel();
    }


    public  void getViedoData(String url){

        groomModel.getVideoData(url, new IGroomListener() {
            @Override
            public void onGroomSucceed(VideoListBean videoListBean) {
                groomView.onViewSusseed(videoListBean);
            }

            @Override
            public void onGroomError(Throwable throwable) {

            }
        });



    }




}
