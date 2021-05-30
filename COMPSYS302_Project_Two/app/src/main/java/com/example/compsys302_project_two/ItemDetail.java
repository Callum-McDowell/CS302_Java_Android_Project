/*
    COMPSYS302 Project 2 (Java/Android)

    Author: Callum McDowell
    Date:   May 2021

    Summary

        ItemDetail is a child of the Item class. An instance of ItemDetail is
        created for every listing. ItemDetail holds larger and more in-depth
        content that may be needed for a detailed view of an item (e.g. in
        DetailActivity) but is unnecessary and wasteful of memory for showing
        a simple list of listings (e.g. ListActivity).

        Class properties:
            - contentText:  Body text of the listing (excluding featureText).
            - images:       List of all images for the listing (including
                            the featureImage).
*/

package com.example.compsys302_project_two;

import java.util.List;

public class ItemDetail extends Item {

    String  contentText;
    List<String> images;


    public ItemDetail(String title, String featureImage, String featureText,
                      float price, Seller seller, String contextText, List<String> images)
    {
        super(title, featureImage, featureText, price, seller);
        this.contentText = contextText;
        this.images = images;
    }

    @Override
    public String getContentText() {
        return contentText;
    }
    @Override
    List<String> getImages() {
        return images;
    }
}
