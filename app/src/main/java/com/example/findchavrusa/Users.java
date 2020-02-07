package com.example.findchavrusa;

import java.io.Serializable;
import java.util.List;


public class Users implements Serializable {

    public String userName;


    public String password;
    private List<String> topics;


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


}
