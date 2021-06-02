package com.example.compsys302_project_two;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchableInfo;
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
        Button priceSort;
        Button distanceSort;

        public ViewHolder() {
            searchBar = (SearchView) findViewById(R.id.searchBar);
            listView = (ListView) findViewById(R.id.listView);
            errorText = (TextView) findViewById(R.id.errorText);

            categorySpinner = (MultiSpinner) findViewById(R.id.categorySpinner);
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

        // Instantiate properties
        vh = new ViewHolder();
        types = new ArrayList<CategoryType>();
        list = new ArrayList<Item>();   // Must create copy so operations are not performed on DataProvider itself (whoops)!


        // Starting scope is all items from DataProvider
        list.addAll(DataProvider.getItems());

        // Create and attach adapter, populated from list
        // NOTE: Initial layout will be all items, in DataProvider FIFO order
        itemsAdapter = new ItemAdapter(this,R.layout.item_layout, list);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(itemsAdapter);
        updateErrorText();

        // Prepare search options
        initialiseSearchOptions();

        // TEMP <-- hardcode in result
        search();
    }

    private void initialiseSearchOptions() {
        // Spinner
        List<CategoryType> options = Arrays.asList(CategoryType.values());
        vh.categorySpinner.setOptions(options);

    }

    public List<CategoryType> getSelectedCategoryOptions() {
        return vh.categorySpinner.getSelectedOptions();
    }

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

    private void search() {
        //list = Search.findBySearch(list,);
        types.clear();
        types.add(CategoryType.FRUIT);

        list = Search.findByCategory(list, types);
        // types
        // searchString
        // maxPrice
        // maxDistance

        updateAdapter(list);
    }
}