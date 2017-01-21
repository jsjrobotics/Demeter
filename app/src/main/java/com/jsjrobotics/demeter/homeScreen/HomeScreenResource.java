package com.jsjrobotics.demeter.homeScreen;

import android.support.annotation.Nullable;

import com.jsjrobotics.demeter.dataStructures.DisplayableScreen;
import com.jsjrobotics.demeter.dataStructures.resources.OfflineFirstResource;

class HomeScreenResource extends OfflineFirstResource {
    private final String mFilename;
    private final String mUrl;

    HomeScreenResource(String filename, String url) {
        mFilename = filename;
        mUrl = url;
    }

    @Nullable
    @Override
    protected DisplayableScreen loadOnlineContent() {
        return null;
    }

    @Nullable
    @Override
    protected DisplayableScreen loadOfflineContent() {
        return null;
    }

    @Override
    public String getFilename() {
        return mFilename;
    }

    @Override
    public String getUrl() {
        return mUrl;
    }

}
