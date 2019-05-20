package mrhao.com.youyuaccount.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;

public class MyNoSlideViewpager extends ViewPager {

    public MyNoSlideViewpager(Context context) {
        super(context);
    }

    public MyNoSlideViewpager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        super.onInterceptTouchEvent(ev);
        // 不拦截这个事件
        return true;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        super.onTouchEvent(ev);
        // 不处理这个事件
//        return true;//不禁用viewpage滑动
        return false;//禁用viewpage滑动
    }


    @Override
    public boolean executeKeyEvent(@NonNull KeyEvent event) {
        // 不响应按键事件
        return true;
    }


}
