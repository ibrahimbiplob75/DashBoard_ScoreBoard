package com.example.admindashboard;

public class regisData {
    String name,username,email,phone,classID,password;

    public regisData() {

    }

    public regisData(String name, String username, String email, String phone, String classID, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.classID = classID;
        this.password = password;
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

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getClassID() {
        return classID;
    }

    public String getPassword() {
        return password;
    }
}
