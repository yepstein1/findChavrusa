package com.example.findchavrusa.Database;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.findchavrusa.Topics_studied;

import java.util.List;

public class AppViewModel extends AndroidViewModel {
    private AppRepository mRepository;

    private LiveData<List<Topics_studied>> mTopics;

    public AppViewModel(Application application) {
        super(application);
        mRepository = new AppRepository(application);


    }

    public void setRepositoryTopics(String s) {
        mRepository.setTopics(s);
        setmTopics();
    }

    private void setmTopics() {
        mTopics = mRepository.getmTopics();
    }


    public void insertTopic(Topics_studied ts) {
        mRepository.insertTopic(ts);
    }


    public LiveData<List<Topics_studied>> getmTopics(String s) {
        return mTopics;
    }
}
