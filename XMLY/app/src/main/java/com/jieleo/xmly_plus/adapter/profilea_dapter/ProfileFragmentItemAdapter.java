package com.jieleo.xmly_plus.adapter.profilea_dapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.model.bean.model_list_profile.ProfileBean;
import com.jieleo.xmly_plus.tools.MyViewHolder;

import java.util.List;

/**
 * Created by dllo on 17/3/11.
 */

public class ProfileFragmentItemAdapter extends RecyclerView.Adapter<MyViewHolder>{
    private static final String TAG = "ProfileFragmentItemAdap";
    private ProfileBean datas;
    private Context context;

    public void setDatasBeen(ProfileBean datasBeen) {
        this.datas = datasBeen;
        notifyDataSetChanged();
    }

    public ProfileFragmentItemAdapter(Context context) {

        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return MyViewHolder.onCreatMyViewHolder(context,parent, R.layout.item_rv_item_fragment_rv);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.setOnLineImage(R.id.item_rv_item_fragment_rv_image,datas.getDatas().get(0).getList().get(position).getCoverPath());
        holder.setText(R.id.item_rv_item_fragment_rv_title,datas.getDatas().get(0).getList().get(position).getTitle());
        holder.setText(R.id.item_rv_item_fragment_rv_firstContent,datas.getDatas().get(0).getList().get(position).getFirstKResults().get(0).getTitle());

    }

    @Override
    public int getItemCount() {
        Log.e(TAG, "getItemCount: "+datas.getDatas().get(0).getCount() );
        return datas!=null?datas.getDatas().get(0).getCount():0;
    }
}
