package com.example.compsys302_project_two;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {

    protected static final List<Item> items = generateItems();
    protected static final List<Category> categories = generateCategories();
    protected static final ArrayList<Item> topPicks = generateTopPicks();

    public static List<Item> getItems() {
        return items;
    }
    public static List<Category> getCategories()
    {
        return categories;
    }
    public static ArrayList<Item> getTopPicks() { return topPicks; }

    private static List<Item> generateItems()
    {
        List<Item> items = new ArrayList<Item>();

        {
            Item item;

            CategoryType type;
            String  title;
            String  featureImage;
            String  featureText;
            float   price;

            Seller  seller;
            String  sellerName;
            Integer sellerDistance;
            Integer sellerRating;

            String  contentText;
            List<String> images;

            // Item 1
            type = CategoryType.FRUIT;
            title = "Cheap Red Eating Apples";
            featureImage= "img_applebranch";
            featureText = "Selling bags cheap, come get them before they rot. Free if you pick your own.";
            price = (float)2.5;

            sellerName = "Summer Orchards";
            sellerDistance = 12;
            sellerRating = 8;

            contentText = "Red eating apples of assorted breeds. Also good for cooking. Please pick up between 10am and 4pm, (gravel) driveway is first turnoff from Fir corner. Some apples have small blemishes from the hail last month.";
            images = new ArrayList<String>();
            images.add(featureImage);
            images.add("img_applepicking");
            images.add("img_applescrate");

            seller = new Seller(sellerName, sellerDistance, sellerRating);
            item = new Item(type, title, featureImage, featureText, price, seller, contentText, images);
            items.add(item);

            // Item 2
            type = CategoryType.FRUIT;
            title = "Purple grapes on the vine";
            featureImage= "img_grapesbunch";
            featureText = "No pesticides, no bloom, all natural and good condition. Watch out for seeds!";
            price = (float)6;

            sellerName = "Liz Murphy";
            sellerDistance = 4;
            sellerRating = 7;

            contentText = "Grapes grown on pergola round the back.";
            images = new ArrayList<String>();
            images.add(featureImage);
            images.add("img_grapespergola");
            images.add("img_grapesleafy");

            seller = new Seller(sellerName, sellerDistance, sellerRating);
            item = new Item(type, title, featureImage, featureText, price, seller, contentText, images);
            items.add(item);

            // Item 3
            title = "Free Lemons!!";
            featureImage= "img_lemon";
            featureText = "When life gives you lemons, grow more.";
            price = (float)0;

            sellerName = "Bo";
            sellerDistance = 7;
            sellerRating = 10;

            contentText = "Zingy and zesty. Good for drinking too, with 2 cups of sugar every 1L water and juice + rind of 12 lemons.";
            images = new ArrayList<String>();
            images.add(featureImage);
            images.add("img_lemonsstore");
            images.add("img_lemontree");

            seller = new Seller(sellerName, sellerDistance, sellerRating);
            item = new Item(type, title, featureImage, featureText, price, seller, contentText, images);
            items.add(item);

            // Item 4
//            title = "";
//            featureImage= "";
//            featureText = "";
//            price = (float)0;
//
//            sellerName = "";
//            sellerDistance = 4;
//            sellerRating = 4;
//
//            contentText = "";
//            images = new ArrayList<String>();
//            images.add(featureImage);
//            images.add("");
//            images.add("");
//
//            seller = new Seller(sellerName, sellerDistance, sellerRating);
//            item = new Item(title, featureImage, featureText, price, seller, contentText, images);
//            items.add(item);
        }



        for (int i = 0; i < 10; i++)
        {
            Item item = new Item();
            items.add(item);
        }

        return items;
    }

    private static List<Category> generateCategories()
    {
        List<Category> categories = new ArrayList<Category>();

        {
            Category category;

            CategoryType type;
            String  title;
            String  featureImage;
            String  featureText;


            // Category 1
            type = CategoryType.FRUIT;
            title = "Fruit";
            featureImage= "img_berries";
            featureText = "Fresh fruit.";

            category = new Category(type, title, featureImage, featureText);
            categories.add(category);

            // Category 2
            // Category 1
            type = CategoryType.VEGETABLES;
            title = "Vegetables";
            featureImage= "img_vegetablesrustic";
            featureText = "Fresh vegetables.";

            category = new Category(type, title, featureImage, featureText);
            categories.add(category);

            // Category 3
            // Category 1
            type = CategoryType.HERBS;
            title = "Herbs";
            featureImage= "img_herbs";
            featureText = "Tasty herbs.";

            category = new Category(type, title, featureImage, featureText);
            categories.add(category);
        }


        for (int i = 0; i < 10; i++)
        {
            Category category = new Category();
            categories.add(category);
        }

        return categories;
    }

    public static ArrayList<Item> generateTopPicks()
    {
        ArrayList<Item> topPicks = new ArrayList<Item>();
        topPicks.add(items.get(0));
        topPicks.add(items.get(1));
        topPicks.add(items.get(2));
        topPicks.add(items.get(3));

        return topPicks;
    }
}
