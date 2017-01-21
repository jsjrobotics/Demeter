package com.jsjrobotics.demeter.homeScreen;


import android.content.res.Resources;

import com.jsjrobotics.defaultTemplate.lifecycle.functional.Receiver;
import com.jsjrobotics.demeter.R;
import com.jsjrobotics.demeter.dataStructures.DisplayableScreen;
import com.jsjrobotics.demeter.dataStructures.resources.OfflineFirstResource;

class MainModel {

    private final Resources mResources;

    public MainModel (final Resources resources){
        mResources = resources;
    }
    private void loadContent(OfflineFirstResource resource, Receiver<DisplayableScreen> content) {

    }

    private OfflineFirstResource buildHomescreenResource() {
        final String filename = mResources.getString(R.string.homescreen_filename);
        final String url = mResources.getString(R.string.homescreen_url);
        return new HomeScreenResource(filename, url);
    }

    void loadHomeScreen(Receiver<DisplayableScreen> receiver) {
        loadContent(buildHomescreenResource(), receiver);
    }
}
