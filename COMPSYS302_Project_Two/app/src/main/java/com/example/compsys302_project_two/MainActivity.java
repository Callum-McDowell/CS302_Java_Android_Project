package com.example.compsys302_project_two;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends BaseActivity {

    protected TopPickAdaptor topPicksAdaptor;
    protected RecyclerView topPicksList_id;
    protected ArrayList<Item> topPicksList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBarTitle("Garden Hub");

        // Initialise topPicks
        topPicksList = new ArrayList<Item>();

        topPicksAdaptor = new TopPickAdaptor(
                this, R.layout.top_pick_layout, topPicksList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                this, LinearLayoutManager.HORIZONTAL, false);

        topPicksList_id = (RecyclerView) findViewById(R.id.top_picks_view);
        topPicksList_id.setLayoutManager(layoutManager);
        topPicksList_id.setAdapter(topPicksAdaptor);

        // Populate categories
        List<Category> list = DataProvider.getCategories();

        CategoryAdapter categoryAdapter = new CategoryAdapter(
                this, R.layout.category_layout, list);
        ListView list_id = (ListView) findViewById(R.id.categoriesList);
        list_id.setAdapter(categoryAdapter);

        // Populate top picks (note View paremeter arbitrary)
        updateTopPicks(list_id);

//        // ITEM ADAPTER
//        ItemAdapter itemsAdapter = new ItemAdapter(this,R.layout.item_layout, list);
//
//        ListView list_id = (ListView) findViewById(R.id.category_list_view);
//        list_id.setAdapter(itemsAdapter);
//        // <---
    }

    // Generate a list of items and populate RecyclerView with them.
    // List is comprised of:
    //      - All items related to the mostViewedItem (by title)
    //      - Then padded to listLength size with the first Items from DataProvider.
    // Note that the padding may include duplicates of related items. Definitely room for improvement!

    // Also called on click of update item - view parameter is redundant but included to support this.
    // WARNING: This is VERY unoptimised. Call sparingly, NOT automatically!
    public void updateTopPicks (View view) {
        Integer listLength = 4;
        Item mostViewedItem = Metadata.getMostViewed();
        topPicksList.clear();

        // Search for all terms in mostViewedItem title and add to topPicks list
        if (mostViewedItem != null) {
            String title = mostViewedItem.getTitle();
            // https://stackoverflow.com/questions/4674850/converting-a-sentence-string-to-a-string-array-of-words-in-java
            String[] words = title.split("\\W+");
            List<CategoryType> types = new ArrayList<CategoryType>();

            for (String word : words) {
                List<Item> searched = Search.findBySearch(DataProvider.getItems(), types, word);
                // Ignore duplicated and most viewed item
                for (Item i : searched) {
                    if (!topPicksList.contains(i) && i != mostViewedItem) {
                        topPicksList.add(i);
                    }
                }
            }
        }

        // Then populate rest of the list with first items from DataProvider, if fewer than listLength items
        // Warning: could create duplicates
        if (listLength > topPicksList.size()) {
            Integer newItems = listLength - topPicksList.size();
            for (int i = 0; i < newItems; i++) {
                topPicksList.add(DataProvider.getItems().get(i));
            }
        } else {
            // Remove all but first listLength elements
            // Must be in } else {, otherwise illegal index size
            topPicksList.subList(listLength, topPicksList.size()).clear();
        }

        // Update adapter with new items
        ArrayList<Item> data = new ArrayList<Item>(topPicksList);
        // NOTE: Must create duplicate list instance otherwise activity garbage collections interferes
        topPicksAdaptor.updateData(data);
    }

    // Placeholder method for debugging details activity (access through actionbar icon)
    public boolean startDetailsActivity (MenuItem item) {
        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);
        return true;
    }
}