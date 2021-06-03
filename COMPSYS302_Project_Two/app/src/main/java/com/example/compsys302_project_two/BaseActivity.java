/*
    This activity defines all functions that is universal across all other activities:
        - Action Bar Menu
    All other activities extends off this activity.
 */

package com.example.compsys302_project_two;

import android.content.Intent;
import android.transition.Slide;
import android.transition.Transition;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {


    // Create an action bar button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // R.menu.* is a reference to a menu.xml file in the res/menu directory.
        // This is for action bar actions
        getMenuInflater().inflate(R.menu.action_bar_menu, menu);
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

    protected boolean startMainActivity (MenuItem item) {
        if (!(this instanceof MainActivity)) {
            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            return true;
        }
        return false;
    }

// does this ...
    // Setup activity transition settings
    protected void setupTransition() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Transition transition = new Slide();
            transition.setDuration(2000);
            transition.excludeTarget(android.R.id.statusBarBackground, true);
            transition.excludeTarget(android.R.id.navigationBarBackground, true);
            getWindow().setEnterTransition(transition);
//            getWindow().setExitTransition(transition); // Does not do anything!!!
        }
// .. conflict with these? ->
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
}
