package com.jsjrobotics.demeter.homeScreen.android;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.jsjrobotics.demeter.homeScreen.HomepageBlurb;

import java.util.ArrayList;
import java.util.List;

public class HomePageAdapter extends RecyclerView.Adapter<HomePageBlurbViewHolder> {
    private List<HomepageBlurb> mList = new ArrayList<>();

    @Override
    public HomePageBlurbViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HomePageBlurbViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(HomePageBlurbViewHolder holder, int position) {
        holder.setData(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addData(HomepageBlurb item) {
        mList.add(item);
        notifyDataSetChanged();
    }
}
