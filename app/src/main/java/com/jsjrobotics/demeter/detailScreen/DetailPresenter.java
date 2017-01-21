package com.jsjrobotics.demeter.detailScreen;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.jsjrobotics.defaultTemplate.lifecycle.functional.Receiver;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Supplier;
import com.jsjrobotics.demeter.androidWrappers.LifeCyclePresenter;
import com.jsjrobotics.demeter.dataStructures.DisplayableScreen;

class DetailPresenter extends LifeCyclePresenter<DetailView> {
    private final Supplier<Fragment> mContext;
    private final DetailModel mModel;
    private DetailView mView;

    DetailPresenter(Supplier<Fragment> context, Bundle savedInstanceState) {
        mContext = context;
        mModel = new DetailModel(mContext.get().getResources());
    }

    @Override
    public void onViewStateRestored(DetailView view, Bundle inState) {
        mView = view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {}

    @Override
    public void onResume() {
        mView.setLoading(true);
        mModel.loadDetailScreen(buildReceiver());
    }

    private Receiver<DisplayableScreen> buildReceiver() {
        return null;
    }

}
