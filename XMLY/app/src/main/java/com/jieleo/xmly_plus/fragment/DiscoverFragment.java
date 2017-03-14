package com.jieleo.xmly_plus.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.adapter.discover_adapter.DisCoverAdapter;
import com.jieleo.xmly_plus.model.bean.model_discover.DisCoverBean;
import com.jieleo.xmly_plus.presenter.persenter_discover_page.DisCoverPresenter;
import com.jieleo.xmly_plus.view.DisCoverView;

/**
 * Created by yuyongjie on 17/3/9.
 */


public class DiscoverFragment extends BaseFragment implements View.OnClickListener,DisCoverView {

    private LinearLayout history, load;
    private ImageView imageView;

    private RecyclerView recyclerView;
    private DisCoverAdapter disCoverAdapter;
    private DisCoverPresenter disCoverPresenter;

    private String url="http://140.207.215.247/mobile/discovery/v1/square/list?cityCode=43_220000_2203" +
            "&device=android&timestamp=1489059340075&version=5.4.87";

    @Override
    protected int bindLayout() {
        return R.layout.fragment_discover;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        history = (LinearLayout) view.findViewById(R.id.merge_history);
        load = (LinearLayout) view.findViewById(R.id.merge_load);
        imageView = (ImageView) view.findViewById(R.id.merge_search);

        recyclerView= (RecyclerView) view.findViewById(R.id.discover_recyclerView);
        disCoverPresenter=new DisCoverPresenter(this);
        disCoverPresenter.getDisCoverData(url);
    }

    @Override
    protected void initData() {
        history.setOnClickListener(this);
        load.setOnClickListener(this);
        imageView.setOnClickListener(this);
        disCoverAdapter=new DisCoverAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(disCoverAdapter);

    }

    @Override
    protected void bindEvent() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.merge_search:
                break;
            case R.id.merge_history:
                break;
            case R.id.merge_load:
                break;

        }
    }

    @Override
    public void RequestSuccess(DisCoverBean disCoverBean) {
        disCoverAdapter.setDisCoverBean(disCoverBean);
    }

    @Override
    public void RequestFail() {

    }
}
