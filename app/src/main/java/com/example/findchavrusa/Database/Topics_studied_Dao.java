package com.example.findchavrusa.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.findchavrusa.Topics_studied;

import java.util.List;

@Dao
public interface Topics_studied_Dao {

    @Insert
    void insertTopic(Topics_studied ts);

    @Query("SELECT * FROM TOPICS_STUDYING WHERE topic = :selectedTopic")
    LiveData<List<Topics_studied>> getTopics(String selectedTopic);

}
