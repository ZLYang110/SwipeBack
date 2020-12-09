package com.zlyandroid.swipeback;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.zlylib.swipeback.SwipeBackActivity;
import com.zlylib.swipeback.SwipeBackDirection;
import com.zlylib.swipeback.former.ParallaxSwipeBackTransformer;
import com.zlylib.swipeback.former.ShrinkSwipeBackTransformer;

public class MainActivity extends SwipeBackActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void start(View view){
        startActivity(new Intent(MainActivity.this,BackActivity.class));
    }
}
