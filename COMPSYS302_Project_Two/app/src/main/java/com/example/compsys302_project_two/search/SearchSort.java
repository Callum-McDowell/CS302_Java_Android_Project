/*
    COMPSYS302 Project 2 (Java/Android)

    Author: Callum McDowell
    Date:   June 2021

    Summary

        SearchSort is a class for sorting lists of Item instances. It uses custom Comparators to do
        so.

        It can sort by the following parameters, ascending and descending:
            - title:            Alphabetically
            - sellerPrice:      Float
            - sellerDistance:   Integer

        Useful: https://stackoverflow.com/questions/2784514/sort-arraylist-of-custom-objects-by-property/2784576
*/
package com.example.compsys302_project_two.search;

import com.example.compsys302_project_two.item.Item;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class SearchSort {
    public class ComparatorTitle implements Comparator<Item> {
        @Override
        public int compare(Item o1, Item o2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }
    public class ComparatorPrice implements Comparator<Item> {
        @Override
        public int compare(Item o1, Item o2) {
            if (o1.getPrice() > o2.getPrice()) {
                return 1;
            } else if (o1.getPrice() == o2.getPrice()) {
                return 0;
            } else {
                return -1;
            }
        }
    }
    public class ComparatorDistance implements Comparator<Item> {
        @Override
        public int compare(Item o1, Item o2) {
            return o1.getSellerDistance() - o2.getSellerDistance();
        }
    }

    public void sortAlphabetically(List<Item> list, boolean isAscending) {
        Collections.sort(list, new ComparatorTitle());
        if (!isAscending) {
            Collections.reverse(list);
        }
    }
    public void sortPrice(List<Item> list, boolean isAscending) {
        Collections.sort(list, new ComparatorPrice());
        if (!isAscending) {
            Collections.reverse(list);
        }
    }
    public void sortDistance(List<Item> list, boolean isAscending) {
        Collections.sort(list, new ComparatorDistance());
        if (!isAscending) {
            Collections.reverse(list);
        }
    }
}
