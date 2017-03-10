package com.jieleo.xmly_plus.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.model.bean.model_list_page.ListPageBean;
import com.jieleo.xmly_plus.tools.MyViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuHao on 17/3/10.
 */
public class ListFragmentPageRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private ListPageBean listPageBean;

    public ListFragmentPageRVAdapter(Context context) {
        this.context = context;
    }

    public void setListPageBean(ListPageBean listPageBean) {
        this.listPageBean = listPageBean;
    }

    class ListPageViewHolder extends RecyclerView.ViewHolder{
        private RecyclerView recyclerView;
        public ListPageViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.rv_item_rv_list);
        }
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListPageViewHolder listPageViewHolder = null;
        if (listPageViewHolder==null){
            View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_fragment_list,parent,false);
            listPageViewHolder = new ListPageViewHolder(view);
        }

        return listPageViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ListPageViewHolder listPageViewHolder = (ListPageViewHolder) holder;
        ListFragmentItemRvAdapter listFragmentItemRvAdapter = new ListFragmentItemRvAdapter(context);
        listPageViewHolder.recyclerView.setAdapter(listFragmentItemRvAdapter);
        List<ListPageBean.ListBean> datas = new ArrayList<>();
       switch (position){
           case 0 :
               for (int i = 1; i < 7; i++) {
                   datas.add(listPageBean.getList().get(i));
               }
               break;
           case 1:
               for (int i = 7; i < 13; i++) {
                   datas.add(listPageBean.getList().get(i));
               }
               break;
           case 2:
               for (int i = 13; i < 19; i++) {
                   datas.add(listPageBean.getList().get(i));
               }
               break;
           case 3:
               for (int i = 19; i < 25; i++) {
                   datas.add(listPageBean.getList().get(i));
               }
               break;
           case 4:
               for (int i = 25; i < 29; i++) {
                   datas.add(listPageBean.getList().get(i));
               }
               break;
       }
        listFragmentItemRvAdapter.setListBeen(datas);
    }

    @Override
    public int getItemCount() {
        return listPageBean==null?0:5;
    }
}
