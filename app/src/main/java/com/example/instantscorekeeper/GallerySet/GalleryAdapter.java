package com.example.instantscorekeeper.GallerySet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instantscorekeeper.R;

import java.util.ArrayList;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryItemsViewHolder> {

private ArrayList<Gallery> galleryArrayList;

    public GalleryAdapter(ArrayList<Gallery> galleryArrayList) {
        this.galleryArrayList = galleryArrayList;

    }

    @NonNull
    @Override
    public GalleryItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_items, parent, false);
        GalleryItemsViewHolder galleryItemsViewHolder = new GalleryItemsViewHolder(view, galleryArrayList);
        return galleryItemsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryItemsViewHolder holder, int position) {

        Gallery gallery = galleryArrayList.get(position);

        holder.playerImage.setImageResource(gallery.getPlayerImageIcon());
    }

    @Override
    public int getItemCount() {
        return galleryArrayList.size();
    }


    public class GalleryItemsViewHolder extends RecyclerView.ViewHolder {

        ArrayList<Gallery> galleryArrayList;
        private ImageView playerImage;

        public GalleryItemsViewHolder(@NonNull View itemView, ArrayList<Gallery> galleryArrayList) {
            super(itemView);

            playerImage = itemView.findViewById(R.id.player_image_icon);
            this.galleryArrayList = galleryArrayList;
        }
    }

}
