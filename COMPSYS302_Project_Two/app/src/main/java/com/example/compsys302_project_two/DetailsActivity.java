/*
    COMPSYS302 Project 2 (Java/Android)

    Author: Callum McDowell
    Date:   May 2021

    Summary

        DetailsActivity is responsible for displaying the detailed information of items. It is
        opened by any OnClick event of an item listing.
        It receives the items from the intent the activity passed to transition to this activity.
*/

package com.example.compsys302_project_two;

import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class DetailsActivity extends BaseActivity {

    // ViewHolder class to hold all views to be manipulated in this activity
    class ViewHolder {
        TextView    title;
        ImageView   featureImage;
        TextView    featureText;
        TextView    price;

        TextView    sellerName;
        TextView    sellerDistance;
        TextView    sellerRating;

        TextView    contentText;
        ImageView   images;

        ViewPager   viewPager;
        ImagePagerAdapter imagePagerAdapter;

        public ViewHolder() {
            title = (TextView) findViewById(R.id.title);
            //featureImage
            featureText = (TextView) findViewById(R.id.featureText);
            price = (TextView) findViewById(R.id.price);

            sellerName = (TextView) findViewById(R.id.sellerName);
            sellerDistance= (TextView) findViewById(R.id.sellerDistance);
            //sellerRating

            contentText = (TextView) findViewById(R.id.contentText);
            //images

            viewPager = (ViewPager) findViewById(R.id.viewPager);
        }
    }

    ViewHolder vh;
    Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        vh = new ViewHolder();

        // Load Item
        Intent startingIntent = getIntent();
        Item item = (Item) startingIntent.getParcelableExtra("item");
        this.item = item;

        if (item.getCategoryType() != null) {
            setActionBarTitle(CategoryType.toStringHeading(item.getCategoryType()));
        }
        refreshViews();

        // Initialise image ViewPager
        // https://www.geeksforgeeks.org/image-slider-in-android-using-viewpager/
        vh.imagePagerAdapter = new ImagePagerAdapter(this, item.getImages(), false);
        vh.viewPager.setAdapter(vh.imagePagerAdapter);

        // Create seller button to ItemListView
        vh.sellerName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open ListActivity of all Items from seller
                Intent itemListActivity = new Intent(getBaseContext(), ListActivity.class);
                itemListActivity.putExtra("sellerName", item.getSellerName());
                startActivity(itemListActivity);
            }
        });
    }

    private void refreshViews() {
        vh.title.setText(item.getTitle());
        //vh.featureImage
        vh.featureText.setText(item.getFeatureText());
        //vh.price.setText("$ " + Float.toString(item.getPrice()));
        vh.price.setText(String.format(Locale.getDefault(), "$ %.1f", item.getPrice()));

        vh.sellerName.setText(item.getSellerName());
        vh.sellerDistance.setText(Integer.toString(item.getSellerDistance()) + " km");
        //vh.sellerRating

        vh.contentText.setText(item.getContentText());
        //vh.images
    }
}