package com.jieleo.xmly_plus.model.bean.model_list_page;

import com.jieleo.xmly_plus.tools.CallBack;
import com.jieleo.xmly_plus.tools.NetTool;

/**
 * Created by liuHao on 17/3/10.
 */
public class ListPageModel implements IlistListener{
    @Override
    public void getListPageBean(String url, final IlistNet ilistNet) {
        NetTool.getInstance().startRequest(url, ListPageBean.class, new CallBack<ListPageBean>() {
            @Override
            public void onSuccess(ListPageBean response) {
                ilistNet.onSucceed(response);
            }

            @Override
            public void onError(Throwable throwable) {
                ilistNet.onFailed();
            }
        });
    }
}
