package com.openclassrooms.entrevoisins.ui.neighbour_fav_list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;


public class MyFavNeighbourRecyclerViewAdapter extends RecyclerView.Adapter<FavViewHolder> {

    private final List<Neighbour> mFavNeighbour;

    public MyFavNeighbourRecyclerViewAdapter(List<Neighbour> favItems) { this.mFavNeighbour=favItems; }


    @Override
    public FavViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view =
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fav_neighbour_item, viewGroup, false);
        return new FavViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavViewHolder favViewHolder, int i) {
        Neighbour neighbour = mFavNeighbour.get(i);
        favViewHolder.bind(neighbour);
    }

    @Override
    public int getItemCount() {
        return mFavNeighbour.size();
    }
}
