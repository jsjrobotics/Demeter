package com.jsjrobotics.demeter.homeScreen;

import android.content.Context;
import android.support.annotation.Nullable;

import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Receiver;
import com.jsjrobotics.demeter.backend.downloader.HomepageApi;
import com.jsjrobotics.demeter.backend.downloader.HomepageResponse;
import com.jsjrobotics.demeter.dataStructures.DisplayableScreen;
import com.jsjrobotics.demeter.dataStructures.HomepageBlurb;
import com.jsjrobotics.demeter.dataStructures.resources.OfflineFirstResource;
import com.jsjrobotics.demeter.displayableScreens.HomepageBlurbScreen;

import java.util.List;

class HomeScreenResource extends OfflineFirstResource {
    private final String mFilename;
    private final String mUrl;
    private final Context mContext;

    HomeScreenResource(Context context, String filename, String url) {
        mFilename = filename;
        mUrl = url;
        mContext = context;
    }


    @Nullable
    @Override
    protected void loadOnlineContent(final Receiver<Optional<DisplayableScreen>> listener) {
        new HomepageApi(mContext).downloadData(buildHomepageReceiver(listener));
    }

    private Receiver<HomepageResponse> buildHomepageReceiver(final Receiver<Optional<DisplayableScreen>> listener) {
        return response -> {
            if (response.getSuccess()) {
                listener.accept(Optional.of(buildDisplayableScreen(response.getResult())));
                return;
            }
            listener.accept(Optional.empty());
        };
    }

    private DisplayableScreen buildDisplayableScreen(List<HomepageBlurb> result) {
        return new HomepageBlurbScreen(result);
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
