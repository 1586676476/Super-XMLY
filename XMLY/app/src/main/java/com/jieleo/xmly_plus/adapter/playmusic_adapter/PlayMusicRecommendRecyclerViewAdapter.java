package com.jieleo.xmly_plus.adapter.playmusic_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.model.bean.model_play_music.PlayMusicBean;
import com.jieleo.xmly_plus.tools.BaseViewHolder;

import java.util.List;

/**
 * Created by jie on 2017/3/13.
 */

public class   PlayMusicRecommendRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private static final String TAG = "PlayMusicRecommendRecyc";
    private List<PlayMusicBean.AssociationAlbumsInfoBean> mBeen;
    private Context mContext;

    public void setBeen(List<PlayMusicBean.AssociationAlbumsInfoBean> been) {
        mBeen = been;
        notifyDataSetChanged();
    }

    public PlayMusicRecommendRecyclerViewAdapter(Context context) {
        mContext = context;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return BaseViewHolder.onCreatMyViewHolder(mContext,parent, R.layout.item_recommend_rv_play_music);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        PlayMusicBean.AssociationAlbumsInfoBean mBean=mBeen.get(position);
        Log.e(TAG, "onBindViewHolder: "+mBean.getIntro() );
            holder.setOnLineImage(R.id.iv_head_recommend_rv_activity_play_music, mBean.getCoverSmall());
            holder.setText(R.id.tv_title_recommend_rv_activity_play_music, mBean.getTitle());
            holder.setText(R.id.tv_introduction_commend_rv_acy_play_music, mBean.getIntro());
    }

    @Override
    public int getItemCount() {
        return mBeen !=null? mBeen.size():0;
    }
}
