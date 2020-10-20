package com.example.myapplication.activtiys;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class AnimationTest extends AppCompatActivity {

    private ImageView mAnmIvTest;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_test);
        initView();
        setView();
    }

    private void setView() {
        mAnmIvTest.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
//                final ValueAnimator animator = ValueAnimator.ofInt(0,330);
//                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                    @Override
//                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
//                        Log.d("LOGING",animator.getAnimatedValue()+"");
//                        mAnmIvTest.getLayoutParams().height = (int) animator.getAnimatedValue();
//                        mAnmIvTest.requestLayout();
//                    }
//                });
//                animator.setDuration(3000);
//                animator.start();
//                Intent intent = new Intent();
//                intent.setClass(getApplicationContext(),ButtonTest.class);
//                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(AnimationTest.this,
//                        Pair.<View,String>create(mAnmIvTest,"iv_bt")).toBundle());


            }
        });
    }

    private void initView() {
        mAnmIvTest = (ImageView) findViewById(R.id.anm_iv_test);
    }
}