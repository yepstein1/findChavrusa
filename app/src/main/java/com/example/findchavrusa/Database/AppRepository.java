package com.example.findchavrusa.Database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.findchavrusa.Topics_studied;
import com.example.findchavrusa.Users;

import java.util.List;

class AppRepository {
    private UserDao mUserDao;
    private LiveData<List<Users>> mUsers;
    private Topics_studied_Dao mTopicsDao;
    private LiveData<List<Topics_studied>> mTopics;

    AppRepository(Application application) {
        AppDataBase db = AppDataBase.getDatabase(application);
        mUserDao = db.userDao();
        mTopicsDao = db.topicDao();
        mUsers = mUserDao.getUsers();

    }

    LiveData<List<Users>> getmUsers() {
        return mUsers;
    }

    LiveData<List<Topics_studied>> getmTopics() {
        return mTopics;
    }

    void insert(final Users user) {
        AppDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mUserDao.insertAll(user);
            }
        });
    }


    void insertTopic(final Topics_studied topic) {
        AppDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mTopicsDao.insertTopic(topic);
            }
        });
    }


}
