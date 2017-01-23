package com.jsjrobotics.demeter.dataStructures;

import com.jsjrobotics.demeter.displayableScreens.HomepageBlurbDisplayItem;

public class DisplayItem {
    public DisplayItem() throws IllegalArgumentException {}

    public void transform(DisplayTransformer transformer) {
        if (this instanceof HomepageBlurbDisplayItem){
            transformer.apply((HomepageBlurbDisplayItem) this);
        }
    }
}
