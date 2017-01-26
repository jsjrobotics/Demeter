package com.jsjrobotics.demeter.homeScreen;


import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;
import com.jsjrobotics.demeter.dataStructures.DisplayItem;

import org.json.JSONException;
import org.json.JSONObject;

public class HomepageBlurb extends DisplayItem {

    private static final String JSON_TITLE = "title";
    private static final String JSON_SUMMARY = "summary";
    private static final String JSON_IMAGE = "image";

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

    public JSONObject getJson() {
        JSONObject json = new JSONObject();
        try {
            json.put(JSON_TITLE, mTitle);
            json.put(JSON_SUMMARY, mSummary);
            json.put(JSON_IMAGE, mImage);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }

    public static Optional<HomepageBlurb> parse(JSONObject current) {
        try {
            String title = current.getString(JSON_TITLE);
            String summary = current.getString(JSON_SUMMARY);
            String image = current.getString(JSON_IMAGE);
            return Optional.of(new HomepageBlurb(title, summary, image));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
