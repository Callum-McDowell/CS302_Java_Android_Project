package com.example.compsys302_project_two;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {

    protected static List<ItemDetail> items = generateItems();
    protected static List<Category> categories = generateCategories();
    protected static ArrayList<TopPick> topPicks = generateTopPicks();

    public static List<ItemDetail> getItems() {
        return items;
    }
    public static List<Category> getCategories()
    {
        return categories;
    }
    public static ArrayList<TopPick> getTopPicks() { return topPicks; }

    public static List<ItemDetail> generateItems()
    {
        List<ItemDetail> items = new ArrayList<ItemDetail>();

        for (int i = 0; i < 10; i++)
        {
            ItemDetail item = new ItemDetail();
            items.add(item);
        }

        return items;
    }

    public static List<Category> generateCategories()
    {
        List<Category> categories = new ArrayList<Category>();

        for (int i = 0; i < 10; i++)
        {
            Category category = new Category();
            categories.add(category);
        }

        return categories;
    }

    public static ArrayList<TopPick> generateTopPicks()
    {
        ArrayList<TopPick> topPicks = new ArrayList<TopPick>();

        for (int i = 0; i < 10; i++)
        {
            TopPick topPick = new TopPick();
            topPicks.add(topPick);
        }

        return topPicks;
    }
}
