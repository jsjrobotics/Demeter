package com.jsjrobotics.demeter.homeScreen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.jsjrobotics.demeter.androidWrappers.DefaultFragment;

public class HomeScreenFragment extends DefaultFragment<HomeScreenPresenter, HomeScreenView> {

    @Override
    protected HomeScreenPresenter buildPresenter(Bundle savedInstanceState) {
        return new HomeScreenPresenter(() -> this, savedInstanceState);
    }

    @Override
    protected HomeScreenView buildView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        return new HomeScreenView(inflater, viewGroup, savedInstanceState);
    }
}
