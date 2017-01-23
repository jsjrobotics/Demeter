package com.jsjrobotics.demeter.homeScreen;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.jsjrobotics.defaultTemplate.lifecycle.appCompat.DefaultAppCompatLifecycleFragment;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Receiver;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Supplier;
import com.jsjrobotics.demeter.androidWrappers.LifeCyclePresenter;
import com.jsjrobotics.demeter.displayableScreens.DisplayItem;
import com.jsjrobotics.demeter.dataStructures.DisplayableScreen;

class MainPresenter extends LifeCyclePresenter<MainView> {
    private final Supplier<Fragment> mContext;
    private final MainModel mMainModel;
    private MainView mView;

    MainPresenter(Supplier<Fragment> context, Bundle savedInstanceState) {
        mContext = context;
        mMainModel = new MainModel(mContext.get().getContext(), mContext.get().getResources());
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
        mMainModel.loadHomeScreen(buildReceiver());
    }

    private Receiver<Optional<DisplayableScreen>> buildReceiver() {
        return result -> {
            result.ifPresent( screen -> {
                DefaultAppCompatLifecycleFragment.runOnUiThread(mContext.get(), () -> {
                    for (DisplayItem displayItem : screen.getContent()) {
                        displayItem.transform(item -> {
                            mView.addData(item);
                        });
                    }
                    mView.setLoading(false);
                });
            });
        };
    }


}
