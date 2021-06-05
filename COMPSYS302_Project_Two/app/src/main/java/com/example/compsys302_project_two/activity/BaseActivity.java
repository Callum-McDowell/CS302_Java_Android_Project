/*
    COMPSYS302 Project 2 (Java/Android)

    Author: Hao Lin, Callum McDowell
    Date:   May 2021

    Summary

        This activity defines all functions that is universal across all other activities:
            - Action Bar Menu Creation
            - Activity Transition Setup

        All other activities (except splash) extends off this activity.
*/

package com.example.compsys302_project_two.activity;

import android.content.Intent;
import android.transition.Fade;
import android.transition.Transition;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.example.compsys302_project_two.R;
import com.example.compsys302_project_two.helper_class.TypefaceSpan;
import com.example.compsys302_project_two.category.CategoryType;

public class BaseActivity extends AppCompatActivity {

    // Create an action bar button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // R.menu.* is a reference to a menu.xml file in the res/menu directory.
        // This is for action bar actions
        getMenuInflater().inflate(R.menu.menu_action_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Handles selection of action icons
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_search) {
            startSearchActivity(item);
        } else if (id == R.id.action_home) {
            startMainActivity(item);
        }
        return super.onOptionsItemSelected(item);
    }

    protected void hideActionBar (boolean doHide) {
        getSupportActionBar().hide();
    }

    protected void setActionBarTitle (String title) {
        // See TypefaceSpan for full content and attribution
        // https://www.tristanwaddington.com/2013/03/styling-the-android-action-bar-with-a-custom-font/
        SpannableString s = new SpannableString(title);
        s.setSpan(new TypefaceSpan(this, "lehavre_roughbasic.otf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getSupportActionBar().setTitle(s);

    }

    protected boolean startSearchActivity (MenuItem item) {
        if (!(this instanceof SearchActivity)) {
            Intent intent = new Intent(getBaseContext(), SearchActivity.class);
            if (this instanceof ListActivity) {
                // If opened from category view of items, apply category to search filter
                CategoryType type = ((ListActivity) this).getIntentType();
                intent.putExtra("type", type);
            }
            startActivity(intent);
            return true;
        }
        return false;
    }

    protected boolean startMainActivity (MenuItem item) {
        if (!(this instanceof MainActivity)) {
            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            return true;
        }
        return false;
    }

    // Setup activity-activity transition settings
    protected void setupTransition() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Transition transition = new Fade();
            transition.setDuration(2000);
            transition.excludeTarget(android.R.id.statusBarBackground, true);
            transition.excludeTarget(android.R.id.navigationBarBackground, true);
            getWindow().setEnterTransition(transition);
//            getWindow().setExitTransition(transition); // Does not do anything!!!
        }
    }
}
