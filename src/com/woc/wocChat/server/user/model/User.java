package com.woc.wocChat.server.user.model;

/**
 * Created by silen on 16-10-10.
 */
public class User {
    private long id=0;
    private String sign="";
    private long signUpTime;
    private long chatPartnerId=0;
    private String username="";
    private String password="";
    private long lastLogin;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public long getSignUpTime() {
        return signUpTime;
    }

    public void setSignUpTime(long signUpTime) {
        this.signUpTime = signUpTime;
    }

    public long getChatPartnerId() {
        return chatPartnerId;
    }

    public void setChatPartnerId(long chatPartnerId) {
        this.chatPartnerId = chatPartnerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
