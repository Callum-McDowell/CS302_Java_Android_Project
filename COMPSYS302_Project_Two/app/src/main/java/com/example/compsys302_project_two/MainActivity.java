package com.example.compsys302_project_two;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // create an action bar button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // R.menu.* is a reference to a menu.xml file in the res/menu directory.
        // This is for action bar actions
        getMenuInflater().inflate(R.menu.search_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Placeholder for update icon
    public void updateTopPicks (View view) {

    }

    // Placeholder method for debugging details activity (access through actionbar icon)
    public boolean openDetails (MenuItem item) {
        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);
        return true;
    }
}