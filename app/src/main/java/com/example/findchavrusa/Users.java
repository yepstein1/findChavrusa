package com.example.findchavrusa;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "login_table")
public class Users implements Serializable {


    public String getUserName() {
        return userName;
    }

    public Users(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }


    public String getPassword() {
        return password;
    }

    public int getUid() {
        return uid;
    }

    @PrimaryKey
    @NonNull
    public int uid;

    @ColumnInfo(name = "userName")
    public String userName;

    @ColumnInfo(name = "password")
    public String password;

}
