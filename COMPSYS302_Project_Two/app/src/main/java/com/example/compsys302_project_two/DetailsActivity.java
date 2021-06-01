package com.example.compsys302_project_two;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Locale;

public class DetailsActivity extends AppCompatActivity {

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
        }
    }

    ViewHolder vh;
    Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        vh = new ViewHolder();

        Intent startingIntent = getIntent();
        Item item = (Item) startingIntent.getParcelableExtra("item");
        this.item = item;


        refreshViews();
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