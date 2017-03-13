package com.jieleo.xmly_plus.adapter.discover_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidkun.adapter.ViewHolder;
import com.bumptech.glide.Glide;
import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.model.bean.model_discover.DisCoverBean;
import com.jieleo.xmly_plus.tools.BaseViewHolder;

/**
 * Created by dllo on 17/3/10.
 */

public class DisCoverAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "DisCoverAdapter";
    private DisCoverBean disCoverBean;
    private Context context;

    public final int ONE = 0;
    public final int TWO = 1;
    public final int THREE = 2;
    public final int FOUR = 3;
    public final int FIVE = 4;

    public void setDisCoverBean(DisCoverBean disCoverBean) {
        this.disCoverBean = disCoverBean;
        notifyDataSetChanged();
    }

    public DisCoverAdapter(Context context) {
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case ONE:
                view = LayoutInflater.from(context).inflate(R.layout.discover_recyclerview_item, parent, false);
                holder = new OneHolder(view);
               return holder;
            case TWO:
                view = LayoutInflater.from(context).inflate(R.layout.discover_recyclerview_item, parent, false);
                holder = new OneHolder(view);
                return holder;
            case THREE:
                view = LayoutInflater.from(context).inflate(R.layout.discover_recycleview_item_two, parent, false);
                holder = new TwoHolder(view);
                return holder;
            case FOUR:
                view = LayoutInflater.from(context).inflate(R.layout.discover_recyclerview_item, parent, false);
                holder = new OneHolder(view);
                return holder;
            case FIVE:
                view = LayoutInflater.from(context).inflate(R.layout.discover_recyclerview_item_three, parent, false);
                holder = new ThreeHolder(view);
                return holder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        int type = getItemViewType(position);

        switch (type) {
//            case 0:
//                OneHolder oneHolder = (OneHolder) holder;
//                oneHolder.left.setText(disCoverBean.getList().get(0).getList().get(position).getTitle());
//                oneHolder.right.setText(disCoverBean.getList().get(0).getList().get(position).getSubtitle());
//                Glide.with(context).load(disCoverBean.getList().get(0).getList().get(position).getCoverPath()).into(oneHolder.leftImgae);
//                Glide.with(context).load(disCoverBean.getList().get(0).getList().get(position).getSubCoverPath()).into(oneHolder.rightImage);
//                Log.e(TAG, "onBindViewHolder: "+oneHolder.left);
//                break;
//            case 1:
//                OneHolder oneHoldera = (OneHolder) holder;
//                oneHoldera.left.setText(disCoverBean.getList().get(0).getList().get(position-1).getTitle());
//                oneHoldera.right.setText(disCoverBean.getList().get(0).getList().get(position-1).getSubtitle());
//                Glide.with(context).load(disCoverBean.getList().get(0).getList().get(position-1).getCoverPath()).into(oneHoldera.leftImgae);
//                Glide.with(context).load(disCoverBean.getList().get(0).getList().get(position-1).getSubCoverPath()).into(oneHoldera.rightImage);
//                Log.e(TAG, "onBindViewHolder: "+oneHoldera.leftImgae);
//                break;
//            case 2:
//                break;
//            case 3:
//                OneHolder oneHolderc = (OneHolder) holder;
//                oneHolderc.left.setText(disCoverBean.getList().get(0).getList().get(position-3).getTitle());
//                oneHolderc.right.setText(disCoverBean.getList().get(0).getList().get(position-3).getSubtitle());
//                Glide.with(context).load(disCoverBean.getList().get(0).getList().get(position-3).getCoverPath()).into(oneHolderc.leftImgae);
//                Glide.with(context).load(disCoverBean.getList().get(0).getList().get(position-3).getSubCoverPath()).into(oneHolderc.rightImage);
//                break;
//            case 4:
//                break;

        }
    }



    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ONE;
        } else if (position == 1) {
            return TWO;
        } else if (position == 2) {
            return THREE;
        } else if (position == 3) {
            return FOUR;
        } else {
            return FIVE;
        }
    }

    @Override
    public int getItemCount() {
        return disCoverBean==null?0:disCoverBean.getList().size()

                ;
    }

    class OneHolder extends RecyclerView.ViewHolder {
        private TextView left, right;
        private ImageView leftImgae, rightImage;


        public OneHolder(View itemView) {
            super(itemView);
            left = (TextView) itemView.findViewById(R.id.discover_recycleView_leftText);
            right = (TextView) itemView.findViewById(R.id.discover_recycleView_rightText);
            leftImgae = (ImageView) itemView.findViewById(R.id.discover_recycleView_leftImage);
            rightImage = (ImageView) itemView.findViewById(R.id.discover_recycleView_rightImage);
        }
    }

    class TwoHolder extends RecyclerView.ViewHolder {

        public TwoHolder(View itemView) {
            super(itemView);
        }
    }

    class ThreeHolder extends RecyclerView.ViewHolder {

        public ThreeHolder(View itemView) {
            super(itemView);
        }
    }


}
