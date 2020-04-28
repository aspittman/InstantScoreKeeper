package com.example.instantscorekeeper.ScoreSet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instantscorekeeper.R;
import com.example.instantscorekeeper.ScoreSet.Score;
import com.example.instantscorekeeper.ScoreSet.ScoreAdapter;
import com.example.instantscorekeeper.ScoreSet.ScoreItemTouchHelper;

import java.util.ArrayList;

public class ScoreFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Score> scoreData;
    private ScoreAdapter scoreAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_score, container, false);

        scoreData = new ArrayList<>();
        scoreData.add(new Score(R.drawable.ic_launcher_foreground, "Player Name", "0", R.drawable.score_up_arrow_24dp, R.drawable.score_down_arrow_24dp));
        scoreData.add(new Score(R.drawable.ic_launcher_foreground, "Player Name", "0", R.drawable.score_up_arrow_24dp, R.drawable.score_down_arrow_24dp));
        scoreData.add(new Score(R.drawable.ic_launcher_foreground, "Player Name", "0", R.drawable.score_up_arrow_24dp, R.drawable.score_down_arrow_24dp));
        scoreData.add(new Score(R.drawable.ic_launcher_foreground, "Player Name", "0", R.drawable.score_up_arrow_24dp, R.drawable.score_down_arrow_24dp));
        scoreData.add(new Score(R.drawable.ic_launcher_foreground, "Player Name", "0", R.drawable.score_up_arrow_24dp, R.drawable.score_down_arrow_24dp));
        scoreData.add(new Score(R.drawable.ic_launcher_foreground, "Player Name", "0", R.drawable.score_up_arrow_24dp, R.drawable.score_down_arrow_24dp));


        recyclerView = rootView.findViewById(R.id.score_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        scoreAdapter = new ScoreAdapter(scoreData);

        initiateRecyclerView();

        return rootView;
    }

    private void initiateRecyclerView() {

        ItemTouchHelper.Callback callback = new ScoreItemTouchHelper(scoreAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        scoreAdapter.setItemTouchHelper(itemTouchHelper);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        recyclerViewAdapter = new ScoreAdapter(scoreData);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
