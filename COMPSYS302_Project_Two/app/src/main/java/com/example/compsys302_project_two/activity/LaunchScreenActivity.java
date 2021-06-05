package com.example.compsys302_project_two.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.transition.Fade;
import android.transition.Transition;
import android.view.WindowManager;

import com.example.compsys302_project_two.R;

public class LaunchScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_screen);
        setContentView(R.layout.activity_splash);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

//        Intent mainActivity = new Intent(this, MainActivity.class);
//        // Check if we're running on Android 5.0 or higher
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            // Apply activity transition
//            setupTransition();
//            Bundle bundle = ActivityOptionsCompat.makeCustomAnimation(
//                    getApplicationContext(), R.anim.fade_in, R.anim.fade_out).toBundle();
////            startActivity(mainActivity, bundle);
//        } else {
//            // Swap without transition
////            startActivity(mainActivity);
//        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startMainActivity();
            }
        }, 3000); // 3 sec
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setupTransition() {
        Transition transition = new Fade();
        transition.setDuration(3000);
        getWindow().setExitTransition(transition);
    }

    @Override
    protected void onStop() {
        // redundant!?
        super.onStop();
        finish();
    }

    private void startMainActivity() {
        Intent mainActivity = new Intent(getBaseContext(), MainActivity.class);
        mainActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        // Check if we're running on Android 5.0 or higher
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Apply activity transition
            Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(LaunchScreenActivity.this).toBundle();
            startActivity(mainActivity, bundle);
        } else {
            // Swap without transition
        }
        startActivity(mainActivity);
    }
}