package com.jieleo.xmly_plus.view.view_search;

import com.jieleo.xmly_plus.model.bean.model_search_.SearchBean;

/**
 * Created by dllo on 17/3/16.
 */

public interface SearchView {
    void Success(SearchBean searchBean);
    void Failed();
}
