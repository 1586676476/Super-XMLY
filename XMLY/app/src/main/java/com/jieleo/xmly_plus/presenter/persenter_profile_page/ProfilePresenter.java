package com.jieleo.xmly_plus.presenter.persenter_profile_page;

import com.jieleo.xmly_plus.model.bean.model_list_profile.ProfileBean;
import com.jieleo.xmly_plus.model.bean.model_list_profile.ProfileListener;
import com.jieleo.xmly_plus.model.bean.model_list_profile.ProfileModel;
import com.jieleo.xmly_plus.view.ProfileView;

/**
 * Created by dllo on 17/3/10.
 */

public class ProfilePresenter {
    private ProfileModel profileModel;
    private ProfileView profileView;

    public ProfilePresenter(ProfileView profileView) {
        this.profileView = profileView;
        profileModel=new ProfileModel();
    }

    public void profileData(String url){
        profileModel.getProfileData(url, new ProfileListener() {
            @Override
            public void onSuccess(ProfileBean profileBean) {
                profileView.onProfileViewSuccess(profileBean);
            }

            @Override
            public void onError() {
                profileView.onProfileViewError();
            }
        });
    }
}
