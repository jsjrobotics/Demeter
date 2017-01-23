package com.jsjrobotics.demeter.displayableScreens;

import com.jsjrobotics.demeter.dataStructures.DisplayItem;
import com.jsjrobotics.demeter.dataStructures.HomepageBlurb;

public class HomepageBlurbDisplayItem extends DisplayItem {
    private final HomepageBlurb mData;

    public HomepageBlurbDisplayItem(HomepageBlurb data) throws IllegalArgumentException{
        mData = data;
    }
}
