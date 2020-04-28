package com.example.languapp.Models;

public class Users {
    private String name, email, phone, pass;

    public String getName() {
        return name;
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

    public Users(String name, String enail, String phone, String pass) {
        this.name = name;
        this.email = enail;
        this.phone = phone;
        this.pass = pass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String enail) {
        this.email = enail;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Users() {}
}
