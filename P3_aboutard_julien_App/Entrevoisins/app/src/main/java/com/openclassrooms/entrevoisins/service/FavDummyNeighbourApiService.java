package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;

public class FavDummyNeighbourApiService implements NeighbourApiService {

    private List<Neighbour> mFavList = DummyNeighbourGenerator.generateNeighbours();

    @Override
    public List<Neighbour> getNeighbours() {
        return mFavList;
    }

    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        mFavList.remove(neighbour);

    }

    @Override
    public void createNeighbour(Neighbour neighbour) {
        mFavList.add(neighbour);
    }
}
