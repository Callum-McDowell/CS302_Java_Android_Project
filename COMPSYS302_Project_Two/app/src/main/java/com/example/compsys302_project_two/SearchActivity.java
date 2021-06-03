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
        boolean alphabetSortFlag = false;
        Button priceSort;
        boolean priceSortFlag = false;
        Button distanceSort;
        boolean distanceSortFlag = false;

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
    SearchSort searchSort;

    List<Item> list;
    ItemAdapter itemsAdapter;
    List<CategoryType> types;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        setActionBarTitle("Search");

    /* Instantiate properties */
        vh = new ViewHolder();
        searchSort = new SearchSort();
        types = new ArrayList<CategoryType>();

        // Starting scope is all items from DataProvider
        // NOTE: Must create copy so operations are not performed on DataProvider itself (whoops)!
        list = new ArrayList<Item>(DataProvider.getItems());

    /* Adapter and layout setup */
        // Prepare search options
        initialiseSearchListener();
        initialiseSearchOptions();
        updateErrorText();

     /* Prepare opening search view */
        // Intent - open search filtered to the current
        Intent startingIntent = getIntent();
        try {
            CategoryType type = (CategoryType) startingIntent.getSerializableExtra("type");
            types.add(type);
            vh.categorySpinner.setOptionsSelected(types);
        } catch (Exception e) {
            // Do nothing, leave list empty (to include all types)
        }

        // Create and attach adapter, populated from list
        // NOTE: Initial layout will be all items, in DataProvider FIFO order
        itemsAdapter = new ItemAdapter(this,R.layout.item_layout, list);
        vh.listView.setAdapter(itemsAdapter);

        filterAuto();
    }

    private void initialiseSearchOptions() {
        // Spinner
        List<CategoryType> options = Arrays.asList(CategoryType.values());
        vh.categorySpinner.setOptions(options);
        // Alphabetical Sort Button
        vh.alphabetSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortAlphabetically();
                updateAdapter();
            }
        });
        // Price Sort Button
        vh.priceSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortPrice();
                updateAdapter();
            }
        });
        // Distance Sort Button
        vh.distanceSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortDistance();
                updateAdapter();
            }
        });
    }

    // Search on submit or text change
    private void initialiseSearchListener() {
        vh.searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filterAuto();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterAuto();
                return true;
            }
        });
    }

    // Update adapter contents with class field
    protected void updateAdapter() {
        // Update data shown by adapter
        itemsAdapter.updateObjects(list);
        updateErrorText();
    }
    // Filter Item list with the given parameters. Automatically draw types from categorySpinner and
    // searchString from searchBar.
    public void filterAuto() {
        filter(vh.categorySpinner.getSelectedOptions(), vh.searchBar.getQuery().toString());
    }
    // Filter Item list with given parameters.
    protected void filter(List<CategoryType> types, String searchString) {
        // Resets search scope to top level (DataProvider) before filtering
        list = Search.findBySearch(DataProvider.getItems(), types, searchString);
        resetButtonFlags(); // reset flags as sorting is also reset
        updateAdapter();
    }
    // Sort Item list for descending/ascending alphabetically
    public void sortAlphabetically() {
        if (vh.alphabetSortFlag) {
            // sort descending
            searchSort.sortAlphabetically(list, false);
            vh.alphabetSortFlag = false;
        } else {
            // sort ascending
            searchSort.sortAlphabetically(list, true);
            vh.alphabetSortFlag = true;
        }
        updateAdapter();
    }
    // Sort Item list for ascending price
    public void sortPrice() {
        if (vh.priceSortFlag) {
            // sort ascending
            searchSort.sortPrice(list, true);
            vh.priceSortFlag = false;
        } else {
            // sort descending
            searchSort.sortPrice(list, false);
            vh.priceSortFlag = true;
        }
        updateAdapter();
    }
    // Sort Item list for ascending distance
    public void sortDistance() {
        if (vh.distanceSortFlag) {
            // sort ascending
            searchSort.sortDistance(list, true);
            vh.distanceSortFlag = false;
        } else {
            // sort descending
            searchSort.sortDistance(list, false);
            vh.distanceSortFlag = true;
        }
        updateAdapter();
    }
    public void resetButtonFlags() {
        vh.alphabetSortFlag = false;
        vh.priceSortFlag    = false;
        vh.distanceSortFlag = false;
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