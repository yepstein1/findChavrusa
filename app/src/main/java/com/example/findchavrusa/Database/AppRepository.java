package com.example.findchavrusa.Database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.findchavrusa.Users;

import java.util.List;

public class AppRepository {
    private UserDao mUserDao;
    private LiveData<List<Users>> mUsers;

    AppRepository(Application application) {
        AppDataBase db = AppDataBase.getDatabase(application);
        mUserDao = db.userDao();
        mUsers = mUserDao.getUsers();

    }

    LiveData<List<Users>> getmUsers() {
        return mUsers;
    }

    void insert(final Users user) {
        AppDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mUserDao.insertAll(user);
            }
        });
    }


}
