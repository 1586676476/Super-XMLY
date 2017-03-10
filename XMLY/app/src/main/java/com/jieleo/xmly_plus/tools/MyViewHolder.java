package com.jieleo.xmly_plus.tools;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by liuHao on 17/3/10.
 */
public class MyViewHolder  extends RecyclerView.ViewHolder{
    private View view;
    private Context context;
    private SparseArray<View> viewSparseArray;
    public MyViewHolder(View itemView,Context context) {
        super(itemView);
        this.context = context;
        view = itemView;
        viewSparseArray = new SparseArray<>();
    }

    public static MyViewHolder onCreatMyViewHolder(Context context, ViewGroup viewGroup,int layoutId){
        View view = LayoutInflater.from(context).inflate(layoutId,viewGroup,false);
        MyViewHolder myViewHolder = new MyViewHolder(view,context);
         return  myViewHolder;
    }

    public static MyViewHolder onCreatMyListViewHoler(View view,ViewGroup viewGroup,int layoutId){
        MyViewHolder myViewHolder =null;
        if (view==null){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(layoutId,viewGroup,false);
            myViewHolder = new MyViewHolder(view,viewGroup.getContext());
            view.setTag(myViewHolder);
        }else {
            myViewHolder = (MyViewHolder) view.getTag();

        }

        return myViewHolder;
    }

    public <T extends View> T getView(int resId){
        View view = viewSparseArray.get(resId);
        if (view==null){
            view = itemView.findViewById(resId);
            viewSparseArray.put(resId,view);
        }
        return (T) view;
    }

    public MyViewHolder setText(int resId,String s){
        TextView textView = (TextView) itemView.findViewById(resId);
        if (s!=null){
            textView.setText(s);
        }
        return this;
    }
    public MyViewHolder setOnLineImage(int resId,String url){
        ImageView imageView  = (ImageView) itemView.findViewById(resId);
        if (url!=null){
            Glide.with(context).load(url).into(imageView);
        }
        return this;
    }

}
