package com.jieleo.xmly_plus.model.bean;

import java.util.List;

/**
 * Created by yuyongjie on 17/3/9.
 */


public interface IGetWordsListener {
    List<String> onSuccess(TabWordsBean tabWordsBean);
    void onError();
}
