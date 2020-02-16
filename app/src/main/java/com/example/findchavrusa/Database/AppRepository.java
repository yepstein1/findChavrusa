package com.example.findchavrusa.Database;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.findchavrusa.Topics_studied;
import com.example.findchavrusa.Users;

import java.util.List;

public class AppRepository {

    private LiveData<List<Users>> mUsers;
    private Topics_studied_Dao mTopicsDao;
    private LiveData<List<Topics_studied>> mTopics;
    String topic;

    AppRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);

        mTopicsDao = db.topicDao();


    }

    void setTopics(String s) {
        mTopics = mTopicsDao.getTopics(s);

        Log.i("RepoLog", mTopicsDao.toString());
    }

    LiveData<List<Users>> getmUsers() {
        return mUsers;
    }

    LiveData<List<Topics_studied>> getmTopics() {
        return mTopics;
    }



    void insertTopic(final Topics_studied topic) {
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mTopicsDao.insertTopic(topic);
            }
        });
    }


}
