package com.jieleo.xmly_plus.model.bean.model_search_;

import java.util.List;

/**
 * Created by dllo on 17/3/16.
 */

public interface SearchListener {

    void getSearchOnSuccess(SearchBean[] searchBeanList);
    void getSearchOnError();
}
