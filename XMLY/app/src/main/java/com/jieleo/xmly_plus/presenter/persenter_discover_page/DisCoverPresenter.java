package com.jieleo.xmly_plus.presenter.persenter_discover_page;

import com.jieleo.xmly_plus.model.bean.model_discover.DisCoverBean;
import com.jieleo.xmly_plus.model.bean.model_discover.DisCoverModel;
import com.jieleo.xmly_plus.model.bean.model_discover.IDisCoverListener;
import com.jieleo.xmly_plus.view.DisCoverView;

/**
 * Created by dllo on 17/3/10.
 */

public class DisCoverPresenter {
    private DisCoverModel disCoverModel;
    private DisCoverView disCoverView;

    public DisCoverPresenter(DisCoverView disCoverView) {
        this.disCoverView = disCoverView;
        disCoverModel = new DisCoverModel();
    }

    public void getDisCoverData(String url){
        disCoverModel.getData(url, new IDisCoverListener() {
            @Override
            public void onSuccess(DisCoverBean disCoverBean) {
                disCoverView.RequestSuccess(disCoverBean);
            }

            @Override
            public void Error() {
                disCoverView.RequestFail();
            }
        });
    }
}
