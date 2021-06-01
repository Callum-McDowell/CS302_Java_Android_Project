package com.example.compsys302_project_two;

public class Category implements ICategory {

    String title;
    String featureImage;
    String featureText;

    public Category(String title, String featureImage, String featureText) {
        this.title = title;
        this.featureImage = featureImage;
        this.featureText = featureText;
    }

    public String getTitle() {
        return title;
    }
    public String getFeatureImage() {
        return featureImage;
    }
    public String getFeatureText() {
        return featureText;
    }

    // For TESTING use ONLY
    public Category() {
        title = "Example Category";
        featureImage = "img_vegetablesrustic";
        featureText = "Description of the category goes here. One or two sentences at most.";
    }
}
