package com.example.compsys302_project_two;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

public class GalleryActivity extends AppCompatActivity {

    int position;
    List<String> images;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        // Get Intent
        Intent startingIntent = getIntent();
        position = startingIntent.getIntExtra("position",0);
        images = startingIntent.getStringArrayListExtra("images");

        // Initialise image ViewPager
        // https://www.geeksforgeeks.org/image-slider-in-android-using-viewpager/
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        ImagePagerAdapter imagePagerAdapter = new ImagePagerAdapter(this, images);
        viewPager.setAdapter(imagePagerAdapter);

        // Go to current image in list
        viewPager.setCurrentItem(position);
    }
}
