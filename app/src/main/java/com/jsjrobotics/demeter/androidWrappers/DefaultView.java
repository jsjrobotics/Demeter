package com.jsjrobotics.demeter.androidWrappers;

import android.os.Bundle;
import android.view.View;

public interface DefaultView {
    View getLayout();

    void saveInstanceState(Bundle outState);
}
