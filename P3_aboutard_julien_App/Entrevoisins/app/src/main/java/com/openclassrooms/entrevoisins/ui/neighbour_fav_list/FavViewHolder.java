package com.openclassrooms.entrevoisins.ui.neighbour_fav_list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;


public class FavViewHolder extends RecyclerView.ViewHolder {

    private TextView nameView;
    private ImageView avatarView;

    public FavViewHolder(@NonNull View itemView) {
        super(itemView);

        avatarView = itemView.findViewById(R.id.item_fav_avatar);
        nameView = itemView.findViewById(R.id.item_fav_name);
    }

    public void bind(Neighbour neighbour) {
        Glide.with(avatarView.getContext())
                .load(neighbour.getAvatarUrl())
                .apply(RequestOptions.circleCropTransform())
                .into(avatarView);
        nameView.setText(neighbour.getName());
    }
}
