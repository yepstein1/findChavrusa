package com.example.findchavrusa.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.findchavrusa.Users;

import java.util.List;

@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(Users... users);

    @Insert
    void insertUserName(Users users);

    @Query("SELECT * FROM login_table")
    LiveData<List<Users>> getUsers();

    @Delete
    void delete(Users user);
}
