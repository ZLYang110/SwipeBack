package com.zlylib.swipeback.former;

import android.view.View;

import androidx.annotation.FloatRange;

import com.zlylib.swipeback.SwipeBackLayout;



public class ShrinkSwipeBackTransformer implements SwipeBackLayout.SwipeBackTransformer {

    private final float mScale;
    private final float mAlpha;

    public ShrinkSwipeBackTransformer() {
        this(0.96F, 1F);
    }

    public ShrinkSwipeBackTransformer(@FloatRange(from = 0, to = 1) float scale,
                                      @FloatRange(from = 0, to = 1) float alpha) {
        mScale = scale;
        mAlpha = alpha;
    }

    @Override
    public void transform(View currentView, View previousView, float fraction, int swipeDirection) {
        if (previousView == null) {
            return;
        }
        float scale = mScale + (1 - mScale) * fraction;
        previousView.setScaleX(scale);
        previousView.setScaleY(scale);
        float alpha = mAlpha + (1 - mAlpha) * fraction;
        previousView.setAlpha(alpha);
    }
}
