package com.jsjrobotics.demeter.detailScreen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jsjrobotics.demeter.R;
import com.jsjrobotics.demeter.androidWrappers.DefaultView;

class DetailView implements DefaultView {
    private final View mRoot;

    DetailView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.detail_view, viewGroup, false);
    }

    @Override
    public View getLayout() {
        return mRoot;
    }

    @Override
    public void saveInstanceState(Bundle outState) {

    }
}
