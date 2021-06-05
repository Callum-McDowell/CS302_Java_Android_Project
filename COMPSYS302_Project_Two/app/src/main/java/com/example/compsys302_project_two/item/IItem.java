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

package com.example.compsys302_project_two.item;

import com.example.compsys302_project_two.category.CategoryType;

import java.util.List;

public interface IItem {

    CategoryType getCategoryType();

    String   getTitle();
    String   getFeatureImage();
    String   getFeatureText();
    float    getPrice();

    Seller getSeller();
    String   getSellerName();
    Integer  getSellerDistance();
    Integer  getSellerRating();

    String   getContentText();
    List<String> getImages();
}
