package com.jsjrobotics.demeter.homeScreen;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.jsjrobotics.demeter.displayableScreens.HomepageBlurbDisplayItem;

import java.util.ArrayList;
import java.util.List;

public class HomePageAdapter extends RecyclerView.Adapter {
    private List<HomepageBlurbDisplayItem> mList = new ArrayList<>();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void addData(HomepageBlurbDisplayItem item) {
        mList.add(item);
        notifyDataSetChanged();
    }
}
