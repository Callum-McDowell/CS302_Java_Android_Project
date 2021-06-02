package com.example.compsys302_project_two;

import java.util.List;

public enum CategoryType {
    FRUIT, VEGETABLES, HERBS;


    // Return true if the enum value 'check' is in the list 'types'.
    public static boolean isPresentIn(CategoryType check, List<CategoryType> types) {
        for (CategoryType i : types) {
            if (check == i) {
                return true;
            }
        }
        return false;
    }
}
