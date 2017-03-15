package com.jieleo.xmly_plus.adapter.hot_adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.androidkun.adapter.ViewHolder;
import com.bumptech.glide.Glide;
import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.fragment.home.HotPageFragment;
import com.jieleo.xmly_plus.model.bean.model_hot_page.HotBean;
import com.jieleo.xmly_plus.model.bean.model_hot_page.HotCenterBean;
import com.jieleo.xmly_plus.tools.BaseViewHolder;
import com.jieleo.xmly_plus.tools.CallBack;
import com.jieleo.xmly_plus.tools.DemoRecyclerView;
import com.jieleo.xmly_plus.tools.MyUrl;
import com.jieleo.xmly_plus.tools.NetTool;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 17/3/13.
 */

public class HotAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "HotAdapter";
    private HotCenterBean hotCenterBean;

    public void setHotCenterBean(HotCenterBean hotCenterBean) {
        this.hotCenterBean = hotCenterBean;
        notifyDataSetChanged();
    }

    private List<String> picture;
    private Context context;

    public HotAdapter(Context context) {
        this.context = context;
    }

    private int HEAD = 0;
    private int CENTER = 1;
    private int BLOW = 2;


    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEAD;
        } else if (position == 1) {
            return CENTER;
        } else {
            return BLOW;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(context).inflate(R.layout.fragment_hot_head, parent, false);
                viewHolder = new HeadViewHolder(view);
                break;
            case 1:
                view = LayoutInflater.from(context).inflate(R.layout.fragment_hot_center, parent, false);
                viewHolder = new CenterViewHolder(view);
                break;
            case 2:
                view = LayoutInflater.from(context).inflate(R.layout.fragment_hot_below, parent, false);
                viewHolder = new BelowViewHolder(view);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        switch (type) {
            case 0:
                //轮播图
                final HeadViewHolder headViewHolder = (HeadViewHolder) holder;
                picture = new ArrayList<>();
                //设置轮播图属性
                headViewHolder.banner.setDelayTime(4000);
                headViewHolder.banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
                headViewHolder.banner.setBannerStyle(BannerConfig.LEFT);
                headViewHolder.banner.setImageLoader(new MyImageLoader());

                NetTool.getInstance().startRequest(MyUrl.HOT_LUNBOTU, HotBean.class, new CallBack<HotBean>() {
                    @Override
                    public void onSuccess(HotBean response) {
                        for (int i = 0; i < response.getFocusImages().getList().size(); i++) {
                            picture.add(response.getFocusImages().getList().get(i).getPic());
                        }
                        headViewHolder.banner.setImages(picture);
                        headViewHolder.banner.start();
                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }
                });
                break;
            case 1:
                //横向滑动recycleView
                CenterViewHolder centerViewHolder = (CenterViewHolder) holder;
                HotCenterAdapter adapter = new HotCenterAdapter(context);
                adapter.setHotCenterBean(hotCenterBean);
                LinearLayoutManager manager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
                centerViewHolder.demoRecyclerView.setLayoutManager(manager);
                centerViewHolder.demoRecyclerView.setAdapter(adapter);
                break;
            case 2:
                //听小说等recycleView
                BelowViewHolder belowViewHolder = (BelowViewHolder) holder;
                HotBelowAdapter hotBelowAdapter = new HotBelowAdapter(context);
                hotBelowAdapter.setHotCenterBean(hotCenterBean);
//                belowViewHolder.recyclerView.setLayoutManager(new GridLayoutManager(context,3));
                belowViewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
                belowViewHolder.recyclerView.setAdapter(hotBelowAdapter);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return hotCenterBean!=null?3:0;
    }

    class HeadViewHolder extends RecyclerView.ViewHolder {
        private Banner banner;

        public HeadViewHolder(View itemView) {
            super(itemView);
            banner = (Banner) itemView.findViewById(R.id.fragment_hot_banner);
        }
    }

    class CenterViewHolder extends RecyclerView.ViewHolder {
        private DemoRecyclerView demoRecyclerView;

        public CenterViewHolder(View itemView) {
            super(itemView);
            demoRecyclerView = (DemoRecyclerView) itemView.findViewById(R.id.fragment_hot_recycleView);
        }
    }

    class BelowViewHolder extends RecyclerView.ViewHolder {
        private DemoRecyclerView recyclerView;

        public BelowViewHolder(View itemView) {
            super(itemView);
            recyclerView = (DemoRecyclerView) itemView.findViewById(R.id.fragment_hot_below_recycleView);
        }
    }

    class MyImageLoader extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }

}
