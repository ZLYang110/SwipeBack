package com.zlyandroid.swipeback;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.zlylib.swipeback.SwipeBackDirection;
import com.zlylib.swipeback.SwipeBackHelper;


public abstract class BaseActivity extends AppCompatActivity  {
    protected SwipeBackHelper mSwipeBackHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initSwipeBack();
    }

    /**
     * 初始化 SwipeBack
     */
    @SuppressLint("ResourceAsColor")
    private void initSwipeBack() {
        mSwipeBackHelper = SwipeBackHelper.inject(this);
        mSwipeBackHelper.setSwipeBackEnable(swipeBackEnable());
        mSwipeBackHelper.setSwipeBackOnlyEdge(swipeBackOnlyEdge());
        mSwipeBackHelper.setSwipeBackForceEdge(swipeBackForceEdge());
        mSwipeBackHelper.setSwipeBackDirection(swipeBackDirection());
        mSwipeBackHelper.getSwipeBackLayout().setShadowStartColor(0);
    }
    protected boolean swipeBackEnable() {
        return true;
    }

    protected boolean swipeBackOnlyEdge() {
        return false;
    }

    protected boolean swipeBackForceEdge() {
        return true;
    }

    @SwipeBackDirection
    protected int swipeBackDirection() {
        return SwipeBackDirection.FROM_LEFT;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mSwipeBackHelper.onPostCreate();
    }

    @Override
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();
        mSwipeBackHelper.onEnterAnimationComplete();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSwipeBackHelper.onDestroy();
    }

    @Override
    public void finish() {
        if (mSwipeBackHelper.finish()) {
            super.finish();
        }
    }
}
