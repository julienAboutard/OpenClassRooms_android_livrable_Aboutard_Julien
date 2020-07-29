package com.openclassrooms.entrevoisins.neighbour_fav_list;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DIFav;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(AndroidJUnit4.class)
public class OnlyFavTest {

    private static int ITEMS_COUNT = DIFav.getFavNeighbourApiService().getNeighbours().size();

    private ListNeighbourActivity mActivity;

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityRule =
            new ActivityTestRule(ListNeighbourActivity.class);

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }

    /**
     * Favorite Tab should only show favorties neighbours
     */
    @Test
    public void myFAvNeighboursList_shouldShowOnlyFav() {
        // Checking we have the right size of recyclerview for favorites neighbours
        onView(ViewMatchers.withId(R.id.recyclerview_fav)).check(withItemCount(ITEMS_COUNT));

        //Checking for each delete of a favorite neighbour the size of recyclerview for favorites neighbours
        //decrease by 1
        for (int i=ITEMS_COUNT-1; i>=0; i--) {
            DIFav.getFavNeighbourApiService().deleteNeighbour(DIFav.getFavNeighbourApiService().getNeighbours().get(i));
            onView(ViewMatchers.withId(R.id.recyclerview_fav)).check(withItemCount(i));
        }
    }
}
