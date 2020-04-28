package com.example.instantscorekeeper.GallerySet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instantscorekeeper.R;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

private RecyclerView.Adapter adapter;
private RecyclerView recyclerView;
private GalleryAdapter galleryAdapter;
private ArrayList<Gallery> galleryData;
private RecyclerView.LayoutManager layoutManager;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View rootPics = inflater.inflate(R.layout.fragment_gallery, container, false);

        galleryData = new ArrayList<>();
        galleryData.add(new Gallery(R.drawable.ic_menu_gallery));
        galleryData.add(new Gallery(R.drawable.ic_menu_send));
        galleryData.add(new Gallery(R.drawable.ic_menu_camera));
        galleryData.add(new Gallery(R.drawable.ic_menu_manage));
        galleryData.add(new Gallery(R.drawable.ic_menu_slideshow));

        recyclerView = rootPics.findViewById(R.id.gallery_recycler_view);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        galleryAdapter = new GalleryAdapter(galleryData);

        adapter = new GalleryAdapter(galleryData);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return rootPics;
    }
}
