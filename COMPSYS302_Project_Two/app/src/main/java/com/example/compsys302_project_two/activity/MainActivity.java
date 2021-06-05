/*
    COMPSYS302 Project 2 (Java/Android)

    Author: Hao Lin, Callum McDowell
    Date:   May 2021

    Summary

        MainActivity is the landing (MAIN) activity for the application. It is
        opened by SplashActivity, and contains UI to navigate to other activities through:
            - TopPicks RecyclerView through the TopPickAdaptor
            - Category ListView through the CategoryAdaptor
*/

package com.example.compsys302_project_two.activity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.view.View;

import com.example.compsys302_project_two.DataProvider;
import com.example.compsys302_project_two.top_pick.Metadata;
import com.example.compsys302_project_two.R;
import com.example.compsys302_project_two.top_pick.TopPickAdaptor;
import com.example.compsys302_project_two.category.Category;
import com.example.compsys302_project_two.category.CategoryAdapter;
import com.example.compsys302_project_two.category.CategoryType;
import com.example.compsys302_project_two.item.Item;
import com.example.compsys302_project_two.search.Search;

public class MainActivity extends BaseActivity {

    protected TopPickAdaptor topPicksAdaptor;
    protected RecyclerView topPicksList_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setupTransition();
        }
        setContentView(R.layout.activity_main);
        setActionBarTitle("Garden Hub");

        topPicksAdaptor = new TopPickAdaptor(
                this, R.layout.layout_top_pick, new ArrayList<Item>());
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                this, LinearLayoutManager.HORIZONTAL, false);

        topPicksList_id = (RecyclerView) findViewById(R.id.top_picks_view);
        topPicksList_id.setLayoutManager(layoutManager);
        topPicksList_id.setAdapter(topPicksAdaptor);

        // Populate categories
        List<Category> list = DataProvider.getCategories();

        CategoryAdapter categoryAdapter = new CategoryAdapter(
                this, R.layout.layout_category, list);
        ListView list_id = (ListView) findViewById(R.id.categoriesList);
        list_id.setAdapter(categoryAdapter);

        // Populate top picks (note that View parameter is arbitrary)
        updateTopPicks(list_id);
    }

    public void updateTopPicks(View view) {
        topPicksAdaptor.updateData(findTopPicks());
    }
    // Returns a list of all items related to the most viewed items. When necessary, pads the list
    // with random un-viewed items to reach the desired number of topPick items.
    public List<Item> findTopPicks () {
        final Integer listLength = 9; // topPicks displays listLength items

        // Warning: this list will grow throughout each session, potentially to a very large size!
        List<Item> mostViewed       = new ArrayList<Item>(Metadata.getMostViewedDescending());
        List<Item> notViewed        = new ArrayList<Item>(Metadata.getUnViewed());
        List<Item> relatedItems     = new ArrayList<Item>();
        List<CategoryType> types    = new ArrayList<CategoryType>();    // leave empty to include all types

        // Populate the list with
        if (mostViewed.size() != 0) {
            outerLoop:
            for (Item item : mostViewed) {
                // For each item in the mostViewed list:
                String[] words = item.getTitle().split("\\W+");

                for (String word : words) {
                    // For each word in the item's title, search for related items:
                    relatedItems.addAll(Search.findBySearch(notViewed, types, word));
                    notViewed.removeAll(Search.findBySearch(notViewed, types, word));

                    if (relatedItems.size() >= listLength) {
                        // If the relatedItems list is populated, stop searching for more items:
                        break outerLoop;
                    }
                }
            }
        }
        // Populate the rest of the list with random un-viewed Items
        if (relatedItems.size() < listLength) {
            Random r = new Random(notViewed.size());
            int exitCount = 0;
            while (notViewed.size() > 0 && relatedItems.size() < listLength) {
                int i = r.nextInt(notViewed.size());
                Item newItem = notViewed.get(i);

                if (!relatedItems.contains(newItem)) {
                    relatedItems.add(newItem);
                    // Temporarily remove to prevent duplicates
                    notViewed.remove(i);
                }

                if (exitCount > 40) {
                    break;
                }
                exitCount++;
            }
        }

        if (relatedItems.size() > listLength) {
            // Sanity check: limit list length to a reasonable value
            relatedItems.subList(listLength, relatedItems.size() - 1).clear();
        }
        return relatedItems;
    }



//    // Generate a list of items and populate RecyclerView with them.
//    // List is comprised of:
//    //      - All items related to the mostViewedItem (by title)
//    //      - Then padded to listLength size with the first Items from DataProvider.
//    // Note that the padding may include duplicates of related items. Definitely room for improvement!
//
//    // Also called on click of update item - view parameter is redundant but included to support this.
//    // WARNING: This is VERY unoptimised. Call sparingly, NOT automatically!
//    public void updateTopPicks2 (View view) {
//        Integer listLength = 4;
//        Item mostViewedItem = Metadata.getMostViewed();
//        topPicksList.clear();
//
//        // Search for all terms in mostViewedItem title and add to topPicks list
//        if (mostViewedItem != null) {
//            String title = mostViewedItem.getTitle();
//            // https://stackoverflow.com/questions/4674850/converting-a-sentence-string-to-a-string-array-of-words-in-java
//            String[] words = title.split("\\W+");
//            List<CategoryType> types = new ArrayList<CategoryType>();
//
//            for (String word : words) {
//                List<Item> searched = Search.findBySearch(DataProvider.getItems(), types, word);
//                // Ignore duplicated and most viewed item
//                for (Item i : searched) {
//                    if (!topPicksList.contains(i) && i != mostViewedItem) {
//                        topPicksList.add(i);
//                    }
//                }
//            }
//        }
//
//        // Then populate rest of the list with first items from DataProvider, if fewer than listLength items
//        // Warning: could create duplicates
//        if (listLength > topPicksList.size()) {
//            Integer newItems = listLength - topPicksList.size();
//            for (int i = 0; i < newItems; i++) {
//                topPicksList.add(DataProvider.getItems().get(i));
//            }
//        } else {
//            // Remove all but first listLength elements
//            // Must be in } else {, otherwise illegal index size
//            topPicksList.subList(listLength, topPicksList.size()).clear();
//        }
//
//        // Update adapter with new items
//        ArrayList<Item> data = new ArrayList<Item>(topPicksList);
//        // NOTE: Must create duplicate list instance otherwise activity garbage collections interferes
//        topPicksAdaptor.updateData(data);
//    }

    // Protection override to not return to (albeit finished) splash.
    @Override
    public void onBackPressed() {
        finish();
    }
}