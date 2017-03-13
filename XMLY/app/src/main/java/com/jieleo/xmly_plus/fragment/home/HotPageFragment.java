package com.jieleo.xmly_plus.fragment.home;

import android.content.Context;
import android.graphics.Picture;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.adapter.hot_adapter.HotCenterAdapter;
import com.jieleo.xmly_plus.fragment.BaseFragment;
import com.jieleo.xmly_plus.model.bean.model_hot_page.HotBean;
import com.jieleo.xmly_plus.model.bean.model_hot_page.HotCenterBean;
import com.jieleo.xmly_plus.presenter.persenter_hot_page.HotPagePresenter;
import com.jieleo.xmly_plus.tools.CallBack;
import com.jieleo.xmly_plus.tools.DemoRecyclerView;
import com.jieleo.xmly_plus.tools.MyUrl;
import com.jieleo.xmly_plus.tools.NetTool;
import com.jieleo.xmly_plus.view.HotView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jie on 2017/3/9.
 */

public class HotPageFragment extends BaseFragment implements HotView {
    private static final String TAG = "HotPageFragment";

    private Banner banner;
    private HotPagePresenter hotPagePresenter;
    private List<String> picture;

    private DemoRecyclerView recycleView;
    private HotCenterAdapter hotCenterAdapter;



    @Override
    protected int bindLayout() {
        return R.layout.fragment_hot;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {


        banner = (Banner) view.findViewById(R.id.fragment_hot_banner);
        hotPagePresenter = new HotPagePresenter(this);
        hotPagePresenter.getHotdata(MyUrl.HOT_CENTER);
        picture = new ArrayList<>();
        banner();

        recycleView = (DemoRecyclerView) view.findViewById(R.id.fragment_hot_recycleView);
        hotCenterAdapter = new HotCenterAdapter(getContext());
        LinearLayoutManager manager=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recycleView.setLayoutManager(manager);
        recycleView.setAdapter(hotCenterAdapter);

    }

    private void banner() {
        //设置轮播图属性
        banner.setDelayTime(4000);
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        banner.setBannerStyle(BannerConfig.LEFT);
        banner.setImageLoader(new MyImageLoader());

        NetTool.getInstance().startRequest(MyUrl.HOT_LUNBOTU, HotBean.class, new CallBack<HotBean>() {
            @Override
            public void onSuccess(HotBean response) {
                for (int i = 0; i < response.getFocusImages().getList().size(); i++) {
                    picture.add(response.getFocusImages().getList().get(i).getPic());
                }
                banner.setImages(picture);
                banner.start();
            }
            @Override
            public void onError(Throwable throwable) {

            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void bindEvent() {

    }

    @Override
    public void getHotSuccess(HotCenterBean hotCenterBean) {
        hotCenterAdapter.setHotCenterBean(hotCenterBean);
    }

    @Override
    public void getHotError() {

    }

    class MyImageLoader extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }


}
