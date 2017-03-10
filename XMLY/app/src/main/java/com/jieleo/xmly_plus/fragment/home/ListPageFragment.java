package com.jieleo.xmly_plus.fragment.home;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.fragment.BaseFragment;
import com.jieleo.xmly_plus.model.bean.model_list_page.ListPageBean;
import com.jieleo.xmly_plus.model.bean.presenter_list_page.ListPagePresenter;
import com.jieleo.xmly_plus.model.bean.view_list_page.IlistPageView;

/**
 * Created by jie on 2017/3/9.
 */

public class ListPageFragment extends BaseFragment implements IlistPageView{
    private RecyclerView recyclerView;
    private ImageView imageView;
    private ListPagePresenter listPagePresenter;
    @Override
    protected int bindLayout() {
        return R.layout.fragment_list;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_fragment_list);
        imageView = (ImageView) view.findViewById(R.id.iv_adv_fragment_list);
        listPagePresenter
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void bindEvent() {

    }

    @Override
    public void onViewSucceed(ListPageBean listPageBean) {

    }

    @Override
    public void onViewFailed() {

    }

    @Override
    public void setFirstImage(ListPageBean listPageBean) {

    }
}
