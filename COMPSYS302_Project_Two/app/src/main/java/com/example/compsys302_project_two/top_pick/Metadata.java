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

package com.example.compsys302_project_two.top_pick;

import android.renderscript.Sampler;

import com.example.compsys302_project_two.DataProvider;
import com.example.compsys302_project_two.item.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Metadata {
    protected static Map<Item, Integer> views = generateViews();

    // Fill HashMap 'views' with all of DataProvider's items, and set their views to 0
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
    // Return a list of Items that have 0 views.
    public static List<Item> getUnViewed() {
        List<Item> unviewed = new ArrayList<Item>();
        for (Map.Entry<Item, Integer> pair : views.entrySet()) {
            if (pair.getValue() <= 0) {
                unviewed.add(pair.getKey());
            }
        }
        return unviewed;
    }
    // Return a list of the most viewed Items, descending. Excluding un-viewed Items.
    public static List<Item> getMostViewedDescending () {
        List<Map.Entry<Item, Integer>> list = new ArrayList<>(views.entrySet());
        List<Item> sorted = new ArrayList<Item>();

        Collections.sort(list, new Comparator<Map.Entry<Item, Integer>>() {
            @Override
            public int compare(Map.Entry<Item, Integer> o1, Map.Entry<Item, Integer> o2) {
                // Return descending (highest values first)
                return o2.getValue() - o1.getValue();
            }
        });

        for (Map.Entry<Item, Integer> pair : list) {
            if (pair.getValue() > 0) {
                sorted.add(pair.getKey());
            } else {
                // Exit when reached un-viewed Items
                break;
            }
        }

        return sorted;
    }
}
