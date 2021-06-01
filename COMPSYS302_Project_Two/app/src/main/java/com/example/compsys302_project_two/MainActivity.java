package com.example.compsys302_project_two;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TEMP for TESTING --->
        List<Item> list = DataProvider.getItems();
//        List<Category> list = DataProvider.getCategories();

        // CATEGORY ADAPTER
//        CategoryAdapter categoryAdapter = new CategoryAdapter(
//                this, R.layout.category_layout, list);
//
//        ListView list_id = (ListView) findViewById(R.id.category_list_view);
//        list_id.setAdapter(categoryAdapter);


        // ITEM ADAPTER
        ItemAdapter itemsAdapter = new ItemAdapter(this,R.layout.item_layout, list);

        ListView list_id = (ListView) findViewById(R.id.category_list_view);
        list_id.setAdapter(itemsAdapter);
        // <---

//        ArrayList<TopPick> topPicksList = DataProvider.getTopPicks();
//
//        TopPickAdaptor topPicksAdaptor = new TopPickAdaptor(
//                this, R.layout.top_pick_layout, topPicksList);
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(
//                this, LinearLayoutManager.HORIZONTAL, false);
//
//        RecyclerView topPicksList_id = (RecyclerView) findViewById(R.id.top_picks_view);
//        topPicksList_id.setLayoutManager(layoutManager);
//        topPicksList_id.setAdapter(topPicksAdaptor);
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