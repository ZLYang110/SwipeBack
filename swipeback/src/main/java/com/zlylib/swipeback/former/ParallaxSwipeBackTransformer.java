package com.zlylib.swipeback.former;

import android.view.View;

import androidx.annotation.FloatRange;

import com.zlylib.swipeback.SwipeBackDirection;
import com.zlylib.swipeback.SwipeBackLayout;


public class ParallaxSwipeBackTransformer implements SwipeBackLayout.SwipeBackTransformer {

    private final float mPercent;
    private final float mAlpha;

    public ParallaxSwipeBackTransformer() {
        this(0.12F, 1F);
    }

    public ParallaxSwipeBackTransformer(@FloatRange(from = 0, to = 1) float percent,
                                        @FloatRange(from = 0, to = 1) float alpha) {
        mPercent = percent;
        mAlpha = alpha;
    }

    @Override
    public void transform(View currentView, View previousView, float fraction, int swipeDirection) {
        if (previousView == null) {
            return;
        }
        int maxTranslation = previousView.getWidth();
        if (swipeDirection == SwipeBackDirection.FROM_LEFT) {
            float translation = (maxTranslation * mPercent) * (1 - fraction);
            previousView.setTranslationX(-translation);
        } else if (swipeDirection == SwipeBackDirection.FROM_RIGHT) {
            float translation = previousView.getWidth() * mPercent * (1 - fraction);
            previousView.setTranslationX(translation);
        } else if (swipeDirection == SwipeBackDirection.FROM_TOP) {
            float translation = maxTranslation * mPercent * (1 - fraction);
            previousView.setTranslationY(-translation);
        } else if (swipeDirection == SwipeBackDirection.FROM_BOTTOM) {
            float translation = maxTranslation * mPercent * (1 - fraction);
            previousView.setTranslationY(translation);
        }
        float alpha = mAlpha + (1 - mAlpha) * fraction;
        previousView.setAlpha(alpha);
    }
}
