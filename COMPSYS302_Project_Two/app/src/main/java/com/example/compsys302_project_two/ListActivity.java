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
package com.example.compsys302_project_two;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends BaseActivity {

    List<Item> list = DataProvider.getItems();
    CategoryType type;
    String sellerName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
}