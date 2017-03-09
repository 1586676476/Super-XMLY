package com.jieleo.xmly_plus.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jieleo.xmly_plus.R;

/**
 * Created by yuyongjie on 17/3/9.
 */


public class DiscoverFragment extends BaseFragment implements View.OnClickListener {

    private LinearLayout history, load;
    private ImageView imageView;

    @Override
    protected int bindLayout() {
        return R.layout.fragment_discover;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        history = (LinearLayout) view.findViewById(R.id.merge_history);
        load = (LinearLayout) view.findViewById(R.id.merge_load);
        imageView = (ImageView) view.findViewById(R.id.merge_search);
    }

    @Override
    protected void initData() {
        history.setOnClickListener(this);
        load.setOnClickListener(this);
        imageView.setOnClickListener(this);
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
}
