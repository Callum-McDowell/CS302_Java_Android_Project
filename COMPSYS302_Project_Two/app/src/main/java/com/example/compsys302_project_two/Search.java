/*
    COMPSYS302 Project 2 (Java/Android)

    Author: Callum McDowell
    Date:   June 2021

    Summary

        Search is a static class for filtering lists of Item instances.
        It can filter by the following parameters:
            - CategoryTypes:    Any items with the given types
            - searchString:     Any items with the sub-string in title or featureText

        There is also a method to obtain all Item instances of a specific Seller.
*/
package com.example.compsys302_project_two;

import java.util.ArrayList;
import java.util.List;

public class Search {

    // Return a List of Item that fulfill the given search parameters.
    // Set maxPrice or maxDistance to -1 to omit them.
    public static List<Item> findBySearch(List<Item> items, List<CategoryType> types, String searchString) {
        List<Item> filteredItems = new ArrayList<Item>();

        for (Item item : items) {
            if (Search.matchesSearch(item, types, searchString)) {
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }

    // Return a List of all items with the given CategoryTypes.
    public static List<Item> findByCategory(List<Item> items, List<CategoryType> types) {
        List<Item> filteredItems = new ArrayList<Item>();

        for (Item item : items) {
            if (CategoryType.isPresentIn(item.getCategoryType(), types)) {
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }

    // Return a List of all items with the given seller.
    // Note that this must be called on DataProvider or other non-serialised items ONLY.
    // Current parcelable implementation removes link to seller instance.
    public static List<Item> findBySeller(List<Item> items, Seller seller) {
        List<Item> filteredItems = new ArrayList<Item>();

        for (Item item : items) {
            if (seller == item.getSeller()) {
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }

    // Return true if all parameters are met
    private static boolean matchesSearch(Item item, List<CategoryType> types, String searchString) {
        if (!CategoryType.isPresentIn(item.getCategoryType(), types)) {
            return false;
        }
        if (!(Search.matchesSearchString(item, searchString))) {
            return false;
        }
        return true;
    }

    // Return true if substring is present in item title or featureText
    private static boolean matchesSearchString(Item item, String searchString) {
        if (item.getTitle().contains(searchString)) {
            return true;
        }
        if (item.getFeatureText().contains(searchString)) {
            return true;
        }
        return false;
    }


}
