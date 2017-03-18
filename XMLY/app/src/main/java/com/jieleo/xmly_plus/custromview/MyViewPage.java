package com.jieleo.xmly_plus.custromview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by yuyongjie on 17/3/18.
 */


public class MyViewPage extends ViewPager {
    public MyViewPage(Context context) {
        super(context);
    }

    public MyViewPage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}
