package com.jsjrobotics.demeter.homeScreen;

import android.graphics.Bitmap;

import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;
import com.jsjrobotics.demeter.Utils.BitmapInflater;
import com.jsjrobotics.demeter.dataStructures.DisplayableScreen;
import com.jsjrobotics.demeter.dataStructures.DisplayItem;

import java.util.ArrayList;
import java.util.List;

public class HomepageBlurbScreen extends DisplayableScreen {
    public HomepageBlurbScreen(List<HomepageBlurb> result) {
        super(buildInflater(), buildContent(result));
    }

    private static BitmapInflater buildInflater() {
        return new BitmapInflater() {
            @Override
            public Bitmap buildBitmap(int width, int height) {
                return null;
            }
        };
    }

    private static List<DisplayItem> buildContent(final List<HomepageBlurb> data) {
        List<DisplayItem> result = new ArrayList<>();
        for (HomepageBlurb current : data) {
            Optional<HomepageBlurb> item = buildHomepageDisplayItem(current);
            item.ifPresent(result::add);
        }
        return result;
    }

    private static Optional<HomepageBlurb> buildHomepageDisplayItem(HomepageBlurb current) {
        try {
            return Optional.ofNullable(current);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
