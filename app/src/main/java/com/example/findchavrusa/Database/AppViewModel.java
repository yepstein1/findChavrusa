package com.example.findchavrusa.Database;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.findchavrusa.Users;

import java.util.List;

public class AppViewModel extends AndroidViewModel {
    private AppRepository mRepository;
    private LiveData<List<Users>> mUsers;

    public AppViewModel(Application application) {
        super(application);
        mRepository = new AppRepository(application);
        mUsers = mRepository.getmUsers();
    }

    public void insert(Users user) {
        mRepository.insert(user);
    }

    public LiveData<List<Users>> getmUsers() {
        return mUsers;
    }
}