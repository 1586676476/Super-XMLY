package com.jieleo.xmly_plus.tools;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by dllo on 17/3/11.
 */

public class DemoRecyclerView extends RecyclerView{
    public DemoRecyclerView(Context context) {
        super(context);
    }

    public DemoRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DemoRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
        //重新绘制高度
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthSpec, expandSpec);

    }
}
