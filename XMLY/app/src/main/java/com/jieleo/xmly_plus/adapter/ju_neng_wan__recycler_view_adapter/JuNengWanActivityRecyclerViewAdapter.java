package com.jieleo.xmly_plus.adapter.ju_neng_wan__recycler_view_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jieleo.xmly_plus.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

/**
 * Created by jie on 2017/3/22.
 */

public class JuNengWanActivityRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<String> bannerUrls;
    private static final int BANNER_TYPE=0;

    public JuNengWanActivityRecyclerViewAdapter(Context context) {
        mContext = context;
    }

    public void setBannerUrls(List<String> bannerUrls) {
        this.bannerUrls = bannerUrls;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder=null;
        if (viewHolder==null){
        switch (viewType) {
            case BANNER_TYPE:
            View view= LayoutInflater.from(mContext).inflate(R.layout.item_banner_ju_neng_wan,parent,false);
                viewHolder=new BannerHolder(view);
        }

        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BannerHolder bannerHolder= (BannerHolder) holder;
        bannerHolder.mBanner.setImages(bannerUrls);
        bannerHolder.mBanner.setDelayTime(3000);
        bannerHolder.mBanner.setBannerStyle(BannerConfig.CENTER);
        bannerHolder.mBanner.setImageLoader(new MyImageLoader());
        bannerHolder.mBanner.isAutoPlay(true);
        bannerHolder.mBanner.start();
    }

    @Override
    public int getItemCount() {
        return 1;
    }


    @Override
    public int getItemViewType(int position) {
       if (position==0){
           return BANNER_TYPE;
       }
       return 0;
    }

    class BannerHolder extends RecyclerView.ViewHolder{
        private Banner mBanner;
        public BannerHolder(View itemView) {
            super(itemView);
            mBanner= (Banner) itemView.findViewById(R.id.banner_ju_neng_wan);
        }
    }


    class MyImageLoader extends ImageLoader{

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }
}
