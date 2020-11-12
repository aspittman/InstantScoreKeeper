package com.example.instantscorekeeper.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.instantscorekeeper.databinding.GalleryListItemsBinding

class GalleryAdapter(
        private val galleryArrayList: List<Gallery>
) :
        RecyclerView.Adapter<GalleryAdapter.GalleryItemsViewHolder>() {

    inner class GalleryItemsViewHolder(binding: GalleryListItemsBinding) :
            RecyclerView.ViewHolder(binding.root) {
        val playerImage: ImageView = binding.playerImageIcon

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryItemsViewHolder {
        return GalleryItemsViewHolder(
                GalleryListItemsBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                )
        )
    }

    override fun onBindViewHolder(holder: GalleryItemsViewHolder, position: Int) {
        val gallery = galleryArrayList[position]
        holder.playerImage.setImageResource(gallery.playerImageIcon)
    }

    override fun getItemCount() = galleryArrayList.size
}


