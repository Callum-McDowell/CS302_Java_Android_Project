/*
    COMPSYS302 Project 2 (Java/Android)

    Author: Callum McDowell
    Date:   June 2021

    Summary

        SearchActivity is the activity for searching Items. The results are displayed in a list view
        with the standard ItemAdapter.

        filter() methods operate on the base Item list (DataProvider.getItems()) and return a list
            of items matching their criteria.
        sort() methods rearrange the given Item list for a given criteria (e.g. alphabetical, highest
            to lowest, for title, sellerPrice, and sellerDistance).
        updateAdapter() method is called after the filter() and sort() methods, and updates the items
            being shown in the listView.

        For example, filter() methods will be applied for changes in searchString or the CategoryTypes
        selection. sort() will applied for
*/

package com.example.compsys302_project_two;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchableInfo;
import android.content.Intent;
import android.media.MediaParser;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchActivity extends BaseActivity {

    class ViewHolder {
        SearchView searchBar;
        ListView listView;
        TextView errorText;

        MultiSpinner categorySpinner;
        ArrayAdapter<CharSequence> spinnerAdapter;
        Button alphabetSort;
        Button priceSort;
        Button distanceSort;

        public ViewHolder() {
            searchBar = (SearchView) findViewById(R.id.searchBar);
            listView = (ListView) findViewById(R.id.listView);
            errorText = (TextView) findViewById(R.id.errorText);

            categorySpinner = (MultiSpinner) findViewById(R.id.categorySpinner);
            alphabetSort = (Button) findViewById(R.id.alphabetSort);
            priceSort = (Button) findViewById(R.id.priceSort);
            distanceSort = (Button) findViewById(R.id.distanceSort);
        }
    }

    ViewHolder vh;
    List<Item> list;
    ItemAdapter itemsAdapter;

    List<CategoryType> types;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

    /* Instantiate properties */
        vh = new ViewHolder();
        types = new ArrayList<CategoryType>();

        // Starting scope is all items from DataProvider
        // NOTE: Must create copy so operations are not performed on DataProvider itself (whoops)!
        list = new ArrayList<Item>(DataProvider.getItems());

    /* Adapter and layout setup */
        // Create and attach adapter, populated from list
        // NOTE: Initial layout will be all items, in DataProvider FIFO order
        itemsAdapter = new ItemAdapter(this,R.layout.item_layout, list);
        vh.listView.setAdapter(itemsAdapter);

        // Prepare search options
        initialiseSearchListener();
        initialiseSearchOptions();
        updateErrorText();

     /* Prepare opening search view */
        // Intent - open search filtered to the current
        Intent startingIntent = getIntent();
        CategoryType type;
        try {
            type = (CategoryType) startingIntent.getSerializableExtra("type");
            types.add(type);
        } catch (Exception e) {
            // Do nothing, leave list empty (to include all types)
        }
        search(types, "");
    }

    private void initialiseSearchOptions() {
        // Spinner
        List<CategoryType> options = Arrays.asList(CategoryType.values());
        vh.categorySpinner.setOptions(options);
    }

    // Search on submit or text change
    private void initialiseSearchListener() {
        vh.searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchAuto();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchAuto();
                return true;
            }
        });
    }
    // Search with the given parameters. Automatically draw types from categorySpinner and
    // searchString from searchBar.
    public void searchAuto() {
        search(vh.categorySpinner.getSelectedOptions(), vh.searchBar.getQuery().toString());
    }
    // Search with given parameters.
    private void search(List<CategoryType> types, String searchString) {
        // Resets search scope to top level (DataProvider) before filtering
        list = Search.findBySearch(DataProvider.getItems(), types, searchString);
        // SORT

        updateAdapter(list);
        updateErrorText();
    }
    // Update adapter contents
    private void updateAdapter(List<Item> list) {
        // Update data shown by adapter
        itemsAdapter.updateObjects(list);
        //itemsAdapter.notifyDataSetChanged();
        updateErrorText();
    }

    protected void updateErrorText() {
        // If no results, show error text
        if (list.size() == 0) {
            vh.errorText.setVisibility(View.VISIBLE);
        } else {
            vh.errorText.setVisibility(View.GONE);
        }
    }
}