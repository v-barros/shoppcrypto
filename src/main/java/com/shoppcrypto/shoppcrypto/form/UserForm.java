package com.shoppcrypto.shoppcrypto.form;

import com.shoppcrypto.shoppcrypto.model.User;

public class UserForm {

    private String email;
    private String password;
    private String name;
    private String taxId;
    private char gender;
    private String nickName;

    public UserForm(String email, String password, String name, String taxId, char gender, String nickName) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.taxId = taxId;
        this.gender = gender;
        this.nickName = nickName;
    }
    public User toUser(){
        User user = new User();
        user.setEmail(getEmail());
        user.setPassword(getPassword());
        user.setName(getName());
        user.setTaxId(getTaxId());
        user.setGender(getGender());
        user.setNickName(getNickName());
        return user;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

}
