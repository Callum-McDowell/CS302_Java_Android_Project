/*
    COMPSYS302 Project 2 (Java/Android)

    Author: Callum McDowell
    Date:   May 2021

    Summary

        Item class is a class containing key information for a given listing.
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

package com.example.compsys302_project_two;

import java.util.ArrayList;
import java.util.List;

public class Item implements IItem {

    String  title;
    String  featureImage;
    String  featureText;
    float   price;
    Seller  seller;

    List<String> meta;

    public Item(String title, String featureImage, String featureText, float price, Seller seller)
    {
        this.title = title;
        this.featureImage = featureImage;
        this.featureText = featureText;
        this.price = price;
        this.seller = seller;
    }

    public Item()
    {
        // Placeholders for TESTING ONLY
        this.title          = "Placeholder Listing";
        this.featureImage   = ""
        this.featureText = featureText;
        this.price = price;
        this.seller = seller;
    }

    protected void generateMeta()
    {
        /* Populate with words (no spaces) from:
            - title
            - featureText
            - and any other relevant sources
         */
    }

    /* IItem Interface Calls */
    public String getTitle() {
        return title;
    }
    public String getFeatureImage() {
        return featureImage;
    }
    public String getFeatureText() {
        return featureText;
    }
    public float getPrice() {
        return price;
    }
    public Seller getSeller() {
        return seller;
    }
    public String getSellerName() {
        try {
            return seller.getName();
        } catch {
            return "Null Seller";
        }
    }
    public Integer getSellerDistance() {
        try {
            return seller.getDistance();
        } catch {
            return 0;
        }
    }
    public Integer getSellerRating() {
        try {
            return seller.getRating();
        } catch {
            return 0;
        }
    }
    // NOT IMPLEMENTED: Should be called on ItemDetail only.
    public String getContentText() {
        return "Error: getContextText() called on Item, not ItemDetail";
    }
    // NOT IMPLEMENTED: Should be called on ItemDetail only.
    List<String> getImages() {
        List<String> images = new ArrayList<String>();
        return images;
    }

}
