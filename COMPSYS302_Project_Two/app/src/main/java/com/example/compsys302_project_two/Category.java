package com.example.compsys302_project_two;

public class Category implements ICategory {

    CategoryType type;

    String title;
    String featureImage;
    String featureText;

    public Category(CategoryType type, String title, String featureImage, String featureText) {
        this.type = type;
        this.title = title;
        this.featureImage = featureImage;
        this.featureText = featureText;
    }

    @Override
    public CategoryType getCategoryType() {
        return type;
    }
    @Override
    public String getTitle() {
        return title;
    }
    @Override
    public String getFeatureImage() {
        return featureImage;
    }
    @Override
    public String getFeatureText() {
        return featureText;
    }

    // For TESTING use ONLY
    public Category() {
        type = CategoryType.FRUIT;
        title = "Example Category";
        featureImage = "img_vegetablesrustic";
        featureText = "Description of the category goes here. One or two sentences at most.";
    }
}
