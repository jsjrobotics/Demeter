package com.jsjrobotics.demeter.homeScreen;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jsjrobotics.demeter.R;
import com.jsjrobotics.demeter.androidWrappers.DefaultView;
import com.jsjrobotics.demeter.dataStructures.HomepageBlurb;

class MainView implements DefaultView {
    private static final int HOMESCREEN_SPAN = 2;
    private final View mRoot;
    private final View mLoading;
    private final RecyclerView mLoaded;
    private final View mError;
    private final HomePageAdapter mAdapter;

    MainView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.main_view, viewGroup, false);
        mLoading = mRoot.findViewById(R.id.loading);
        mLoaded = (RecyclerView) mRoot.findViewById(R.id.content);
        mError = mRoot.findViewById(R.id.error);
        mAdapter = new HomePageAdapter();
        mLoaded.setAdapter(mAdapter);
        mLoaded.setLayoutManager(new GridLayoutManager(mRoot.getContext(), HOMESCREEN_SPAN));
        setLoading(true);
    }

    public View getLayout() {
        return mRoot;
    }

    public void saveInstanceState(Bundle outState) {

    }

    @Override
    public void setLoading(boolean isLoading) {
        if (isLoading) {
            mError.setVisibility(View.GONE);
            mLoaded.setVisibility(View.GONE);
            mLoading.setVisibility(View.VISIBLE);
        } else {
            mError.setVisibility(View.GONE);
            mLoaded.setVisibility(View.VISIBLE);
            mLoading.setVisibility(View.GONE);
        }
    }

    @Override
    public void setError(boolean displayErrorScreen) {
        if (displayErrorScreen) {
            mError.setVisibility(View.VISIBLE);
            mLoaded.setVisibility(View.GONE);
            mLoading.setVisibility(View.GONE);
        } else {
            mError.setVisibility(View.GONE);
            mLoaded.setVisibility(View.GONE);
            mLoading.setVisibility(View.VISIBLE);
        }
    }

    public void addData(HomepageBlurb item) {
        mAdapter.addData(item);
    }
}
