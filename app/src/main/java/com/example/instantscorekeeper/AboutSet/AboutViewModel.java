package com.example.instantscorekeeper.AboutSet;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AboutViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AboutViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Coming to you LIVE FROM \n &ffinity @pps!!!");
    }

    public LiveData<String> getText() {
        return mText;
    }

}
