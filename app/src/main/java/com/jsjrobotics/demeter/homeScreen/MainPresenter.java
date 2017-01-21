package com.jsjrobotics.demeter.homeScreen;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.jsjrobotics.defaultTemplate.lifecycle.functional.Receiver;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Supplier;
import com.jsjrobotics.demeter.androidWrappers.LifeCyclePresenter;
import com.jsjrobotics.demeter.dataStructures.DisplayableScreen;

class MainPresenter extends LifeCyclePresenter<MainView> {
    private final Supplier<Fragment> mContext;
    private MainView mView;

    MainPresenter(Supplier<Fragment> context, Bundle savedInstanceState) {
        mContext = context;
    }

    @Override
    public void onViewStateRestored(MainView view, Bundle inState) {
        mView = view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {}

    @Override
    public void onResume() {
        mView.setLoading(true);
        MainModel.loadHomeScreen(buildReceiver());
    }

    private Receiver<DisplayableScreen> buildReceiver() {
        return null;
    }


}
