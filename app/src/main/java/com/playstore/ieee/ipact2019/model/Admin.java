package com.playstore.ieee.ipact2019.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Admin {

//    @SerializedName("email")
//    @Expose
    private String email;
//    @SerializedName("login_status")
//    @Expose
    private String login_status;
//    @SerializedName("name")
//    @Expose
    private String name;
//    @SerializedName("password")
//    @Expose
    private String password;
//    @SerializedName("type")
//    @Expose
    private String type;

    public Admin(String email, String login_status, String name, String password, String type) {
        this.email = email;
        this.login_status = login_status;
        this.name = name;
        this.password = password;
        this.type = type;
    }

    public String getLogin_status() {
        return login_status;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin_status(String login_status) {
        this.login_status = login_status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
