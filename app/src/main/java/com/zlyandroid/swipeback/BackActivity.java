package com.zlyandroid.swipeback;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.zlylib.swipeback.SwipeBackActivity;
import com.zlylib.swipeback.SwipeBackDirection;
import com.zlylib.swipeback.former.ParallaxSwipeBackTransformer;
import com.zlylib.swipeback.former.ShrinkSwipeBackTransformer;

public class BackActivity extends BaseActivity {
    private RadioGroup mTracking,mTransformer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);

        mTracking = (RadioGroup) findViewById(R.id.tracking_mode);
        mTracking.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.mode_left:
                        mSwipeBackHelper.getSwipeBackLayout().setSwipeBackDirection(SwipeBackDirection.FROM_LEFT);
                        break;
                    case R.id.mode_right:
                        mSwipeBackHelper.getSwipeBackLayout().setSwipeBackDirection(SwipeBackDirection.FROM_RIGHT);
                        break;
                    case R.id.mode_top:
                        mSwipeBackHelper.getSwipeBackLayout().setSwipeBackDirection(SwipeBackDirection.FROM_TOP);
                        break;
                    case R.id.mode_bottom:
                        mSwipeBackHelper.getSwipeBackLayout().setSwipeBackDirection(SwipeBackDirection.FROM_BOTTOM);
                        break;

                }

            }
        });
        mTransformer = (RadioGroup) findViewById(R.id.rg_transformer);
        mTransformer.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int edgeFlag = 0;
                switch (checkedId){
                    case R.id.rb_parallax:
                        mSwipeBackHelper.getSwipeBackLayout().setSwipeBackTransformer(new ParallaxSwipeBackTransformer());
                        break;
                    case R.id.rb_shrink:
                        mSwipeBackHelper.getSwipeBackLayout().setSwipeBackTransformer(new ShrinkSwipeBackTransformer());
                        break;


                }

            }
        });
    }
    public void start(View view){
        startActivity(new Intent(BackActivity.this, BackActivity.class));
    }
    public void finish(View view){
        mSwipeBackHelper.finish();
    }

}
