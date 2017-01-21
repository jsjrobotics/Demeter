package com.jsjrobotics.demeter.homeScreen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.jsjrobotics.demeter.androidWrappers.DefaultFragment;

public class MainFragment extends DefaultFragment<MainPresenter, MainView> {

    @Override
    protected MainPresenter buildPresenter(Bundle savedInstanceState) {
        return new MainPresenter(() -> this, savedInstanceState);
    }

    @Override
    protected MainView buildView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        return new MainView(inflater, viewGroup, savedInstanceState);
    }
}
