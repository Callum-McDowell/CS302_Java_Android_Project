package com.example.compsys302_project_two;

import android.content.Context;
import android.content.Intent;
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
import androidx.cardview.widget.CardView;

import java.util.List;

public class CategoryAdapter extends ArrayAdapter {
    int         mLayoutID;
    List<Category>  mCategories;
    Context     mContext;

    public CategoryAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        mContext = context;
        mLayoutID = resource;
        mCategories = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currentViewCategory = convertView;

        // Existing view being reused (i.e. != null)? If not, inflate.
        if (currentViewCategory == null) {
            currentViewCategory = LayoutInflater.from(getContext()).inflate(mLayoutID, parent, false);
        }

        Category currentCategory = mCategories.get(position);

        // Set featureImage with img from res\raw
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

                //@TODO
                // Use intent to apply category filter?
                //String message = "ListActivity";
                //Toast.makeText(mContext.getApplicationContext(), message,Toast.LENGTH_SHORT).show();

                Intent itemListActivity = new Intent(mContext.getApplicationContext(), ItemListActivity.class);
                itemListActivity.putExtra("type", currentCategory.getCategoryType());

                mContext.startActivity(itemListActivity);
            }
        });

        return currentViewCategory;
    }
}
