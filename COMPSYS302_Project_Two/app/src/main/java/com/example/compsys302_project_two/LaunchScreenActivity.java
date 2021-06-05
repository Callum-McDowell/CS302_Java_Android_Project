package com.example.compsys302_project_two;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;

public class LaunchScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // From cold start, first thing to be loaded will be launch_screen_drawable (i.e. logo)
        // Then the general theme is loaded to show the action bar:
        setTheme(R.style.Theme_COMPSYS302_Project_Two);
        // Then we create the instance so the LaunchScreen activity is rendered:
        super.onCreate(savedInstanceState);
        // Then we load the content view so static elements are visible even while adaptors are loading:
        setContentView(R.layout.activity_main);

        Intent mainActivity = new Intent(LaunchScreenActivity.this, MainActivity.class);

//        // Check if we're running on Android 5.0 or higher
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            // Apply activity transition
//            getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
//            // If this activity has an enter transition allow it to overlap with another activity's
//            // exiting transition.
//            getWindow().setAllowEnterTransitionOverlap(true);
//            //getWindow().setSharedElementExitTransition();
//
//            CardView card = (CardView) findViewById(R.id.topPicksToolbar);
//            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, card, "topPicksToolbar");
//
//            //mainActivity.putExtra()
//            startActivity(mainActivity, options.toBundle());
//        } else {
//            // Swap without transition
//            startActivity(mainActivity);
//        }

        startActivity(mainActivity);


    }
}