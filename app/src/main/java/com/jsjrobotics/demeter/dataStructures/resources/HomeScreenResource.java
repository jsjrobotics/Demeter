package com.jsjrobotics.demeter.dataStructures.resources;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.Nullable;

import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Receiver;
import com.jsjrobotics.demeter.FileUtils;
import com.jsjrobotics.demeter.R;
import com.jsjrobotics.demeter.backend.HomepageApi;
import com.jsjrobotics.demeter.backend.HomepageResponse;
import com.jsjrobotics.demeter.dataStructures.DisplayableScreen;
import com.jsjrobotics.demeter.dataStructures.HomepageBlurb;
import com.jsjrobotics.demeter.displayableScreens.HomepageBlurbScreen;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

public class HomeScreenResource extends OnlineFirstResource {
    private final Context mContext;
    private final String mFilename;
    private final String mUrlPath;
    private final ConnectivityManager mConnectivityManager;

    public HomeScreenResource(Context context) {
        mFilename = context.getString(R.string.homescreen_filename);
        mUrlPath = context.getString(R.string.homescreen_url);
        mContext = context;
        mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }


    private boolean isOnline() {
        NetworkInfo networkInfo = mConnectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }

    @Nullable
    @Override
    public void loadOnlineContent(final Receiver<Optional<DisplayableScreen>> listener) {
        if (isOnline()) {
            new HomepageApi(mContext).downloadData(mUrlPath, buildHomepageReceiver(listener));
        } else {
            listener.accept(Optional.empty());
        }
    }

    private Receiver<HomepageResponse> buildHomepageReceiver(final Receiver<Optional<DisplayableScreen>> listener) {
        return response -> {
            if (response.getSuccess()) {
                FileUtils.writeToFile(getFile(), response.getJson());
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
    public Optional<DisplayableScreen> loadOfflineContent() {
        File offline = getFile();
        if (!offline.exists()) {
            return Optional.empty();
        }
        Optional<String> offlineJson = FileUtils.readFile(getFile());
        if (offlineJson.isPresent()) {
            HomepageResponse result = HomepageResponse.parse(offlineJson.get());
            if (!result.getResult().isEmpty()) {
                return Optional.of(buildDisplayableScreen(result.getResult()));
            }
        }
        return Optional.empty();
    }

    @Override
    public String getFilename() {
        return mFilename;
    }

    @Override
    public String getUrl() {
        return mUrlPath;
    }

    public File getFile() {
        return new File(mContext.getFilesDir(), getFilename());
    }
}
