package com.jsjrobotics.demeter.homeScreen;


import android.content.Context;
import android.content.res.Resources;

import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Receiver;
import com.jsjrobotics.demeter.R;
import com.jsjrobotics.demeter.dataStructures.DisplayableScreen;
import com.jsjrobotics.demeter.dataStructures.resources.OfflineFirstResource;

class MainModel {

    private final Resources mResources;
    private final Context mContext;

    public MainModel (final Context context, final Resources resources){
        mContext = context;
        mResources = resources;
    }

    private void loadContent(final OfflineFirstResource resource, final Receiver<Optional<DisplayableScreen>> listener) {
        Thread t = new Thread(() -> {
            resource.getContent(listener);
        });
        t.start();
    }

    private OfflineFirstResource buildHomescreenResource() {
        final String filename = mResources.getString(R.string.homescreen_filename);
        final String url = mResources.getString(R.string.homescreen_url);
        return new HomeScreenResource(mContext, filename, url);
    }

    void loadHomeScreen(Receiver<Optional<DisplayableScreen>> receiver) {
        loadContent(buildHomescreenResource(), receiver);
    }
}
