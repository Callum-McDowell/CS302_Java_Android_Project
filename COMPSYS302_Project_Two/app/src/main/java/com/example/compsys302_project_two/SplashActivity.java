/*
    The SplashActivity is the launch activity and will transition to main after some delay.
 */

package com.example.compsys302_project_two;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.transition.Fade;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {

    private ViewGroup splashLayout;
    private View title;
    private View background;
    private View featureText;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupTransition();
        setContentView(R.layout.activity_splash);

//        splashLayout = (ViewGroup) findViewById(R.id.splash_layout);
//        title = (View) findViewById(R.id.splash_title);
//        background = (View) findViewById(R.id.splash_background);
//        featureText = (View) findViewById(R.id.splash_feature_text);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startMainActivity();
            }
        }, 3000); // 3 sec
    }

    // Setup activity transition settings
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setupTransition() {
        Transition transition = new Slide();
        transition.setDuration(6000);
        getWindow().setEnterTransition(transition);
        getWindow().setExitTransition(transition);
//        TransitionManager.beginDelayedTransition(splashLayout, transition);
    }

    public void startMainActivity() {
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(SplashActivity.this).toBundle());
        } else {
            startActivity(intent);
        }
    }

    // Override onStop() to destory splashscreen a bit later to allow connection with MainActivity's
    // transition animation
    @Override
    public void onStop() {
        super.onStop();
        finish();
    }
}