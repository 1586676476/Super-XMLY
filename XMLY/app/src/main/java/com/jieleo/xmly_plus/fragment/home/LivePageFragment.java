package com.jieleo.xmly_plus.fragment.home;

import android.os.Bundle;
import android.view.View;

import com.androidkun.PullToRefreshRecyclerView;
import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.fragment.BaseFragment;

/**
 * Created by jie on 2017/3/9.
 */

public class LivePageFragment extends BaseFragment {
    private PullToRefreshRecyclerView recyclerView;
    @Override
    protected int bindLayout() {
        return R.layout.fragment_live;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        recyclerView = (PullToRefreshRecyclerView) view.findViewById(R.id.rv_fragment_live);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void bindEvent() {

    }
}
