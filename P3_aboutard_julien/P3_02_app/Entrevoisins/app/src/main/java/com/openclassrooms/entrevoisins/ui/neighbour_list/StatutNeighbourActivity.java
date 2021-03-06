package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.di.DIFav;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import butterknife.BindView;
import butterknife.ButterKnife;



public class StatutNeighbourActivity extends AppCompatActivity {

    @BindView(R.id.avatarFavView) ImageView avatar;
    @BindView(R.id.toolbarstatut) Toolbar toolb;
    @BindView(R.id.nameTextView2) TextView nameView2;
    @BindView(R.id.positionTextView)TextView positionView;
    @BindView(R.id.numberTextView) TextView numberView;
    @BindView(R.id.favButton) FloatingActionButton favButton;
    @BindView(R.id.resumeTextView) TextView resumeView;
    Neighbour neighbour;

    private NeighbourApiService mApiService = DIFav.getFavNeighbourApiService();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statut_neighbour);
        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();
        neighbour = DI.getNeighbourApiService().getNeighbours().get(extras.getInt("position_list"));
        init();
        this.checkFav(neighbour);

    }

    private void init() {
        Glide.with(avatar.getContext())
                .load(neighbour.getAvatarUrl())
                .apply(RequestOptions.centerCropTransform())
                .apply(RequestOptions.encodeQualityOf(100))
                .into(avatar);
        nameView2.setText(neighbour.getName());
        positionView.setText(neighbour.getAddress());
        numberView.setText(neighbour.getPhoneNumber());
        resumeView.setText(neighbour.getAboutMe());
        setSupportActionBar(toolb);
        toolb.setTitle(neighbour.getName());
        toolb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private  View.OnClickListener favListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (!mApiService.getNeighbours().contains(neighbour)) {
                mApiService.createNeighbour(neighbour);
                ((FloatingActionButton) view).setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_star_white_24dp));
            } else if (mApiService.getNeighbours().contains(neighbour)) {
                mApiService.deleteNeighbour(neighbour);
                ((FloatingActionButton) view).setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_star_border_white_24dp));
            }
        }
    };


    private void checkFav(Neighbour neighbour) {
        if (mApiService.getNeighbours().contains(neighbour)) {
            favButton.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_star_white_24dp));
        } else if (!mApiService.getNeighbours().contains(neighbour)) {
            favButton.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_star_border_white_24dp));
        }
        favButton.setOnClickListener(favListener);
    }

}
