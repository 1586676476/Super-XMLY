package com.jieleo.xmly_plus.adapter.search_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.model.bean.model_search_.SearchBean;
import com.jieleo.xmly_plus.tools.BaseViewHolder;

/**
 * Created by dllo on 17/3/16.
 */

public class SearchAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private SearchBean[] searchBeanList;
    private Context context;

    public void setSearchBeanList(SearchBean[] searchBeanList) {
        this.searchBeanList = searchBeanList;
    }

    public SearchAdapter(Context context) {

        this.context = context;
    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return BaseViewHolder.onCreatMyViewHolder(context,parent, R.layout.activity_search_item);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        SearchBean searchBean = searchBeanList[position];
        holder.setText(R.id.activity_search_item_text,searchBean.getSearchWord());
    }

    @Override
    public int getItemCount() {
        return searchBeanList == null ? 0 : searchBeanList.length;
    }
}
