/*
    COMPSYS302 Project 2 (Java/Android)

    Author: Callum McDowell
    Date:   May 2021

    Summary

        Seller class a model class is instantiated for each individual seller.
        It contains simple information that will not change. Each listing
        (an Item instance) must be associated with a Seller instance.

        Class properties:
            - name:     Name of the seller
            - distance: Distance of the seller from the browser (in actuality
                        this would be dynamic and dependent on the location
                        of the current browser).
            - rating:   Rating of the seller (i.e. trustworthiness). The scale
                        is a 5-star scale from 0 to 5.
*/

package com.example.compsys302_project_two;

public class Seller {

    String  name;
    Integer distance;
    Integer rating;

    public Seller(String name, Integer distance, Integer rating)
    {
        this.name = name;
        this.distance = distance;
        this.rating = rating;
    }

    public String   getName() {return name;}
    public Integer  getDistance() {return distance;}
    public Integer  getRating() {return rating;}

    public Seller()
    {
        // Placeholders for TESTING ONLY
        name = "Seller McSeller";
        distance = 2;
        rating = 6;
    }
}
