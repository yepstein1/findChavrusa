package com.example.findchavrusa.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.findchavrusa.Users;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Users.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    public abstract UserDao userDao();

    private static volatile AppDataBase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static AppDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDataBase.class, "app_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }


}