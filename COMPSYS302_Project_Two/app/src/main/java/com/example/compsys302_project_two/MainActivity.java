package com.example.compsys302_project_two;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TEMP for TESTING
        List<ItemDetail> listDetails = DataProvider.getItems();
        List<Item> list = new ArrayList<Item>(listDetails);

        ItemAdapter itemsAdapter = new ItemAdapter(this,R.layout.list_item, list);

        ListView list_id = (ListView) findViewById(R.id.list);
        list_id.setAdapter(itemsAdapter);
        
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bot_nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected (MenuItem item){
                        switch (item.getItemId()) {
                            case R.id.bot_nav_search:
                                startSearchActivity(item);
                                return true;
                            case R.id.bot_nav_home:
                                // do something here
                                return true;
                            case R.id.bot_nav_abouts:
                                // do something here
                                return true;
                            default:
                                return true;
                        }
                    }
                });
    }

    // create an action bar button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // R.menu.* is a reference to a menu.xml file in the res/menu directory.
        // This is for action bar actions
        getMenuInflater().inflate(R.menu.action_bar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_search) {
            startSearchActivity(item);
        }
        return super.onOptionsItemSelected(item);
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

    public boolean startSearchActivity (MenuItem item) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
        return true;
    }
}