package com.jsjrobotics.demeter.detailScreen;


import android.content.res.Resources;

import com.jsjrobotics.defaultTemplate.lifecycle.functional.Receiver;
import com.jsjrobotics.demeter.R;
import com.jsjrobotics.demeter.dataStructures.DisplayableScreen;
import com.jsjrobotics.demeter.dataStructures.resources.OfflineFirstResource;

class DetailModel {
    private final Resources mResources;

    public DetailModel (final Resources resources){
        mResources = resources;
    }
    private void loadContent(OfflineFirstResource resource, Receiver<DisplayableScreen> content) {

    }

    private OfflineFirstResource buildDetailScreenResource() {
        final String filename = mResources.getString(R.string.detailscreen_filename);
        final String url = mResources.getString(R.string.detailscreen_url);
        return new DetailScreenResource(filename, url);
    }

    void loadDetailScreen(Receiver<DisplayableScreen> receiver) {
        loadContent(buildDetailScreenResource(), receiver);
    }
}
