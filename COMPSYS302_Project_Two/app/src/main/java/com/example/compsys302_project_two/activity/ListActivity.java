/*
    COMPSYS302 Project 2 (Java/Android)

    Author: Callum McDowell
    Date:   May 2021

    Summary

        ListActivity is a basic activity for showing Item instances in a ListView. It is
        opened by CategoryAdapter, and for simple browsing only.

        ListActivity uses the standard itemsAdapter, and is only capable of searching by
        CategoryType. This is as more detailed searches will be carried out in SearchActivity.
*/

package com.example.compsys302_project_two.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ListView;
import android.widget.TextView;

import com.example.compsys302_project_two.DataProvider;
import com.example.compsys302_project_two.R;
import com.example.compsys302_project_two.category.CategoryType;
import com.example.compsys302_project_two.item.Item;
import com.example.compsys302_project_two.item.ItemAdapter;
import com.example.compsys302_project_two.search.Search;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends BaseActivity {

    List<Item> list = DataProvider.getItems();
    CategoryType type;
    String sellerName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupTransition();
        setContentView(R.layout.activity_item_list);

        // Get search parameters from intent
        Intent startingIntent = getIntent();
        // WARNING: Either of these intents could fail and return null at any time. Must check.
        type = (CategoryType) startingIntent.getSerializableExtra("type");
        sellerName = startingIntent.getStringExtra("sellerName");

        // Filter list with search parameters
        List<CategoryType> types = new ArrayList<CategoryType>();
        if (type != null) {
            // Show all items in given category
            types.add(type);
            list = Search.findByCategory(list, types);
            setActionBarTitle(CategoryType.toStringHeading(type));
        } else if (sellerName != null) {
            // Show all items with the provided sellerName
            list = Search.findBySeller(list, sellerName);
            setActionBarTitle(sellerName);
        } else {
            // Default to all items (types and sellerName default values will be ignored)
            list = Search.findBySearch(list, types, sellerName);
        }

        // Create and attach adapter, populated from list
        ItemAdapter itemsAdapter = new ItemAdapter(this,R.layout.layout_item, list);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(itemsAdapter);

        // In case of list being empty:
        TextView errorText = (TextView) findViewById(R.id.errorText);
        if (list.size() == 0) {
            errorText.setVisibility(View.VISIBLE);
        } else {
            errorText.setVisibility(View.GONE);
        }
    }

    public CategoryType getIntentType() {
        return type;
    }

    // Setup activity-activity transition settings
    @Override
    protected void setupTransition() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {

            Slide slide = new Slide();
            slide.setSlideEdge(Gravity.LEFT);
            slide.setDuration(1000);
            slide.excludeTarget(android.R.id.statusBarBackground, true);
            slide.excludeTarget(android.R.id.navigationBarBackground, true);
            getWindow().setEnterTransition(slide);
            slide.setSlideEdge(Gravity.RIGHT);
            getWindow().setExitTransition(slide);
        }
    }
}