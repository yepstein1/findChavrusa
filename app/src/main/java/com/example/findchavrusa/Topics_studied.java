package com.example.findchavrusa;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "topics_studying", primaryKeys = {"userName", "topic"})
public class Topics_studied {

    @ColumnInfo(name = "userName")
    private String userName;

    @ColumnInfo(name = "topic")
    public String topic;


    Topics_studied(String userName, String topic) {
        this.userName = userName;
        this.topic = topic;
    }
}
