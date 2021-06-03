/*
    COMPSYS302 Project 2 (Java/Android)

    Author: Callum McDowell
    Date:   May 2021

    Summary

        CategoryType is an enum of the different categories. It is used for classifying items
        and filtering them (e.g. in SearchActivity, Search, etc).
*/
package com.example.compsys302_project_two;

import java.util.List;

public enum CategoryType {
    FRUIT, VEGETABLES, HERBS;


    // Return true if the enum value 'check' is in the list 'types'.
    // Returns true for all if list 'types' is empty.
    public static boolean isPresentIn(CategoryType check, List<CategoryType> types) {
        if (types.size() == 0) {return true;}

        for (CategoryType i : types) {
            if (check == i) {
                return true;
            }
        }
        return false;
    }
}
