package com.example.zwf.entity;

public class User {
    private String email;
    private String password;
    private String ensure;
    private String userName;
    private String pnumber;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEnsure() {
        return ensure;
    }

    public void setEnsure(String ensure) {
        this.ensure = ensure;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPnumber() {
        return pnumber;
    }

    public void setPnumber(String pnumber) {
        this.pnumber = pnumber;
    }
}
