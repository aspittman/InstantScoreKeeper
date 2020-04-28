package com.example.instantscorekeeper.ShareSet;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ShareViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ShareViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Send Snapshots to facebook or wherever");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
