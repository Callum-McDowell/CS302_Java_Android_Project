/*
    COMPSYS302 Project 2 (Java/Android)

    Author: Callum McDowell
    Date:   May 2021

    Summary

        Metadata class is a static class containing key information for a the metadata memory of
        the application. It is associated with the Items class.

        This class tracks the viewing frequency of each item, and is called in MainActivity
        and ItemAdaptor whenever the item is selected for viewing. This information is used to
        populate topPick through the upDateTopPicks() method in main.

        Class properties:
            - views:        A hashmap mapping each item's view frequency.
*/

package com.example.compsys302_project_two;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Metadata {
    protected static Map<Item, Integer> views = generateViews();

    private static Map<Item, Integer> generateViews() {
        Map<Item, Integer> views = new HashMap<Item, Integer>();
        List<Item> items = new ArrayList<Item>(DataProvider.getItems());

        for (Item item : items) {
            views.put(item, 0);
        }
        return views;
    }
    // Increment the view count for the current Item
    public static void incrementItemView(Item item) {
        // Increment view for given item
        views.put(item, views.get(item) + 1);
    }
    // Returns the most viewed Item. Returns null if all views are equal.
    public static Item getMostViewed() {
        Item viewMaxItem = new Item();
        // WARNING: This Item() is to prevent trying to return an un-instantiated item.
        // This item should never actually be returned.
        Integer viewMax = 0;
        Integer viewMin = 0;

        for (Map.Entry<Item, Integer> pair : views.entrySet()) {
            if (pair.getValue() > viewMax) {
                viewMax = pair.getValue();
                viewMaxItem = pair.getKey();
                // WARNING: Could incorrectly return temp Item if the largest value is smaller than the
                // initialised value (e.g. would fail for [-1,-3,-6] when it should return the Item
                // for value -1. As views cannot be negative the current application is acceptable.
            }
            if (pair.getValue() < viewMin) {
                viewMin = pair.getValue();
            }
        }
        if (viewMax != viewMin) {
            return viewMaxItem;
        } else {
            return null;
        }
    }
}
