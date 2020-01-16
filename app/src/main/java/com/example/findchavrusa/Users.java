package com.example.findchavrusa;

import java.io.Serializable;

public class Users implements Serializable {
  private  String email;
   private String password;

    public Users(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {


        return email;
    }

    public String getPassword() {
        return password;
    }
}
