package com.jieleo.xmly_plus.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.model.bean.model_groom_page.VideoListBean;
import com.jieleo.xmly_plus.tools.BaseViewHolder;

import java.util.List;

/**
 * Created by liuHao on 17/3/15.
 */
public class GroomPageRvAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private VideoListBean videoListBean;
    private Context context;
    private List<VideoListBean.ResultBean.MvListBean> datas;

    public GroomPageRvAdapter(Context context) {
        this.context = context;
    }

    public void setVideoListBean(VideoListBean videoListBean) {
        this.videoListBean = videoListBean;
        datas = videoListBean.getResult().getMv_list();
        notifyDataSetChanged();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return  BaseViewHolder.onCreatMyViewHolder(context,parent, R.layout.item_video_groom_page);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.setOnLineImage(R.id.iv_item_gird_video,datas.get(position).getThumbnail());
        holder.setText(R.id.tv_item_gird_name,datas.get(position).getTitle());
        holder.setText(R.id.tv_item_gird_author,datas.get(position).getArtist());
    }

    @Override
    public int getItemCount() {
        return videoListBean==null?0:videoListBean.getResult().getMv_list().size();
    }
}
