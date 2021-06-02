/*
    COMPSYS302 Project 2 (Java/Android)

    Author: Callum McDowell
    Date:   May 2021

    Summary

        ItemListActivity is a basic activity for showing Item instances in a ListView. It is
        opened by CategoryAdapter, and for simple browsing only.

        ItemListActivity uses the standard itemsAdapter, and is only capable of searching by
        CategoryType. This is as more detailed searches will be carried out in SearchActivity.
*/
package com.example.compsys302_project_two;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ItemListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        // Get search parameters from intent
        Intent startingIntent = getIntent();
        CategoryType type = (CategoryType) startingIntent.getSerializableExtra("type");

        // Filter list with search parameters
        List<Item> list = DataProvider.getItems();
        List<CategoryType> types = new ArrayList<CategoryType>();
        types.add(type);
        list = Search.findByCategory(list, types);

        // Create and attach adapter, populated from list
        ItemAdapter itemsAdapter = new ItemAdapter(this,R.layout.item_layout, list);

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
}