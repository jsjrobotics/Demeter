package com.jsjrobotics.demeter.dataStructures;

import com.jsjrobotics.demeter.dataStructures.DisplayTransformer;
import com.jsjrobotics.demeter.homeScreen.HomepageBlurb;

public class DisplayItem {
    protected DisplayItem() throws IllegalArgumentException {}

    @SuppressWarnings("unchecked")
    // Type checking is handled by display transformer
    public final void transform(DisplayTransformer transformer) {
        if (getClass() == transformer.getTransformToType()){
            transformer.apply(this);
        }
    }
}
