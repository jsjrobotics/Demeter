package com.jsjrobotics.demeter.homeScreen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jsjrobotics.demeter.R;
import com.jsjrobotics.demeter.androidWrappers.DefaultView;

class MainView implements DefaultView {
    private final View mRoot;

    MainView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.main_view, viewGroup, false);
    }

    public View getLayout() {
        return mRoot;
    }

    public void saveInstanceState(Bundle outState) {

    }
}
