package com.jieleo.xmly_plus.model;

import java.util.List;

/**
 * Created by yuyongjie on 17/3/9.
 */


public interface IGetWordsListener {
    void onSuccess(TabWordsBean tabWordsBean);
    void onError();
}
