package com.jsjrobotics.demeter.detailScreen;

import android.os.Bundle;

import com.jsjrobotics.demeter.androidWrappers.LifeCyclePresenter;

class DetailPresenter extends LifeCyclePresenter<DetailView> {
    private DetailView mView;

    @Override
    public void onViewStateRestored(DetailView view, Bundle inState) {
        mView = view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }
}
