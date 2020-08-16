package com.koyald.trello.model;

public class User {
    private String userID;
    private String name;
    private String email;

    public User(String userID) {
        this.userID = userID;
        this.name = userID;
        //this.email = email;
    }

    public void show(){
        String s = String.format("\t ID: %S, Name: %s", this.userID, this.name);
        System.out.println(s);
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
