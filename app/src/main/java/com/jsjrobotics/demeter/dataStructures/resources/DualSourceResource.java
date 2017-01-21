package com.jsjrobotics.demeter.dataStructures.resources;


import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;
import com.jsjrobotics.demeter.dataStructures.DisplayableScreen;

public interface DualSourceResource {
    String getFilename();
    String getUrl();
    Optional<DisplayableScreen> getContent();
}
