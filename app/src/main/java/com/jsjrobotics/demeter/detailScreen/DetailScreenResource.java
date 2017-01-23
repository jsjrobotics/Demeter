package com.jsjrobotics.demeter.detailScreen;

import android.support.annotation.Nullable;

import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Receiver;
import com.jsjrobotics.demeter.dataStructures.DisplayableScreen;
import com.jsjrobotics.demeter.dataStructures.resources.OfflineFirstResource;

class DetailScreenResource extends OfflineFirstResource {
    private final String mFilename;
    private final String mUrl;

    DetailScreenResource(String filename, String url) {
        mFilename = filename;
        mUrl = url;
    }

    @Override
    public String getFilename() {
        return mFilename;
    }

    @Override
    public String getUrl() {
        return mUrl;
    }

    @Nullable
    @Override
    protected void loadOnlineContent(Receiver<Optional<DisplayableScreen>> listener) {

    }

    @Nullable
    @Override
    protected DisplayableScreen loadOfflineContent() {
        return null;
    }
}
