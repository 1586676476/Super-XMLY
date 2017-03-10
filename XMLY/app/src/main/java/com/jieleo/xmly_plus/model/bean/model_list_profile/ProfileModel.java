package com.jieleo.xmly_plus.model.bean.model_list_profile;

import com.jieleo.xmly_plus.tools.CallBack;
import com.jieleo.xmly_plus.tools.NetTool;

/**
 * Created by dllo on 17/3/10.
 */

public class ProfileModel implements Profile{
    @Override
    public void getProfileData(String url, final ProfileListener profileListener) {
        NetTool.getInstance().startRequest(url, ProfileBean.class, new CallBack<ProfileBean>() {
            @Override
            public void onSuccess(ProfileBean response) {
                profileListener.onSuccess(response);
            }

            @Override
            public void onError(Throwable throwable) {
                profileListener.onError();
            }
        });
    }
}
