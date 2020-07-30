package com.openclassrooms.entrevoisins.ui.neighbour_fav_list;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ListFavNeighbourPagerAdapter extends FragmentPagerAdapter {

    public ListFavNeighbourPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return FavNeighbourFragment.newInstance();
    }

    @Override
    public int getCount() {
        return 1;
    }
}
