package com.example.findchavrusa;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "topics_studying", primaryKeys = {"userName", "topic"})
public class Topics_studied {
    @NonNull
    @ColumnInfo(name = "userName")
    private String userName;
    @NonNull

    @ColumnInfo(name = "topic")
    public String topic;


    public Topics_studied(String userName, String topic) {
        this.userName = userName;
        this.topic = topic;
    }

    public String getUserName() {
        return userName;
    }
}
