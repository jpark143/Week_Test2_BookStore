package com.company;

public class Users {
    int id;
    String userName;

    public Users(){

    }

    public Users(int id, String userName, String password){
        this.id = id;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
