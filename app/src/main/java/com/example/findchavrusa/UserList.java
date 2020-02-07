package com.example.findchavrusa;

import java.util.ArrayList;

/**
 * Dummy data for project in case room doesn't work
 */
public class UserList {
    private ArrayList<Users> userList = new ArrayList<>();

    public ArrayList<Users> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<Users> userList) {
        this.userList = userList;
    }

    public Users getIndex(int index) {
        return userList.get(0);
    }

    public void addUser(Users user) {
        userList.add(user);
    }
}
