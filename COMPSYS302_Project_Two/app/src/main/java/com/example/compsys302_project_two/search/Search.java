/*
    COMPSYS302 Project 2 (Java/Android)

    Author: Callum McDowell
    Date:   June 2021

    Summary

        Search is a static class for filtering lists of Item instances.
        It can filter by the following parameters:
            - CategoryTypes:    Any items with the given types
            - searchString:     Any items with the sub-string in title or featureText

        There is also a method to obtain all Item instances of a specific Seller (using a string
        search with sellerName, for Intent and serialisation support).

        It can sort by the following parameters:
            - title:            Alphabetically descending
            - sellerPrice:      Integer, ascending
            - sellerDistance:   Integer, descending
*/

package com.example.compsys302_project_two.search;

import com.example.compsys302_project_two.category.CategoryType;
import com.example.compsys302_project_two.item.Item;

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
    // Note parcelable implementation removes link to seller instance, so this much be called on
    // sellerName not actual seller reference.
    public static List<Item> findBySeller(List<Item> items, String sellerName) {
        List<Item> filteredItems = new ArrayList<Item>();

        for (Item item : items) {
            if (sellerName.equals(item.getSellerName())) {
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }

    // Return true if all parameters are met
    // Leave 'types' empty or searchString empty ("") to ignore them
    private static boolean matchesSearch(Item item, List<CategoryType> types, String searchString) {
        if (!CategoryType.isPresentIn(item.getCategoryType(), types)) {
            return false;
        }
        return Search.matchesSearchString(item, searchString);
    }

    // Return true if substring is present in item title or featureText
    // Enter an empty string "" to skip.
    private static boolean matchesSearchString(Item item, String searchString) {
        if (searchString.equals("")) {
            return true;
        }
        searchString = searchString.toLowerCase();
        if (item.getTitle().toLowerCase().contains(searchString)) {
            return true;
        }
        if (item.getFeatureText().toLowerCase().contains(searchString)) {
            return true;
        }
        return item.getSellerName().toLowerCase().contains(searchString);
    }
}
