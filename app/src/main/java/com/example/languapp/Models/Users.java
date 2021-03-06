package com.example.languapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Users {
//    @SerializedName("mail")
//    @Expose
    private String mail;
//    @SerializedName("pass")
//    @Expose
    private String pass;
//    @SerializedName("phone")
//    @Expose
    private String phone;
//    @SerializedName("name")
//    @Expose
    private String name;
//    @SerializedName("id")
//    @Expose
    private int id;

    public String toString(){

        return "test";
    }
    public Users(String mail, String pass)
    {
        this.mail = mail;
        this.pass = pass;
    }

    public Users(String mail, String pass, String phone, String name) {
        this.mail = mail;
        this.pass = pass;
        this.phone = phone;
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
