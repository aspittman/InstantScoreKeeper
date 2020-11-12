package com.example.instantscorekeeper.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instantscorekeeper.R
import com.example.instantscorekeeper.databinding.FragmentGalleryBinding
import java.util.*
import kotlin.collections.ArrayList

class GalleryFragment : Fragment() {
    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    private lateinit var galleryData: ArrayList<Gallery>
    private lateinit var galleryAdapter: GalleryAdapter

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)

        galleryData = ArrayList()
        galleryData.add(Gallery(R.drawable.ic_menu_gallery))
        galleryData.add(Gallery(R.drawable.ic_menu_send))
        galleryData.add(Gallery(R.drawable.ic_menu_camera))
        galleryData.add(Gallery(R.drawable.ic_menu_manage))
        galleryData.add(Gallery(R.drawable.ic_menu_slideshow))

        galleryAdapter = GalleryAdapter(galleryData)
        binding.galleryRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, 3)
            adapter = GalleryAdapter(galleryData)
            itemAnimator = DefaultItemAnimator()
    }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}