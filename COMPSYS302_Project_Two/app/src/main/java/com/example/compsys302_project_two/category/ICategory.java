/*
    COMPSYS302 Project 2 (Java/Android)

    Author: Callum McDowell
    Date:   May 2021

    Summary

        ICategory is an interface for receiving data from an Category
        class instance.
*/

package com.example.compsys302_project_two.category;

import com.example.compsys302_project_two.category.CategoryType;

public interface ICategory {

    CategoryType getCategoryType();

    String getTitle();

    String getFeatureImage();

    String getFeatureText();
}
