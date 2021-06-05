/*
    COMPSYS302 Project 2 (Java/Android)

    Author: Callum McDowell
    Date:   May 2021

    Summary

        TopPickAdapter is an adapter for RecyclerView for showing items in a
        horizontal list format. The card appearance is as described in layout_top_pick.xml.

        Class properties:
            - mLayoutID:        The id of the target view
            - mData:            The list of categories to be shown
            - mContext:         The context under which the adaptor runs
*/

package com.example.compsys302_project_two.top_pick;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.compsys302_project_two.R;
import com.example.compsys302_project_two.activity.DetailsActivity;
import com.example.compsys302_project_two.item.Item;

import java.util.ArrayList;
import java.util.List;

public class TopPickAdaptor extends RecyclerView.Adapter<TopPickAdaptor.ViewHolder>{
    private final int         mLayoutID;
    private final List<Item>  mData;
    private Context     mContext;

    private final LayoutInflater mInflater;

    public TopPickAdaptor(Context context, int resource, ArrayList<Item> data) {
        this.mData = data;
        this.mLayoutID = resource;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    // Declare objects of all the views to be manipulated.
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView topPickImage;
        public TextView topPickName;
        public CardView cardView;

        public ViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            // Initialize the view objects
            topPickImage = view.findViewById(R.id.top_pick_image);
            topPickName = view.findViewById(R.id.top_pick_name);
            cardView = view.findViewById(R.id.categoryCard);
        }

        @Override
        public void onClick(View v) {
            // To do
        }
    }

    // Inflates the custom top pick layout from xml when needed
    @Override
    public TopPickAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = mInflater.inflate(mLayoutID, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item thisPick = mData.get(position);

        int image_id = mContext.getResources().getIdentifier(
                thisPick.getFeatureImage(), "drawable", mContext.getPackageName());

        holder.topPickName.setText(thisPick.getTitle());
        holder.topPickImage.setImageResource(image_id);

        // OnClick - Title
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // When featureImage is clicked...
                // Transition to DetailActivity

                Intent detailsActivity = new Intent(mContext.getApplicationContext(), DetailsActivity.class);
                detailsActivity.putExtra("item", thisPick);
                mContext.startActivity(detailsActivity);
                // https://stackoverflow.com/questions/2139134/how-to-send-an-object-from-one-android-activity-to-another-using-intents
            }
        });
    }

    // Clear adapter data and set to given list
    public void updateData(@NonNull List<Item> list) {
        mData.clear();
        mData.addAll(list);
        this.notifyDataSetChanged();
    }

    // Total number of items
    @Override
    public int getItemCount() {
        return mData.size();
    }
}
