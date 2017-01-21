package com.jsjrobotics.demeter.dataStructures.resources;


import android.support.annotation.Nullable;

import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;
import com.jsjrobotics.demeter.dataStructures.DisplayableScreen;

public abstract class OnlineFirstResource implements DualSourceResource {
    public Optional<DisplayableScreen> getContent() {
        Optional<DisplayableScreen> online = Optional.ofNullable(loadOnlineContent());
        if (online.isPresent()) {
            return online;
        }
        return Optional.ofNullable(loadOfflineContent());
    }

    abstract @Nullable
    DisplayableScreen loadOnlineContent();

    abstract @Nullable DisplayableScreen loadOfflineContent();
}
