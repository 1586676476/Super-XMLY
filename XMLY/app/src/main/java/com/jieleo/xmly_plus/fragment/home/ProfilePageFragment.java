package com.jieleo.xmly_plus.fragment.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jieleo.xmly_plus.MyApp;
import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.adapter.profilea_dapter.ProfileFragmentPageRVAdapter;
import com.jieleo.xmly_plus.fragment.BaseFragment;
import com.jieleo.xmly_plus.model.bean.model_list_profile.ProfileBean;
import com.jieleo.xmly_plus.presenter.persenter_profile_page.ProfilePresenter;
import com.jieleo.xmly_plus.view.ProfileView;

/**
 * Created by jie on 2017/3/9.
 */

public class ProfilePageFragment extends BaseFragment implements ProfileView {

    private RecyclerView recyclerView;
    private ProfileFragmentPageRVAdapter profileFragmentPageRVAdapter;
    private ProfilePresenter profilePresenter;
    private String url = "http://mobile.ximalaya.com/mobile/discovery/v2/rankingList/group?channel=and-a1&device=android" +
            "&includeActivity=true&includeSpecial=true&scale=2&version=5.4.87";

    @Override
    protected int bindLayout() {
        return R.layout.fragment_profile;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

        recyclerView = (RecyclerView) view.findViewById(R.id.rv_fragment_profile);
        profileFragmentPageRVAdapter = new ProfileFragmentPageRVAdapter(MyApp.getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(MyApp.getContext()));
        recyclerView.setAdapter(profileFragmentPageRVAdapter);
        profilePresenter = new ProfilePresenter(this);
        profilePresenter.profileData(url);
    }

    @Override
    protected void initData() {


    }

    @Override
    protected void bindEvent() {

    }

    @Override
    public void onProfileViewSuccess(ProfileBean profileBean) {
        profileFragmentPageRVAdapter.setProfileBean(profileBean);
    }

    @Override
    public void onProfileViewError() {

    }
}
