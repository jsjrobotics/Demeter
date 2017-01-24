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

class HomeScreenPresenter extends LifeCyclePresenter<HomeScreenView> {
    private final Supplier<Fragment> mContext;
    private final HomeScreenModel mHomeScreenModel;
    private HomeScreenView mView;

    HomeScreenPresenter(Supplier<Fragment> context, Bundle savedInstanceState) {
        mContext = context;
        mHomeScreenModel = new HomeScreenModel(mContext.get().getContext());
    }

    @Override
    public void onViewStateRestored(HomeScreenView view, Bundle inState) {
        mView = view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {}

    @Override
    public void onResume() {
        mView.setLoading(true);
        mHomeScreenModel.loadHomeScreen(buildReceiver());
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
