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

    public CategoryType getCategoryType();

    public String getTitle();

    public String getFeatureImage();

    public String getFeatureText();
}
