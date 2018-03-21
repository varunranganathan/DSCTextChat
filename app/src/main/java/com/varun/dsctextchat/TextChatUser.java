package com.varun.dsctextchat;

/**
 * Created by vvvro on 3/21/2018.
 */

public class TextChatUser {
    public String userName;
    public String uid;

    public TextChatUser(){
        
    }

    public TextChatUser(String userName, String uid) {
        this.userName = userName;
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
