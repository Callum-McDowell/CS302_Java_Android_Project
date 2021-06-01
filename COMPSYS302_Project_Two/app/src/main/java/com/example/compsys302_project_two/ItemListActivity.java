package com.example.compsys302_project_two;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class ItemListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        Intent startingIntent = getIntent();
        CategoryType type = (CategoryType) startingIntent.getSerializableExtra("type");

        String message = type.name();
        Toast.makeText(this, message,Toast.LENGTH_SHORT).show();

        List<Item> list = DataProvider.getItems();
        ItemAdapter itemsAdapter = new ItemAdapter(this,R.layout.item_layout, list);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(itemsAdapter);
    }
}