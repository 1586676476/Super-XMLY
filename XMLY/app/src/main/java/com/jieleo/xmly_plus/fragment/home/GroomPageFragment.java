package com.jieleo.xmly_plus.fragment.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.androidkun.PullToRefreshRecyclerView;
import com.bumptech.glide.Glide;
import com.jieleo.xmly_plus.MyApp;
import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.activity.JieCaoPlayerActivity;
import com.jieleo.xmly_plus.adapter.GroomPageRvAdapter;
import com.jieleo.xmly_plus.fragment.BaseFragment;
import com.jieleo.xmly_plus.model.bean.model_groom_page.VideoListBean;
import com.jieleo.xmly_plus.presenter.GroomPagePresenter;
import com.jieleo.xmly_plus.tools.MyRecyclerClickListener;
import com.jieleo.xmly_plus.tools.MyUrl;
import com.jieleo.xmly_plus.view.GroomView;

/**
 * Created by jie on 2017/3/9.
 */

public class GroomPageFragment extends BaseFragment implements GroomView,MyRecyclerClickListener, View.OnClickListener {
    private PullToRefreshRecyclerView recyclerView;
    private GroomPageRvAdapter groomPageRvAdapter;
    private GroomPagePresenter groomPagePresenter;
    private VideoListBean videoListBean;
    private Button jiecao;
    private ImageView mImageView;

    @Override
    protected int bindLayout() {
        return R.layout.fragment_groom;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        recyclerView = (PullToRefreshRecyclerView) view.findViewById(R.id.rv_list_video);
        jiecao = (Button) view.findViewById(R.id.fragment_groom_jiecao);
        mImageView = (ImageView) view.findViewById(R.id.iv_groom_fragment);
    }

    @Override
    protected void initData() {
        groomPageRvAdapter = new GroomPageRvAdapter(MyApp.getContext());
        recyclerView.setLayoutManager(new GridLayoutManager(MyApp.getContext(), 2, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(groomPageRvAdapter);
        groomPagePresenter = new GroomPagePresenter(this);
//        groomPagePresenter.getViedoData(MyUrl.VIDEO_NEW_URL);
        jiecao.setOnClickListener(this);
        Glide.with(this).load("http://d.hiphotos.baidu.com/image/pic/item/2fdda3cc7cd98d10ba9982dc253fb80e7aec908a.jpg").into(mImageView);

    }

    @Override
    protected void bindEvent() {

    }

    @Override
    public void onViewSusseed(VideoListBean videoListBean) {
        this.videoListBean = videoListBean;
        groomPageRvAdapter.setVideoListBean(videoListBean);
    }

    @Override
    public void onViewError() {

    }

    @Override
    public void onRecyclerItemClick(int position) {
//        Intent intent = new Intent(getActivity(),)
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fragment_groom_jiecao:
                Intent intent = new Intent(getContext(), JieCaoPlayerActivity.class);
                startActivity(intent);

        }
    }
}