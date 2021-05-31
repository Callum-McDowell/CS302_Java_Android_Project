package com.example.compsys302_project_two;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    }
}