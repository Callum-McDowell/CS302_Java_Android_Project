package com.example.compsys302_project_two;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.Notification;
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

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TEMP for TESTING
        List<ItemDetail> listDetails = DataProvider.getItems();
        List<Item> list = new ArrayList<Item>(listDetails);

        ItemAdapter itemsAdapter = new ItemAdapter(this,R.layout.list_item, list);

        ListView list_id = (ListView) findViewById(R.id.category_list_view);
        list_id.setAdapter(itemsAdapter);
    }

        // Placeholder for update icon
    public void updateTopPicks (View view) {

    }

    // Placeholder method for debugging details activity (access through actionbar icon)
    public boolean startDetailsActivity (MenuItem item) {
        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);
        return true;
    }
}