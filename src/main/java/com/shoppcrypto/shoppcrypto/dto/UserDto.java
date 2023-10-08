package com.shoppcrypto.shoppcrypto.dto;

import com.shoppcrypto.shoppcrypto.model.User;

import java.util.UUID;

public class UserDto {
    private UUID id;
    private String email;
    private String name;
    private String nickName;

    public UserDto (User user){
        this.email = user.getEmail();
        this.name = user.getName();
        this.nickName = user.getNickName();
      //  this.id = user.getId();
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}