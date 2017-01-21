package com.jsjrobotics.demeter.dataStructures;

import com.jsjrobotics.demeter.ImageUtils.BitmapInflater;

import java.util.List;

public class DisplayableScreen {
    private BitmapInflater imageInflater;
    private List<DisplayItem> mContent;

    public BitmapInflater getHeaderInflater() {
        return imageInflater;
    }

    public List<DisplayItem> getContent() {
        return mContent;
    }
}
