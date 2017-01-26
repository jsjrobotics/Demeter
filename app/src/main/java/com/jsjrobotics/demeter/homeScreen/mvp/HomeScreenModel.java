package com.jsjrobotics.demeter.homeScreen.mvp;


import android.content.Context;

import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Receiver;
import com.jsjrobotics.demeter.dataStructures.DisplayableScreen;
import com.jsjrobotics.demeter.dataStructures.resources.DualSourceResource;
import com.jsjrobotics.demeter.homeScreen.HomeScreenResource;

class HomeScreenModel {

    private final HomeScreenResource mResource;

    HomeScreenModel(final Context context){
        mResource = new HomeScreenResource(context);
    }

    private static void loadContent(final DualSourceResource resource,
                                    final Receiver<Optional<DisplayableScreen>> listener) {
        Thread t = new Thread(() -> {
            resource.getContent(listener);
        });
        t.start();
    }

    void loadHomeScreen(Receiver<Optional<DisplayableScreen>> receiver) {
        loadContent(mResource, receiver);
    }
}
