/*
    COMPSYS302 Project 2 (Java/Android)

    Author: Callum McDowell
    Date:   May 2021

    Summary

        IItem is an interface for receiving data from an Item or ItemDetail
        class instance.

        Note that the following methods should ony be called on ItemDetail,
        as Item does not have the extraneous information for performance
        reasons.
            - getContextText();
            - getImages();
*/

package com.example.compsys302_project_two;

import java.util.List;

public interface IItem {

    public String   getTitle();
    public String   getFeatureImage();
    public String   getFeatureText();
    public float    getPrice();
    public List<String> getMeta();

    public Seller   getSeller();
    public String   getSellerName();
    public Integer  getSellerDistance();
    public Integer  getSellerRating();

    public String   getContentText();
    public List<String> getImages();
}
