package com.jieleo.xmly_plus.presenter.persenter_hot_page;

import com.jieleo.xmly_plus.model.bean.model_hot_page.HotBean;
import com.jieleo.xmly_plus.model.bean.model_hot_page.HotCenterBean;
import com.jieleo.xmly_plus.model.bean.model_hot_page.HotModel;
import com.jieleo.xmly_plus.model.bean.model_hot_page.IHotListener;
import com.jieleo.xmly_plus.view.HotView;

import java.util.List;

/**
 * Created by dllo on 17/3/13.
 */

public class HotPagePresenter {
    private HotModel hotModel;
    private HotView hotView;

    public HotPagePresenter(HotView hotView) {
        this.hotView = hotView;
        hotModel = new HotModel();
    }

    public void getHotdata(String url) {
        hotModel.getIHotData(url, new IHotListener() {
            @Override
            public void onIHotSuccess(HotCenterBean hotCenterBean) {
                hotView.getHotSuccess(hotCenterBean);
            }

            @Override
            public void onIHotError() {
                hotView.getHotError();
            }
        });
    }


}
