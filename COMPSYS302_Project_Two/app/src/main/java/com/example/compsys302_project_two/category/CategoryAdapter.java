/*
    COMPSYS302 Project 2 (Java/Android)

    Author: Callum McDowell
    Date:   May 2021

    Summary

        CategoryAdapter is an adapter for ListView for showing categories in a
        list/card format. The card appearance is as described in layout_category.xml.

        Class properties:
            - mLayoutID:        The id of the target view
            - mCategories:      The list of categories to be shown
            - mContext:         The context under which the adaptor runs
*/

package com.example.compsys302_project_two.category;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.example.compsys302_project_two.activity.ListActivity;
import com.example.compsys302_project_two.R;
import com.example.compsys302_project_two.activity.SplashActivity;

import java.util.List;

public class CategoryAdapter extends ArrayAdapter {
    int             mLayoutID;
    List<Category>  mCategories;
    Context         mContext;

    public CategoryAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        mContext = context;
        mLayoutID = resource;
        mCategories = objects;
    }

    // Create and returns the views to be displayed from a list view.
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currentViewCategory = convertView;

        // Existing view being reused (i.e. != null)? If not, inflate.
        if (currentViewCategory == null) {
            currentViewCategory = LayoutInflater.from(getContext()).inflate(mLayoutID, parent, false);
        }

        Category currentCategory = mCategories.get(position);

        // Set featureImage with img from res\raw & res/drawable
        ImageView featureImage = (ImageView) currentViewCategory.findViewById(R.id.featureImage);
        int i = mContext.getResources().getIdentifier(
                currentCategory.getFeatureImage(), "drawable", mContext.getPackageName());
        featureImage.setImageResource(i);

        // Set title
        TextView title = (TextView) currentViewCategory.findViewById(R.id.title);
        title.setText(currentCategory.getTitle());

        // OnClick - Layout
        CardView rootLayout = (CardView) currentViewCategory.findViewById(R.id.root_layout);
        rootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // When the item is clicked...
                // Transition to ListActivity
                startItemListActivity(currentCategory);
            }
        });

        return currentViewCategory;
    }

    public void startItemListActivity(Category currentCategory) {
        Intent itemListActivity = new Intent(mContext.getApplicationContext(), ListActivity.class);
        itemListActivity.putExtra("type", currentCategory.getCategoryType());
        itemListActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mContext.startActivity(itemListActivity, ActivityOptions.makeSceneTransitionAnimation(
                    (Activity) mContext).toBundle());
        } else {
            mContext.startActivity(itemListActivity);
        }
    }
}
