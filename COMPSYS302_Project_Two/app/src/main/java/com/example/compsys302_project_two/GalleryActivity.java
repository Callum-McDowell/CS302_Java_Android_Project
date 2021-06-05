/*
    COMPSYS302 Project 2 (Java/Android)

    Author: Callum McDowell
    Date:   May 2021

    Summary

        Gallery activity is responsible for displaying a number of features images of items in
        exclusive view. It is opened by DetailsActivity, items which provides the images are fed
        and selected through a Viewpager adapter and ViewPager.
*/

package com.example.compsys302_project_two;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

public class GalleryActivity extends BaseActivity {

    int position;
    List<String> images;
    String scaleType;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        hideActionBar(true);

        // Get Intent
        Intent startingIntent = getIntent();
        position = startingIntent.getIntExtra("position",0);
        images = startingIntent.getStringArrayListExtra("images");
        scaleType = "";

        // Initialise image ViewPager
        // https://www.geeksforgeeks.org/image-slider-in-android-using-viewpager/
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        ImagePagerAdapter imagePagerAdapter = new ImagePagerAdapter(this, images, true);
        viewPager.setAdapter(imagePagerAdapter);

        // Go to current image in list
        viewPager.setCurrentItem(position);
    }
}
