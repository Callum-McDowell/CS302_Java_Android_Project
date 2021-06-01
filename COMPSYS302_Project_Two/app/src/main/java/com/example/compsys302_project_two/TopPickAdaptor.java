package com.example.compsys302_project_two;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TopPickAdaptor extends RecyclerView.Adapter<TopPickAdaptor.ViewHolder>{
    private int mLayoutID;
    private List<TopPick> mData;
    private Context mContext;

    private LayoutInflater mInflater;

    public TopPickAdaptor(Context context, int resource, ArrayList<TopPick> data) {
        this.mData = data;
        this.mLayoutID = resource;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    // Declare objects of all the views to be manipulated.
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView topPickImage;
        public TextView topPickName;

        public ViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            // Initialize the view objects
            topPickImage = view.findViewById(R.id.top_pick_image);
            topPickName = view.findViewById(R.id.top_pick_name);
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
        TopPick thisPick = mData.get(position);

        int image_id = mContext.getResources().getIdentifier(
                thisPick.getFeatureImage(), "drawable", mContext.getPackageName());

        holder.topPickName.setText(thisPick.getTitle());
        holder.topPickImage.setImageResource(image_id);
    }

    // Total number of items
    @Override
    public int getItemCount() {
        return mData.size();
    }
}
