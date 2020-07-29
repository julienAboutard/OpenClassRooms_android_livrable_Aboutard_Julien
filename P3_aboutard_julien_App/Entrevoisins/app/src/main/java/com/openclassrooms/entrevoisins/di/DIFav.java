package com.openclassrooms.entrevoisins.di;

import com.openclassrooms.entrevoisins.service.FavDummyNeighbourApiService;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

public class DIFav {

    private static NeighbourApiService service = new FavDummyNeighbourApiService();

    /**
     * Get an instance on @{@link NeighbourApiService}
     * @return
     */
    public static NeighbourApiService getFavNeighbourApiService() {
        return service;
    }

    /**
     * Get always a new instance on @{@link NeighbourApiService}. Useful for tests, so we ensure the context is clean.
     * @return
     */
    public static NeighbourApiService getNewInstanceApiService() {
        return new FavDummyNeighbourApiService();
    }
}
