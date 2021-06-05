/*
    COMPSYS302 Project 2 (Java/Android)

    Author: Hao Lin
    Date:   June 2021

    Summary

        SearchActivity is the launch activity which will transition to main after some delay.
*/

package com.example.compsys302_project_two;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Spannable;
import android.text.SpannableString;
import android.transition.Explode;
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
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    class ViewHolder {
        private TextView splashTitle;
    }

    ViewHolder vh = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        vh.splashTitle = (TextView) findViewById(R.id.splash_title);
        setSplashTitle("Garden Hub");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setupTransition();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startMainActivity();
            }
        }, 3000); // 3 sec
    }

    // Setup activity transition settings
    public void setupTransition() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Transition transition = new Fade();
            transition.setDuration(3000);
            getWindow().setExitTransition(transition);
        }
    }

    public void startMainActivity() {
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Choice between starting with animated transition vs no animated transition
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(SplashActivity.this).toBundle());
        } else {
            startActivity(intent);
        }
    }

    protected void setSplashTitle (String title) {
        // See TypefaceSpan for full content and attribution
        // https://www.tristanwaddington.com/2013/03/styling-the-android-action-bar-with-a-custom-font/
        SpannableString s = new SpannableString(title);
        s.setSpan(new TypefaceSpan(this, "lehavre_roughbasic.otf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        vh.splashTitle.setText(s);
    }

    // Override onStop() to destroy splashscreen a bit later to allow connection with MainActivity's
    // transition animation
    @Override
    public void onStop() {
        super.onStop();
        finish();
    }
}