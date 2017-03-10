package com.jieleo.xmly_plus.view;

import com.jieleo.xmly_plus.model.bean.model_list_profile.ProfileBean;

/**
 * Created by dllo on 17/3/10.
 */

public interface ProfileView {
    void onProfileViewSuccess(ProfileBean profileBean);
    void onProfileViewError();
}
