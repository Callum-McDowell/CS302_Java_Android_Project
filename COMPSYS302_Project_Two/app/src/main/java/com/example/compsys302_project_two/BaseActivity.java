/*
    This activity defines all functions that is universal across all other activities:
        - Action Bar Menu
    All other activities extends off this activity.
 */

package com.example.compsys302_project_two;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

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
        Intent intent = new Intent(getBaseContext(), SearchActivity.class);
        if (this instanceof ItemListActivity) {
            // If opened from category view of items, apply category to search filter
            CategoryType type = ((ItemListActivity) this).getIntentType();
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
}
