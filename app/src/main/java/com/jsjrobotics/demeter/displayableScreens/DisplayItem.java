package com.jsjrobotics.demeter.displayableScreens;

import com.jsjrobotics.demeter.dataStructures.DisplayTransformer;
import com.jsjrobotics.demeter.dataStructures.HomepageBlurb;

public class DisplayItem {
    protected DisplayItem() throws IllegalArgumentException {}

    public final void transform(DisplayTransformer transformer) {
        if (this instanceof HomepageBlurb){
            transformer.apply((HomepageBlurb) this);
        }
    }
}
