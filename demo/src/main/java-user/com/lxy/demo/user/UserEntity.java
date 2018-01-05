package com.lxy.demo.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonProperty("id")
    private long id;

    @JsonProperty("user_name")
    private String  userName;

    @JsonProperty("password")
    private String passWord;

    @JsonProperty("user_sex")
    private UserSexEnum userSex;

    @JsonProperty("nick_name")
    private String nickName;

    public UserEntity() {
        super();
    }


    public UserEntity(String userName, String passWord, UserSexEnum userSex) {
        super();
        this.passWord = passWord;
        this.userName = userName;
        this.userSex = userSex;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public UserSexEnum getUserSex() {
        return userSex;
    }

    public void setUserSex(UserSexEnum userSex) {
        this.userSex = userSex;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString(){
        return "userName " + this.userName + ", pasword " + this.passWord + "sex " + userSex.name();
    }


}
