package com.example.findchavrusa.Database;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.findchavrusa.Topics_studied;
import com.example.findchavrusa.Users;

import java.util.List;

public class AppViewModel extends AndroidViewModel {
    private AppRepository mRepository;
    private LiveData<List<Users>> mUsers;
    private LiveData<List<Topics_studied>> mTopics;

    public AppViewModel(Application application) {
        super(application);
        mRepository = new AppRepository(application);
        mUsers = mRepository.getmUsers();
    }

    public void insert(Users user) {
        mRepository.insert(user);
    }

    public void insertTopic(Topics_studied ts) {
        mRepository.insertTopic(ts);
    }

    public LiveData<List<Users>> getmUsers() {
        return mUsers;
    }

    public LiveData<List<Topics_studied>> getmTopics() {
        return mTopics;
    }
}
