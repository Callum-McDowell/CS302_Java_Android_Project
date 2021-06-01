package com.example.compsys302_project_two;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Locale;

public class DetailsActivity extends BaseActivity {

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

        refreshViews();

        // Initialise image ViewPager
        // https://www.geeksforgeeks.org/image-slider-in-android-using-viewpager/
        vh.imagePagerAdapter = new ImagePagerAdapter(this, item.getImages());
        vh.viewPager.setAdapter(vh.imagePagerAdapter);
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