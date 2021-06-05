/*
    COMPSYS302 Project 2 (Java/Android)

    Author: Callum McDowell
    Date:   May 2021

    Summary

        Item class is a model class containing key information for a given listing.
        A new Item is instantiated for each listing. Item holds 'thumbnail'
        information on the listing, a low memory solution for when a large
        number of listings need to be shown at once with only simple
        information (e.g. ListActivity).

        ItemDetails extends Item, and has the further data required for an
        in-depth appraisal of the listing (e.g. DetailActivity).

        Class properties:
            - title:        The displayed name of the listing.
            - featureImage: The image used as the thumbnail.
            - featureText:  A 1-2 sentence summary of the listing.
            - price:        The price the listing has been posted at.
            - seller:       The Seller who posted and owns the listing.
            - meta:         A list of keyword Strings used for searching and
                            analytics.
*/

package com.example.compsys302_project_two.item;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.compsys302_project_two.category.CategoryType;

import java.util.ArrayList;
import java.util.List;

public class Item implements Parcelable, IItem {

    CategoryType type;

    String  title;
    String  featureImage;
    String  featureText;
    float   price;

    // WARNING: Reference to seller is lost when serialised, thus contents are cached locally.
    //          The moment Item is serialised and passed between activities its un-parceled
    //          instance has seller == null.
    Seller seller;
    String  sellerName;
    Integer sellerDistance;
    Integer sellerRating;

    String  contentText;
    List<String> images;

    public Item(CategoryType type, String title, String featureImage, String featureText, float price, Seller seller, String contentText, List<String> images)
    {
        this.type = type;

        this.title = title;
        this.featureImage = featureImage;
        this.featureText = featureText;
        this.price = price;

        this.seller = seller;
        refreshSellerData();

        this.contentText = contentText;
        this.images = images;
    }

    public void refreshSellerData() {
        try {
            this.sellerName = seller.getName();
            this.sellerDistance = seller.getDistance();
            this.sellerRating = seller.getRating();
        } catch (Exception e) {
            ;
        }
    }

    /* IItem Interface Calls */
    @Override
    public CategoryType getCategoryType() {
        return type;
    }
    @Override
    public String getTitle() {
        return title;
    }
    @Override
    public String getFeatureImage() {
        return featureImage;
    }
    @Override
    public String getFeatureText() {
        return featureText;
    }
    @Override
    public float getPrice() {
        return price;
    }
    @Override
    public Seller getSeller() {
        return seller;
    }
    @Override
    public String getSellerName() {
        return sellerName;
    }
    @Override
    public Integer getSellerDistance() {
        return sellerDistance;
    }
    @Override
    public Integer getSellerRating() {
        return sellerRating;
    }
    @Override
    public String getContentText() {
        return contentText;
    }
    @Override
    public List<String> getImages() {
        return images;
    }


    //*** PARCELABLE ***//
    //
    //    For passing objects via Intents with high performance serialisation.
    //    https://stackoverflow.com/questions/2139134/how-to-send-an-object-from-one-android-activity-to-another-using-intents
    //    https://stackoverflow.com/questions/7181526/how-can-i-make-my-custom-objects-parcelable
    //    https://developer.android.com/reference/android/os/Parcel

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(getCategoryType());
        dest.writeString(getTitle());
        dest.writeString(getFeatureImage());
        dest.writeString(getFeatureText());
        dest.writeFloat(getPrice());

        dest.writeString(getSellerName());
        dest.writeInt(getSellerDistance());
        dest.writeInt(getSellerRating());

        dest.writeString(getContentText());
        dest.writeStringList(getImages());
    }

    public static final Parcelable.Creator<Item> CREATOR
            = new Parcelable.Creator<Item>() {
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    private Item(Parcel in) {
        // Constructor for parcelable
        // Reads data as FIFO
        type            = (CategoryType) in.readSerializable();
        title           = in.readString();
        featureImage    = in.readString();
        featureText     = in.readString();
        price           = in.readFloat();

        sellerName      = in.readString();
        sellerDistance  = in.readInt();
        sellerRating    = in.readInt();

        contentText     = in.readString();

        if (images == null) {
            // Must create list instance before trying to store to it
            // https://idlesun.blogspot.com/2012/12/android-parcelable-example-2-subobject.html
            images = new ArrayList<String>();
        }
        in.readStringList(images);

        // category type, seller, meta left empty
    }

    public Item()
    {
        // Placeholders for TESTING ONLY
        this.type = CategoryType.FRUIT;

        this.title          = "Placeholder Listing";
        this.featureImage   = "placeholder_featureimage";
        this.featureText    = "Placeholder listing featureText";

        this.price          = 0;
        this.seller         = new Seller();
        refreshSellerData();

        this.contentText    = "Placeholder listing contentText";
        List<String> images = new ArrayList<String>();
        images.add("placeholder_featureimage");
        images.add("placeholder_featureimage");
        this.images         = images;
    }
}
