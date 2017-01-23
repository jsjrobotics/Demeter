package com.jsjrobotics.demeter.dataStructures;


import com.jsjrobotics.demeter.displayableScreens.DisplayItem;

public class HomepageBlurb extends DisplayItem {
    private final String mTitle;
    private final String mSummary;
    private final String mImage;

    public HomepageBlurb(String title, String summary, String image) {
        mTitle = title;
        mSummary = summary;
        mImage = image;
    }


    public String getTitle() {
        return mTitle;
    }

    public String getSummary() {
        return mSummary;
    }

    public String getImage() {
        return mImage;
    }
}
