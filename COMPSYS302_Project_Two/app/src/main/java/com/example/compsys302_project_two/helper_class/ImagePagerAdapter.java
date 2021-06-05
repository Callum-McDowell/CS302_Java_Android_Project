/*
    COMPSYS302 Project 2 (Java/Android)

    Author: Callum McDowell
    Date:   May 2021

    Summary

        ImagePagerAdapter is an adapter for RecyclerView for showing item feature images in a
        slidable page viewer. The viewer appearance is as described in layout_pager.xml.
*/

package com.example.compsys302_project_two.helper_class;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.compsys302_project_two.R;
import com.example.compsys302_project_two.activity.GalleryActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// https://www.geeksforgeeks.org/image-slider-in-android-using-viewpager/

public class ImagePagerAdapter extends PagerAdapter {

    private Context         mContext;
    private List<String>    mImages;
    private LayoutInflater  mlayoutInflater;
    private boolean         showWholeImage;

    public ImagePagerAdapter(Context context, List<String> images, boolean showWholeImage) {
        super();
        mContext = context;
        mImages = images;
        this.showWholeImage = showWholeImage;
        mlayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return (int)mImages.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        // Match root layout in pager_layout.
        return view == ((ConstraintLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        // Inflate the 'page' (pager_layout.xml)
        View pagerView = mlayoutInflater.inflate(R.layout.layout_pager, container, false);
        // Set the image
        ImageView imageView = (ImageView) pagerView.findViewById(R.id.pager_image);
        int i = mContext.getResources().getIdentifier(
                mImages.get(position), "drawable", mContext.getPackageName());
        imageView.setImageResource(i);

        if (showWholeImage) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }

        Objects.requireNonNull(container).addView(pagerView);

        // Click on image to open full screen viewer
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mContext.getClass() != GalleryActivity.class) {
                    Intent galleryActivity = new Intent(mContext.getApplicationContext(), GalleryActivity.class);
                    galleryActivity.putExtra("position", position);
                    ArrayList<String> images = new ArrayList<String>(mImages);
                    galleryActivity.putStringArrayListExtra("images", images);

                    mContext.startActivity(galleryActivity);
                }
            }
        });

        return pagerView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout) object);
    }
}