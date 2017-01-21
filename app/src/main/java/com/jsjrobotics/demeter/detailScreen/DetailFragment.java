package com.jsjrobotics.demeter.detailScreen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.jsjrobotics.demeter.androidWrappers.DefaultFragment;

public class DetailFragment extends DefaultFragment<DetailPresenter, DetailView> {
    @Override
    protected DetailPresenter buildPresenter(Bundle savedInstanceState) {
        return null;
    }

    @Override
    protected DetailView buildView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        return new DetailView(inflater, viewGroup, savedInstanceState);
    }
}
