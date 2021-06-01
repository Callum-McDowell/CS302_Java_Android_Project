package com.example.compsys302_project_two;

public class TopPick {

    String title;
    String featureImage;

    public TopPick (String title, String featureImage, String featureText) {
        this.title = title;
        this.featureImage = featureImage;
    }

    public String getTitle() {
        return title;
    }
    public String getFeatureImage() {
        return featureImage;
    }

    // For TESTING use ONLY
    public TopPick() {
        title = "Example Pick";
        featureImage = "img_vegetablesrustic";
    }
}
