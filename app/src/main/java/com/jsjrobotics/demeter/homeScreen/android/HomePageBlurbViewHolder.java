package com.jsjrobotics.demeter.homeScreen.android;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jsjrobotics.demeter.R;
import com.jsjrobotics.demeter.homeScreen.HomepageBlurb;

public class HomePageBlurbViewHolder extends RecyclerView.ViewHolder {
    private final TextView mTitle;
    private final TextView mSummary;
    private final ImageView mImage;

    public HomePageBlurbViewHolder(ViewGroup parent) {
        super(createView(parent));
        mTitle = (TextView) itemView.findViewById(R.id.title);
        mImage = (ImageView) itemView.findViewById(R.id.image);
        mSummary = (TextView) itemView.findViewById(R.id.summary);
    }

    private static View createView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.home_page_blurb_view_holder,parent, false);
    }

    public void setData(HomepageBlurb item) {
        mTitle.setText(item.getTitle());
        mSummary.setText(item.getSummary());
    }
}
