package com.shoppcrypto.shoppcrypto.form;

import com.shoppcrypto.shoppcrypto.model.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.*;

public class UserForm {

    @NotNull @Size(min=1,max=50) @Email
    private String email;
    @NotNull @NotEmpty @Size(min = 8,max = 16)
    private String password;
    @NotNull @Size(min = 2, max = 50)
    private String name;
    private char gender;
    @NotNull @NotBlank @Size(min =1,max =50)
    private String nickname;

    public UserForm(String email, String password, String name, char gender, String nickname) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.nickname = nickname;
    }

    public User toUser(){
        User user = new User();
        user.setEmail(getEmail());
        user.setPassword(getPassword());
        user.setName(getName());
        user.setGender(getGender());
        user.setNickName(getNickname());
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
