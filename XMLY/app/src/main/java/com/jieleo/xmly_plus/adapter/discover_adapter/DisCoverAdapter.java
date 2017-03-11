package com.jieleo.xmly_plus.adapter.discover_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.model.bean.model_discover.DisCoverBean;
import com.jieleo.xmly_plus.tools.BaseViewHolder;

/**
 * Created by dllo on 17/3/10.
 */

public class DisCoverAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private DisCoverBean disCoverBean;
    private Context context;

    public final int ONE=0;
    public final int TWO=1;
    public final int THREE=2;
    public final int FOUR=3;
    public final int FIVE=4;

    public void setDisCoverBean(DisCoverBean disCoverBean) {
        this.disCoverBean = disCoverBean;
    }

    public DisCoverAdapter(Context context) {
        this.context = context;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return BaseViewHolder.onCreatMyViewHolder(context, parent, R.layout.discover_recyclerview_item);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        load(holder, position);
     }

    private void load(BaseViewHolder holder, int position) {
        DisCoverBean.ListBeanX listBeanX=disCoverBean.getList().get(position);

        for (int i = 0; i < listBeanX.getList().size(); i++) {
            holder.setText(R.id.discover_recycleView_leftText,listBeanX.getList().get(i).getTitle());
            holder.setText(R.id.discover_recycleView_rightText,listBeanX.getList().get(i).getSubtitle());
            holder.setOnLineImage(R.id.discover_recycleView_leftImage,listBeanX.getList().get(i).getCoverPath() );
            holder.setOnLineImage(R.id.discover_recycleView_rightImage,listBeanX.getList().get(i).getSubCoverPath());
        }
    }

    @Override
    public int getItemCount() {
        return disCoverBean!=null?disCoverBean.getList().size():0;
    }


}
