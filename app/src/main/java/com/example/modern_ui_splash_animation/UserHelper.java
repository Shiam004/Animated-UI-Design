package com.example.modern_ui_splash_animation;

public class UserHelper {
    String name,username,email,phone,pass;

    public UserHelper() {

    }

    public UserHelper(String name, String username, String email, String phone, String pass) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPass() {
        return pass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
