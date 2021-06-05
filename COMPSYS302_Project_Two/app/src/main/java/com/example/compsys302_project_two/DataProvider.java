/*
    COMPSYS302 Project 2 (Java/Android)

    Author: Callum McDowell
    Date:   May 2021

    Summary

        DataProvider class generates all information of:
            - Items - generateItems()
            - Categories - generateCategories()
        As their appropriate model class and hold them in this class
*/

package com.example.compsys302_project_two;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {

    protected static final List<Item> items = generateItems();
    protected static final List<Category> categories = generateCategories();

    public static List<Item> getItems() {
        return items;
    }
    public static List<Category> getCategories()
    {
        return categories;
    }

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

            /** FRUIT **/
            // Item 1
            type = CategoryType.FRUIT;
            title = "Cheap Eating Apples";
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
            title = "Purple vine grapes";
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
            type = CategoryType.FRUIT;
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
            type = CategoryType.FRUIT;
            title = "LEMONY LEMONS";
            featureImage= "img_lemonsbox";
            featureText = "Twelve boxes to go by this time next week.";
            price = (float)4;

            sellerName = "Citrus Circus";
            sellerDistance = 8;
            sellerRating = 4;

            contentText = "From an organic farm near where my dad lives, and I brought some of that with me from home.";
            images = new ArrayList<String>();
            images.add(featureImage);
            images.add("img_lemontree");
            images.add("img_lemon");

            seller = new Seller(sellerName, sellerDistance, sellerRating);
            item = new Item(type, title, featureImage, featureText, price, seller, contentText, images);
            items.add(item);

            // Item 5
            type = CategoryType.FRUIT;
            title = "Organic Mandarins";
            featureImage= "img_mandarins";
            featureText = "Picked from orchard. Seasonal variety, juicy and sweet.";
            price = (float)3;

            // Use previous seller!
//            sellerName = "";
//            sellerDistance = 4;
//            sellerRating = 4;

            contentText = "Getting rid of them before they rot - worms don't like the rind!!! Very juicy and sweet, can make juice/smoothies from them.";
            images = new ArrayList<String>();
            images.add(featureImage);
            images.add("img_lemontree");
            images.add("img_fruitpreserves");

            //seller = new Seller(sellerName, sellerDistance, sellerRating);
            item = new Item(type, title, featureImage, featureText, price, seller, contentText, images);
            items.add(item);

            // Item 6
            type = CategoryType.FRUIT;
            title = "Early Strawberries";
            featureImage= "img_strawberrybox";
            featureText = "Grown in hothouse and riped a bit early this year. Grown in fresh straw, but check for bugs just in case.";
            price = (float)7.5;

            sellerName = "Berry Bob";
            sellerDistance = 4;
            sellerRating = 4;

            contentText = "The garden strawberry (or simply strawberry; Fragaria × ananassa) is a widely grown hybrid species of the genus Fragaria, collectively known as the strawberries, which are cultivated worldwide for their fruit. The fruit is widely appreciated for its characteristic aroma, bright red color, juicy texture, and sweetness.";
            images = new ArrayList<String>();
            images.add(featureImage);
            images.add("img_berries");
            images.add("img_fruitpreserves");

            seller = new Seller(sellerName, sellerDistance, sellerRating);
            item = new Item(type, title, featureImage, featureText, price, seller, contentText, images);
            items.add(item);

            // Item 7
            type = CategoryType.FRUIT;
            title = "Blueberries";
            featureImage= "img_blueberries";
            featureText = "Yum yum. Better than blackberries, since these ones don't have thorns.";
            price = (float)9;

//            sellerName = "";
//            sellerDistance = 4;
//            sellerRating = 4;

            contentText = "Blueberries are perennial flowering plants with blue or purple berries. They are classified in the section Cyanococcus within the genus Vaccinium. Vaccinium also includes cranberries, bilberries, huckleberries and Madeira blueberries.";
            images = new ArrayList<String>();
            images.add(featureImage);
            images.add("img_berries");
            images.add("img_fruitpreserves");

//            seller = new Seller(sellerName, sellerDistance, sellerRating);
            item = new Item(type, title, featureImage, featureText, price, seller, contentText, images);
            items.add(item);

            // Item 8
            type = CategoryType.FRUIT;
            title = "Seedless Grapes";
            featureImage= "img_grapesleafy";
            featureText = "";
            price = (float)3.3;

            sellerName = "Konstantin";
            sellerDistance = 1;
            sellerRating = 4;

            contentText = "A seedless fruit is a fruit developed to possess no mature seeds. As consumption of seedless fruits is generally easier and more convenient, they are considered commercially valuable. ";
            images = new ArrayList<String>();
            images.add(featureImage);
            images.add("img_grapesbunch");
            images.add("img_grapespergola");

            seller = new Seller(sellerName, sellerDistance, sellerRating);
            item = new Item(type, title, featureImage, featureText, price, seller, contentText, images);
            items.add(item);

            // Item 9
            type = CategoryType.FRUIT;
            title = "Red Cooking Apples";
            featureImage= "img_apples";
            featureText = "Tart, but soften up nicely in cooking. Make a great crumble or pie.";
            price = (float)0;

//            sellerName = "";
//            sellerDistance = 4;
//            sellerRating = 4;

            contentText = "An apple is an edible fruit produced by an apple tree (Malus domestica). Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today.";
            images = new ArrayList<String>();
            images.add(featureImage);
            images.add("img_applebranch");
            images.add("img_applespicking");

//            seller = new Seller(sellerName, sellerDistance, sellerRating);
            item = new Item(type, title, featureImage, featureText, price, seller, contentText, images);
            items.add(item);

            // Item 10
            type = CategoryType.FRUIT;
            title = "Summer Apricots";
            featureImage= "img_apricots";
            featureText = "Worth the price!";
            price = (float)20;

//            sellerName = "";
//            sellerDistance = 4;
//            sellerRating = 4;

            contentText = "Apricots are species belonging to Prunus sect. Armeniaca. The taxonomic position of P. brigantina is disputed. It is grouped with plum species according to chloroplast DNA sequences.";
            images = new ArrayList<String>();
            images.add(featureImage);
            images.add("placeholder_featureimage");
            images.add("img_mandarins");

//            seller = new Seller(sellerName, sellerDistance, sellerRating);
            item = new Item(type, title, featureImage, featureText, price, seller, contentText, images);
            items.add(item);

            /** VEGETABLES **/
            // Item 1
            type = CategoryType.VEGETABLES;
            title = "Homegrown Lettuce";
            featureImage= "img_lettuceplanter";
            featureText = "Come get what the snails haven't.";
            price = (float)0.5;

            sellerName = "Amateur Growers";
            sellerDistance = 11;
            sellerRating = 4;

            contentText = "Lotsa lettuce. Beware of the dog.";
            images = new ArrayList<String>();
            images.add(featureImage);
            images.add("img_lettucegarden");
            images.add("img_lettucegreenhouse");

            seller = new Seller(sellerName, sellerDistance, sellerRating);
            item = new Item(type, title, featureImage, featureText, price, seller, contentText, images);
            items.add(item);

            // Item 2
            type = CategoryType.VEGETABLES;
            title = "Green Lettuce";
            featureImage= "img_lettucegarden";
            featureText = "Rocket, not iceberg. Like the Apollo 12.";
            price = (float)2;

            sellerName = "Snail Feeders";
            sellerDistance = 4;
            sellerRating = 4;

            contentText = "Lettuce was originally farmed by the ancient Egyptians, who transformed it from a plant whose seeds were used to create oil into an important food crop raised for its succulent leaves and oil-rich seeds. Lettuce spread to the Greeks and Romans; the latter gave it the name lactuca, from which the English lettuce is derived.";
            images = new ArrayList<String>();
            images.add(featureImage);
            images.add("img_lettucegreenhouse");
            images.add("img_lettuceplanter");

            seller = new Seller(sellerName, sellerDistance, sellerRating);
            item = new Item(type, title, featureImage, featureText, price, seller, contentText, images);
            items.add(item);

            // Item 3
            type = CategoryType.VEGETABLES;
            title = "Lettuce - good condition";
            featureImage= "img_lettucegreenhouse";
            featureText = "Grown in this here greenhouse.";
            price = (float)0;

            sellerName = "Pigeon Man";
            sellerDistance = 4;
            sellerRating = 4;

            contentText = "Lettuce was originally farmed by the ancient Egyptians, who transformed it from a plant whose seeds were used to create oil into an important food crop raised for its succulent leaves and oil-rich seeds. Lettuce spread to the Greeks and Romans; the latter gave it the name lactuca, from which the English lettuce is derived.";
            images = new ArrayList<String>();
            images.add(featureImage);
            images.add("img_lettuceplanter");
            images.add("img_lettucegarden");

            seller = new Seller(sellerName, sellerDistance, sellerRating);
            item = new Item(type, title, featureImage, featureText, price, seller, contentText, images);
            items.add(item);

            // Item 4
            type = CategoryType.VEGETABLES;
            title = "Courgette";
            featureImage= "img_avocados";
            featureText = "Wait... avocados aren't a vegetable!";
            price = (float)6;

//            sellerName = "";
//            sellerDistance = 4;
//            sellerRating = 4;

            contentText = "Supposedly avocados are classified as berries. Before you know it they'll be saying the earth isn't flat, too!";
            images = new ArrayList<String>();
            images.add(featureImage);
            images.add("img_avocados");
            images.add("img_avocados");

//            seller = new Seller(sellerName, sellerDistance, sellerRating);
            item = new Item(type, title, featureImage, featureText, price, seller, contentText, images);
            items.add(item);

            // Item 5
            type = CategoryType.VEGETABLES;
            title = "Mixed Veg";
            featureImage= "img_vegetablebasket";
            featureText = "Lotsa veggies. Eat yer greens.";
            price = (float)10;

            sellerName = "Saltlake Farm";
            sellerDistance = 16;
            sellerRating = 4;

            contentText = "They're veg.";
            images = new ArrayList<String>();
            images.add(featureImage);
            images.add("img_vegetablesrustic");
            images.add("img_lettucegreenhouse");

            seller = new Seller(sellerName, sellerDistance, sellerRating);
            item = new Item(type, title, featureImage, featureText, price, seller, contentText, images);
            items.add(item);

            // Item 6
            type = CategoryType.VEGETABLES;
            title = "Cauliflower";
            featureImage= "img_cauliflower";
            featureText = "Buttery when microwaved";
            price = (float)4.2;

            sellerName = "Li Family";
            sellerDistance = 3;
            sellerRating = 4;

            contentText = "Cauliflower is one of several vegetables in the species Brassica oleracea in the genus Brassica, which is in the Brassicaceae (or Mustard) family. It is an annual plant that reproduces by seed. Typically, only the head is eaten – the edible white flesh sometimes called curd (with a similar appearance to cheese curd)";
            images = new ArrayList<String>();
            images.add(featureImage);
            images.add("img_vegetablebasket");
            images.add("img_vegetablebasket");

            seller = new Seller(sellerName, sellerDistance, sellerRating);
            item = new Item(type, title, featureImage, featureText, price, seller, contentText, images);
            items.add(item);

            // Item 7
            type = CategoryType.VEGETABLES;
            title = "Carrots";
            featureImage= "img_carrots";
            featureText = "Let you see in the dark*. *terms and conditions apply";
            price = (float)2.5;

//            sellerName = "";
//            sellerDistance = 4;
//            sellerRating = 4;

            contentText = "(Doesn't actually let you see in the dark. Or give you RADAR).";
            images = new ArrayList<String>();
            images.add(featureImage);
            images.add("img_vegetablesrustic");
            images.add("img_vegetablebasket");

//            seller = new Seller(sellerName, sellerDistance, sellerRating);
            item = new Item(type, title, featureImage, featureText, price, seller, contentText, images);
            items.add(item);

            // Item 8
            type = CategoryType.VEGETABLES;
            title = "Ravishing Radishes";
            featureImage= "img_radish";
            featureText = "Good in salads.";
            price = (float)5;

            sellerName = "Greenthumb";
            sellerDistance = 1;
            sellerRating = 4;

            contentText = "Please forgive the pun.";
            images = new ArrayList<String>();
            images.add(featureImage);
            images.add("img_applescrate");
            images.add("img_radish");

            seller = new Seller(sellerName, sellerDistance, sellerRating);
            item = new Item(type, title, featureImage, featureText, price, seller, contentText, images);
            items.add(item);

            // Item 9
            type = CategoryType.VEGETABLES;
            title = "Big Cauli";
            featureImage= "img_cauliflower";
            featureText = "Yuuge heads on 'em. Big crop.";
            price = (float)0;

//            sellerName = "";
//            sellerDistance = 4;
//            sellerRating = 4;

            contentText = "It's a cauliflower, mate. Nothing much special. Except for the size. Biggest in years, I tell ya.";
            images = new ArrayList<String>();
            images.add(featureImage);
            images.add("img_vegetablebasket");
            images.add("img_vegetablesrustic");

//            seller = new Seller(sellerName, sellerDistance, sellerRating);
            item = new Item(type, title, featureImage, featureText, price, seller, contentText, images);
            items.add(item);

            // Item 10
            type = CategoryType.VEGETABLES;
            title = "Orange Cucumbers";
            featureImage= "img_carrots";
            featureText = "They taste funny, too. And since when do cucumbers grow in the ground?";
            price = (float)0;

//            sellerName = "";
//            sellerDistance = 4;
//            sellerRating = 4;

            contentText = "Weird.";
            images = new ArrayList<String>();
            images.add(featureImage);
            images.add("img_vegetablebasket");
            images.add("img_vegetablesrustic");

//            seller = new Seller(sellerName, sellerDistance, sellerRating);
            item = new Item(type, title, featureImage, featureText, price, seller, contentText, images);
            items.add(item);

            /** HERBS **/
            // Item 1
            type = CategoryType.HERBS;
            title = "Parsley";
            featureImage= "img_parsley";
            featureText = "No snails.";
            price = (float)0;

            sellerName = "Maddie";
            sellerDistance = 3;
            sellerRating = 4;

            contentText = "Good flavouring.";
            images = new ArrayList<String>();
            images.add(featureImage);
            images.add("img_greenhousecosy");
            images.add("img_parsley");

            seller = new Seller(sellerName, sellerDistance, sellerRating);
            item = new Item(type, title, featureImage, featureText, price, seller, contentText, images);
            items.add(item);

            // Item 2
            type = CategoryType.HERBS;
            title = "Assorted Herbs";
            featureImage= "img_herbpots";
            featureText = "Dill, coriander, rosemary, spearmint, etc.";
            price = (float)2.5;

//            sellerName = "";
//            sellerDistance = 4;
//            sellerRating = 4;

            contentText = "Pots not included.";
            images = new ArrayList<String>();
            images.add(featureImage);
            images.add("img_greenhouserustic");
            images.add("img_greenhouserural");

//            seller = new Seller(sellerName, sellerDistance, sellerRating);
            item = new Item(type, title, featureImage, featureText, price, seller, contentText, images);
            items.add(item);

            // Item 3
            type = CategoryType.HERBS;
            title = "Basil";
            featureImage= "img_basil";
            featureText = "Fresh basil.";
            price = (float)0;

//            sellerName = "";
//            sellerDistance = 4;
//            sellerRating = 4;

            contentText = "";
            images = new ArrayList<String>();
            images.add(featureImage);
            images.add("img_greenhouserustic");
            images.add("img_greenhousecosy");

//            seller = new Seller(sellerName, sellerDistance, sellerRating);
            item = new Item(type, title, featureImage, featureText, price, seller, contentText, images);
            items.add(item);

            // Item 4
            type = CategoryType.HERBS;
            title = "Bay Leaf";
            featureImage= "img_greenhousecosy";
            featureText = "Popular in Russia.";
            price = (float)6;

            sellerName = "Greenhouse Growers";
            sellerDistance = 19;
            sellerRating = 4;

            contentText = "Don't actually eat them, though.";
            images = new ArrayList<String>();
            images.add(featureImage);
            images.add("img_greenhouserural");
            images.add("img_greenhouserustic");

            seller = new Seller(sellerName, sellerDistance, sellerRating);
            item = new Item(type, title, featureImage, featureText, price, seller, contentText, images);
            items.add(item);

            // Item 5
            type = CategoryType.HERBS;
            title = "Rosemary";
            featureImage= "img_rosemary";
            featureText = "Season lamb with this and a bit of salt and pepper.";
            price = (float)0;

            sellerName = "Minceton Nunnery";
            sellerDistance = 3;
            sellerRating = 4;

            contentText = "Grow your own bushes from cuttings!";
            images = new ArrayList<String>();
            images.add(featureImage);
            images.add("img_greenhouserustic");
            images.add("img_herbpots");

            seller = new Seller(sellerName, sellerDistance, sellerRating);
            item = new Item(type, title, featureImage, featureText, price, seller, contentText, images);
            items.add(item);

            // Item 6
            type = CategoryType.HERBS;
            title = "Oregano";
            featureImage= "img_greenhouserustic";
            featureText = "";
            price = (float)1.2;

//            sellerName = "";
//            sellerDistance = 4;
//            sellerRating = 4;

            contentText = "";
            images = new ArrayList<String>();
            images.add(featureImage);
            images.add("img_greenhousecosy");
            images.add("img_mint");

//            seller = new Seller(sellerName, sellerDistance, sellerRating);
            item = new Item(type, title, featureImage, featureText, price, seller, contentText, images);
            items.add(item);

            // Item 7
            type = CategoryType.HERBS;
            title = "Spearmint";
            featureImage= "img_mint";
            featureText = "Good for chewing. Freshens the breath!";
            price = (float)0;

//            sellerName = "";
//            sellerDistance = 4;
//            sellerRating = 4;

            contentText = "";
            images = new ArrayList<String>();
            images.add(featureImage);
            images.add("img_greenhouserural");
            images.add("img_herbpots");

//            seller = new Seller(sellerName, sellerDistance, sellerRating);
            item = new Item(type, title, featureImage, featureText, price, seller, contentText, images);
            items.add(item);

            // Item 8
            type = CategoryType.HERBS;
            title = "Sage";
            featureImage= "img_greenhouserural";
            featureText = "";
            price = (float)0.8;

//            sellerName = "";
//            sellerDistance = 4;
//            sellerRating = 4;

            contentText = "";
            images = new ArrayList<String>();
            images.add(featureImage);
            images.add("img_herbpots");
            images.add("img_greenhouserustic");

//            seller = new Seller(sellerName, sellerDistance, sellerRating);
            item = new Item(type, title, featureImage, featureText, price, seller, contentText, images);
            items.add(item);

            // Item 9
            type = CategoryType.HERBS;
            title = "All sorts of herbs";
            featureImage= "img_lettucegreenhouse";
            featureText = "";
            price = (float)0.5;

//            sellerName = "";
//            sellerDistance = 4;
//            sellerRating = 4;

            contentText = "";
            images = new ArrayList<String>();
            images.add(featureImage);
            images.add("img_parsley");
            images.add("img_greenhouserural");

//            seller = new Seller(sellerName, sellerDistance, sellerRating);
            item = new Item(type, title, featureImage, featureText, price, seller, contentText, images);
            items.add(item);

            // Item 10
            type = CategoryType.HERBS;
            title = "Thyme";
            featureImage= "img_herbs";
            featureText = "Heals all wounds.";
            price = (float)1;

//            sellerName = "";
//            sellerDistance = 4;
//            sellerRating = 4;

            contentText = "";
            images = new ArrayList<String>();
            images.add(featureImage);
            images.add("img_greenhouserural");
            images.add("img_greenhousecosy");

//            seller = new Seller(sellerName, sellerDistance, sellerRating);
            item = new Item(type, title, featureImage, featureText, price, seller, contentText, images);
            items.add(item);
        }


//          // Expand items for STRESS TESTING
//        for (int i = 0; i < 10; i++)
//        {
//            Item item = new Item();
//            items.add(item);
//        }

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

//        // Expand categories for STRESS TESTING
//        for (int i = 0; i < 10; i++)
//        {
//            Category category = new Category();
//            categories.add(category);
//        }

        return categories;
    }
}
