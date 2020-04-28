package com.example.instantscorekeeper.ScoreSet;

import android.os.Parcel;
import android.os.Parcelable;

public class Score implements Parcelable {

    private int playerImageIcon;
    private String playerNameText;
    private String playerScoreText;
    private int playerScoreUpButton;
    private int playerScoreDownButton;


    public Score(int playerImageIcon, String playerNameText, String playerScoreText, int playerScoreUpButton, int playerScoreDownButton) {

        this.playerImageIcon = playerImageIcon;
        this.playerNameText = playerNameText;
        this.playerScoreText = playerScoreText;
        this.playerScoreUpButton = playerScoreUpButton;
        this.playerScoreDownButton = playerScoreDownButton;
    }


    protected Score(Parcel in) {
        playerImageIcon = in.readInt();
        playerNameText = in.readString();
        playerScoreText = in.readString();
        playerScoreUpButton = in.readInt();
        playerScoreDownButton = in.readInt();
    }

    public static final Creator<Score> CREATOR = new Creator<Score>() {
        @Override
        public Score createFromParcel(Parcel in) {
            return new Score(in);
        }

        @Override
        public Score[] newArray(int size) {
            return new Score[size];
        }
    };

    public int getPlayerImageIcon() {
        return playerImageIcon;
    }

    public void setPlayerImageIcon(int playerImageIcon) {
        this.playerImageIcon = playerImageIcon;
    }

    public String getPlayerNameText() {
        return playerNameText;
    }

    public void setPlayerNameText(String playerNameText) {
        this.playerNameText = playerNameText;
    }

    public String getPlayerScoreText() {
        return playerScoreText;
    }

    public void setPlayerScoreText(String playerScoreText) {
        this.playerScoreText = playerScoreText;
    }

    public int getPlayerScoreUpButton() {
        return playerScoreUpButton;
    }

    public void setPlayerScoreUpButton(int playerScoreUpButton) {
        this.playerScoreUpButton = playerScoreUpButton;
    }

    public int getPlayerScoreDownButton() {
        return playerScoreDownButton;
    }

    public void setPlayerScoreDownButton(int playerScoreDownButton) {
        this.playerScoreDownButton = playerScoreDownButton;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(playerImageIcon);
        dest.writeString(playerNameText);
        dest.writeString(playerScoreText);
        dest.writeInt(playerScoreUpButton);
        dest.writeInt(playerScoreDownButton);
    }
}
