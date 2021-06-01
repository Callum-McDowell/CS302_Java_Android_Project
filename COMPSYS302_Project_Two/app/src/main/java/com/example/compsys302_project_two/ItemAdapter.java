/*
    COMPSYS302 Project 2 (Java/Android)

    Author: Callum McDowell
    Date:   May 2021

    Summary

        ItemAdapter is an adapter for RecyclerView for showing item listings in a
        list/card format. The card appearance is as described in item_layout.xml.
*/

package com.example.compsys302_project_two;

import android.content.Context;
import android.media.MediaPlayer;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.List;

public class ItemAdapter extends ArrayAdapter {
    int         mLayoutID;
    List<Item>  mItems;
    Context     mContext;

    public ItemAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        mLayoutID = resource;
        mItems = objects;
        mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currentViewItem = convertView;

        // Existing view being reused (i.e. != null)? If not, inflate.
        if (currentViewItem == null) {
            currentViewItem = LayoutInflater.from(getContext()).inflate(mLayoutID, parent, false);
        }

        Item currentItem = mItems.get(position);

        // Set featureImage with img from res\raw
        ImageView featureImage = (ImageView) currentViewItem.findViewById(R.id.featureImage);
        int i = mContext.getResources().getIdentifier(
                currentItem.getFeatureImage(), "drawable", mContext.getPackageName());
        featureImage.setImageResource(i);

        // Set title
        TextView title = (TextView) currentViewItem.findViewById(R.id.title);
        title.setText(currentItem.getTitle());

        // Set seller (name + rating)
        TextView sellerName = (TextView) currentViewItem.findViewById(R.id.sellerName);
        sellerName.setText(currentItem.getSellerName());

        // Set price (to 2 dp)
        TextView price = (TextView) currentViewItem.findViewById(R.id.price);
        price.setText("$ " + Float.toString(currentItem.getPrice()));

        // Set featureText
        TextView featureText = (TextView) currentViewItem.findViewById(R.id.featureText);
        featureText.setText(currentItem.getFeatureText());


        // OnClick - Title
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // When title is clicked...
                // Transition to DetailActivity

                //@TODO
                String message = "DetailActivity";
                Toast.makeText(mContext.getApplicationContext(), message,Toast.LENGTH_SHORT).show();
            }
        });

        // OnClick - Layout
        LinearLayout rootLayout = (LinearLayout) currentViewItem.findViewById(R.id.root_layout);
        rootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // When the item is clicked...
                // Hide or unhide the featureText
                if (featureText.getVisibility() == View.GONE) {
                    featureText.setVisibility(View.VISIBLE);
                } else {
                    featureText.setVisibility(View.GONE);
                }
            }
        });

        return currentViewItem;
    }
}