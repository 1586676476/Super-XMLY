package com.jieleo.xmly_plus.view;

import com.jieleo.xmly_plus.model.bean.model_hot_page.HotBean;
import com.jieleo.xmly_plus.model.bean.model_hot_page.HotCenterBean;

/**
 * Created by dllo on 17/3/13.
 */

public interface HotView {
    void getHotSuccess(HotCenterBean hotCenterBean);
    void getHotError();


}
