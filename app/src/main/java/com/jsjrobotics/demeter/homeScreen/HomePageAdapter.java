package com.jsjrobotics.demeter.homeScreen;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.jsjrobotics.demeter.displayableScreens.HomepageBlurbDisplayItem;

import java.util.ArrayList;
import java.util.List;

public class HomePageAdapter extends RecyclerView.Adapter<HomePageBlurbViewHolder> {
    private List<HomepageBlurbDisplayItem> mList = new ArrayList<>();

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

    public void addData(HomepageBlurbDisplayItem item) {
        mList.add(item);
        notifyDataSetChanged();
    }
}
