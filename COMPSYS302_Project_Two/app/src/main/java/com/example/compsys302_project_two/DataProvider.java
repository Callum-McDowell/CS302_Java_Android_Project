package com.example.compsys302_project_two;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {

    protected static List<ItemDetail> items = generateItems();
//    protected static List<Category> categories = generateCategories();

    public static List<ItemDetail> getItems()
    {
        return items;
    }

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

//    public static List<Category> getCategories()
//    {
//        return categories;
//    }

//    public static void generateCategories()
//    {
//
//    }

}
