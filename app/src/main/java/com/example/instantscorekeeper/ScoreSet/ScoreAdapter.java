package com.example.instantscorekeeper.ScoreSet;

import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instantscorekeeper.R;

import java.util.ArrayList;

public class ScoreAdapter extends RecyclerView.Adapter<ScoreAdapter.ScoreItemsViewHolder>
        implements ItemTouchHelperAdapter {

    private ArrayList<Score> scoreData;
    public ItemTouchHelper itemTouchHelper;


    public ScoreAdapter(ArrayList<Score> scoreData) {
        this.scoreData = scoreData;
    }


    @NonNull
    @Override
    public ScoreItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_items, parent, false);
        ScoreItemsViewHolder scoreItemsViewHolder = new ScoreItemsViewHolder(view, scoreData);
        return scoreItemsViewHolder;

    }


    @Override
    public void onBindViewHolder(@NonNull ScoreItemsViewHolder holder, int position) {

        Score score = scoreData.get(position);

        holder.playerImageIcon.setImageResource(score.getPlayerImageIcon());
        holder.playerNameText.setText(score.getPlayerNameText());
        holder.playerScoreText.setText(score.getPlayerScoreText());
        holder.playerScoreUpButton.setImageResource(score.getPlayerScoreUpButton());
        holder.playerScoreDownButton.setImageResource(score.getPlayerScoreDownButton());

    }


    @Override
    public int getItemCount() {
        return scoreData.size();
    }


    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Score fromScore = scoreData.get(fromPosition);
        scoreData.remove(fromScore);
        scoreData.add(toPosition, fromScore);
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemSwiped(int position) {
        scoreData.remove(position);
        notifyItemRemoved(position);
    }

    public void setItemTouchHelper(ItemTouchHelper itemTouchHelper) {
        this.itemTouchHelper = itemTouchHelper;
    }


    public class ScoreItemsViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener,
            View.OnTouchListener,
            GestureDetector.OnGestureListener {

        private ImageView playerImageIcon;
        private TextView playerNameText;
        private TextView playerScoreText;
        private ImageView playerScoreUpButton;
        private ImageView playerScoreDownButton;
        private int scoreRoster;

        private ArrayList<Score> scoreData;
        private GestureDetector gestureDetector;


        public ScoreItemsViewHolder(View itemView, ArrayList<Score> scoreData) {

            super(itemView);
            playerImageIcon = itemView.findViewById(R.id.image_for_users);
            playerNameText = itemView.findViewById(R.id.name_for_users);
            playerScoreText = itemView.findViewById(R.id.score_for_users);
            playerScoreUpButton = itemView.findViewById(R.id.score_up_image);
            playerScoreDownButton = itemView.findViewById(R.id.score_down_image);

            playerImageIcon.setOnClickListener(this);
            playerScoreUpButton.setOnClickListener(this);
            playerScoreDownButton.setOnClickListener(this);
            itemView.setOnTouchListener(this);

            this.scoreData = scoreData;
            gestureDetector = new GestureDetector(itemView.getContext(), this);
        }

        @Override
        public void onClick(View view) {

            int viewID = view.getId();

            switch (viewID) {

                case R.id.score_up_image:
                    scoreRoster++;
                    playerScoreText.setText(String.valueOf(scoreRoster));
                    break;

                case R.id.score_down_image:
                    scoreRoster--;
                    playerScoreText.setText(String.valueOf(scoreRoster));
            }
        }


        @Override
        public boolean onDown(MotionEvent e) {
            return false;
        }

        @Override
        public void onShowPress(MotionEvent e) {

        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {

          itemTouchHelper.startDrag(this);

        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            return false;
        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
//            Warning Solver Code
//            switch (event.getAction()) {
//                case MotionEvent.ACTION_DOWN:
//                    //some code....
//                    break;
//                case MotionEvent.ACTION_UP:
//                    v.performClick();
//                    break;
//                default:
//                    break;
//            }
//            return true;
            gestureDetector.onTouchEvent(event);
            return true;
        }
    }

}
