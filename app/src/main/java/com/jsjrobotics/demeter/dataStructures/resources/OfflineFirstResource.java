package com.jsjrobotics.demeter.dataStructures.resources;


import android.support.annotation.Nullable;

import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;
import com.jsjrobotics.demeter.dataStructures.DisplayableScreen;

public abstract class OfflineFirstResource implements DualSourceResource {
    public Optional<DisplayableScreen> getContent() {
        Optional<DisplayableScreen> offline = Optional.ofNullable(loadOfflineContent());
        if (offline.isPresent()) {
            return offline;
        }
        return Optional.ofNullable(loadOnlineContent());
    }

    protected abstract @Nullable DisplayableScreen loadOnlineContent();

    protected abstract @Nullable DisplayableScreen loadOfflineContent();
}
